#!/bin/bash
which java | grep -q /usr/bin/java
if [[ $? = 0  ]]
	then
	echo executando a aplicação java
	java -jar continuada-3.jar
else
	echo instalando o java
	sudo apt install zip curl
	curl -s "https://get.sdkman.io" | bash
	source "$HOME/.sdkman/bin/sdkman-init.sh"
	sdk install java 11.0.9.j9-adpt
	echo executando a aplicação java
	java -jar continuada-3.jar
fi
