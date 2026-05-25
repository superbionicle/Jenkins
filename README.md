# Jenkins

# Monitoring Glance
Pour permettre à Glance de faire le monitoring :
Dans "Security", cocher "Allow anonymous read access"

# Mise en place d'un agent
Source : https://www.jenkins.io/doc/book/using/using-agents/

Créer une clef SSH avec la commande `ssh-keygen -f ~/.ssh/jenkins_agent_key` (ou tout autre endroit différent de ~/.ssh/ pour stocker la clef).
Dans Jenkins, ajouter un nouveau credentials de type "SSH Username with private key", renseigner `jenkins` comme ID et y renseigner notamment la clef SSH privée.
Ajouter le contenu de `agent-jenkins.yml` dans le `docker-compose.yml` et démarrer le conteneur.

> Remarque : dans `SSH_AGENT_KEY`, ne pas mettre le contenu de `~/.ssh/jenkins_agent_key` mais celui de `~/.ssh/jenkins_agent_key.pub` et n'oubliez pas de mettre les "" pour prévenir des erreurs avec les espaces

Dans les paramètres, aller dans "Nodes" et "New node" pour créer un agent.
Dans les informations importantes à remplir, mettre `/home/jenkins` dans "Répertoire de travail du système distant" et sélectionner "Launch agent via SSH" pour la méthode de lancement, puis renseigner la valeur du "Host" et sélectionner les credentials précédemment créés et mettre "Manually trusted key Verification Strategy" pour "Host Key Verification Strategy".

> Il ne faut pas mettre `localhost` comme valeur puisqu'il correspond au localhost du conteneur Jenkins, et non au localhost de la machine qui héberge tous les conteneurs

> Attention : si comme dans le [agent-jenkins.yml](/files/agent-jenkins.yml), vous avez indiqué un port autre que le 22, il faudra cliquer sur "Avancés dans les paramètres afin de pouvoir préciser le port, et non pas le mettre directement dans le champ "Host"

Valider les modifications. Dans le panneau à gauche, cliquer sur "Trush SSH Host Key" puis cliquer sur "Launch agent".
Dans les noeuds, sélectionner "Contrôleur" puis choisissez "Réserver ce noeud uniquement pour les jobs qui lui sont attachés" pour "Utilisation".

# Mise en place du lien avec le repo Github
## Création d'un premier job
Dans "Nouvel Item", créer un nouveau job "Pipeline".
Dans la configuration de ce job, descendre au niveau de "Pipeline" et dans "Definition", sélectionner "Pipeline script from SCM".
Dans "SCM", sélectionner "Git" puis mettre le lien de votre repo dans "Repository URL". Aucun credential n'est requis.

> Attention : il faut que le repo soit en public

Dans "Banch Specifier", saisir la branche désirée.

> Attention : la branche par défaut créée par Github est `main` et non `master`

Dans "Script Path", saisir `pipelines/script.groovy`, où `script.groovy` est le script à utiliser dans la pipeline.
Si le job est lancé, il tombera en échec car la library *jenkins-shared-libs* n'est pas encore configuré sur le Jenkins.

## Création d'une library
Dans "System", descendre jusque "Global Trusted Pipeline Libraries".
Renseigner `jenkins-shared-libs` dans "Name".
Choisir "Modern SCM" pour "Retrievak method" et "Github" pour "Source Code Management".

> Attention : de la même manière que le repo Jenkins doit être en public, le jenkins-shared-libs doit également être en public
> Des credentials sont recommandées mais non nécessaires pour cela.

