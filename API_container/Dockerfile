FROM openjdk:11

RUN --mount=type=secret,id=github_token \
  ls

RUN --mount=type=secret,id=MADPT_VERSION \
  export VERSION=$(cat /run/secrets/MADPT_VERSION)


RUN apt-get update -y
RUN apt-get upgrade -y
RUN apt-get install vim -y
RUN sed -i "s/MADPT_VERSION/$VERSION/g" ./API_container/MadPtApi/build.gradle
RUN sed -i "s/MADPT_VERSION/$VERSION/g' ./API_container/MadPtApi/src/main/resources/application.yml
RUN sed -i "s/MADPT_VERSION/$VERSION/g' ./API_container/Script/server_start.sh

COPY ./API_container/MadPtApi/ /workspace/MadPtApi
COPY ./API_container/Script /script


WORKDIR /workspace/MadPtApi

RUN ls
RUN chmod 755 gradlew 
RUN ./gradlew build

CMD /script/server_start.sh
