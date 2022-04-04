# madPT API Container

## 사용방법
https://hub.docker.com/repository/docker/jhkimdocker/capstone_api_image
### 1. Dockerhub 다운로드

```bash
#생략가능
docker pull jhkimdocker/capstone_api_image

docker run -d -p 8080:8080 --name {container_name} jhkimdocker/capstone_api_image

# cli 접근
docker exec -it {container_name} bash

# jar파일 실행
# /workspace/build/libs 디렉토리에 존재
# java -jar {filename.jar}
```


## Dockerfile
sprint boot 프로젝트를 `spring_boot_data` 디렉토리로 넣어준다.  
해당 디렉토리를 docker 컨테이너 내부로 카피하여,  
내부에서 빌드 진행.

~이후 컨테이너 실행시 ENTRYPOINT를 통해 빌드된 jar 파일 실행.~  
현재는 ENTRYPOINT를 비워둠
