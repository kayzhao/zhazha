#!/bin/sh
echo update source code...
git branch
git pull

echo stop application...
PID=$(ps -ef | grep wifetool-0.0.1.jar | grep -v grep | awk '{ print $2 }')
if [ -z "$PID" ]
then
    echo application is already stopped.
else
    echo killing $PID.
    kill $PID
    echo done.
fi

echo package application...
mvn clean install -DskipTests

echo start application...
cd target
nohup java -Djava.io.tmpdir=/root/kayzhao/tmpwife/ -jar wifetool-0.0.1.jar &
tail -f nohup.out
