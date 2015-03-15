FROM tomcat
MAINTAINER Romin Irani <romin.irani@mindstormsoftware.com>
ADD  app.war /usr/local/tomcat/webapps/
ENV CLOUDSQL_IP 173.194.84.2
ENV CLOUDSQL_USERID root
ENV CLOUDSQL_PWD admin
CMD ["catalina.sh", "run"]