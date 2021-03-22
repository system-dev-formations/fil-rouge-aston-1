#!/bin/bash

GREEN='\e[32m'
NC='\033[0m'

checkInstall() {
  if ! command --version "$1" &> /dev/null
  then
      return 1
  fi
  return 0
}

echo -e "${GREEN}Provisioning virtual machine...${NC}"

# Suppression d'un fichier Mint qui empeche d'installer snap
if [[ -f /etc/apt/preferences.d/nosnap.pref ]]
then
  sudo rm -rf /etc/apt/preferences.d/nosnap.pref
fi

# Update
echo -e "${GREEN}Updating${NC}"
sudo apt update

# Basic packages
if ! [[ -d /usr/share/doc/apt-transport-https/ ]]
then
  echo -e "${GREEN}Installing apt-transport-https${NC}"
  sudo apt-get -y install apt-transport-https
fi
if ! [[ -d /etc/ca-certificates/ ]]
then
  echo -e "${GREEN}Installing ca-certificates${NC}"
  sudo apt-get -y install ca-certificates
fi
if checkInstall curl
then
  echo -e "${GREEN}Installing curl${NC}"
  sudo apt-get -y install curl
fi
if ! [[ -d /usr/share/doc/gnupg-agent/ ]]
then
  echo -e "${GREEN}Installing gnupg-agent${NC}"
  sudo apt-get -y install gnupg-agent
fi
if ! [[ -d /usr/share/doc/software-properties-common/ ]]
then
  echo -e "${GREEN}Installing software-properties-common${NC}"
  sudo apt-get -y install software-properties-common
fi

# SNAP
if checkInstall snap
then
  echo -e "${GREEN}Installing Snap${NC}"
  sudo apt install snapd
fi

# GIT
if checkInstall git
then
  echo -e "${GREEN}Installing Git${NC}"
  sudo add-apt-repository -y ppa:git-core/ppa
  sudo apt update
  sudo apt install git -y
fi

# JAVA
if checkInstall java
then
  echo -e "${GREEN}Installing Java${NC}"
  sudo add-apt-repository -y ppa:openjdk-r/ppa
  sudo apt-get update
  sudo apt install openjdk-11-jdk -y
fi

# INTELLIJ

if ! [[ -d /snap/intellij-idea-community ]]
then
  echo -e "${GREEN}Installing IntelliJ${NC}"
  sudo snap install intellij-idea-community --classic
fi

# WGET
if checkInstall wget
then
  echo -e "${GREEN}Installing Wget${NC}"
  sudo apt-get -y install wget
fi

# LOMBOK
if ! [[ -f /home/vagrant/lombok.jar ]]
then
  echo -e "${GREEN}Installing lombok${NC}"
  wget https://projectlombok.org/downloads/lombok.jar -q
fi

# VSCODE

if checkInstall code
then
  echo -e "${GREEN}Installing Visual Studio Code${NC}"
  sudo snap install code --classic
fi

# OHMYZSH
if checkInstall zsh
then
  echo -e "${GREEN}Installing OhMyZsh${NC}"
  sudo apt-get -y install zsh
  sudo chsh -s /usr/bin/zsh "$USER"
  wget https://github.com/robbyrussell/oh-my-zsh/raw/master/tools/install.sh -O - | zsh
  cp ~/.oh-my-zsh/templates/zshrc.zsh-template ~/.zshrc
  source ~/.zshrc
fi

# DOCKER
if checkInstall docker
then
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
fi

# BRAVE
if ! [[ -d /snap/brave/ ]]
then
  echo -e "${GREEN}Installing Brave Browser${NC}"
  sudo snap install brave
fi

# CHROME
if checkInstall google-chrome
then
  echo -e "${GREEN}Installing Chrome Browser${NC}"
  wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb -q
  sudo apt install ./google-chrome-stable_current_amd64.deb -y
fi

# DBEAVER
if ! [[ -d /snap/dbeaver-ce/ ]]
then
  echo -e "${GREEN}Installing DBeaver${NC}"
  sudo snap install dbeaver-ce
fi

# POSTGRES
if checkInstall psql
then
  echo -e "${GREEN}Installing PostgreSQL${NC}"
  sudo apt install postgresql postgresql-contrib -y
fi

# POSTMAN
if ! [[ -d /snap/postman/ ]]
then
  echo -e "${GREEN}Installing Postman${NC}"
  sudo snap install postman
fi

# ANGULAR
if checkInstall ng
then
  echo -e "${GREEN}Installing Angular${NC}"
  curl -L https://deb.nodesource.com/setup_14.x | bash
  sudo apt install nodejs -y
  npm install npm@latest -g
  npm install -g @angular/10
fi

# ANSIBLE
if checkInstall ansible
then
  echo -e "${GREEN}Installing Ansible${NC}"
  sudo apt install ansible -y
fi
