/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettp5;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author Romain
 */
public class World {

    private int tailleMonde;
    private double nbPersonnage;

    String plateauDeJeu[][];
    //private ArrayList<ArrayList<int>> plateauDeJeu;

    private ArrayList<Archer> lArcher;
    private ArrayList<Guerrier> lGuerrier;
    private ArrayList<Paysan> lPaysan;
    private ArrayList<Mage> lMage;
    private ArrayList<Lapin> lLapin;
    private ArrayList<Loup> lLoup;
    private ArrayList<Joueur> lJoueur;

    public World(int taille, int nbP) {
        /*
       Dans ce constructeur le nombre de personnage est un multiple de 6
        */
       
            nbPersonnage = nbP;
            tailleMonde = taille;
            plateauDeJeu = new String[taille][taille];

            lArcher = new ArrayList<>();
            lGuerrier = new ArrayList<>();
            lPaysan = new ArrayList<>();
            lMage = new ArrayList<>();
            lLapin = new ArrayList<>();
            lLoup = new ArrayList<>();
            lJoueur = new ArrayList<>();
            /*
            Initialisation du palteau de jeu
            */
            for(int n=0;n<tailleMonde;n++){
                for(int m=0;m<tailleMonde;m++){
                    plateauDeJeu[n][m]=" 0";
                }
            }
            /* 
            Variable aléatoire de tirage de position
            */
            Random generePos = new Random();

            /*
            Appel des joueurs
            On commence par demander si l'utilisateur veut créer un joueur
            */
            Point2D origine=new Point2D(0,0);
            boolean test;
            test=true;
            boolean OK;
            int choixJoueur = 0;
            int compt=1;
            
            while(test){
                OK=true;
                while(OK){
                    System.out.println("Que désirez vous faire?");
                    System.out.println(" 1 : Créer un joueur "+compt); 
                   System.out.println(" 2 : Ne pas Créer de joueur (cela stoppera la procédure)");
                            
                    Scanner myScan=new Scanner(System.in);
                    choixJoueur=myScan.nextInt();
                    if((choixJoueur==1)||(choixJoueur==2)){
                        OK=false;
                    }
                }
                    if(choixJoueur==2){
                    test=false;
                    }    
                    else{    Joueur joueurcompt= new Joueur(compt);
                    lJoueur.add(joueurcompt);
                    boolean verif;
                    verif = true;
                    while(verif){
                        int xJoueur= generePos.nextInt(taille);
                        int yJoueur= generePos.nextInt(taille);
                        Point2D posJoueur=new Point2D(xJoueur,yJoueur);
                        for(int j=0;j<lJoueur.size();j++){
                            if((lJoueur.get(j).getPersonnageChoisi().pos.equals(posJoueur))&&(j!=compt)){
                                verif=false;
                            }
                        }
                        joueurcompt.getPersonnageChoisi().pos=posJoueur;
                    }
                    plateauDeJeu[(int)joueurcompt.getPersonnageChoisi().pos.getAbcisse()][(int)joueurcompt.getPersonnageChoisi().pos.getOrdonnee()]="J"+compt;
                }
            }
            /*
            Les archers
            */
            for(int i=0;i<(nbP/6);i++){
                
                Archer Archeri = new Archer("Robin Des Bois"+i, 100, 0, 80, 50, 0, 0, 20, 0, 5, 10, origine, 30);

            boolean test2;
            test2=false;
            while(test2){
                int nouvx=generePos.nextInt(taille);
                int nouvy=generePos.nextInt(taille);
                Point2D nouvPos=new Point2D(nouvx,nouvy);
                /*
                Les guerriers
                */
                if(memePos(nouvPos)){
                    test2=false;
                }
                Archeri.pos=nouvPos;
                lArcher.add(Archeri);
                plateauDeJeu[(int)Archeri.pos.getAbcisse()][(int)Archeri.pos.getOrdonnee()]="A"+i;
            }    
            }
            
             /*
            Les Guerriers
            */
            for(int k=0;k<(nbP/6);k++){
                
                Guerrier Guerrierk = new Guerrier("Gros Bill"+k, 100, 0, 80, 50, 0, 0, 20, 0, 1, 50, origine);
            boolean test2;
            test2=false;
            while(test2){
                int nouvx=generePos.nextInt(taille);
                int nouvy=generePos.nextInt(taille);
                Point2D nouvPos=new Point2D(nouvx,nouvy);

                if(memePos(nouvPos)){
                    test2=false;
                }
                Guerrierk.pos=nouvPos;
                lGuerrier.add(Guerrierk);
                plateauDeJeu[(int)Guerrierk.pos.getAbcisse()][(int)Guerrierk.pos.getOrdonnee()]="G"+k;
            }    
            }
             /*
            Les Mages
            */
            for(int m=0;m<(nbP/6);m++){
                
                Mage Magem = new Mage("Merlin"+m, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, origine);
            boolean test2;
            test2=true;
            while(test2){
                int nouvx=generePos.nextInt(taille);
                int nouvy=generePos.nextInt(taille);
                Point2D nouvPos=new Point2D(nouvx,nouvy);

                if(memePos(nouvPos)){
                    test2=false;
                }
                Magem.pos=nouvPos;
                lMage.add(Magem);
                plateauDeJeu[(int)Magem.pos.getAbcisse()][(int)Magem.pos.getOrdonnee()]="M"+m;
            }    
            }
             /*
            Les Paysans
            */
            for(int n=0;n<(nbP/6);n++){
                
                Paysan Paysann = new Paysan("Jean le peon"+n, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, origine);
            boolean test2;
            test2=true;
            while(test2){
                int nouvx=generePos.nextInt(taille);
                int nouvy=generePos.nextInt(taille);
                Point2D nouvPos=new Point2D(nouvx,nouvy);

                if(memePos(nouvPos)){
                    test2=false;
                }
                Paysann.pos=nouvPos;
                lPaysan.add(Paysann);
                plateauDeJeu[(int)Paysann.pos.getAbcisse()][(int)Paysann.pos.getOrdonnee()]="P"+n;
            }    
            }
            
            /*
            Les Loups
            */
            for(int p=0;p<(nbP/6);p++){
                
                Loup Loupp = new Loup("Wolf aaaahhhhouuu"+p, 10, 10, 10, 10, 40, origine);
            boolean test2;
            test2=true;
            while(test2){
                int nouvx=generePos.nextInt(taille);
                int nouvy=generePos.nextInt(taille);
                Point2D nouvPos=new Point2D(nouvx,nouvy);

                if(memePos(nouvPos)){
                    test2=false;
                }
                Loupp.pos=nouvPos;
                lLoup.add(Loupp);
                plateauDeJeu[(int)Loupp.pos.getAbcisse()][(int)Loupp.pos.getOrdonnee()]="L"+p;
            }    
            }
            
             /*
            Les Lapin
            */
            for(int q=0;q<(nbP/6);q++){
                
                 Lapin Lapinq = new Lapin("Jiji la lapine"+q, 10, 10, 10, 10, 40, origine);
            boolean test2;
            test2=true;
            while(test2){
                int nouvx=generePos.nextInt(taille);
                int nouvy=generePos.nextInt(taille);
                Point2D nouvPos=new Point2D(nouvx,nouvy);

                if(memePos(nouvPos)){
                    test2=false;
                }
                Lapinq.pos=nouvPos;
                lLapin.add(Lapinq);
                plateauDeJeu[(int)Lapinq.pos.getAbcisse()][(int)Lapinq.pos.getOrdonnee()]="l"+q;
            }    
            }
            
        
    }

    public void afficheWorld() {

        for (int i = 0; i < nbPersonnage; i++) {
            lGuerrier.get(i).affiche();
        }
        for (int i = 0; i < nbPersonnage; i++) {
            lArcher.get(i).affiche();
        }
        for (int i = 0; i < nbPersonnage; i++) {
            lPaysan.get(i).affiche();
        }
        for (int i = 0; i < nbPersonnage; i++) {
            lMage.get(i).affiche();
        }
        for (int i = 0; i < nbPersonnage; i++) {
            lLapin.get(i).affiche();
        }
        for (int i = 0; i < nbPersonnage; i++) {
            lLoup.get(i).affiche();
        }

    }

    public void affichePlateau() {
        for (int i = 0; i < tailleMonde; i++) {
            for (int j = 0; j < tailleMonde; j++) {
                System.out.println("Case " + "[" + i + ";" + j + "]: " + plateauDeJeu[i][j]);
            }
        }
    }

    public void tourDeJeu(int nbTour) {
        /*
            Affichage des caractéristiques
            */
            for(int u=0;u<lJoueur.size();u++){
                lJoueur.get(u).afficheCaractJoueur();
            }
        for (int i = 1; i <= nbTour; i++) {

            int action;
            int depl;
            int choixPerso;
            Scanner scan = new Scanner(System.in);
            /*
            Creation d'un tableau de créature
            */
            ArrayList<Creature> lCreature=new ArrayList<Creature>();
            for(int j=0;j<lJoueur.size();j++){
                lCreature.add(lJoueur.get(j).getPersonnageChoisi());
            }
            for(int k=0;k<lArcher.size();k++){
                lCreature.add(lArcher.get(k));
            }
            for(int l=0;l<lGuerrier.size();l++){
                lCreature.add(lGuerrier.get(l));
            }
            for(int m=0;m<lMage.size();m++){
                lCreature.add(lMage.get(m));
            }
            for(int n=0;n<lPaysan.size();n++){
                lCreature.add(lPaysan.get(n));
            }
            for(int p=0;p<lLoup.size();p++){
                lCreature.add(lLoup.get(p));
            }
            for(int q=0;q<lLapin.size();q++){
                lCreature.add(lLapin.get(q));
            }
            
            
            System.out.println("========= Tour de jeu n°: "+i+" ===========");
            /*
            On commence par faire joueur les joueurs
            */
            for(int j=0;j<lJoueur.size();j++){
            System.out.println("====================");   
            System.out.println("Au tour de Joueur "+j);
            boolean test;
            test=true;
            while(test){
            System.out.println("Que désirez vous faire?");
            System.out.println("1 : se déplacer");
            System.out.println("2 : combattre");
            int choixUtil=scan.nextInt();
            if((choixUtil==1)||(choixUtil==2)){
                test=false;
            }
            if(choixUtil==1){
                lJoueur.get(j).getPersonnageChoisi().deplacer(lCreature);
            }
            if(choixUtil==2){
                System.out.println("Entrer le type d'une créature à attaquer");
                String nomPersoAttaque=scan.next();
                int numero=0;
                System.out.println("Entrer le numéro de la créature à attaquer");
                numero=scan.nextInt();
                if(nomPersoAttaque.equals("Archer")){
                    combattreAvecJoueurA(j,lArcher,numero);
                }
                if(nomPersoAttaque.equals("Guerrier")){
                    combattreAvecJoueurG(j,lGuerrier,numero);
                }
                if(nomPersoAttaque.equals("Mage")){
                    combattreAvecJoueurM(j,lMage,numero);
                }
                if(nomPersoAttaque.equals("Paysan")){
                    combattreAvecJoueurP(j,lPaysan,numero);
                }
                if(nomPersoAttaque.equals("Loup")){
                    combattreAvecJoueurL(j,lLoup,numero);
                }
                if(nomPersoAttaque.equals("Lapin")){
                    combattreAvecJoueurl(j,lLapin,numero);
                }
            }
            
            }
            miseAJourPlateau();
            affichePlateauDeJeu();
            }
            System.out.println("====================");   
            System.out.println("Au tour des IA - On commence par les Archers");
            for(int i1=0;i1<lArcher.size();i1++){
                if(lArcher.get(i1).APorter(this)){
                lArcher.get(i1).combattreIA(this);
            }
                else{
                    lArcher.get(i1).deplacerIA(plateauDeJeu);
                }
            }
            for(int i2=0;i2<lGuerrier.size();i2++){
                if(lGuerrier.get(i2).APorter(this)){
                lGuerrier.get(i2).combattreIA(this);
            }
                else{
                    lGuerrier.get(i2).deplacerIA(plateauDeJeu);
                }
            }
            for(int i3=0;i3<lMage.size();i3++){
                if(lMage.get(i3).APorter(this)){
                lMage.get(i3).combattreIA(this);
            }
                else{
                    lMage.get(i3).deplacerIA(plateauDeJeu);
                }
            }
            for(int i4=0;i4<lLoup.size();i4++){
                if(lLoup.get(i4).APorter(this)){
                lLoup.get(i4).combattreIA(this);
            }
                else{
                    lLoup.get(i4).deplacerIA(plateauDeJeu);
                }
            }
            for(int i5=0;i5<lPaysan.size();i5++){
                
                    lPaysan.get(i5).deplacerIA(plateauDeJeu);
               
            }
            for(int i6=0;i6<lLapin.size();i6++){
                
                    lLapin.get(i6).deplacerIA(plateauDeJeu);
               
            }
            
    }

}
/*
    Getter
    */

    public ArrayList<Joueur> getlJoueur() {
        return lJoueur;
    }

    public int getTailleMonde() {
        return tailleMonde;
    }

    public double getNbPersonnage() {
        return nbPersonnage;
    }

    public String[][] getPlateauDeJeu() {
        return plateauDeJeu;
    }

    public ArrayList<Archer> getlArcher() {
        return lArcher;
    }

    public ArrayList<Guerrier> getlGuerrier() {
        return lGuerrier;
    }

    public ArrayList<Paysan> getlPaysan() {
        return lPaysan;
    }

    public ArrayList<Mage> getlMage() {
        return lMage;
    }

    public ArrayList<Lapin> getlLapin() {
        return lLapin;
    }

    public ArrayList<Loup> getlLoup() {
        return lLoup;
    }
    
 /*
    Setter
    */   

    public void setlJoueur(ArrayList<Joueur> lJoueur) {
        this.lJoueur = lJoueur;
    }

    public void setTailleMonde(int tailleMonde) {
        this.tailleMonde = tailleMonde;
    }

    public void setNbPersonnage(double nbPersonnage) {
        this.nbPersonnage = nbPersonnage;
    }

    public void setPlateauDeJeu(String[][] plateauDeJeu) {
        this.plateauDeJeu = plateauDeJeu;
    }

    public void setlArcher(ArrayList<Archer> lArcher) {
        this.lArcher = lArcher;
    }

    public void setlGuerrier(ArrayList<Guerrier> lGuerrier) {
        this.lGuerrier = lGuerrier;
    }

    public void setlPaysan(ArrayList<Paysan> lPaysan) {
        this.lPaysan = lPaysan;
    }

    public void setlMage(ArrayList<Mage> lMage) {
        this.lMage = lMage;
    }

    public void setlLapin(ArrayList<Lapin> lLapin) {
        this.lLapin = lLapin;
    }

    public void setlLoup(ArrayList<Loup> lLoup) {
        this.lLoup = lLoup;
    }
    
    public void affichePlateauDeJeu(){
      for(int i=0;i<tailleMonde;i++){
          for(int j=0;j<tailleMonde;j++){
          System.out.print(plateauDeJeu[i][j]);    
          System.out.print(" ");
          }
          System.out.println("");
      }  
       
    }
    
    public boolean memePos(Point2D nouvPos){
        boolean test;
        test=true;
        for(int i=0;i<lJoueur.size();i++){
            if(lJoueur.get(i).getPersonnageChoisi().pos.equals(nouvPos)){
                test=false;
            }      
        }
        for(int j=0;j<lArcher.size();j++){
            if(lArcher.get(j).pos.equals(nouvPos)){
                test=false;
            }      
        }
        for(int k=0;k<lGuerrier.size();k++){
            if(lGuerrier.get(k).pos.equals(nouvPos)){
                test=false;
            }      
        }
        for(int l=0;l<lMage.size();l++){
            if(lMage.get(l).pos.equals(nouvPos)){
                test=false;
            }      
        }
        for(int m=0;m<lPaysan.size();m++){
            if(lPaysan.get(m).pos.equals(nouvPos)){
                test=false;
            }      
        }
        for(int n=0;n<lLoup.size();n++){
            if(lLoup.get(n).pos.equals(nouvPos)){
                test=false;
            }      
        }
        for(int p=0;p<lLapin.size();p++){
            if(lLapin.get(p).pos.equals(nouvPos)){
                test=false;
            }      
        }
        return(test);
    }
    
    public void miseAJourPlateau(){
        
        for(int n=0;n<tailleMonde;n++){
                for(int m=0;m<tailleMonde;m++){
                    plateauDeJeu[n][m]=" 0";
                }
            }
        
            for(int j=0;j<lJoueur.size();j++){
                plateauDeJeu[(int)lJoueur.get(j).getPersonnageChoisi().pos.getAbcisse()][(int)lJoueur.get(j).getPersonnageChoisi().pos.getOrdonnee()]="J"+(j+1);
            }
            for(int k=0;k<lArcher.size();k++){
                plateauDeJeu[(int)lArcher.get(k).pos.getAbcisse()][(int)lArcher.get(k).pos.getOrdonnee()]="A"+k;
            }
            for(int l=0;l<lGuerrier.size();l++){
                plateauDeJeu[(int)lGuerrier.get(l).pos.getAbcisse()][(int)lGuerrier.get(l).pos.getOrdonnee()]="G"+l;
            }
            for(int m=0;m<lMage.size();m++){
                plateauDeJeu[(int)lMage.get(m).pos.getAbcisse()][(int)lMage.get(m).pos.getOrdonnee()]="M"+m;
            }
            for(int n=0;n<lPaysan.size();n++){
               plateauDeJeu[(int)lPaysan.get(n).pos.getAbcisse()][(int)lPaysan.get(n).pos.getOrdonnee()]="P"+n;
            }
            for(int p=0;p<lLoup.size();p++){
               plateauDeJeu[(int)lLoup.get(p).pos.getAbcisse()][(int)lLoup.get(p).pos.getOrdonnee()]="L"+p;
            }
            for(int q=0;q<lLapin.size();q++){
                plateauDeJeu[(int)lLapin.get(q).pos.getAbcisse()][(int)lLapin.get(q).pos.getOrdonnee()]="l"+q;
            }
            
    }
    
    public void combattreAvecJoueurA(int j,ArrayList<Archer> lA,int numero){
         if(lJoueur.get(j).getPersonnageChoisi() instanceof Archer){
                    ((Archer)(lJoueur.get(j).getPersonnageChoisi())).combattre(lA.get(numero));
                }
                if(lJoueur.get(j).getPersonnageChoisi() instanceof Guerrier){
                    ((Guerrier)(lJoueur.get(j).getPersonnageChoisi())).combattre(lA.get(numero));
                }
                if(lJoueur.get(j).getPersonnageChoisi() instanceof Mage){
                    ((Mage)(lJoueur.get(j).getPersonnageChoisi())).combattre(lA.get(numero));
                }
    }
public void combattreAvecJoueurG(int j,ArrayList<Guerrier> lG,int numero){
         if(lJoueur.get(j).getPersonnageChoisi() instanceof Archer){
                    ((Archer)(lJoueur.get(j).getPersonnageChoisi())).combattre(lG.get(numero));
                }
                if(lJoueur.get(j).getPersonnageChoisi() instanceof Guerrier){
                    ((Guerrier)(lJoueur.get(j).getPersonnageChoisi())).combattre(lG.get(numero));
                }
                if(lJoueur.get(j).getPersonnageChoisi() instanceof Mage){
                    ((Mage)(lJoueur.get(j).getPersonnageChoisi())).combattre(lG.get(numero));
                }
    }
public void combattreAvecJoueurM(int j,ArrayList<Mage> lM,int numero){
         if(lJoueur.get(j).getPersonnageChoisi() instanceof Archer){
                    ((Archer)(lJoueur.get(j).getPersonnageChoisi())).combattre(lM.get(numero));
                }
                if(lJoueur.get(j).getPersonnageChoisi() instanceof Guerrier){
                    ((Guerrier)(lJoueur.get(j).getPersonnageChoisi())).combattre(lM.get(numero));
                }
                if(lJoueur.get(j).getPersonnageChoisi() instanceof Mage){
                    ((Mage)(lJoueur.get(j).getPersonnageChoisi())).combattre(lM.get(numero));
                }
    }
public void combattreAvecJoueurP(int j,ArrayList<Paysan> lP,int numero){
         if(lJoueur.get(j).getPersonnageChoisi() instanceof Archer){
                    ((Archer)(lJoueur.get(j).getPersonnageChoisi())).combattre(lP.get(numero));
                }
                if(lJoueur.get(j).getPersonnageChoisi() instanceof Guerrier){
                    ((Guerrier)(lJoueur.get(j).getPersonnageChoisi())).combattre(lP.get(numero));
                }
                if(lJoueur.get(j).getPersonnageChoisi() instanceof Mage){
                    ((Mage)(lJoueur.get(j).getPersonnageChoisi())).combattre(lP.get(numero));
                }
    }
public void combattreAvecJoueurL(int j,ArrayList<Loup> lL,int numero){
         if(lJoueur.get(j).getPersonnageChoisi() instanceof Archer){
                    ((Archer)(lJoueur.get(j).getPersonnageChoisi())).combattre(lL.get(numero));
                }
                if(lJoueur.get(j).getPersonnageChoisi() instanceof Guerrier){
                    ((Guerrier)(lJoueur.get(j).getPersonnageChoisi())).combattre(lL.get(numero));
                }
                if(lJoueur.get(j).getPersonnageChoisi() instanceof Mage){
                    ((Mage)(lJoueur.get(j).getPersonnageChoisi())).combattre(lL.get(numero));
                }
    }
public void combattreAvecJoueurl(int j,ArrayList<Lapin> ll,int numero){
         if(lJoueur.get(j).getPersonnageChoisi() instanceof Archer){
                    ((Archer)(lJoueur.get(j).getPersonnageChoisi())).combattre(ll.get(numero));
                }
                if(lJoueur.get(j).getPersonnageChoisi() instanceof Guerrier){
                    ((Guerrier)(lJoueur.get(j).getPersonnageChoisi())).combattre(ll.get(numero));
                }
                if(lJoueur.get(j).getPersonnageChoisi() instanceof Mage){
                    ((Mage)(lJoueur.get(j).getPersonnageChoisi())).combattre(ll.get(numero));
                }
    }






}

