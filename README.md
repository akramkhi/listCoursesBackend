
Shopshop est une API REST de gestion de listes de courses. Elle permet de :
- Préparer la liste des articles constituant une liste de course, avant d'aller en magasin pour les acheter,
- Pendant la collecte des articles en magasin : Distinguer les articles collectés des articles à récupérer.

### Entités

Une liste de courses se caractérise par :
- Une date de création ;
- La liste des articles la constituant ;
- Un statut pouvant prendre les valeurs "vide", "complète" ou "en cours" ;

Un article se caractérise par :
- Un libellé ;
- Le nombre d'exemplaires attendu, égal à 1 par défaut ;
- Un statut prenant la valeur "à prendre" par defaut, ou "collecté".

Le statut de la liste de course est déterminé par le statut des articles la constituant :
- S'il n'y a aucun article dans la liste de courses, son statut est "vide" ;
- Si tous les articles ont le statut "collecté", alors la liste de course a le statut "complète" ; 
- Sinon, la liste de course a le statut "en cours".

Il n'est pas possible de modifier directement le statut d'une liste de course.


### Fonctionnalités offertes

L'API REST doit proposer les fonctionnalités suivantes :
- Création d'une nouvelle liste de course vide ;
- Ajout / Suppression d'articles sur une liste de courses ;
- Modification des caractéristiques des articles d'une liste, en particulier des statuts ;
- Consultation d'une liste de course ;

La suppression d'une liste de course n'est pas attendue.

### Gestion des accès concurrents

L'API doit assurer la cohérence des données en cas d'accès concurrent.

Ainsi par exemple, si deux utilisateurs tentent de modifier le statut d'un article en même temps, l'API doit avoir un comportement cohérent. L'objectif ici est d'éviter que deux personnes traitant la même liste de course dans deux magasins simultanéement ne collectent des articles en double.

Si vous n'avez pas le temps d'adresser cette problématique présentez une solution théorique dans l'email de réponse.