#!/bin/bash
ls
docker pull jhkimdocker/capstone_api_image:MADPT_VERSION
docker pull jhkimdocker/capstone_db_image:MADPT_VERSION

docker stop $(docker ps -aq -f=name=api_)
docker stop $(docker ps -aq -f=name=db_)

docker run -d -p 3306:3306 --name db_MADPT_VERSION jhkimdocker/capstone_db_image:MADPT_VERSION
docker run -d -p 8080:8080 --name api_MADPT_VERSION -it jhkimdocker/capstone_api_image:MADPT_VERSION bash

