/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettp5;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Quentin
 */
public class Joueur {
    /*
    Attribut : un personnage qui sera choisi par le joueur
    */
    private Personnage personnageChoisi;
    private int numeroJoueur;

    /*
    Getter sur le personnage du Joueur
    */
    
    public int getNumeroJoueur() {
        return numeroJoueur;
    }

    public Personnage getPersonnageChoisi() {
        return personnageChoisi;
    }
    /*
    Setter sur le personnage du Joueur
    */
    public void setPersonnageChoisi(Personnage personnageChoisi) {
        this.personnageChoisi = personnageChoisi;
    }

    public void setNumeroJoueur(int numeroJoueur) {
        this.numeroJoueur = numeroJoueur;
    }
  
      /*
    Constructeur
    */

   public Joueur(int num){
       System.out.println("-----------------------------------------------------");
       System.out.println("CHOIX DU PERSONNAGE");
       System.out.println("Choisissez votre personnage");
       System.out.println("1 : Archer");
       System.out.println("2 : Guerrier");
       System.out.println("3 : Mage");
       System.out.println("4 : Paysan");
       int numero=0;
       Scanner scan= new Scanner(System.in);
       Random varAlea1= new Random();
       Random varAlea2= new Random();
       Random varAlea3= new Random();
       int pA;
       int pMana;
       int pP;
       int pM;
       int rM;
       int dA;
       int dM;
       int distMax;
       int pPar;
       int nbFleche;
       Point2D origine=new Point2D(0,0);
       String nomPersonnage;
       while((numero<=0)||(numero>4)){
           System.out.println("Entrer un entier entre 1 et 4");
           numero=scan.nextInt();
       }
       System.out.println("Entrer un nom de personnage");
       nomPersonnage=scan.next();
       switch(numero){
           case 1: 
               pA=(varAlea1.nextInt(31)+30);
               pP=(varAlea1.nextInt(31)+50);
               dA=(varAlea2.nextInt(11)+30);
               pPar=(varAlea2.nextInt(11)+10);
               nbFleche=(varAlea3.nextInt(16));
               personnageChoisi=new Archer(nomPersonnage,100,0,pA,pP,0,50,dA,0,3,pPar,origine,nbFleche);
               break;
           case 2:    
               pA=(varAlea1.nextInt(31)+50);
               pP=(varAlea1.nextInt(31)+30);
               dA=(varAlea2.nextInt(11)+20);
               pPar=(varAlea2.nextInt(16)+10);
               personnageChoisi=new Guerrier(nomPersonnage,100,0,pA,pP,0,50,dA,0,1,pPar,origine);   
             break;           
           case 3:    
               pM=(varAlea1.nextInt(31)+40);
               pP=(varAlea1.nextInt(31)+40);
               dM=(varAlea2.nextInt(11)+25);
               pPar=(varAlea2.nextInt(11)+10);
               pMana=(varAlea3.nextInt(16));
               personnageChoisi=new Mage(nomPersonnage,100,pMana,0,pP,pM,50,0,dM,3,pPar,origine);   
             break;    
           case 4:    
               pP=(varAlea1.nextInt(31)+50);
               pPar=(varAlea2.nextInt(11)+40);
               personnageChoisi=new Guerrier(nomPersonnage,100,0,0,pP,0,70,0,0,0,pPar,origine);   
             break;          
          default:
            System.out.println("choice error");     
       }
       numeroJoueur=num;
       System.out.println("-----------------------------------------------------");    
   }
     /*
    Méthode11
    */
  public void afficheCaractJoueur(){
      if(personnageChoisi instanceof Archer){
         System.out.println("************************************************");   
         System.out.println("Affiche caractéristique de Joueur "+numeroJoueur+" qui est un Archer"); 
         System.out.println("Nom du personnage "+personnageChoisi.getNom()); 
         System.out.println("Point de vie "+personnageChoisi.getPtVie()); 
         System.out.println("Pourcentage d'attaque "+personnageChoisi.getPourcentageAtt()); 
         System.out.println("Pourcentage de parade "+personnageChoisi.getPourcentagePar()); 
         System.out.println("Dégâts d'attaque "+personnageChoisi.getDegAtt()); 
         System.out.println("Dist Max d'attaque "+personnageChoisi.getDistAttMax());
         System.out.println("Vous ne pouvez pas attaquer en adjacent");
         System.out.println("Points de Parade "+personnageChoisi.getPtPar());
         System.out.println("nbFleche "+((Archer)personnageChoisi).getNbFleche());
         System.out.println("************************************************");
      }
      if(personnageChoisi instanceof Guerrier){
         System.out.println("************************************************");   
         System.out.println("Affiche caractéristique de Joueur "+numeroJoueur+" qui est un Guerrier"); 
         System.out.println("Nom du personnage "+personnageChoisi.getNom()); 
         System.out.println("Point de vie "+personnageChoisi.getPtVie()); 
         System.out.println("Pourcentage d'attaque "+personnageChoisi.getPourcentageAtt()); 
         System.out.println("Pourcentage de parade "+personnageChoisi.getPourcentagePar()); 
         System.out.println("Dégâts d'attaque "+personnageChoisi.getDegAtt()); 
         System.out.println("Dist Max d'attaque "+personnageChoisi.getDistAttMax());
         System.out.println("Vous ne pouvez pas attaquer à distance");
         System.out.println("Points de Parade "+personnageChoisi.getPtPar());
         System.out.println("************************************************");
      }
      if(personnageChoisi instanceof Mage){
         System.out.println("************************************************");   
         System.out.println("Affiche caractéristique de Joueur "+numeroJoueur+" qui est un Mage"); 
         System.out.println("Nom du personnage "+personnageChoisi.getNom()); 
         System.out.println("Point de vie "+personnageChoisi.getPtVie()); 
         System.out.println("Pourcentage de Magie "+personnageChoisi.getPourcentageMag()); 
         System.out.println("Pourcentage de parade "+personnageChoisi.getPourcentagePar()); 
         System.out.println("Dégâts magiques "+personnageChoisi.getDegMag()); 
         System.out.println("Dist Max d'attaque "+personnageChoisi.getDistAttMax());
         System.out.println("Vous pouvez attaquer sur une distance entre ente 1 et 3 compris");
         System.out.println("Points de Parade "+personnageChoisi.getPtPar());
         System.out.println("Points de Mana "+personnageChoisi.getPtMana());
         System.out.println("************************************************");
      }
      if(personnageChoisi instanceof Guerrier){
         System.out.println("************************************************");   
         System.out.println("Affiche caractéristique de Joueur "+numeroJoueur+" qui est un Paysan"); 
         System.out.println("Nom du personnage "+personnageChoisi.getNom()); 
         System.out.println("Point de vie "+personnageChoisi.getPtVie()); 
         System.out.println("Pourcentage d'attaque "+personnageChoisi.getPourcentageAtt()); 
         System.out.println("Pourcentage de parade "+personnageChoisi.getPourcentagePar()); 
         System.out.println("Vous ne pouvez pas attaquer");
         System.out.println("Points de Parade "+personnageChoisi.getPtPar());
         System.out.println("************************************************");
      }
      
      
      
  }  
    
    
    
    
    
    
}
