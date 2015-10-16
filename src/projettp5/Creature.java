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
        if((TablCreature.get(j).pos.equals(nouvellePos))&&(TablCreature.get(j).getNom()!=nom)&&(nouvellePos.getAbcisse()>0)&&(nouvellePos.getOrdonnee()>0)){
            test=true;
        }
    }
    
    }
    pos=nouvellePos;
    System.out.println(getNom()+" se deplace");
    System.out.println(" ");
    }
   /* public boolean APorter(World monde){
    boolean test;
    test= false;
    for(int i1=0;i1<monde.getlArcher().size();i1++){
                if((this.pos.distance(monde.getlArcher().get(i1).pos)<(monde.getlArcher().get(i1).getDistAttMax()+0.5))&&(this.pos.distance(monde.getlArcher().get(i1).pos)>1.5)){
                    test=true;
            }
            }
    for(int i2=0;i2<monde.getlGuerrier().size();i2++){
                if(this.pos.distance(monde.getlGuerrier().get(i2).pos)<(monde.getlGuerrier().get(i2).getDistAttMax()+0.5)){
                    test=true;
            }
            }
    for(int i3=0;i3<monde.getlMage().size();i3++){
                if(this.pos.distance(monde.getlGuerrier().get(i3).pos)<(monde.getlMage().get(i3).getDistAttMax()+0.5)){
                    test=true;
            }
            }
    for(int i4=0;i4<monde.getlPaysan().size();i4++){
                if(this.pos.distance(monde.getlPaysan().get(i4).pos)<(monde.getlPaysan().get(i4).getDistAttMax()+0.5)){
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
    */
    
    public void deplacerIA(ArrayList<Creature> TablCreature) {
        int direction;
    boolean test=true;
    Random genereDirection= new Random();
    Point2D nouvellePos=new Point2D(pos);
    while(test){
    test= false;
    direction=genereDirection.nextInt(9);
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
        if((TablCreature.get(j).pos.equals(nouvellePos))&&(TablCreature.get(j)!=this)){
            test=true;
        }
    }
         
    }
    this.pos=nouvellePos;
    System.out.println(getNom()+" se déplace");
    System.out.println("");
    }
}
