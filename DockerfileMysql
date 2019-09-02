FROM mysql:5.6
ENV MYSQL_ROOT_PASSWORD root
ENV MYSQL_DATABASE portal
ENV MYSQL_USER srini
ENV MYSQL_PASSWORD srini
ADD script.sql /docker-entrypoint-initdb.d
EXPOSE 3306

# docker build -t bathurudocker/dockermysql .
# docker push bathurudocker/dockermysql:latest


