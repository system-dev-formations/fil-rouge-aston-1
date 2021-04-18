# Vagrant
## Prerequis

- Vagrant v2.2.15
- VirtualBox v6.1

## Description

Ce système permet d'installer et provisionner une VM virtualBox avec Linux Mint 20 Cinnamon et les outils utilisés lors du projet.  
Il s'agit d'un environnement de developpement à destination des collaborateurs qui travaillent sur le projet avec Windows.  

## Mise en place

Téléchargez et installez vagrant depuis leur site officiel. (https://www.vagrantup.com/)

Créez un repertoire sur votre poste et placez y le fichier 'Vagrantfile' et le repertoire scripts avec son contenu.  
Ouvrez un terminal à la racine du Vagrantfile et lancez la commande : 

```shell
vagrant up
```

Lors de la premiere utilisation, vagrant se chargera de telecharger et d'installer tout le systeme à destination de votre VM.  
Puis il la créera dans VirtualBox et installera dans celle-ci tous les outils présent dans le script setup.sh.  
Le temps d'installation est assez long.  

La boxe vagrant utilisé pour l'installation de l'OS a été créée et déposée dans le vagrant cloud spécifiquement par le groupe de ce projet.  
Il s'agit de la boxe groupe2-devOps/Mint-20-cinna-64  

Une fois l'installation terminée, vous pouvez vous loggez dans votre VM avec les identifiants vagrant/vagrant.  

La commande vagrant up ne provisionnera votre VM que la premiere fois.  
Les fois suivante, elle se contentera de lancer votre VM et prendra donc très peu de temps à s'executer.  

Si vous voulez rajouter des choses dans le scripts pour convenir à vos besoins, il faudra relancer le provisionnement avec la commande suivante : 

```shell
vagrant up --provision
```
