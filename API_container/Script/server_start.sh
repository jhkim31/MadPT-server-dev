#!/bin/bash

while [ 1 ]
do
    pid=`ps -ef | grep "MadPtApi" | grep -v 'grep' | awk '{print $2}'`

    if [ -z $pid ]
    then
        java -jar /workspace/MadPtApi/build/libs/MadPtApi-MADPT_VERSION.jar
    fi
    sleep 2
done
