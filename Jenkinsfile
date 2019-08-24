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
    stage('Remove Previous Container'){
	try{
            sh 'docker rm -f portal'
            sh 'docker rm -f dockermysql'
	    sh 'docker rmi bathurudocker/portal'
	}catch(error){
		//  do nothing if there is an exception
	}
 }
  stage('Build Docker Image'){ 
     sh 'docker build -t bathurudocker/portal:latest .'
   }
   
  stage('Push Docker Image'){
     withCredentials([string(credentialsId: 'dockerHubPwd', variable: 'dockerpwd')]) {
        sh "docker login -u bathurudocker -p ${dockerpwd}"
     }
     sh 'docker push bathurudocker/portal:latest'
   }
  
   stage('Run Container'){
     sh 'docker run --name dockermysql -p 3306:3306 -d bathurudocker/dockermysql'	   
     sh 'docker run --name portal -p 8080:8080 -d --link dockermysql:mysql -d bathurudocker/portal'
   }
   
    stage('Email Notification'){
      emailext  bcc: '', 
           body: """Hi Team, Your project successfully Build and Deployed.
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
