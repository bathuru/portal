node{
   stage('GitHub Checkout'){
       git credentialsId: 'GitHubCredentials', 
                     url: 'https://github.com/itsmydevops/portal.git'
   }
   
   stage('Maven Build'){
     def mvnHome = tool name: 'Maven', type: 'maven'
     def mvnCMD = "${mvnHome}/bin/mvn"
     sh "${mvnCMD} clean package"
   }

   stage('SonarQube Analysis') {
        def mvnHome =  tool name: 'Maven', type: 'maven'
        withSonarQubeEnv('SonarQubeServer') { 
          sh "${mvnHome}/bin/mvn sonar:sonar"
        }
    }
   
   stage('Copy to Nexux Repo'){
   nexusPublisher   nexusInstanceId: 'NexusRepoServer', 
                  nexusRepositoryId: 'DevopsNexusRepo', 
                           packages: [[$class: 'MavenPackage', 
                     mavenAssetList: [[classifier: '', 
                          extension: '', 
                           filePath: '/Users/srinivas/.jenkins/workspace/portal/target/portal.war']], 
                    mavenCoordinate: [artifactId: 'portal', 
                            groupId: 'com.itsmydevops', 
                          packaging: 'war', 
                            version: '1.0']]]
   
   } 
    stage('Docker Build & Deploy'){
	    
	withDockerServer([uri: 'tcp://127.0.0.1:6443']) {
  
	try{
            sh 'docker rm -f portal'
            sh 'docker rm -f portaldb'
	    sh 'docker rmi bathurudocker/portal'
	    sh 'docker rmi bathurudocker/portaldb'
	}catch(error){
		//  do nothing if there is an exception
	}
	    

     sh 'docker build -t bathurudocker/portal:latest .'
     sh 'docker build -f DockerfileMysql -t bathurudocker/portaldb:latest .'

   

     withCredentials([string(credentialsId: 'dockerHubPwd', variable: 'dockerpwd')]) {
        sh "docker login -u bathurudocker -p ${dockerpwd}"
     }
     sh 'docker push bathurudocker/portal:latest'

  

     sh 'docker run --name portaldb -p 3306:3306 -d bathurudocker/portaldb'	   
     sh 'docker run -p 8080:8080 --name portal --link portaldb:mysql -d bathurudocker/portal'
   }
    }
	    
    stage('Email Notification'){
      emailext  bcc: '', 
           body: """Hi Team, 
	   
Your project successfully Build and Deployed.

	   Job Name: ${env.JOB_NAME}
	   Job URL : ${env.JOB_URL}
	   
	   
Thanks
DevOps Team""", 
             cc: '', 
           from: '', 
        replyTo: '', 
        subject: 'Portal - Jenkins Job Status', 
             to: 'srinivas.bathuru@gmail.com'
        attachLog: 'true'
   }
}
