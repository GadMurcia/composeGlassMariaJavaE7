#/bin/bash

source docker.conf


docker run -p 4848:4848 -p 8080:8080 -p 8181:8181 -p 9009:9009 --rm --name glasscompose -it $DOCKER_NOMBRE

