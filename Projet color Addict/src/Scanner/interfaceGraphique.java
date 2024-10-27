package Scanner;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;





public class interfaceGraphique {
	
	
	
	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Joueur joueurIA=new Joueur("robot",true);
		 
		 
		Joueur joueurHumain2=new Joueur(askForName());
		 Joueur joueurHumain1=new Joueur(askForName());
		 Joueur joueurActuel = joueurHumain1;//on commence le jeu toujours par un joueur humain
		  ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	
		// Initialisation des panels et des listes de boutons
	      
		  Debutant jeu = new Debutant(joueurs);
		//creation de la fenetre
		JFrame frame=new JFrame("Color Addict");
		frame.setSize(650,780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		JPanel titlePanel=new JPanel();
		titlePanel.setBackground(Color.WHITE);
		JLabel titleLabel=new JLabel("Color Addict Jeu");
		titleLabel.setFont(new Font("Arial",Font.BOLD,24));
		titleLabel.setForeground(Color.yellow);
		titlePanel.add(titleLabel);
		//creation de l'arrière-plan:
		JPanel cardPanel=new JPanel();
		
		
		
		cardPanel.setBackground( Color.WHITE);
		JLabel cardLabel =new JLabel(new ImageIcon("./photos game/71nSqf3JF8L._AC_SX450_.jpg"));
		cardPanel.add(titleLabel);
		cardPanel.add(cardLabel);
		
		//mettre une photo d'icon
		ImageIcon icon = new ImageIcon("./photos game/COLOR-ADDICT-JEU-DE-BASE-FRANC387AIS__3114524104001-Z.png"); 
		frame.setIconImage(icon.getImage());
		//creation des boutons:
		JPanel buttonPanel1=new JPanel();
		buttonPanel1.setLayout(new GridLayout(3,1));
		buttonPanel1.setBackground(Color.WHITE);
		
		
		frame.add(titlePanel,BorderLayout.NORTH);
		frame.add(cardPanel,BorderLayout.CENTER);
		frame.add(buttonPanel1,BorderLayout.SOUTH);
		frame.setVisible(true);
	
		// Boutons
        JButton playButton = createButton("Jouer");
        JButton scoreButton = createButton("Score");
        JButton quitButton = createButton("Quitter");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // quand je click sur "quitter" ca ferme la fenêtre
            }
        });
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);  // Espacement entre les boutons
        gbc.gridx = 0;

        JPanel menuPanel=new JPanel();
        menuPanel.add(playButton,gbc);
        menuPanel.add(scoreButton,gbc);
        menuPanel.add(quitButton,gbc);
     // on crée des boutons pour chaque niveau
        JPanel levelPanel=new JPanel();
        //levelPanel.setLayout(new GridLayout(3,1));
       // levelPanel.setBackground(Color.gray); 
        JButton level1Button = createButton("Debutant");
        JButton level2Button = createButton("Initié");
        JButton level3Button = createButton("Confié");
        levelPanel.add(level1Button,gbc);
        levelPanel.add(level2Button,gbc);
        levelPanel.add(level3Button,gbc);
        cardPanel.add(menuPanel,"MENU");
        
        
        JButton boutonVersionKid = createButton("Version Kids");
        JButton boutonVersionRectoVerso = createButton("Version Recto-Verso");
        JButton boutonVersionApéro=createButton("Version Apéro");
        JButton boutonVersionttB=createButton("Version Têtes Brulées");
        JButton boutonVersionNormal=createButton("Version Normal");
        JPanel versionPanel=new JPanel();
        versionPanel.add(boutonVersionKid);
        versionPanel.add(boutonVersionRectoVerso);
        versionPanel.add(boutonVersionApéro);
        versionPanel.add(boutonVersionttB);
        versionPanel.add(boutonVersionNormal);
        JButton revenirArrier1=createButton1("","./photos game/R1.jpeg");
        versionPanel.add(revenirArrier1);
        JButton revenirArriere2=createButton1("","./photos game/R1.jpeg");
        levelPanel.add(revenirArriere2);
        ImageIcon iconJoueurHumain=new ImageIcon(new ImageIcon("./photos game/human-face-icon-29.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
       // ImageIcon iconnJoueurIA=new ImageIcon(new ImageIcon("C:/Users/rekbi/eclipse-workspace/ProjetColorAddict/photos game/R (1).png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
      //on ajoute les 3 icons de deux humains et d'un IA dans  JLabel
		JLabel labelJoueurHumain1=new JLabel("joueurH:"+joueurHumain1.getNom(),iconJoueurHumain,SwingConstants.RIGHT);
		JLabel labelJoueurHumain2=new JLabel("joueurH:"+joueurHumain2.getNom(),iconJoueurHumain,SwingConstants.LEFT);
		//JLabel labelJoueurIA=new JLabel("joueurIA:"+joueurIA.getNom(),iconnJoueurIA,SwingConstants.LEFT);
	    // configuerer  l'alignement du texte et de l'image pour les étiquettes
        labelJoueurHumain1.setVerticalTextPosition(JLabel.BOTTOM);
        labelJoueurHumain1.setHorizontalTextPosition(JLabel.CENTER);
        
        labelJoueurHumain2.setVerticalTextPosition(JLabel.BOTTOM);
        labelJoueurHumain2.setHorizontalTextPosition(JLabel.CENTER);
        //labelJoueurIA.setVerticalTextPosition(JLabel.BOTTOM);
       // labelJoueurIA.setHorizontalTextPosition(JLabel.CENTER);
        //on definit la taille des labels
		Dimension tailleLabel=new Dimension(100,150);
		//labelJoueurIA.setPreferredSize(tailleLabel);//on modifie la taille de label joueurIA
		labelJoueurHumain1.setPreferredSize(tailleLabel);
		labelJoueurHumain2.setPreferredSize(tailleLabel);
		//on met à jour les deux labels 
		//labelJoueurIA.setIcon(iconnJoueurIA);
		labelJoueurHumain1.setIcon(iconJoueurHumain);
		labelJoueurHumain2.setIcon(iconJoueurHumain);
        
        JButton reglesbutton=createButton("Règles");
        Stack<Carte> listeCartes=jeu.getlisteCartes();
    	//  Stack<Carte>cartesTable=jeu.getCartesTable();
            //Carte joker
            Carte[] joker = {
                new Carte("Joker", "Joker"),
                new Carte("Joker", "Joker"),
                new Carte("Joker", "Joker"),
                new Carte("Joker", "Joker")
            };
             //Cartes Nom Jaune 
            Carte[] cartesJaune = {
                new Carte("Jaune", "Vert"),
                new Carte("Jaune", "Bleu"),
                new Carte("Jaune", "Rouge"),
                new Carte("Jaune", "Vert"),
                new Carte("Jaune", "Bleu"),
            };
            //Carte Nom Rouge
            Carte[] cartesRouge = {
                new Carte("Rouge", "Jaune"),
                new Carte("Rouge", "Vert"),
                new Carte("Rouge", "Bleu"),
                new Carte("Rouge", "Vert"),
                new Carte("Rouge", "Bleu")
            };
            //Carte Nom Vert
            Carte[] cartesVert = {
                new Carte("Vert", "Jaune"),
                new Carte("Vert", "Rouge"),
                new Carte("Vert", "Bleu"),
                new Carte("Vert", "Jaune"),
                new Carte("Vert", "Rouge"),
                new Carte("Vert", "Jaune"),
                new Carte("Vert", "Rouge"),
                new Carte("Vert", "Bleu")
            };
            //Carte Nom Bleu
            Carte[] cartesBleu = {
                new Carte("Bleu", "Jaune"),
                new Carte("Bleu", "Rouge"),
                new Carte("Bleu", "Vert"),
                new Carte("Bleu", "Jaune"),
                new Carte("Bleu", "Rouge"),
                new Carte("Bleu", "Vert"),
                new Carte("Bleu", "Jaune"),
                new Carte("Bleu", "Rouge"),
                new Carte("Bleu", "Vert"),
                new Carte("Bleu", "Vert"),
                new Carte("Bleu", "Vert")
                
            };

            for(int i = 0; i < 1; i++){ //Remettre ici à i < 3 après avoir fini de tester tout le jeu en mode debutant
                listeCartes.addAll(Arrays.asList(joker));
                listeCartes.addAll(Arrays.asList(cartesJaune));
                listeCartes.addAll(Arrays.asList(cartesRouge));
                listeCartes.addAll(Arrays.asList(cartesVert));
                listeCartes.addAll(Arrays.asList(cartesBleu));
            }

            jeu.melangerCartes(listeCartes);
        
        JButton clickCarte=createButton( "Carte ");
        //declaration de  labelCarteJouee, initialisation 
        JLabel labelCarteJouee=new JLabel();
        labelCarteJouee.setHorizontalAlignment(JLabel.CENTER);//centerer l'image dans le llabel
        JButton piocherbutton1=createButton("Piocher");
        JButton piocherbutton2=createButton("Piocher");
        JButton passerTour1=createButton("Passer son Tour");
        JButton passerTour2=createButton("Passer son Tour");
        JLabel labelCarte=new JLabel();
        labelCarte.setPreferredSize(new Dimension(100, 100));
        JButton distribuercartes=createButton("distribuer Cartes");
        //label affiche le nombre de cartes restant dans la pioche de joueur
        JLabel pileLabel1=new JLabel(new ImageIcon("./photos iconpioche/pile_24.png"));
        JLabel pileLabel2=new JLabel(new ImageIcon("./photos iconpioche/pile_24.png"));
        //bouton pour Pause pour s'arreter le jeu ou quitter:
        JButton pause=createButton1("Pause", "./photos game/R.jpeg");
       //panel pour les cartes main de chque joueur:
        JPanel player1Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    JPanel player2Panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	    JPanel cardPanelJeu=new JPanel();
	    
	    boolean carteAffichage=false;//boolean pour controler si une carte est bien afichée ou pas 
	    //choix d'une carte aleatoire de notre listeCartes
	    Random random1 = new Random();
	    Carte carteAleatoire = listeCartes.get(random1.nextInt(listeCartes.size()));
	    if(carteAleatoire.getNom().equals("Joker")) {
    		listeCartes.push(carteAleatoire);
    		Collections.shuffle(listeCartes);
    	}
	    
	    //boolean pour signaler si le joueur a bien passé son tour ou pas:
	    Boolean aPasserTour1=false;
	    Boolean aPasserTour2=false;
	    
        //pour remplacer les buttons jouer, score,quitter avec la choix de niveaux
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // supprimer les boutons existants du panneau
                buttonPanel1.removeAll();
                menuPanel.setVisible(false);

                // Ajouter les boutons de niveau au panneau
                buttonPanel1.add(levelPanel);

                // Actualiser le panneau pour montrer les nouveaux boutons
                buttonPanel1.revalidate();
                buttonPanel1.repaint();
            }
        });
             //remplacer les buttons de choix de niveau de l'utilisateur par choix de versions
        level1Button.addActionListener(e -> {
        	
        	
            //supprime les buttons existants :
         	buttonPanel1.removeAll();
         	levelPanel.setVisible(false);
         	//Ajoute les boutons de versions
         	buttonPanel1.add(versionPanel);
         	//Actualise le panneau pour montrer les nouveaux boutons
         	 buttonPanel1.revalidate();
              buttonPanel1.repaint();
         	
              System.out.println("Vous avez choisi le mode debutant");
               joueurs.add(joueurActuel);
 		
               
 			//jeu.remplissageCarte();
             jeu.distribuerCartes();
 			jeu.jouer();
              
              
         });
       
        level2Button.addActionListener(e -> {
         	
         	
            //supprime les buttons existants :
         	buttonPanel1.removeAll();
         	levelPanel.setVisible(false);
         	//Ajoute les boutons de versions
         	buttonPanel1.add(versionPanel);
         	//Actualise le panneau pour montrer les nouveaux boutons
         	 buttonPanel1.revalidate();
              buttonPanel1.repaint();
              
              System.out.println("Vous avez choisi le mode initie");
               joueurs.add(joueurActuel);
 		
               
 			jeu.remplissageCarte();
             jeu.distribuerCartes();
 			jeu.jouer();
         	
         });
        level3Button.addActionListener(e -> {
        	
            //supprime les buttons existants :
         	buttonPanel1.removeAll();
         	levelPanel.setVisible(false);
         	//Ajoute les boutons de versions
         	buttonPanel1.add(versionPanel);
         	//Actualise le panneau pour montrer les nouveaux boutons
         	 buttonPanel1.revalidate();
              buttonPanel1.repaint();
              System.out.println("Vous avez choisi le mode confie");
               joueurs.add(joueurActuel);
 		
 			jeu.remplissageCarte();
             jeu.distribuerCartes();
 			jeu.jouer();
         });
        
        frame.add(cardPanel);
        frame.setVisible(true);
        
        //revenir en arriere de versions vers niveau joueur
        revenirArrier1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				levelPanel.setVisible(true);
				buttonPanel1.add(levelPanel);
				versionPanel.setVisible(false);
				buttonPanel1.revalidate();
                buttonPanel1.repaint();
                
                
			}
        	
        });
        /**
      		 * Méthode avec "addActionListener" pour revenir en arriere de niveau joueur vers la page accueil avec score, jouer,quitter
      		 * 
      		 */
        
        revenirArriere2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menuPanel.setVisible(true);
				buttonPanel1.add(menuPanel);
				levelPanel.setVisible(false);
				buttonPanel1.revalidate();
                buttonPanel1.repaint();
			}
        	
        });
        /**
      		 * Méthode avec "addActionListener" pour affiher les regles de jeu aux joueurs
      		 * 
      		 */
        reglesbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				afficherRegles();
			}

			private void afficherRegles() {
				// TODO Auto-generated method stub
				String texteDesRegles = "Les règles du jeu sont les suivantes : \n";
		        texteDesRegles += "\r\n"
		        		+ "-	Un joueur commence avec 3 cartes en main -> 1 pioche\r\n"
		        		+ "-	Une première carte doit être placée au centre de la table\r\n"
		        		+ "-	S’il ne peut pas poser une carte -> doit piocher une carte et passe son tour\r\n"
		        		+ "-	Si personne ne peut poser de carte, la partie est bloquée. Deux possibilités s’offrent aux joueurs, c’est à\r\n"
		        		+ "décider en début de partie :\r\n"
		        		+ "- La partie continue et c’est alors au dernier joueur qui a posé une carte d’en placer une de son choix au\r\n"
		        		+ "centre afin que la partie reprenne.\r\n"
		        		+ "- La partie s’arrête, on compte les cartes et le joueur qui a le moins de cartes en main et dans sa pioche a\r\n"
		        		+ "gagné.\r\n"
		        		+ "-	Pour gagner -> le joueur ne doit disposer d’aucune carte\r\n"
		        		+ "-	Une carte joker peut être utilisé dans tous les cas (il aura la caractéristique de chaque carte du tableau couleurCarte). \r\n"
		        		+ "-	Maximum 110 cartes \r\n"
		        		+ "-	Nombre joueurs : 2-8\r\n"
		        		+ "\n";
		        
		        // Affiche le message des règles
		        JOptionPane.showMessageDialog( reglesbutton, texteDesRegles, "Règles du Jeu", JOptionPane.INFORMATION_MESSAGE);
		    }
			
			
			 

        
        	
        });
        /**
		 * Méthode avec "addActionListener" pour la creation d'un tableau score
		 * 
		 */
        
       
             scoreButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				   String[] columnNames = {"Joueur", "Score"};
				   
				   
			        Object[][] data = new Object[joueurs.size()][2];
			        JTable scoreTable = new JTable(data, columnNames);
			        
			        
		        for (int i = 0; i < joueurs.size(); i++) {
		            data[i][0] = joueurs.get(i).getNom(); 
		            data[i][1] = joueurs.get(i).getScore();
		        }

		        joueurs.add(joueurHumain2);
		        
		        JScrollPane scrollPane = new JScrollPane(scoreTable);
		        scoreTable.setFillsViewportHeight(true);
		        
		        //  un JFrame pour afficher le tableau des scores
		        JFrame frame = new JFrame("Scores des Joueurs");
		        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame.add(scrollPane);
		        frame.pack(); // la taille de la fenêtre en fonction du contenu
		        frame.setLocationRelativeTo(null); 
		        frame.setVisible(true); 
		      
		        //mettre à jour les scores pour chaque joueur
				mettreAJourScore( joueurHumain1,   aPasserTour1,joueurHumain1.getScore());
				mettreAJourScore( joueurHumain2,   aPasserTour2, joueurHumain2.getScore());
		    }
			
			 //on mette à jour les scores après chaque tour:
	        
	        private void mettreAJourScore(Joueur joueur, boolean aPasséSonTour, int pointsPourLaCarte) {
	            // Calcul du score
	        	 pointsPourLaCarte=0;
	            if (aPasséSonTour) {
	                joueur.retirerPoints( pointsPourLaCarte-5); // Pénalité pour avoir passé son tour
	            } 
	           
	            else {
	                joueur.ajouterPoints(  pointsPourLaCarte+15); // Ajouter des points pour la carte jouée
	            }
	        }
			
			
        
        	
        });

      
     
	
        boutonVersionKid.addActionListener(new ActionListener() {
        
			@Override
			
			
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				//on supprime tous les composants de notre fenetre et ensuite on met à jour notre frame 
				
				frame.getContentPane().removeAll();
				frame.setSize(1300,1400);
				
			    frame.setLayout(new BorderLayout());
			    labelJoueurHumain1.setBounds(900,250,250,200);
				frame.getContentPane().add(labelJoueurHumain1);
				labelJoueurHumain2.setBounds(200,250, 250, 200);
				frame.getContentPane().add(labelJoueurHumain2);
				frame.getContentPane().add(labelCarteJouee);
				JPanel panel1=new JPanel(new FlowLayout(FlowLayout.CENTER));
				//mettre une bouton click carte qui affiche une carte au milieu en haut de la fenetre, les buttons distribuercarte, score
				panel1.add(clickCarte);
				panel1.setBounds(450,300,500,100);
				frame.add(panel1);
				panel1.add(distribuercartes);
				panel1.add(scoreButton);
				
			
				JPanel panel2=new JPanel(new FlowLayout(FlowLayout.RIGHT));
				panel2.add(reglesbutton);
				panel2.add(pause);
				panel2.setBounds(1200, 600, 100, 100);
				frame.getContentPane().add(panel2);
				//ajouter la button piocher et passer tour
				JPanel piocherButtonJoueur1=new JPanel();
				piocherButtonJoueur1.add(passerTour1);
				piocherButtonJoueur1.add(piocherbutton1);
				piocherButtonJoueur1.setBounds(130,450,250,150);//
				frame.getContentPane().add(piocherButtonJoueur1);
				JPanel piocherButtonJoueur2=new JPanel();
				piocherButtonJoueur2.add(piocherbutton2);
				piocherButtonJoueur2.add(passerTour2);
				piocherButtonJoueur2.setBounds(980,450,250,150);//
				frame.getContentPane().add(piocherButtonJoueur2);
				//Label pour montrer le nombre de cartes restantes dans la pioche de chaque joueur
				pileLabel1.setBounds(10, 300, 200, 150);
				frame.getContentPane().add(pileLabel1);
                pileLabel2.setBounds(1200, 300, 200, 150);
				frame.getContentPane().add(pileLabel2);
				//creation de bouton pause pour soit sortir de jeu ou continuer à jouer
				JPanel panel3=new JPanel();
				panel3.add(pause);
				panel3.setBounds(130, 600, 100, 100);
				frame.getContentPane().add(panel3);
				JPanel panel=new JPanel(new FlowLayout(FlowLayout.CENTER));
				frame.getContentPane().add(panel);
				labelJoueurHumain1.setVisible(true);
				labelJoueurHumain2.setVisible(true);
				
				
				
				
				frame.revalidate();
				frame.repaint();
				frame.setVisible(true);
				
				
				
				
			    pause.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			            // un JOptionPane pour confirmer la sortie
			            int response = JOptionPane.showConfirmDialog(
			                    null,
			                    "Êtes-vous sûr de vouloir quitter le jeu ?",
			                    "Pause",
			                    JOptionPane.YES_NO_OPTION,
			                    JOptionPane.QUESTION_MESSAGE
			            );

			            if (response == JOptionPane.YES_OPTION) {
			                System.exit(0); // Quitte l'application si l'utilisateur choisit "OUI"
			            }
			        }
			        
			    });

 distribuercartes.addActionListener(new ActionListener() {
		        	

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						distributeCards();
					}
					String niveau=levelPanel.getName();
					String couleurImposee=null;
					private void distributeCards() {
						// TODO Auto-generated method stub
						
					    // la distribution des cartes aux joueurs
					    for (int i = 0; i < 3; i++) { // Supposons que chaque joueur reçoit 3 cartes
					        if (!listeCartes.isEmpty()) {
					        	 Carte cardPlayer1 = listeCartes.pop();
						            Carte cardPlayer2 = listeCartes.pop();
						            
					        	/*
					            Carte cardPlayer1 = obtenirCartePourNiveau("Debutant");
					            Carte cardPlayer2 = obtenirCartePourNiveau("Debutant");
					            */
					            JButton cardButton1 = new JButton(new ImageIcon(cardPlayer1.getImage()));
					            JButton cardButton2 = new JButton(new ImageIcon(cardPlayer2.getImage()));

					            cardButton1.setPreferredSize(new Dimension(100, 150));
					            cardButton2.setPreferredSize(new Dimension(100, 150));
					            //Ajout d'un ActionListener pour cardButton1 et cardButton2
					            cardButton1.addActionListener(new ActionListener() {
					            	
									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub//quand on clique sur la carte, on teste si la carte qu'on a chisi est valide ou pas
										
										if(!aPasserTour1) {
											jouerCarte(cardPlayer1,joueurHumain1, player1Panel, cardButton1);
											/*
											String niveauActuel=levelPanel.getName().toString();
											switch (niveauActuel) {
				                            case "Confirme":
				                                // Logique pour le niveau "Confirme"
				                                
				                                    jouerCarte(cardPlayer1, joueurHumain1, player1Panel, cardButton1);
				                                    if (joueurHumain1.aGagné()) {
				                                        annoncerGagnant(joueurHumain1);
				                                    }
				                              
				                                break;
				                            case "Initie":
				                                // Logique pour le niveau "Initie"
				                                // ...
				                                break;
				                            case "Debutant":
				                                // Logique pour le niveau "Debutant"
				                                if (estCouleurValidePourDebutant(cardPlayer1.getCouleur())) {
				                                    jouerCarte(cardPlayer1, joueurHumain1, player1Panel, cardButton1);
				                                    if (joueurHumain1.aGagné()) {
				                                        annoncerGagnant(joueurHumain1);
				                                    }
				                                } else {
				                                    JOptionPane.showMessageDialog(frame, "La carte n'est pas valide pour le niveau Debutant", "Carte Invalide", JOptionPane.WARNING_MESSAGE);
				                                }
				                                break;
				                            default:
				                            
											}
											*/
											}
											else {
												JOptionPane.showMessageDialog(frame, "vous avez passé votre tour", "Tour Passé", JOptionPane.WARNING_MESSAGE);
											}
										
									}
									/**
									 * Méthode permet d'obtenir une carte selon le niveau choisie par le joueur au commencement de jeu
									 * @return une carte
									  */

									private boolean estCouleurValidePourDebutant(String couleur) {
										// TODO Auto-generated method stub
										  return couleur.equals("Rouge") || couleur.equals("Bleu") || couleur.equals("Vert") || couleur.equals("Jaune");
									}

									
					            	
					            });
					           
					          
					            cardButton2.addActionListener(new ActionListener() {
					            	
									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										
										if(!aPasserTour2) {
										jouerCarte(cardPlayer2,joueurHumain2, player2Panel, cardButton2);
										}else {
											JOptionPane.showMessageDialog(frame, "vous avez passé votre tour", "Tour Passé", JOptionPane.WARNING_MESSAGE);
										}
									}
										
					            	
					            });
					            player1Panel.add(cardButton1);
					            player2Panel.add(cardButton2);
					        }
					    }

					    // Positionnement des panels sur le frame principal
					    frame.setLayout(new BorderLayout()); // on utilise BorderLayout pour le frame principal

					    // Ajoutation des panels des joueurs au frame
					    frame.add(player1Panel, BorderLayout.WEST); // Les cartes du joueur 1 à gauche
					    frame.add(player2Panel, BorderLayout.EAST); // Les cartes du joueur 2 à droite

					    // Actualisation de frame pour appliquer les changements
					    frame.revalidate();
					    frame.repaint();
					}
					/**
					 * Méthode permet d'obtenir une carte selon le niveau choisie par le joueur au commencement de jeu
					 * @return une carte
					  */
					private Carte obtenirCartePourNiveau(String string) {
						// TODO Auto-generated method stub
						 Carte carte;
						    do {
						        carte = listeCartes.pop();
						        if (niveau.equals("Debutant") && carte.getNom().equals("Joker")) {
						            // Ne pas inclure les cartes Joker pour le niveau débutant
						            listeCartes.push(carte); // Remettre la carte dans la pile
						        }
						    } while (niveau.equals("Debutant") && carte.getNom().equals("Joker"));
						    return carte;
						
					}
					
					 long tempsDebut = System.currentTimeMillis(); // Enregistre le temps de début du jeu
					 int delai = 15 * 60 * 1000; // 15 minutes en millisecondes
					 Timer jeuTimer = new Timer(delai, e -> finDeJeu());
					public void initialiserJeu() {
					 
					    jeuTimer.start();
					}
					

					private int tourspasses=0;
					/**
					 * Méthode permet de passer au tour suivant, c'est à dire quand le joueur1 passe son tour, on passe au tour suivant (c'est au 2eme joueur de jouer)
					 * 
					 * @return void
					  */
					private void passerAuTourSuivant() {
						// TODO Auto-generated method stub
						
						tourspasses++;
						
						//affichage d'une message avec le nombre de tours passés
						JOptionPane.showMessageDialog(frame,"Tour"+tourspasses+"terminé", "Information", JOptionPane.INFORMATION_MESSAGE);
						//on verifie si les deux joueurs ont joué ou passé leur tour et si c'est le cas, on mettra à jour l'interface:
						if(tourspasses>=2) {
							reinitialiserCentre();
							//enuite on mettra à jour le compteur des tours passés:
							tourspasses=0;
							  long tempsActuel = System.currentTimeMillis();
							    
								if (tempsActuel - tempsDebut >= (15 * 60 * 1000)) { // Vérifie si 15 minutes se sont écoulées
							      
									jeuTimer.stop(); // Arrête le timer
							        finDeJeu(); // Annonce le gagnant
						}
					}
					}
					/**
					 * Méthode permet de reinitialiser la carte au centre après que les deux joueurs passent leur tour 
					 * @return void
					 * 
					  */
					

					private void reinitialiserCentre() {
						// TODO Auto-generated method stub
						   cardPanelJeu.removeAll();
						  
						   //on ajoute une nouvelle carte au milieu
						   if (!listeCartes.isEmpty()&&!carteAffichage) {
							   Random random2 = new Random();
							    Carte carteAleatoire2 = listeCartes.get(random2.nextInt(listeCartes.size()));
							    if(carteAleatoire2.getNom().equals("Joker")) {
						    		listeCartes.push(carteAleatoire2);
						    		Collections.shuffle(listeCartes);
						    	}
					            JButton nouvelleCarte= new JButton(new  ImageIcon(carteAleatoire2.getImage()));
					            nouvelleCarte.setPreferredSize(new Dimension(100, 150)); 
					            cardPanelJeu.add(nouvelleCarte);
					            //ensuite on met à jour l'affichage
					            cardPanelJeu.revalidate();
					            cardPanelJeu.repaint();
					            
						   }
						   
					}
				
					/**
					 * Méthode permet de jouer une carte par un joueur
					 * @return void
					 * @param carte de type Carte
					 * @param joueur de type Joueur
					 * @param playerpanel de type JPanel
					 * @param cardButton de type JButton
					  */
					
					private void jouerCarte(Carte carte, Joueur joueur, JPanel playerPanel, JButton cardButton) {
						// TODO Auto-generated method stub
					//si la carte valide on le supprime du panel des cartes (main de chaque joueur) et on l'ajoute dans cardpanelJeu
						initialiserJeu();
						if(carte.getCouleur().equals((carteAleatoire.getCouleur()))|| carte.getNom().equals(carteAleatoire.getNom())){
							
							playerPanel.remove(cardButton);
							playerPanel.revalidate();
							playerPanel.repaint();
							cardPanelJeu.add(cardButton);
							frame.revalidate();
							frame.repaint();
							
						}else if(carte.getCouleur().equals("Joker")|| carte.getNom().equals("Joker")) {
							
							playerPanel.remove(cardButton);
							playerPanel.revalidate();
							playerPanel.repaint();
							cardPanelJeu.add(cardButton);
							frame.revalidate();
							frame.repaint();
									
									
						
							String[] options= {"Jaune", "Rouge", "Vert","Bleu"};
							couleurImposee=(String) JOptionPane.showInputDialog(
									null,
									"Choisissez une couleur: ","Joker!", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
							
							if(carte.getCouleur().equals(couleurImposee)) {
								playerPanel.remove(cardButton);
								playerPanel.revalidate();
								playerPanel.repaint();
								cardPanelJeu.add(cardButton);
								frame.revalidate();
								frame.repaint();
							}
							else {

								JOptionPane.showMessageDialog(frame, "vous devez choisir une carte de couleur "+couleurImposee, "Erreur", JOptionPane.WARNING_MESSAGE);
								
							}
						
							
						}
						else {
							 JOptionPane.showMessageDialog( reglesbutton, "La carte n'est pas valide !!", "ERREUR", JOptionPane.INFORMATION_MESSAGE);
							 joueur.retirerPoints(5);
						}
						//si les deux joueurs ont joué, on met à jour la carte au milieu
						jeu.jouerTour(joueurActuel);
						passerAuTourSuivant();
						
							
						
					}
					
					
					
		        });

				clickCarte.addActionListener(new ActionListener() {
					
					@Override
					
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					   
					    	
				            JButton cardButton = new JButton(new  ImageIcon(carteAleatoire.getImage()));
				            cardButton.setPreferredSize(new Dimension(100, 150));
				            // quand on click sur le button, la carte s'affiche au milieu
				           cardPanelJeu.removeAll();
				            cardPanelJeu.setBounds(600,300,100,100);
				            cardPanelJeu.add(cardButton);
				            frame.getContentPane().add(cardPanelJeu); 
				            

				            frame.revalidate();
				            frame.repaint();
				        }
				    
				});
				
			

	        piocherbutton1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Carte cartePioche=listeCartes.pop();
					if(listeCartes.isEmpty()){
					       JOptionPane.showMessageDialog(frame, "Vous ne pouvez plus piocher de cartes, la partie est terminée.", "Fin de la Partie", JOptionPane.INFORMATION_MESSAGE);
				            finDeJeu(); // Appel de la méthode pour terminer le jeu
				            return; // Sortir de la méthode pour éviter d'exécuter le reste du code
					}
					else {
						JButton carteButton=new JButton(new ImageIcon(cartePioche.getImage()));
						 carteButton.setPreferredSize(new Dimension(100, 150));
						 player1Panel.add(carteButton);
						 player1Panel.revalidate();
						 player1Panel.repaint();

				            frame.revalidate();
				            frame.repaint();
					}
					updatePileImage();
					
					
					
				}
				/**
				 * Méthode permet de compter le nombre de cartes restant dans la piohe de chaque joueur
				 * @return void
				  */

				private void updatePileImage() {
					// TODO Auto-generated method stub
					int nombreCartesRestantes=listeCartes.size();
					String icon= "./photos iconpioche/pile_"+nombreCartesRestantes+".png";
					pileLabel1.setIcon(new ImageIcon(icon));
					pileLabel1.revalidate();
					pileLabel1.repaint();
				}
				
				
				
				
				
	        });
	        
	        piocherbutton2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					Carte cartePioche2=listeCartes.pop();
					if(listeCartes.isEmpty()){
					       JOptionPane.showMessageDialog(frame, "Vous ne pouvez plus piocher de cartes, la partie est terminée.", "Fin de la Partie", JOptionPane.INFORMATION_MESSAGE);
				            finDeJeu(); // Appel de la méthode pour terminer le jeu
				            return; // Sortir de la méthode pour éviter d'exécuter le reste du code
					}
					else {
						JButton carteButton=new JButton(new ImageIcon(cartePioche2.getImage()));
						 carteButton.setPreferredSize(new Dimension(100, 150));
						 player2Panel.add(carteButton);
						 player2Panel.revalidate();
						 player2Panel.repaint();

				            frame.revalidate();
				            frame.repaint();
					}
					updatePileImage();
					
					
					
				}
				/**
				 * Méthode permet de compter le nombre de cartes restant dans la piohe de chaque joueur
				 * @return void
				  */
				private void updatePileImage() {
					// TODO Auto-generated method stub
					int nombreCartesRestantes=listeCartes.size();
					String icon= "./photos iconpioche/pile_"+nombreCartesRestantes+".png";
					pileLabel2.setIcon(new ImageIcon(icon));
					pileLabel2.revalidate();
					pileLabel2.repaint();
				}
				
				
				
				
				
	        });
		
	       
	      
	    	
	        passerTour2.addActionListener(new ActionListener() {
	        	
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//à revoir ca avec wassim
					jeu.jouerTour(joueurActuel);
					
					desactiverCartes(player2Panel);
					
				}

				
	        });
	        passerTour1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//à revoir ca avec wassim
					jeu.jouerTour(joueurActuel);
					desactiverCartes(player1Panel);
					 
				}
	        	
	        });
	      
	    	
	        
			
			
			}

			/**
			 * Méthode permet d'annoncer le gangnant 
			 * @return void
			 * @param gangant de type joueur
			 */
			
			private void annoncerGagnant(Joueur gagnant) {
			    //on annonce le joueur gagné
				JOptionPane.showMessageDialog(null,gagnant.getNom()+ " a gagné la partie avec un score de "+gagnant.getScore(), "FIN DE LA PARTIE", JOptionPane.INFORMATION_MESSAGE);//va afficher une message avec le nom de joueur gagnant 	
				
			
			}
       
			/**
			 * Méthode permet d'annoncer le gangnant et arreter le jeu, fermer la fenetre de jeu 
			 * @return void
			 */

			private void finDeJeu() {
			 // il manque une condition pour annoncer le gagnant et voir pour joueur actuel pour qu'il retourne le joueur qui joue et pas le joueurHumain1 
				
			  Joueur gangant =null;
			  int scoreMax=Integer.MIN_VALUE;
			  for(Joueur joueur: joueurs) {
				  if(joueur.getScore()>scoreMax) {
					  
				  
				  gangant =joueur;
				  scoreMax=joueur.getScore();
				  }
			  }
			  annoncerGagnant(gangant);
			  frame.dispose();
			}
			
			
        
        });
        
    
       
	
        
	
	
	  boutonVersionNormal.addActionListener(new ActionListener() {
	        
			@Override
			
			
		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				//on supprime tous les composants de notre fenetre et ensuite on met à jour notre frame 
				
				frame.getContentPane().removeAll();
				frame.setSize(1300,1400);
				
			    frame.setLayout(new BorderLayout());
			    labelJoueurHumain1.setBounds(900,250,250,200);
				frame.getContentPane().add(labelJoueurHumain1);
				labelJoueurHumain2.setBounds(200,250, 250, 200);
				frame.getContentPane().add(labelJoueurHumain2);
				frame.getContentPane().add(labelCarteJouee);
				JPanel panel1=new JPanel(new FlowLayout(FlowLayout.CENTER));
				//mettre une bouton click carte qui affiche une carte au milieu en haut de la fenetre, les buttons distribuercarte, score
				panel1.add(clickCarte);
				panel1.setBounds(450,300,500,100);
				frame.add(panel1);
				panel1.add(distribuercartes);
				panel1.add(scoreButton);
				
			
				JPanel panel2=new JPanel(new FlowLayout(FlowLayout.RIGHT));
				panel2.add(reglesbutton);
				panel2.add(pause);
				panel2.setBounds(1200, 600, 100, 100);
				frame.getContentPane().add(panel2);
				//ajouter la button piocher, passer tour
				JPanel piocherButtonJoueur1=new JPanel();
				piocherButtonJoueur1.add(passerTour1);
				piocherButtonJoueur1.add(piocherbutton1);
				piocherButtonJoueur1.setBounds(130,450,250,150);
				frame.getContentPane().add(piocherButtonJoueur1);
				JPanel piocherButtonJoueur2=new JPanel();
				piocherButtonJoueur2.add(piocherbutton2);
				piocherButtonJoueur2.add(passerTour2);
				piocherButtonJoueur2.setBounds(980,450,250,150);
				frame.getContentPane().add(piocherButtonJoueur2);
				//Label pour montrer le nombre de cartes restantes dans la pioche de chaque joueur
				pileLabel1.setBounds(10, 300, 200, 150);
				frame.getContentPane().add(pileLabel1);
              pileLabel2.setBounds(1200, 300, 200, 150);
				frame.getContentPane().add(pileLabel2);
				//creation de bouton pause pour soit sortir de jeu ou continuer à jouer
				JPanel panel3=new JPanel();
				panel3.add(pause);
				panel3.setBounds(130, 600, 100, 100);
				frame.getContentPane().add(panel3);
				JPanel panel=new JPanel(new FlowLayout(FlowLayout.CENTER));
				frame.getContentPane().add(panel);
				labelJoueurHumain1.setVisible(true);
				labelJoueurHumain2.setVisible(true);
				
				
				frame.revalidate();
				frame.repaint();
				frame.setVisible(true);
			    pause.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			            // un JOptionPane pour confirmer la sortie
			            int response = JOptionPane.showConfirmDialog(
			                    null,
			                    "Êtes-vous sûr de vouloir quitter le jeu ?",
			                    "Pause",
			                    JOptionPane.YES_NO_OPTION,
			                    JOptionPane.QUESTION_MESSAGE
			            );

			            if (response == JOptionPane.YES_OPTION) {
			                System.exit(0); // Quitte l'application si l'utilisateur choisit "OUI"
			            }
			        }
			        
			    });

distribuercartes.addActionListener(new ActionListener() {
		        	

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						distributeCards();
					}
					String niveau=levelPanel.getName();
					String couleurImposee=null;
					private void distributeCards() {
						// TODO Auto-generated method stub
						
					    // la distribution des cartes aux joueurs
					    for (int i = 0; i < 3; i++) { // Supposons que chaque joueur reçoit 3 cartes
					        if (!listeCartes.isEmpty()) {
					        	 Carte cardPlayer1 = listeCartes.pop();
						            Carte cardPlayer2 = listeCartes.pop();
					        	/*
					            Carte cardPlayer1 = obtenirCartePourNiveau("Debutant");
					            Carte cardPlayer2 = obtenirCartePourNiveau("Debutant");
					            */
					            JButton cardButton1 = new JButton(new ImageIcon(cardPlayer1.getImage()));
					            JButton cardButton2 = new JButton(new ImageIcon(cardPlayer2.getImage()));

					            cardButton1.setPreferredSize(new Dimension(100, 150));
					            cardButton2.setPreferredSize(new Dimension(100, 150));
					            //Ajout d'un ActionListener pour cardButton1 et cardButton2
					            cardButton1.addActionListener(new ActionListener() {
					            	
									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub//quand on clique sur la carte, on teste si la carte qu'on a chisi est valide ou pas
										
										if(!aPasserTour1) {
											jouerCarte(cardPlayer1,joueurHumain1, player1Panel, cardButton1);
											/*
											String niveauActuel=levelPanel.getName().toString();
											switch (niveauActuel) {
				                            case "Confirme":
				                                // Logique pour le niveau "Confirme"
				                                
				                                    jouerCarte(cardPlayer1, joueurHumain1, player1Panel, cardButton1);
				                                    if (joueurHumain1.aGagné()) {
				                                        annoncerGagnant(joueurHumain1);
				                                    }
				                              
				                                break;
				                            case "Initie":
				                                // Logique pour le niveau "Initie"
				                                // ...
				                                break;
				                            case "Debutant":
				                                // Logique pour le niveau "Debutant"
				                                if (estCouleurValidePourDebutant(cardPlayer1.getCouleur())) {
				                                    jouerCarte(cardPlayer1, joueurHumain1, player1Panel, cardButton1);
				                                    if (joueurHumain1.aGagné()) {
				                                        annoncerGagnant(joueurHumain1);
				                                    }
				                                } else {
				                                    JOptionPane.showMessageDialog(frame, "La carte n'est pas valide pour le niveau Debutant", "Carte Invalide", JOptionPane.WARNING_MESSAGE);
				                                }
				                                break;
				                            default:
				                            
											}
											*/
											}
											else {
												JOptionPane.showMessageDialog(frame, "vous avez passé votre tour", "Tour Passé", JOptionPane.WARNING_MESSAGE);
											}
										
									}
									/**
									 * Méthode permet de verifier si la carte est valide ou pas et si la carte est valide on le rajoute au PlayerPanel où on stocke les cartes de chaque joueur
									 * @return boolean
									  */
									

									private boolean estCouleurValidePourDebutant(String couleur) {
										// TODO Auto-generated method stub
										  return couleur.equals("Rouge") || couleur.equals("Bleu") || couleur.equals("Vert") || couleur.equals("Jaune");
									}

									
					            	
					            });
					            cardButton2.addActionListener(new ActionListener() {
					            	
									@Override
									public void actionPerformed(ActionEvent e) {
										// TODO Auto-generated method stub
										
										if(!aPasserTour2) {
										jouerCarte(cardPlayer2,joueurHumain2, player2Panel, cardButton2);
										}else {
											JOptionPane.showMessageDialog(frame, "vous avez passé votre tour", "Tour Passé", JOptionPane.WARNING_MESSAGE);
										}
									}
										
					            	
					            });
					            player1Panel.add(cardButton1);
					            player2Panel.add(cardButton2);
					        }
					    }

					    // Positionnement des panels sur le frame principal
					    frame.setLayout(new BorderLayout()); // On utilise BorderLayout pour le frame principal

					    // Ajoutation des panels des joueurs au frame
					    frame.add(player1Panel, BorderLayout.WEST); // Les cartes du joueur 1 à gauche
					    frame.add(player2Panel, BorderLayout.EAST); // Les cartes du joueur 2 à droite

					    // Actualisation de frame pour appliquer les changements
					    frame.revalidate();
					    frame.repaint();
					}
					/**
					 * Méthode permet d'obtenir une carte selon le niveau choisie par le joueur au commencement de jeu
					 * @return une carte
					  */
					
					private Carte obtenirCartePourNiveau(String string) {
						// TODO Auto-generated method stub
						 Carte carte;
						    do {
						        carte = listeCartes.pop();
						        if (niveau.equals("Debutant") && carte.getNom().equals("Joker")) {
						            // Ne pas inclure les cartes Joker pour le niveau débutant
						            listeCartes.push(carte); // Remettre la carte dans la pile
						        }
						    } while (niveau.equals("Debutant") && carte.getNom().equals("Joker"));
						    return carte;
						
					}
					
					 long tempsDebut = System.currentTimeMillis(); // Enregistre le temps de début du jeu
					 int delai = 15 * 60 * 1000; // 15 minutes en millisecondes
					 Timer jeuTimer = new Timer(delai, e -> finDeJeu());
					public void initialiserJeu() {
					 
					    jeuTimer.start();
					}

					private int tourspasses=0;
					/**
					 * Méthode permet de passer au tour suivant, c'est à dire quand le joueur1 passe son tour, on passe au tour suivant (c'est au 2eme joueur de jouer)
					 * 
					 * @return void
					  */
					
					private void passerAuTourSuivant() {
						// TODO Auto-generated method stub
						
						tourspasses++;
						
						//affichage d'une message avec le nombre de tours passés
						JOptionPane.showMessageDialog(frame,"Tour"+tourspasses+"terminé", "Information", JOptionPane.INFORMATION_MESSAGE);
						//on verifie si les deux joueurs ont joué ou passé leur tour et si c'est le cas, on mettra à jour l'interface:
						if(tourspasses>=2) {
							reinitialiserCentre();
							//enuite on met à jour le compteur des tours passés:
							tourspasses=0;
							  long tempsActuel = System.currentTimeMillis();
							    
								if (tempsActuel - tempsDebut >= (15 * 60 * 1000)) { // Vérifie si 15 minutes se sont écoulées
							      
									jeuTimer.stop(); // Arrête le timer
							        finDeJeu(); // Annonce le gagnant
						}
					}
					}
					/**
					 * Méthode permet de reinitialiser la carte au centre après que les deux joueurs passent leur tour 
					 * @return void
					 * 
					  */
					

					private void reinitialiserCentre() {
						// TODO Auto-generated method stub
						   cardPanelJeu.removeAll();
						  
						   //on ajoute une nouvelle carte au milieu
						   if (!listeCartes.isEmpty()&&!carteAffichage) {
							   Random random2 = new Random();
							    Carte carteAleatoire2 = listeCartes.get(random2.nextInt(listeCartes.size()));
							    if(carteAleatoire2.getNom().equals("Joker")) {
						    		listeCartes.push(carteAleatoire2);
						    		Collections.shuffle(listeCartes);
						    	}
					            JButton nouvelleCarte= new JButton(new  ImageIcon(carteAleatoire2.getImage()));
					            nouvelleCarte.setPreferredSize(new Dimension(100, 150)); 
					            cardPanelJeu.add(nouvelleCarte);
					            //ensuite on met à jour l'affichage
					            cardPanelJeu.revalidate();
					            cardPanelJeu.repaint();
					            
						   }
						   
					}
					/**
					 * Méthode permet de jouer une carte par un joueur
					 * @return void
					 * @param carte de type Carte
					 * @param joueur de type Joueur
					 * @param playerpanel de type JPanel
					 * @param cardButton de type JButton
					  */
					
					private void jouerCarte(Carte carte, Joueur joueur, JPanel playerPanel, JButton cardButton) {
						// TODO Auto-generated method stub
					//si la carte valide on le supprime du panel des cartes (main de chaque joueur) et on l'ajoute dans cardpanelJeu
						initialiserJeu();
						if(carte.getCouleur().equals((carteAleatoire.getCouleur()))|| carte.getNom().equals(carteAleatoire.getNom())){
							
							playerPanel.remove(cardButton);
							playerPanel.revalidate();
							playerPanel.repaint();
							cardPanelJeu.add(cardButton);
							frame.revalidate();
							frame.repaint();
							
						}else if(carte.getCouleur().equals("Joker")|| carte.getNom().equals("Joker")) {
							
							playerPanel.remove(cardButton);
							playerPanel.revalidate();
							playerPanel.repaint();
							cardPanelJeu.add(cardButton);
							frame.revalidate();
							frame.repaint();
									
									
						
							String[] options= {"Jaune", "Rouge", "Vert","Bleu"};
							couleurImposee=(String) JOptionPane.showInputDialog(
									null,
									"Choisissez une couleur: ","Joker!", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
							
							if(carte.getCouleur().equals(couleurImposee)) {
								playerPanel.remove(cardButton);
								playerPanel.revalidate();
								playerPanel.repaint();
								cardPanelJeu.add(cardButton);
								frame.revalidate();
								frame.repaint();
							}
							else {

								JOptionPane.showMessageDialog(frame, "vous devez choisir une carte de couleur "+couleurImposee, "Erreur", JOptionPane.WARNING_MESSAGE);
								
							}
						
							
						}
						
						
						
                            
                         
						
						
						else {
							 JOptionPane.showMessageDialog( reglesbutton, "La carte n'est pas valide !!", "ERREUR", JOptionPane.INFORMATION_MESSAGE);
							 joueur.retirerPoints(5);
						}
						//si les deux joueurs ont joué, on met à jour la carte au milieu
						jeu.jouerTour(joueurActuel);
						passerAuTourSuivant();
						
							
						
					}
					
					
					
		        });
		
			    
			   

				clickCarte.addActionListener(new ActionListener() {
					
					@Override
					
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					   
					    	
				            JButton cardButton = new JButton(new  ImageIcon(carteAleatoire.getImage()));
				            cardButton.setPreferredSize(new Dimension(100, 150));
				           cardPanelJeu.removeAll();
				            cardPanelJeu.setBounds(600,300,100,100);
				            cardPanelJeu.add(cardButton);
				            frame.getContentPane().add(cardPanelJeu); 
				            

				            frame.revalidate();
				            frame.repaint();
				        }
				    
				});
				
			

	        piocherbutton1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Carte cartePioche=listeCartes.pop();
					if(listeCartes.isEmpty()){
					       JOptionPane.showMessageDialog(frame, "Vous ne pouvez plus piocher de cartes, la partie est terminée.", "Fin de la Partie", JOptionPane.INFORMATION_MESSAGE);
				            finDeJeu(); // Appel de la méthode pour terminer le jeu
				            return; // Sortir de la méthode pour éviter d'exécuter le reste du code
					}
					else {
						JButton carteButton=new JButton(new ImageIcon(cartePioche.getImage()));
						 carteButton.setPreferredSize(new Dimension(100, 150));
						 player1Panel.add(carteButton);
						 player1Panel.revalidate();
						 player1Panel.repaint();

				            frame.revalidate();
				            frame.repaint();
					}
					updatePileImage();
					
					
					
				}
				/**
				 * Méthode permet de compter le nombre de cartes restant dans la piohe de chaque joueur
				 * @return void
				  */
				
				private void updatePileImage() {
					// TODO Auto-generated method stub
					int nombreCartesRestantes=listeCartes.size();
					String icon= "./photos iconpioche/pile_"+nombreCartesRestantes+".png";
					pileLabel1.setIcon(new ImageIcon(icon));
					pileLabel1.revalidate();
					pileLabel1.repaint();
				}
				
				
				
				
				
	        });
	        
	        piocherbutton2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					Carte cartePioche2=listeCartes.pop();
					if(listeCartes.isEmpty()){
					       JOptionPane.showMessageDialog(frame, "Vous ne pouvez plus piocher de cartes, la partie est terminée.", "Fin de la Partie", JOptionPane.INFORMATION_MESSAGE);
				            finDeJeu(); // Appel de la méthode pour terminer le jeu
				            return; // Sortir de la méthode pour éviter d'exécuter le reste du code
					}
					else {
						JButton carteButton=new JButton(new ImageIcon(cartePioche2.getImage()));
						 carteButton.setPreferredSize(new Dimension(100, 150));
						 player2Panel.add(carteButton);
						 player2Panel.revalidate();
						 player2Panel.repaint();

				            frame.revalidate();
				            frame.repaint();
					}
					updatePileImage();
					
					
					
				}
				/**
				 * Méthode permet de compter le nombre de cartes restant dans la piohe de chaque joueur
				 * @return void
				  */
				

				private void updatePileImage() {
					// TODO Auto-generated method stub
					int nombreCartesRestantes=listeCartes.size();
					String icon= "./photos iconpioche/pile_"+nombreCartesRestantes+".png";
					pileLabel2.setIcon(new ImageIcon(icon));
					pileLabel2.revalidate();
					pileLabel2.repaint();
				}
				
				
				
				
				
	        });
		
	       
	      
	    	
	        passerTour2.addActionListener(new ActionListener() {
	        	
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					jeu.jouerTour(joueurActuel);
					
					desactiverCartes(player2Panel);
					
				}

				
	        });
	       
			
	        passerTour1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//à revoir ca avec wassim
					jeu.jouerTour(joueurActuel);
					desactiverCartes(player1Panel);
					 
				}
	        	
	        });
	      
	    	
	        
			
			
			}

			/**
			 * Méthode permet d'annoncer le gangnant 
			 * @return void
			 * @param gangant de type joueur
			 */
			
			private void annoncerGagnant(Joueur gagnant) {
			    //on annonce le joueur gagné
				JOptionPane.showMessageDialog(null,gagnant.getNom()+ " a gagné la partie avec un score de "+gagnant.getScore(), "FIN DE LA PARTIE", JOptionPane.INFORMATION_MESSAGE);//va afficher un message avec le nom de joueur gagnant 	
				
			
			}
			/**
			 * Méthode permet d'annoncer le gangnant et arreter le jeu, fermer la fenetre de jeu 
			 * @return void
			 */
			
			private void finDeJeu() {
			
				
			  Joueur gangant =null;
			  int scoreMax=Integer.MIN_VALUE;
			  for(Joueur joueur: joueurs) {
				  if(joueur.getScore()>scoreMax) {
					  
				  
				  gangant =joueur;
				  scoreMax=joueur.getScore();
				  }
			  }
			  annoncerGagnant(gangant);
			  frame.dispose();
			}
			
			
      
      });
      
  
     
	}
      
	


	    


	







	/**
	 * Méthode permet de desactiver les buttons si le joueur clique sur le button passerTour, il pourra plus jouer jusqu'à la prochaine tour
	 * @return void
	 * @param playerPanel de type JPanel 
	 */
	protected static void desactiverCartes(JPanel playerPanel) {
		// TODO Auto-generated method stub
		
		 for (Component comp : playerPanel.getComponents()) {
		        if (comp instanceof JButton) {
		            comp.setEnabled(false); // Désactiver le bouton
		        }
		    }
		}

		


	/**
	 * Méthode permet d'afficher une fenêtre pour demander le nom de l'utilisateur
	 * @return un String
	 *  
	 */

	private static String askForName() {
	   
	    final CountDownLatch latch = new CountDownLatch(1);//on initialise countDownLatch à 1, et quand on decompte jusqu'à 0, ca renvoie le nom de joueur
	    final String[] playerNameHolder = new String[1]; //pour stocker le nom de joueur

	    
	    //la fenetre de notre jeu va pas ouvrir jusqu'à ce que le joueur saisi son nom
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	//la creation de la fenetre de saisie de nom
	            JFrame inputFrame = new JFrame("Veuillez entrer votre nom");
	            inputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	            inputFrame.setLayout(new FlowLayout());
	            //la creation d'une champ de texte pour la saisie du l'utilisateur et boutn "soumettre"
	            JTextField playerNameField = new JTextField(20);
	            JButton submitButton = new JButton("Soumettre");
	            //on ajoute tout les composants à notre fenetre c'est à dire le label, le champ de texte, le bouton 
	            inputFrame.add(new JLabel("nom du joueur:"));
	            inputFrame.add(playerNameField);
	            inputFrame.add(submitButton);
	            //lorsque l'utilisateur click sur soumettre :
	            submitButton.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	//on stock le nom du joueur dans le tableau 
	                    playerNameHolder[0] = playerNameField.getText();
	                    inputFrame.dispose(); // on ferme la fenetre apres la soumission
	                    latch.countDown(); 
	                }
	            });

	            inputFrame.pack();
	            inputFrame.setLocationRelativeTo(null);
	            inputFrame.setVisible(true);
	        }
	    });
	    

	    try {
	        latch.await(); //le thread attend jusqu'à ce que le joueur à ce que le joueur ait soumis son nom, donc son objectif(thread) est des syncronyser la saisie avec l'ffichage de nom de joueur
	    } catch (InterruptedException e) {//en cas d'interruption
	        Thread.currentThread().interrupt();//on remet le statut de thread 
	    }
	    //quand countDown est appelée, elle decremete de 1 ce compteur initialisé à 1

	    return playerNameHolder[0]; //return le nom de joueur après la soumission quand le countDownLatch compte jusqu'à 0
	}


	/**
	 * Méthode permet de defiir le style des buttons de jeu
	 * @param text
	 * @return un button
	 *  
	 */
	private static JButton createButton(String text) {
        JButton button = new JButton(text);

        // Style du bouton
        button.setBackground(Color.gray); // couleur de fond du bouton
        button.setForeground(Color.BLACK); // couleur du texte du bouton
        button.setFont(new Font("Arial", Font.BOLD, 12)); // la police et taille
        button.setBorderPainted(false); // pas de bordure
        button.setFocusPainted(false); // pas de focus
        button.setPreferredSize(new Dimension(100, 100)); // taille du bouton

        return button;
    }
	/**
	 * Méthode permet de defiir le style des buttons de jeu
	 * @param text, iconPath
	 * @return un button
	 *  
	 */
	
	private static JButton createButton1(String text, String iconPath) {
	    JButton button = new JButton(text);

	    // Style du bouton
	    button.setBackground(Color.gray); // couleur de fond du bouton
	    button.setForeground(Color.BLACK); // couleur du texte du bouton
	    button.setFont(new Font("Arial", Font.BOLD, 10)); // la police et taille
	    button.setBorderPainted(false); // pas de bordure
	    button.setFocusPainted(false); // pas de focus
	    button.setPreferredSize(new Dimension(100, 100)); // taille du bouton

	    // Ajout de l'icône au bouton
	    if (iconPath != null && !iconPath.isEmpty()) {
	        ImageIcon originalIcon = new ImageIcon(iconPath);
	        Image scaledImage = originalIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
	        ImageIcon scaledIcon = new ImageIcon(scaledImage);
	        button.setIcon(scaledIcon);
	        button.setHorizontalTextPosition(JButton.RIGHT); 
	    }

	    return button;
	}
	
	
  
    
 
    
		
		
		
		
		
	 }



