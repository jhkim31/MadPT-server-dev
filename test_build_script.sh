#!/bin/zsh

docker build -f DB_container/Dockerfile . -t db_test_image
docker build -f API_container/Dockerfile . -t api_test_image

docker run -p 8080:8080 api_test_image
docker run -p 3306:3306 db_test_image



