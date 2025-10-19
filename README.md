# Blood Bank Management System


## 📄 Description

Le **Système de Gestion de Banque de Sang** est une application web monolithique développée en **Java EE/Jakarta EE**, utilisant **Servlets**, **JSP**, **Hibernate**, et **PostgreSQL**.  

Elle permet de gérer efficacement les **donneurs**, **receveurs**, et l’**association automatique ou manuelle** selon la compatibilité sanguine et l’urgence médicale.  

L’application facilite la gestion des transfusions, réduit les erreurs manuelles et permet une priorisation des cas critiques.

---

## 🏗️ Technologies utilisées

- **Back-end** : Java EE / Jakarta EE, Servlets, Hibernate  
- **Front-end** : JSP, JSTL, Bootstrap 5  
- **Base de données** : PostgreSQL  
- **Build et dépendances** : Maven  
- **Pattern** : DAO, Service Layer  

---

## ⚙️ Installation et configuration

1. **Cloner le projet**

git clone https://github.com/NadaZirari/Gestion_banque_sang.git

 Configurer PostgreSQL

Créer la base : bloodbankdb2

Créer un utilisateur avec mot de passe nada123

Importer les tables via SQL (Donneur, Receveur, Association)

Configurer le projet

Modifier hibernate.cfg.xml ou persistence.xml :

<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/bloodbankdb2</property>
<property name="hibernate.connection.username">postgres</property>
<property name="hibernate.connection.password">nada123</property>
<property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>


Ouvrir dans Eclipse/IntelliJ

JDK 17+

Tomcat 10+

Build Maven : mvn clean install

Déployer sur Tomcat

Accéder à : http://localhost:8080/BloodBankManagement/


## 🧩 Fonctionnalités
Donneurs

Ajouter, modifier, supprimer

Statut : DISPONIBLE / NON_DISPONIBLE

Visualisation de tous les donneurs

Receveurs

Ajouter, modifier, supprimer

Situation médicale : CRITIQUE / URGENT / NORMAL

État : EN_ATTENTE / SATISFAIT

Liste triée selon priorité médicale

Association Donneur – Receveur

Compatibilité sanguine automatique

Association manuelle possible

Mise à jour automatique du statut du donneur et de l’état du receveur

Liste des donneurs compatibles pour chaque receveur

Interface Utilisateur

JSP + Bootstrap responsive

Badges colorés pour situations et états

Formulaires simples pour ajouter et associer


## 📂 Structure du projet
BloodBankManagement/
│
├─ src/main/java/
│   ├─ model/        # Donneur, Receveur, Association, Enums
│   ├─ dao/          # Data Access Objects
│   ├─ service/      # Logique métier
│   └─ servlet/      # Servlets de contrôle
│
├─ src/main/webapp/
│   ├─ index.jsp
│   ├─ receveurForm.jsp
│   ├─ listeReceveurs.jsp
│   ├─ association.jsp
│   └─ css/          # Styles optionnels
│
├─ pom.xml
└─ README.md

 
## 🔗 URLs utiles
Fonctionnalité	URL
Accueil	/BloodBankManagement/
Liste des receveurs	/BloodBankManagement/receveur
Formulaire ajout receveur	/BloodBankManagement/receveur?action=form
Associer un donneur	/BloodBankManagement/association?receveurId=1

## 💡 Bonnes pratiques

Servlets pour le contrôleur

JSP + JSTL pour les vues

Enum pour situations médicales

DAO pour l’accès aux données et Service Layer pour la logique

Vérification du statut du donneur et de l’état du receveur avant association

##  DIAGRAMME DE CLASSE
