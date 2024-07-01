# color-addict

Par REKBI SANA/ EL BAKHTAOUI WASSIM

Application de jeu de cartes "Color Addict", développée en Java.
	
Architecture du projet 


Pour ce projet, nous avons opté pour plusieurs différents modèles afin de constituer notre jeu Color Addict.

	1.	Carte.java : Modélise une carte avec ses caractéristiques telles que sa couleur et son nom.
	2.	Joueur.java : Classe correspondant à un joueur, permettant de jouer une carte et de piocher selon les règles.
	3.	Jeu.java : Classe abstraite pour modéliser le jeu. Elle gère les piles de cartes (pioche et milieu), la liste de joueurs, et le compteur de tours, avec des méthodes pour la gestion et des conditions d’arrêt du jeu. Les méthodes abstraites sont implémentées par des classes filles pour des règles spécifiques.
	4.	Debutant.java : Étend Jeu.java et définit les règles pour les débutants, avec un mélange limité aux couleurs Rouge, Bleu, Jaune, Vert et Joker.
	5.	Initié.java : Hérite de Jeu.java et définit les règles pour les initiés, sans limite de couleurs.
	6.	Confirmé.java : Hérite de Jeu.java et définit les règles pour les joueurs confirmés, où le premier qui peut jouer joue.
	7.	InterfaceGraphique.java : Gère l’interface utilisateur du jeu. Elle initialise une fenêtre principale JFrame avec différents panneaux JPanel pour les titres, cartes et boutons. Les boutons permettent de jouer, afficher les scores, quitter, choisir des niveaux et effectuer des actions spécifiques au jeu. La classe utilise des JOptionPane pour interagir avec l’utilisateur (demander les noms des joueurs, afficher des règles) et des ActionListener pour activer les boutons. Elle utilise JTable pour les scores, avec une méthode pour mettre à jour les scores selon les sanctions ou récompenses. Des boutons spécifiques (ButtonRegles, ButtonPiocher, ButtonclickCarte, ButtonDistribuerCartes, ButtonPause) déclenchent des actions propres : affichage des règles, pioche, distribution des cartes, etc.

![image](https://github.com/sana-rekbi/color-addict/assets/138128268/bb1583f5-2c64-4c09-b2a4-b45164b0c976)

![image](https://github.com/sana-rekbi/color-addict/assets/138128268/6f762857-7839-42be-8835-fd468afc7d63)

![image](https://github.com/sana-rekbi/color-addict/assets/138128268/0acef057-cbe0-407e-93a5-ca9ba2adac1c)
![image](https://github.com/sana-rekbi/color-addict/assets/138128268/0feacc9f-0eea-40e1-b4d5-46b1a64b5b6d)
![image](https://github.com/sana-rekbi/color-addict/assets/138128268/c70b0e16-c727-4b12-b881-9f22a6a70f49)
![image](https://github.com/sana-rekbi/color-addict/assets/138128268/c3e54035-b078-48ed-9420-87e0ea1c2eed)


![image](https://github.com/sana-rekbi/color-addict/assets/138128268/af1793c2-29ce-4d1e-bb1b-228b4510d214)


