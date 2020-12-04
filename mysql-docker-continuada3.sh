#!/bin/bash

sudo apt-get install docker.io
sudo systemctl start docker
sudo systemctl enable docker

sudo docker pull mysql
sudo docker run -d -p 3306:3306 -e"MYSQL_ROOT_PASSWORD=bandtec" mysql
sudo docker exec -it $(sudo docker ps -a -q) bash
