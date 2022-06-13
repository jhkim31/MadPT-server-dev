FROM openjdk:11

COPY ./API_container/MadPtApi/ /workspace/MadPtApi
COPY ./API_container/Script /script
  
RUN ls
RUN apt-get update -y
RUN apt-get upgrade -y
RUN apt-get install vim -y

WORKDIR /workspace/MadPtApi
RUN chmod 755 gradlew
RUN ./gradlew build

WORKDIR /script
RUN chmod 755 ./server_start.sh

CMD ./server_start.sh
