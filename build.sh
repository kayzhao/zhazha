#!/bin/sh
echo update source code...
git branch
git pull

echo stop application...

JAR_FILE = "wifetool-0.0.1.jar"
PID=$(ps -ef | grep ${JAR_FILE} | grep -v grep | awk '{ print $2 }')
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
nohup java -jar ${JAR_FILE} &