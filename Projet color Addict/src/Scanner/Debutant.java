package Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Debutant extends Jeu{


    public Debutant(ArrayList<Joueur> joueurs) {
		super(joueurs);
	}


    public void jouer(){

        //Condition pour pas commencer la partie avec une Carte Joker au milieu de la table
        if(super.listeCartes.peek().getNom().equals("Joker")){
            Carte tmp = listeCartes.pop();
            super.ajouterCarteSurTable(super.listeCartes.pop());
            listeCartes.push(tmp);
        }else{
            super.ajouterCarteSurTable(super.listeCartes.pop());
        }
        
        if (joueurs.size() == 2) {
            Joueur joueur1 = joueurs.get(0);
            Joueur joueur2 = joueurs.get(1);

            while(super.stop() != true){
                super.nbTours++;

                //a enlever après c juste pr  voir il me reste cb de cartes avant la fin
                System.out.println("/-------------------------------------------------/");
				System.out.println("Informations pour dev: " + super.toString());
				System.out.println("/-------------------------------------------------/");


                System.out.println("-------------------");
                System.out.println("Tour n°" + super.nbTours);
				System.out.println("-------------------");
                System.out.println("*************************");
                System.out.println("Tour joueur 1: " + joueur1.toString());
				for(int i = 0; i < joueur1.getMain().size(); i++){
					System.out.println("Carte n°" + i + " : " + joueur1.getMain().get(i));
				}
                jouerTour(joueur1);
                if(super.stop()) break;
                

                System.out.println("");
                System.out.println("*************************");
                System.out.println("Tour joueur 2: " + joueur2.toString());
				for(int i = 0; i < joueur2.getMain().size(); i++){
					System.out.println("Carte n°" + i + " : " + joueur2.getMain().get(i));
				}
                jouerTour(joueur2);
                if(super.stop()) break;

            }

        }
    }


    public void jouerTour(Joueur joueur){
        if (!joueur.getMain().isEmpty()){
            if (joueur.jouerCarteMain(super.listeCartes, super.cartesTable, "debutant", joueur)) {
                if(joueur.getMain().size() < 3 && super.peutPiocher()){
                    //joueur.piocherCarte(super.listeCartes);
                    //pose une carte de leur main sur le tas central et pioche une carte afin d’avoir toujours 3 cartes en mains
                }else if(joueur.getMain().size() > 3){
                    //Si le joueur possède plus de 3 cartes dans sa main, il pose sa carte mais ne repioche pas
                    //joueur.jouerCarteMain(super.listeCartes, super.cartesTable, "Debutant");
                }
            }else{
                //Si le joueur ne peut pas poser de cartes, il doit en piocher une et passer son tour
                //joueur.piocherCarte(super.listeCartes);
            }
        }
    }

    /**
     * pour le mode débutant on remplit qu'avec des ROUGE, BLEU, JAUNE et VERT
     * @return une pile de carte mélangée pr les distribuer aux joueurs
     */
    public void remplissageCarte(){
		//Carte joker
		Carte[] joker = {
			new Carte("Joker", "Joker")
		};
 		//Cartes Nom Jaune 
		Carte[] cartesJaune = {
			new Carte("Jaune", "Jaune"),
			new Carte("Jaune", "Rouge"),
			new Carte("Jaune", "Vert"),
			new Carte("Jaune", "Bleu")
		};
		//Carte Nom Rouge
		Carte[] cartesRouge = {
			new Carte("Rouge", "Jaune"),
			new Carte("Rouge", "Rouge"),
			new Carte("Rouge", "Vert"),
			new Carte("Rouge", "Bleu")
		};
		//Carte Nom Vert
		Carte[] cartesVert = {
			new Carte("Vert", "Jaune"),
			new Carte("Vert", "Rouge"),
			new Carte("Vert", "Vert"),
			new Carte("Vert", "Bleu")
		};
        //Carte Nom Bleu
		Carte[] cartesBleu = {
			new Carte("Bleu", "Jaune"),
			new Carte("Bleu", "Rouge"),
			new Carte("Bleu", "Vert"),
			new Carte("Bleu", "Bleu")
		};

		for(int i = 0; i < 1; i++){ //Remettre ici à i < 3 après avoir fini de tester tout le jeu en mode debutant
			super.listeCartes.addAll(Arrays.asList(joker));
			super.listeCartes.addAll(Arrays.asList(cartesJaune));
			super.listeCartes.addAll(Arrays.asList(cartesRouge));
			super.listeCartes.addAll(Arrays.asList(cartesVert));
            super.listeCartes.addAll(Arrays.asList(cartesBleu));
		}

		super.melangerCartes(super.listeCartes);
	}

}

