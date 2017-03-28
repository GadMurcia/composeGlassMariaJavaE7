#/bin/bash

source docker.conf


docker run -it --rm -p 3304:3306 --name mariacompose $DOCKER_NOMBRE 

