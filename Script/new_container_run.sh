#!/bin/bash

docker run -d -p 8080:8080 --name api_MADPT_VERSION jhkimdocker/capstone_api_image:MADPT_VERSION
docker run -d -p 3306:3306 --name db_MADPT_VERSION jhkimdocker/capstone_db_image:MADPT_VERSION
