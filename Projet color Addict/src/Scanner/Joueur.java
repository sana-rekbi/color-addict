package Scanner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/**
 * Classe correspondant à un joueur
 */
public class Joueur {
    
    /**
     * Attribut correspondant au nom du joueur
     */
    private String nom;

    /**
     * Attribut correspondant aux cartes à sa main
     */
    private ArrayList<Carte> main;

    /** 
	 * Attribut representant le score d'un joueur
     * Carte jouée = +10
     * Carte Joker jouée = +5 bonus (si on joue une carte mais en plus c'est un joker c'est +15 au total)
     * Carte jouée par erreur = -5
     * Si on passe le tour = -5
     * //Pour la version CONFIRME s'il pioche une carte -5 points
	*/
	private int score = 0;


    /**
     * Constructeur permettant d'instancier un joueur
     * @param nom
     * @param main
     * @param score
     */
    public Joueur(String nom){
        this.nom = nom;
        main = new ArrayList<Carte>(); //sera rempli après à l'aide de la méthode setMain 
        score = 0;
    }

    /**
	 * Méthode permettant de piocher une carte 
	 * @param listeCartes
     * @return 
	 */
    //à modifier
    // pour que le joueur pioche maximum 24 cartes  et pour chaque joueur sa propre pioche 
    public Carte piocherCarte(Stack<Carte> listeCartes){
        // verifie si la pile de cartes n'est pas vide et si le joueur a moins de 24 cartes
        if (!listeCartes.empty() && main.size() < 24) {
            Carte cartePiochee = listeCartes.pop(); // Piocher la carte du sommet de la pile
            System.out.println("Le joueur pioche une carte: " + cartePiochee);
            main.add(cartePiochee); // ajoute la carte piochée à la main du joueur
        } else if (main.size() >= 24) {
            System.out.println("Le joueur a déjà le nombre maximum de cartes.");
        } else {
            System.out.println("Il n'y a plus de cartes à piocher.");
        }
		return null;
    }

    /**
     * Méthode permettant de jouer une carte de sa Main
     * @param listeCartes les cartes pour piocher
     * @param cartesTable cartes au mileu de la table
     * @param niveau
     * @return true si la carte a été jouée
     */
    public boolean jouerCarteMain(Stack<Carte> listeCartes, Stack<Carte> cartesTable, String niveau,Joueur joueur){
        System.out.println("");
        System.out.println("Carte sur la table: " + cartesTable.peek());
        System.out.println("");
        Scanner sc = new Scanner(System.in); // Premier scanner pour choisir carte ou piocher
        Scanner sc1 = new Scanner(System.in); // Deuxieme scanner pour savoir quelle carte jouer
        Scanner sc2 = new Scanner(System.in); // Troisième scanner pour demander la couleur du joker
        Carte tmp = cartesTable.peek();
        boolean res = false;
        //on met à jour le score du joueur
        joueur.setScore(joueur.getScore()+score);

        if (niveau.equals("Debutant") || niveau.equals("Initie")){
            while(!res){
                
                int choix0 = sc.nextInt();

                switch(choix0){
                    case 1:
                        System.out.println("Quelle carte voulez-vous jouer? (donnez son numéro)");
                        int choix = sc1.nextInt();
                    
                        if(main.get(choix).getNom().equals(tmp.getNom()) || main.get(choix).getCouleur().equals(tmp.getCouleur()) 
                            || main.get(choix).getNom().equals(tmp.getCouleur()) || main.get(choix).getCouleur().equals(tmp.getNom()) || main.get(choix).getNom().equals("Joker")){
                            System.out.println("Le joueur joue la carte: " + main.get(choix));
                                
                            score += 10;

                            if(main.get(choix).getNom().equals("Joker")){
                                score += 5;
                                System.out.println("Vous avez joué un Joker ! "+
                                "Avec quelle couleur voulez-vous poursuivre? (Jaune, Rouge, Vert, Bleu)");
                                String tmp2 = sc2.next();
                                switch (tmp2) {
                                    case "Jaune":
                                        System.out.println("Vous avez choisi de continuer avec la couleur Jaune");
                                        main.get(choix).setCouleur("Jaune");
                                        break;
                                    case "Rouge":
                                        System.out.println("Vous avez choisi de continuer avec la couleur Rouge");
                                        main.get(choix).setCouleur("Rouge");
                                        break;
                                    case "Vert":
                                        System.out.println("Vous avez choisi de continuer avec la couleur Vert");
                                        main.get(choix).setCouleur("Vert");
                                        break;
                                    case "Bleu":
                                        System.out.println("Vous avez choisi de continuer avec la couleur Bleu");
                                        main.get(choix).setCouleur("Bleu");
                                        break;
                                    default:
                                        System.out.println("Choix non valide. Veuillez sélectionner Jaune, Rouge, Vert ou Bleu");
                                        break;
                                }

                            }
                            cartesTable.push(main.get(choix));
                            main.remove(choix);
                            res = true;
                        }else{
                            score -= 5;
                            System.out.println("La carte que vous avez piochée ne respecte pas les conditions veuillez réessayer");
                        }
                        break;
                    case 2:
                        this.piocherCarte(listeCartes);
                        res = true;
                        break;
                    case 3: 
                        score -= 5;
                        System.out.println("Vous avez passé votre tour");
                        res = true;
                        break;
                        
                }
            }

        }else if(niveau.equals("Confirme")){
            while(!res){
                System.out.println("1: Choisir Carte  2: Piocher");
                int choix0 = sc.nextInt();

                switch(choix0){
                    case 1:
                        System.out.println("Quelle carte voulez-vous jouer? (donnez son numéro)");
                        int choix = sc1.nextInt();
                    
                        if(main.get(choix).getNom().equals(tmp.getNom()) || main.get(choix).getCouleur().equals(tmp.getCouleur()) 
                            || main.get(choix).getNom().equals(tmp.getCouleur()) || main.get(choix).getCouleur().equals(tmp.getNom()) || main.get(choix).getNom().equals("Joker")){
                            System.out.println("Le joueur joue la carte: " + main.get(choix));
                                
                            score += 10;

                            if(main.get(choix).getNom().equals("Joker")){
                                score += 5;
                                System.out.println("Vous avez joué un Joker ! "+
                                "Avec quelle couleur voulez-vous poursuivre? (Jaune, Rouge, Vert, Bleu)");
                                String tmp2 = sc2.next();
                                switch (tmp2) {
                                    case "Jaune":
                                        System.out.println("Vous avez choisi de continuer avec la couleur Jaune");
                                        main.get(choix).setCouleur("Jaune");
                                        break;
                                    case "Rouge":
                                        System.out.println("Vous avez choisi de continuer avec la couleur Rouge");
                                        main.get(choix).setCouleur("Rouge");
                                        break;
                                    case "Vert":
                                        System.out.println("Vous avez choisi de continuer avec la couleur Vert");
                                        main.get(choix).setCouleur("Vert");
                                        break;
                                    case "Bleu":
                                        System.out.println("Vous avez choisi de continuer avec la couleur Bleu");
                                        main.get(choix).setCouleur("Bleu");
                                        break;
                                        //AJOUTER ICI LES AUTRES COULEURS pr la difficulté initié
                                    default:
                                        System.out.println("Choix non valide. Veuillez sélectionner Jaune, Rouge, Vert ou Bleu");
                                        break;
                                }

                            }
                            cartesTable.push(main.get(choix));
                            main.remove(choix);
                            res = true;
                        }else{
                            score -= 5;
                            System.out.println("La carte que vous avez piochée ne respecte pas les conditions veuillez réessayer");
                        }
                        break;
                    case 2:
                        this.piocherCarte(listeCartes);
                        res = true;
                        score -= 5;
                        //CONTINUER ICI FAUT QUE LE JOUEUR PIOCHE JUSQU A QU'IL A UNE CARTE QUI MARCHE 
                        break;
                }
            }
        }


        return res;
    }
    


    /**
	 * Méthodes basiques
	 * Getteurs et accesseurs ainsi que toString
	 */
	@Override
	public String toString() {
		return "Joueur [nom=" + nom + "; main=" + main + "]" + "; score=[" + score +"]";
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Carte> getMain() {
		return main;
	}
	public void setMain(ArrayList<Carte> main) {
		this.main = main;
	}

    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }


	
	// pour enregistrer les scores dans un fichier
	public void enregistrerScores(ArrayList<Joueur> joueurs) {
	    try {
	        BufferedWriter writer = new BufferedWriter(new FileWriter("scores.txt"));
	        for (Joueur joueur : joueurs) {
	            writer.write(joueur.getNom() + "," + joueur.getScore() + "\n");
	        }
	        writer.close();
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}


	public void retirerPoints(int points) {
		// TODO Auto-generated method stub
		 this.score -= points;
	        if (this.score < 0) {
	            this.score = 0; //il faut pas depasser 0
	        }
	}

	public void ajouterPoints(int points) {
		// TODO Auto-generated method stub
		 this.score += points;
	}

	public boolean aGagné() {
		// TODO Auto-generated method stub
		return main.isEmpty();
	}
	
	

}
