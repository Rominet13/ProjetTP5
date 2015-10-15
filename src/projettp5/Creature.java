/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettp5;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Quentin DLMR et Romain DEL GUICIDE
 */
public abstract class Creature implements Deplacable{
    
    /* 
    attributs de la classe créature, attributs communs entre joueurs humains et monstres
    */
   private String nom;
    private int PtVie; 
    private int pourcentageAtt;
    private int pourcentagePar;
    private int degAtt;

    /**
     *
     */
    public Point2D pos;
    /*
    Nouveau champ : points de parade
    */
    private int PtPar;
    /*
    getters sur les attributs de la classe créature
    */
    
    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return
     */
    public int getPtVie() {
        return PtVie;
    }

    /**
     *
     * @return
     */
    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    /**
     *
     * @return
     */
    public int getPourcentagePar() {
        return pourcentagePar;
    }

    /**
     *
     * @return
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     *
     * @return
     */
    public int getPtPar() {
        return PtPar;
    }

    /**
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /*
    setters sur les paramètres de la classe créature
    */

    /**
     *
     * @param nom
     */
    
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param PtVie
     */
    public void setPtVie(int PtVie) {
        this.PtVie = PtVie;
    }

    /**
     *
     * @param pourcentageAtt
     */
    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    /**
     *
     * @param pourcentagePar
     */
    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }

    /**
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     *
     * @param PtPar
     */
    public void setPtPar(int PtPar) {
        this.PtPar = PtPar;
    }

    /**
     *
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    /*
    Constructeurs en rentrant tous les paramètres
    */
    
    /**
     *
     * @param nom
     * @param pV
     * @param pA
     * @param pP
     * @param dA
     * @param ptPar
     * @param pos
     */
    public Creature(String nom,int pV,int pA,int pP,int dA,int ptPar,Point2D pos){
    this.nom=nom;
    this.PtVie=pV;   
    this.pourcentageAtt=pA;
    this.pourcentagePar=pP; 
    this.degAtt=dA;
    this.PtPar=ptPar;
    //l'utilisation de this va permettre d'éviter le masquage ici
    this.pos=pos;
}
    /*
    Constructeur sans paramètre
    */

    /**
     *
     */
    
    public Creature(){
    this.nom="Gollum";
    this.PtVie=100;   
    this.pourcentageAtt=0;
    this.pourcentagePar=0; 
    this.degAtt=0;
    this.PtPar=0;
    //l'utilisation de this va permettre d'éviter le masquage ici
    this.pos.setAbcisse(0);
    this.pos.setOrdonnee(0);
}
    /*
    Méthode d'affichage des paramètres d'une créature
    */
    
    /**
     *
     */
    public abstract void affiche();
    
    /*
    Méthode de déplacement
    */

    /**
     *
     * @param direction
     */
    
    
    public void deplacer(ArrayList<Creature> TablCreature){
    int direction;
    boolean test=true;
    Scanner scan= new Scanner(System.in);
    Point2D nouvellePos=new Point2D(pos);
    while(test){
    test= false;
     System.out.println("Entrer la direction (entier entre 1 et 8)");
    direction=scan.nextInt();
    switch(direction)
    {
        case 1:
             nouvellePos.translation(1,0);
            break;
        case 2:
             nouvellePos.translation(1,1);
            break;
        case 3:
            nouvellePos.translation(0,1);
            break;
        case 4:
            nouvellePos.translation(-1,1);
            break;
        case 5:
            nouvellePos.translation(-1,0);
            break;
        case 6:
            nouvellePos.translation(-1,-1);
            break;
        case 7:
            nouvellePos.translation(0,-1);
            break;
        case 8:
            nouvellePos.translation(1,-1);
            break;
        default:
            System.out.println("move error");
           
    }  
    for(int j=0;j<TablCreature.size();j++){
        if((TablCreature.get(j).pos.equals(nouvellePos))&&(TablCreature.get(j).getNom()!=nom)){
            test=true;
        }
    }
    
    }
    pos=nouvellePos;
    System.out.println(getNom()+" se deplace");
    System.out.println(" ");
    }
    public boolean APorter(World monde){
    boolean test;
    test= false;
    for(int i1=0;i1<monde.getlArcher().size();i1++){
                if(this.pos.distance(monde.getlArcher().get(i1).pos)<monde.getlArcher().get(i1).getDistAttMax()){
                    test=true;
            }
            }
    for(int i2=0;i2<monde.getlGuerrier().size();i2++){
                if(this.pos.distance(monde.getlGuerrier().get(i2).pos)<monde.getlGuerrier().get(i2).getDistAttMax()){
                    test=true;
            }
            }
    for(int i3=0;i3<monde.getlMage().size();i3++){
                if(this.pos.distance(monde.getlGuerrier().get(i3).pos)<monde.getlMage().get(i3).getDistAttMax()){
                    test=true;
            }
            }
    for(int i4=0;i4<monde.getlPaysan().size();i4++){
                if(this.pos.distance(monde.getlPaysan().get(i4).pos)<monde.getlPaysan().get(i4).getDistAttMax()){
                    test=true;
            }
            }
    for(int i5=0;i5<monde.getlLoup().size();i5++){
                if(this.pos.distance(monde.getlLoup().get(i5).pos)<1){
                    test=true;
            }
            }  
    for(int i6=0;i6<monde.getlLoup().size();i6++){
                if(this.pos.distance(monde.getlLoup().get(i6).pos)<1.5){
                    test=true;
            }
            } 
    for(int i7=0;i7<monde.getlJoueur().size();i7++){
                if(this.pos.distance(monde.getlJoueur().get(i7).getPersonnageChoisi().pos)<1.5){
                    test=true;
            }
            } 
    return test;
}
    
    
    public void deplacerIA(String[][] a) {
        System.out.println(getNom() + " se deplace");
        Random genAlea = new Random();

        int x = (int)this.pos.getAbcisse();
        int y = (int)this.pos.getOrdonnee();
        int[] testd = new int[8];
        int c = 0;
        
        
        
        
//        boolean fin = false;  pour ancienne version du choix de nouvelle case
        int l = a.length;
//        System.out.println(a.length);   pour le débogage
        
        //affichage du plateau de jeu avec le déplacement pour comparaison
//        System.out.println("Plateau avant déplacement:  \n");
//        int z = 0, e = 0;
//        while (z < l) {
//            e = 0;
//            while (e < l) {
//                System.out.print(a[e][z]);
//                e++;
//            }
//            System.out.println("");
//            z++;
//        }
// fin de l'affichage
        
// fonction alentour inséré, pour connaitre ce qu'il y a à coté du personnage: vide ou limite du terrain=2 ; autre personnage=1 
//On restre l'information dans un vecteur de 8 case, et on tourne dans le sens inverse des aiguilles d'une montre (case 0=à droite, case1=en haut à droite de l'affichage)        
//    On teste chaque case : d'abord pour voir si elle est en dehors du terrain(on la met à 2 dans le else), sinon si la case est déjà occupé on rentre 1, sinon rien est fait(case reste à 0)
        if ((x + 1) < l - 1) {
            if (!a[x + 1][y].equals(" 0")) {
                testd[0] = 1;
                c++;
            }
        } else {
            testd[0] = 2;
            c++;
        }

        if ((x + 1 < l) && (y + 1 < l - 1)) {
            if (!a[x + 1][y + 1].equals(" 0")) {
                testd[7] = 1;
                c++;
            }
        } else {
            testd[7] = 2;
            c++;
        }

        if ((y + 1) < l - 1) {
            if (!a[x][y + 1].equals(" 0")) {
                testd[6] = 1;
                c++;
            }
        } else {
            testd[6] = 2;
            c++;
        }

        if ((x - 1 >= 0) && (y + 1 < l - 1)) {
            if (!a[x - 1][y + 1].equals(" 0")) {
                testd[5] = 1;
                c++;
            }

        } else {
            testd[5] = 2;
            c++;
        }
        if ((x - 1) >= 0) {
            if (a[x - 1][y].equals(" 0")) {
                testd[4] = 1;
                c++;
            }
        } else {
            testd[4] = 2;
            c++;
        }

        if (((x - 1) >= 0) && ((y - 1) >= 0)) {
            if (a[x - 1][y - 1].equals(" 0")) {
                testd[3] = 1;
                c++;
            }
        } else {
            testd[3] = 2;
            c++;
        }

        if ((y - 1) >= 0) {
            if (a[x][y - 1].equals(" 0")) {
                testd[2] = 1;
                c++;
            }
        } else {
            testd[2] = 2;
            c++;
        }

        if (((y - 1) >= 0) && ((x + 1) < l - 1)) {
            if (a[x + 1][y - 1].equals(" 0")) {
                testd[1] = 1;
                c++;
            }
        } else {
            testd[1] = 2;
            c++;
        }
        //affichage des alentours du personnage dans le vecteur précédent testd
        System.out.println("alentoure dans deplacerIA");
        int r = 0;
        while (r < 8) {
            System.out.print(testd[r]);
            r++;
        }
        
//affichage du personnage à déplacer
        this.affiche();
        System.out.println("avant");
        
        //déplacement ou pas du personnage de façon aléatoire
//        s'il est encerclé, il ne se déplace pas
//        sinon déplacement aléatoire (TANT QUE)jusqu'à que la case où il doit se déplacer soit libre
        if (c == 8) {
            System.out.println(getNom() + " ne peut pas se déplacer. Il/elle est encerclé(e).");
            c = 0;
        } else {

            int direction = genAlea.nextInt(7);
            while (testd[direction] == 1 || testd[direction] == 2) {
                direction = genAlea.nextInt(7);

                //vielle version du choix de déplacement
//            while (fin = false) {
//                fin = true;
//                if (((testd[0] == 1) || (testd[0] == 2)) && (direction == 0)) {
//                    direction +=1;
//                }
//                if (((testd[1] == 1) || (testd[1] == 2)) && (direction == 1)) {
//                    direction += 1;
//                }
//                if (((testd[2] == 1) || (testd[2] == 2)) && (direction == 2)) {
//                    direction +=1;
//                }
//                if (((testd[3] == 1) || (testd[3] == 2)) && (direction == 3)) {
//                    direction +=1;
//                }
//                if (((testd[4] == 1) || (testd[4] == 2)) && (direction == 4)) {
//                    direction +=1;
//                }
//                if (((testd[5] == 1) || (testd[5] == 2)) && (direction == 5)) {
//                    direction +=1;
//                }
//                if (((testd[6] == 1) || (testd[6] == 2)) && (direction == 6)) {
//                    direction +=1;
//                }
//                if (((testd[7] == 1) || (testd[7] == 2)) && (direction == 7)) {
//                    direction = 0;
//                    fin = false;
//                }
            }
            //Mise à 0 de la position occupé avant le déplacement
//            a[x][y] = 0;
// déplacement sur la nouvelle position, mise à 1 dans le plateau
            switch (direction) {
                case 0:
                    pos.translation(1, 0);
                    a[x + 1][y] = a[x][y];
                    a[x][y]=" 0";
                    break;

                case 1:
                    pos.translation(1, -1);
                    a[x + 1][y - 1]= a[x][y];
                    a[x][y]=" 0";
                    break;
                case 2:
                    pos.translation(0, -1);
                    a[x][y - 1] = a[x][y];
                    a[x][y]=" 0";
                    break;
                case 3:
                    pos.translation(-1, -1);
                    a[x - 1][y - 1]= a[x][y];
                    a[x][y]=" 0";
                    break;
                case 4:
                    pos.translation(-1, 0);
                    a[x - 1][y]= a[x][y];
                    a[x][y]=" 0";
                    break;
                case 5:
                    pos.translation(-1, 1);
                    a[x - 1][y + 1] = a[x][y];
                    a[x][y]=" 0";
                    break;
                case 6:
                    pos.translation(0, 1);
                    a[x][y + 1]= a[x][y];
                    a[x][y]=" 0";
                    break;
                case 7:
                    pos.translation(1, 1);
                    a[x + 1][y + 1]= a[x][y];
                    a[x][y]=" 0";
                    break;
                default:
                    System.out.println("move error");
            }
            System.out.println("==================== ");
        }
        System.out.println("après");
        this.affiche();
        //affichage du plateau de jeu après le déplacement pour comparaison
//        System.out.println("Plateau après déplacement:  ");
//        int i = 0, j = 0;
//        while (i < l) {
//            j = 0;
//            while (j < l) {
//                System.out.print(a[j][i]);
//                j++;
//            }
//            System.out.println("");
//            i++;
//        }
         
    }
    
}
