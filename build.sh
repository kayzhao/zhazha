#!/bin/sh
echo update source code...
git branch
git pull

echo stop application...

PID=$(ps -ef | grep wifetool.jar | grep -v grep | awk '{ print $2 }')
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
cd zhazha/target
nohup java -jar wifetool.jar &