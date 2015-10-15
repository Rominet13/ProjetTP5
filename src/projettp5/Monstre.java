/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettp5;

/**
 *
 * @author Quentin DLMR et Romain DEL GUICIDE
 */
public abstract class Monstre extends Creature{
    
    
    /* 
    
    Constructeurs avec tous les paramètres en entrée
    */

    /**
     *
     * @param nom
     * @param pV
     * @param pA
     * @param pP
     * @param dA
     * @param ptP
     * @param pos
     */
    
    
    public Monstre(String nom,int pV,int pA,int pP,int dA,int ptP,Point2D pos){
    super(nom,pV,pA,pP,dA,ptP,pos);
    
}
    /*
    Constructeur sans paramètre
    */

    /**
     *
     */
    
    public Monstre(){
    this.setNom("Gollum");
    this.setPtVie(100);   
    this.setPourcentageAtt(0);
    this.setPourcentagePar(0); 
    this.setDegAtt(0);
    
    //l'utilisation de this va permettre d'éviter le masquage ici
    this.pos.setAbcisse(0);
    this.pos.setOrdonnee(0);
    this.setPtPar(0);
}
  
    
}
