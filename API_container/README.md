# madPT Database Container

## 사용방법

### 1. Dockerhub 다운로드

```bash
#생략가능
docker pull jhkimdocker/api_test_image

docker run -d -p 8080:8080 --name {cname} jhkimdocker/api_test_image

# cli 접근
docker exec -it {cname} bash
```

### 2. build 해서 사용

```bash
#생략가능
docker build -t {image_name} .

docker run -d -p 8080:8080 --name {cname} {image_name}

# cli 접근
docker exec -it {cname} bash
```

## Dockerfile
sprint boot 프로젝트를 `spring_boot_data` 디렉토리로 넣어준다.  
해당 디렉토리를 docker 컨테이너 내부로 카피하여,  
내부에서 빌드 진행.

~이후 컨테이너 실행시 ENTRYPOINT를 통해 빌드된 jar 파일 실행.~
현재는 ENTRYPOINT를 비워둠
