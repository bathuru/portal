FROM tomcat:8

# Mention some Meta data
MAINTAINER srinivas.bathuru@gmail.com 

##
# Take the war and copy to webapps of tomcat
COPY target/*.war /usr/local/tomcat/webapps/portal.war

EXPOSE 80 443 8080
