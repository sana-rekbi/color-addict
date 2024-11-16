# 🎨 Color Addict 

![Java](https://img.shields.io/badge/Language-Java-blue)
![Status](https://img.shields.io/badge/Status-Completed-green)
![License](https://img.shields.io/badge/License-MIT-yellow)

Par **REKBI Sana** / **EL BAKHTAOUI Wassim**

---

## 📋 Description
Color Addict est une application de jeu de cartes, développée en **Java**, inspirée du jeu populaire où les joueurs doivent associer les couleurs le plus rapidement possible. Ce projet a été conçu dans le cadre d'un projet académique pour mettre en œuvre des concepts d'**orienté objet** et d'**interfaces graphiques**.

---

## 🛠️ Architecture du Projet

L'application est construite en suivant une architecture modulaire pour assurer la réutilisabilité et la maintenabilité du code.

### 🗂️ Structure des Classes

- **`Carte.java`** : Modélise une carte avec ses caractéristiques (couleur, nom).
- **`Joueur.java`** : Représente un joueur, avec des actions comme jouer une carte ou piocher selon les règles.
- **`Jeu.java`** : Classe abstraite définissant les bases du jeu (gestion des piles de cartes, liste des joueurs, compteur de tours).
  - Méthodes abstraites à implémenter par des classes dérivées pour des règles spécifiques.
- **`Debutant.java`** : Hérite de `Jeu.java` et implémente des règles simplifiées (couleurs limitées).
- **`Initié.java`** : Étend `Jeu.java` pour des joueurs initiés avec des règles plus avancées.
- **`Confirmé.java`** : Implémente des règles pour joueurs confirmés, permettant à n'importe quel joueur de jouer dès qu'il le peut.
- **`InterfaceGraphique.java`** : Gère l'interface utilisateur avec des panneaux, boutons et interactions.

---

## 🚀 Fonctionnalités

- 🎮 **Modes de jeu** :
  - Niveau Débutant : Couleurs limitées (Rouge, Bleu, Jaune, Vert, Joker).
  - Niveau Initié : Toutes les couleurs disponibles.
  - Niveau Confirmé : Le plus rapide gagne.
- 🖥️ **Interface Utilisateur** :
  - **Fenêtre JFrame** avec panneaux pour les cartes, boutons, et scores.
  - **Interactions utilisateur** avec `JOptionPane` (saisie des noms des joueurs, affichage des règles).
  - **Tableau de scores** interactif (`JTable`) pour suivre les performances.

---

## 🛠️ Installation & Exécution

### 📦 Prérequis
- **Java JDK 17** ou supérieur
- **Maven** (optionnel pour la gestion des dépendances)


 

![image](https://github.com/sana-rekbi/color-addict/assets/138128268/bb1583f5-2c64-4c09-b2a4-b45164b0c976)

![image](https://github.com/sana-rekbi/color-addict/assets/138128268/6f762857-7839-42be-8835-fd468afc7d63)

![image](https://github.com/sana-rekbi/color-addict/assets/138128268/0acef057-cbe0-407e-93a5-ca9ba2adac1c)
![image](https://github.com/sana-rekbi/color-addict/assets/138128268/0feacc9f-0eea-40e1-b4d5-46b1a64b5b6d)
![image](https://github.com/sana-rekbi/color-addict/assets/138128268/c70b0e16-c727-4b12-b881-9f22a6a70f49)
![image](https://github.com/sana-rekbi/color-addict/assets/138128268/c3e54035-b078-48ed-9420-87e0ea1c2eed)


![image](https://github.com/sana-rekbi/color-addict/assets/138128268/af1793c2-29ce-4d1e-bb1b-228b4510d214)


