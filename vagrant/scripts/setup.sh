#!/bin/bash

GREEN='\e[32m'

echo -e "${GREEN}"Provisioning virtual machine...

# Update
echo -e "${GREEN}"Updating
sudo apt-get update

# Suppression d'un fichier Mint qui empeche d'installer snap
sudo rm -rf /etc/apt/preferences.d/nosnap.pref

sudo apt update

sudo apt-get -y install apt-transport-https ca-certificates curl gnupg-agent software-properties-common

# SNAP
echo -e "${GREEN}"Installing Snap
sudo apt install snapd

# GIT
# shellcheck disable=SC2086
echo -e ${GREEN}Installing Git
sudo add-apt-repository -y ppa:git-core/ppa
sudo apt update
sudo apt install git -y

# JAVA
sudo add-apt-repository -y ppa:openjdk-r/ppa
sudo apt-get update
sudo apt install openjdk-11-jdk -y

# INTELLIJ
echo -e "${GREEN}"Installing IntelliJ
sudo snap install intellij-idea-community --classic

# WGET
echo -e "${GREEN}"Installing Wget
sudo apt-get -y install wget

# LOMBOK
echo -e "${GREEN}"Installing lombok
wget https://projectlombok.org/downloads/lombok.jar

# VSCODE
echo -e "${GREEN}"Installing Visual Studio Code
sudo snap install code --classic

# OHMYZSH
sudo apt-get -y install zsh
sudo chsh -s /usr/bin/zsh "$USER"
wget https://github.com/robbyrussell/oh-my-zsh/raw/master/tools/install.sh -O - | zsh
cp ~/.oh-my-zsh/templates/zshrc.zsh-template ~/.zshrc
source ~/.zshrc

# DOCKER
echo -e "${GREEN}"Installing Docker
# Before installing Docker Engine for the first time on a new host machine,
# you need to set up the Docker repository
# Add Docker’s official GPG key:
curl -L https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(. /etc/os-release; echo "$UBUNTU_CODENAME") stable"
sudo apt-get update
sudo apt-get -y install docker-ce docker-ce-cli containerd.io
sudo usermod -aG docker "$USER"
newgrp docker

# BRAVE
echo -e "${GREEN}"Installing Brave Browser
sudo snap install brave

# CHROME
echo -e "${GREEN}"Installing Chrome Browser
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo apt install ./google-chrome-stable_current_amd64.deb -y

# DBEAVER
echo -e "${GREEN}"Installing DBeaver
sudo snap install dbeaver-ce

# POSTGRES
echo -e "${GREEN}"Installing PostgreSQL
sudo apt install postgresql postgresql-contrib

# POSTMAN
echo -e "${GREEN}"Installing Postman
sudo snap install postman

# ANGULAR
echo -e "${GREEN}"Installing Angular
curl https://raw.githubusercontent.com/creationix/nvm/master/install.sh | bash
source ~/.bashrc
nvm install node
npm install -g @angular/cli

# ANSIBLE
echo -e "${GREEN}"Installing Ansible
sudo apt install -y ansible