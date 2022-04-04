# madPT Database Container

## 사용방법
https://hub.docker.com/repository/docker/jhkimdocker/capstone_db_image

### 1. Dockerhub 다운로드

```bash
docker pull jhkimdocker/capstone_db_image

docker run -d -p 3306:3306 --name {container_name} jhkimdocker/db_test_image

# cli 접근 (선택)
docker exec -it {container_name} bash
```

## Dockerfile
세팅할 DB를 data 디렉토리에 넣으면, 해당 sql 파일을  
docker 컨테이너 내부 docker-entrypoint-initdb.d 디렉토리로 추가
이후 해당 디렉토리 내부에 있는 sql 파일은 빌드시 import 된다.

