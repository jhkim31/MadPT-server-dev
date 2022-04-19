#!/bin/bash
pn=$(ps -ef | grep -v "grep" | grep mysqld | wc -l)
if [ $pn -eq "1" ]
then
        mysqldump -uroot -p1234 --databases MadPT > /backup/MadPT$(date +%Y-%m-%dT%H:%M).sql
fi