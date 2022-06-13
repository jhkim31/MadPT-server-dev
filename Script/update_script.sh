#!/bin/bash

kubectl set image deployment/get-api-deployment get-api=jhkimdocker/capstone_get_api_image:MADPT_VERSION
kubectl set image deployment/post-api-deployment post-api=jhkimdocker/capstone_post_api_image:MADPT_VERSION
