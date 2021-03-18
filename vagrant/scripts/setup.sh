#!/bin/bash

GREEN='\e[32m'
NC='\033[0m'

echo -e "${GREEN}Provisioning virtual machine...${NC}"

# Update
echo -e "${GREEN}Updating${NC}"
sudo apt-get update

# Suppression d'un fichier Mint qui empeche d'installer snap
sudo rm -rf /etc/apt/preferences.d/nosnap.pref

sudo apt update

sudo apt-get -y install apt-transport-https ca-certificates curl gnupg-agent software-properties-common

# SNAP
echo -e "${GREEN}Installing Snap${NC}"
sudo apt install snapd

# GIT
echo -e "${GREEN}Installing Git${NC}"
sudo add-apt-repository -y ppa:git-core/ppa
sudo apt update
sudo apt install git -y

# JAVA
sudo add-apt-repository -y ppa:openjdk-r/ppa
sudo apt-get update
sudo apt install openjdk-11-jdk -y

# INTELLIJ
echo -e "${GREEN}Installing IntelliJ${NC}"
sudo snap install intellij-idea-community --classic

# WGET
echo -e "${GREEN}Installing Wget${NC}"
sudo apt-get -y install wget

# LOMBOK
echo -e "${GREEN}Installing lombok${NC}"
wget https://projectlombok.org/downloads/lombok.jar

# VSCODE
echo -e "${GREEN}Installing Visual Studio Code${NC}"
sudo snap install code --classic

# OHMYZSH
sudo apt-get -y install zsh
sudo chsh -s /usr/bin/zsh "$USER"
wget https://github.com/robbyrussell/oh-my-zsh/raw/master/tools/install.sh -O - | zsh
cp ~/.oh-my-zsh/templates/zshrc.zsh-template ~/.zshrc
source ~/.zshrc

# DOCKER
echo -e "${GREEN}Installing Docker${NC}"
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
echo -e "${GREEN}Installing Brave Browser${NC}"
sudo snap install brave

# CHROME
echo -e "${GREEN}Installing Chrome Browser${NC}"
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo apt install ./google-chrome-stable_current_amd64.deb -y

# DBEAVER
echo -e "${GREEN}Installing DBeaver${NC}"
sudo snap install dbeaver-ce

# POSTGRES
echo -e "${GREEN}Installing PostgreSQL${NC}"
sudo apt install postgresql postgresql-contrib -y

# POSTMAN
echo -e "${GREEN}Installing Postman${NC}"
sudo snap install postman

# ANGULAR
echo -e "${GREEN}Installing Angular${NC}"
curl https://raw.githubusercontent.com/creationix/nvm/master/install.sh | bash
source ~/.bashrc
nvm install node
npm install -g @angular/cli

# ANSIBLE
echo -e "${GREEN}Installing Ansible${NC}"
sudo apt install ansible -y