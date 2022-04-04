FROM openjdk:11

COPY ./API_container/MadPtApi/ /workspace/MadPtApi

RUN apt-get update -y
RUN apt-get upgrade -y
RUN apt-get install vim -y

WORKDIR /workspace/MadPtApi
RUN ls

RUN chmod 755 gradlew 
RUN ./gradlew build

WORKDIR ./build/libs

