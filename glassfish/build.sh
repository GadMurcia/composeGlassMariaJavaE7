#/bin/bash
source docker.conf
echo $DOCKER_NOMBRE
docker build -t $DOCKER_NOMBRE .
