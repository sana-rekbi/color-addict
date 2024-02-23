# color-addict
Application de jeu de cartes "Color Addict", développée en Java.
	
Architecture du projet 


Pour ce projet, nous avons opté pour plusieurs différents modèles afin de constituer notre jeu Color Addict.
Carte.java, qui correspond tout simplement à une carte avec ses caractéristiques telles que sa couleur et son nom.
Joueur.java, classe correspondant à un joueur. Cet objet permet au joueur de jouer sa carte en main en respectant les règles ainsi que de piocher une carte.
Jeu.java, classe abstraite conçue pour modéliser le jeu. Elle possède des piles de cartes, un pour la pioche et un autre pour les cartes au milieu, une liste de joueurs et un compteur de tours. Elle offre des méthodes pour la gestion du jeu (par exemple le mélange des cartes, la distribution des cartes aux joueurs) et des conditions pour arrêter le jeu. De plus elle possède des méthodes abstraites qui sont destinées à être implémentées par des classes filles pour des règles spécifiques de jeux de cartes.
Debutant.java, classe qui étend Jeu.java. Elle définit les règles spécifiques pour les débutants, le mélange des cartes est limité aux couleurs Rouge, Bleu, Jaune, Vert et Joker.
Initié.java, classe qui hérite de Jeu.java. Elle définit les règles spécifiques pour les initiés et le mélange des cartes n’a plus de limite, toutes les couleurs sont utilisées.
Confirmé.java, classe qui hérite de Jeu.java. Elle définit les règles spécifiques pour les joueurs confirmés. Ce n’est pas chacun son tour mais le premier qui peut jouer il joue.
InterfaceGraphique.java, est notre classe qui s’occupe de l’interface utilisateur pour le jeu. Elle initialise une fenêtre principale JFrame avec différents panneaux JPanel pour les titres, cartes et boutons. Les boutons sont utilisés afin de jouer ou bien afficher les scores ou même quitter, choisir des niveaux, des versions et d’autres actions spécifiques au jeu (on a implementé une méthode pour le style de bouton s'appelle “createButton”. La classe utilise aussi des JOptionPane pour interagir avec l’utilisateur comme lui demander les noms de joueurs ou afficher des règles. La classe utilise des “ActionListener” pour activer les boutons pour faire certaines actions comme par exemple afficher la carte au centre ou distribuer les cartes aux joueurs.
On utilisé JTable pour la création de tableau pour les scores des deux joueurs, JFrame pour afficher le tableau avec les noms , scores. La méthode mettreAJourScores consiste à retirer des points en cas de sanction pour  le non-respect d’une des conditions de jeu, ou en ajouter en cas de récompense. Dans chaque boutonversion(versionKids, version Recto-Verso, version Apéro, version Têtes Brûlées, version Normal) on implémente une série de méthodes, qui font les actions nécessaires sur l’interface pour que deux joueurs humaines puissent jouer le jeu pendant 15min et lorsque ceux-ci se passent, un dialogue JOptionPane  déclenche et affiche le nom de vainqueur  et son score en utilisant la méthode annoncerGagnant(gangant). On a inséré aussi : labelJoueurHumain2, labelJoueurHumain1 qui représentent chaque joueur par son nom saisie avant le commencement de jeu (en utilisant la method askForName()).
Ensuite, on a inséré une série des buttons (ButtonRegles, ButtonPiocher, ButtonclickCarte, ButtonDistribuerCartes, ButtonPause).
Chacun des buttons déclenche une action spécifique propre à lui.
D’abord , on a le buttonRegles: déclenche une note d’informations pour la fonctionnalité de jeu en utilisant JOptionPane.
Le Bouton Pause: pour quitter le  jeu. On utilise pour ce bouton la fonction JOptionPane.YES_NO_OPTION.
Le Bouton clickCarte: quand on clique sur ce bouton, une carte aléatoire de notre listeCartes s’affiche au milieu de la fenêtre. On récupère chaque carte (image carte) par son nom, sa couleur en utilisant la méthode (getImage() )de la classe Carte.
Le Bouton DistribuerCartes: quand on clique sur ce bouton, 3 cartes pour chaque joueur s’affichent l’une à côté de l’autre de côté de chacun les deux joueurs. Pour ce button on utilise 2 cartes(cartePlayer1, cartePlayer2), 2 buttons (cardButton1, cardButton2) avec une boucle for qui stocke dans chaque cardButton 3 carte.

![image](https://github.com/sana-rekbi/color-addict/assets/138128268/bb1583f5-2c64-4c09-b2a4-b45164b0c976)

![image](https://github.com/sana-rekbi/color-addict/assets/138128268/6f762857-7839-42be-8835-fd468afc7d63)

![image](https://github.com/sana-rekbi/color-addict/assets/138128268/0acef057-cbe0-407e-93a5-ca9ba2adac1c)
![image](https://github.com/sana-rekbi/color-addict/assets/138128268/0feacc9f-0eea-40e1-b4d5-46b1a64b5b6d)
![image](https://github.com/sana-rekbi/color-addict/assets/138128268/c70b0e16-c727-4b12-b881-9f22a6a70f49)
![image](https://github.com/sana-rekbi/color-addict/assets/138128268/c3e54035-b078-48ed-9420-87e0ea1c2eed)


![image](https://github.com/sana-rekbi/color-addict/assets/138128268/af1793c2-29ce-4d1e-bb1b-228b4510d214)
