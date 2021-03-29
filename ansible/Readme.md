# Ansible

### <span style="color:red">*Attention l'inventory est sur le serveur de production !!*</br>*Ne faites pas vos tests dessus !!*</br>*Il faut changer l'adresse ip du serveur pour la remplacer avec un serveur dédié au tests*</span>

Test de connectivite sur les remotes

```shell
ansible -m ping -i configuration/.inventory filrougeservers
```

Le test fail, c'est normal, votre machine ne connais pas les remotes et refuse la connection.  
Lors du ping, il vous sera proposé d'ajouter l'adresse des remotes aux hosts connus par votre machine.  
Faites 'yes' pour les ajouter

Vous pouvez ensuite vérifier de nouveau le ping avec l'option -kK pour vous identifier

```shell
ansible -m ping -i configuration/.inventory filrougeservers -kK
```

Si success, vous pouvez lancer le playbook pour provisionner les remotes

```shell
ansible-playbook -i configuration/.inventory -kK playbook.yml
```

## Sécuriser DokuWiki

Une fois tout installé, il faut parametrer le Wiki en ajoutant un superUser.  
Pour ce faire, allez sur l'url ci-dessous en adaptant l'adresse à votre serveur :

http://ipServeur:8081/install.php

Options à régler : 

- Mettre le wiki en privé
- Ne pas permettre l'inscription
- Ne pas envoyer de données vers dokuwiki

Le reste dépend de vos besoins.  

[//]: # (todo supression des -kK avec vault + schema taches + dependances)