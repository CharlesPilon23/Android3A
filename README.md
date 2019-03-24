# Projet Android 3A - SpaceX viewer
---

# Description du projet

Ce projet est un projet de troisième année d'école d'ingénieur (ESIEA). Il a pour but de faire **découvrir aux étudiants le développement android**. la consigne principale était d'utiliser une **RecyclerView** afin d'afficher les données d'une **API REST**. Étant passionné d'espace, j'ai choisi d'utiliser l'**API de SpaceX** *(disponible à cette adresse : https://api.spacexdata.com/v3/launches/).* 


# Consignes respectées
- **Récuparatuion des données d'une API REST** disponible sur internet
- **Stockage** des données dans un **modèle JAVA cohérent**
- Architecture **MVC**
- Affichage des données dans une **RecyclerView** avec un **Adapter**
- **Affichage d'images** récupérées via des liens dans l'API avec la bibliothèque **Picasso** *(disponible à cette adresse : http://square.github.io/picasso/)*
- Utilisation de **plusieurs activités** dont une affichant une **liste de données** et une autre affichant le **détail d'un objet de cette liste**.
- **Présence d'un cache** permettant un fonctionnement hors connexion
- Message **Toast** quand le téléphone se trouve déconnecté d'internet

# Foncitonnalités

L'application dispose de nombreuses fonctionnalités disponibles sur **3 activités distnctes** : **la page d'accueil**, la liste des **différentes missions de SpaceX** et l'écran de **détail de mission**. 

## Icone

l'icone de l'applicaiton est customisée afin de coller le plus possible à la charte graphique de cette dernière

<img src="https://github.com/CharlesPilon23/Android3A/blob/master/pictures_markdown/Icone.jpg" width="100"/>

## Écran d'accueil

Cet écran est celui par lequel l'utilisateur est accueilli lorsqu'il ouvre l'application, on peut y voir le nom de l'application. 


<img src="https://github.com/CharlesPilon23/Android3A/blob/master/pictures_markdown/Ecran_accueil.jpg" width="250"/>

En bas de cet écran se situent deux boutons :
- Le bouton avec le dessin d'enveloppe permet d'**envoyer un mail au créateur de l'application** afin d'envoyer d'éventuels retours

<img src="https://github.com/CharlesPilon23/Android3A/blob/master/pictures_markdown/Mail_1.jpg" width="250"/>

quand on clique dessus, un onglet s'ouvre en bas et l'**utilisateur est invité à choisir l'application à utiliser**. 

<img src="https://github.com/CharlesPilon23/Android3A/blob/master/pictures_markdown/Mail_2.jpg" width="250"/>

On peut prendre par exemple Gmail, l'**application se lance** et le champ d'adresse se retrouve alors **automatiquement rempli** et l'utilisateur n'a plus qu'à tapper son message. 

<img src="https://github.com/CharlesPilon23/Android3A/blob/master/pictures_markdown/Mail_3-1.jpg" width="250"/>

- Le bouton entrer permet de **lancer la seconde activité** initialisant la connexion avec l'API Rest

## Liste des missions

La secone activité a pour objectif de récupérer les données obtenues via un appel à une API Rest afin de les afficher sous la forme d'une liste en utilisant la RecyclerView et un Adapter.

<img src="https://github.com/CharlesPilon23/Android3A/blob/master/pictures_markdown/Liste_1.jpg" width="250"/> <img src="https://github.com/CharlesPilon23/Android3A/blob/master/pictures_markdown/Liste_2.jpg" width="250"/>

Chaque mission est symbolisée par son logo, récupéré via le lien disponible dans l'API et affiché par **Picasso**, ainsi que par son numéro de mission, son nom et son année de lancement. 

En cliquant sur une mission, on accède à son écran détail *(décrit ci-après)*

## Écran de détail

Cet écran a pour but d'afficher les détails relatifs à chaque mission.

<img src="https://github.com/CharlesPilon23/Android3A/blob/master/pictures_markdown/Detail.jpg" width="250"/>

On peut y voir le logo de la mission affiché en grand ainsi que les détails du vol. 

En bas de page, un bouton permet de lancer une activité navigateur internet pointant vers l'adresse de la vidéo youtube du vol de la fusée. 

<img src="https://github.com/CharlesPilon23/Android3A/blob/master/pictures_markdown/Youtube.jpg" width="250"/>

## Conclusion

Ce projet m'a permi de découvrir la programmation mobile et de me familiariser avec les outils de développement associés. Il a enfin été mon premier gros projet de programmation orienté objet et m'a permi de mettre en pratique ces concepts vus en cours.


