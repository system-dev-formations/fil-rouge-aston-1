# Sauvegarde du dokuWiki vers Google drive
## Prerequis

- RClone v1.54.1
- Configurer RClone

## Description

Ce systeme permet de faire une back-up quotidienne de votre wikipedia personnel vers un repertoire Google Drive.  

Il contient :
- Un script qui compresse le repertoire contenant les données de votre wiki, puis envoi l'archive datée vers votre google drive.  
- Une cron expression permettant de lancer le script à 21h00 quotidiennement, disponible dans la partie 'Mise en place' de ce Readme

## Configurer RClone

Il s'agit d'une configuration de base, vous pouvez l'adapter à vos besoins si nécessaire.

Aller sur https://console.cloud.google.com, loggez vous sur votre compte google qui recevra les fichiers.  
Dans le menu, allez sur “APIs & Services” → “Bibliotheque”  
Recherchez Google Drive API et activé le.  
Allez ensuite dans “Identifiant”, cliquez sur créer des identifiants → IDClient OAuth.  
Vous devez Créer un nom de produit, puis dans la création d'identifiants, choisir “Ordinateur de Bureau”  
Saisissez un nom pour les identifiants, et cliquez sur créer.  
A ce stade, une fenetre apparait avec un Id et un code secret qui seront utilisés pour la configuration du serveur.  

Ensuite, il faut configurer OAuth.  
Allez sur “Ecran d'autorisation OAuth” dans le menu et configurer comme ci dessous :  
- Type d'utilisateur : Externe
- Nom de l'application : rclone
- Adresse e-mail d'assistance utilisateur : Votre adresse gmail
- Edit
- Configurer le serveur

Pour transferer vos documents/repertoires dans googleDrive, il faut configurer rClone et lui donner les identifiants récupérés à l'etape precedante.

Sur le serveur :  

```shell
rclone config
```

Des questions vont vous etre posés, entrer les valeur suivantes :  

- 'n' pour ajouter une remote
- name : gdrive
- Dans la liste proposé, choisir le numero correspondant à GoogleDrive
- Entrer l'ID client récupéré à l'étape precedente
- scope : 1 ⇒ Acces complet au fichiers sauf repertoire appData
- root_folder_id : laisser blanc
- service_account_file: laisser blanc
- edit advanced config : 'n'
- remote config use auto config: 'n'

Allez sur le lien généré pour terminer le process d'authentification  

Retourner sur le serveur pour finir la configuration rclone  

- team drive : 'n'
- 'y' pour confirmer que tous est ok
- 'q' pour terminer

Maintenant, il faut tester si la connection se fait bien.  
Mettez un ficier dans votre googleDrive  
Lancer la commande :

```shell
rclone ls gdrive:/  
```

Si liste des fichiers présent dans votre Drive s'affiche, votre configuration est bonne et vous pouvez passer à la suite.

## Mise en place

<span style="color:red">Attention vérifiez bien que les chemins dans le script et la cron expression correspondent aux votre.</br>Si ce n'est pas le cas, changez les en conséquence.</span>

Placer le script 'save.sh' dans le home directory de votre serveur.  

Donnez les droits d'execution du script à l'utilisateur qui correspond (ubuntu dans notre cas)

```shell
chmod 110 save.sh
```

Ensuite, ouvrez la cronTab de votre utilisateur : 

```shell
crontab -e  
```

Enfin, copiez l'expression suivante à la fin :

```shell
00 21   * * *   /bin/bash /home/ubuntu/save.sh > /home/ubuntu/saveWiki.log
```

Votre script sera executé tout les jours à 21h00.  
Les logs de l'execution du script seront inscrits dans un fichier saveWiki.log et ceux du transfert vers googleDrive dans un fichier gdrive-transfert.log.
