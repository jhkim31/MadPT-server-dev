FROM mariadb:10.5

RUN apt-get update -y  
RUN	apt-get upgrade -y  
RUN	apt-get install git vim -y 

COPY ./DB_container/data /docker-entrypoint-initdb.d
WORKDIR /workspace

ENV MYSQL_ROOT_PASSWORD 1234
