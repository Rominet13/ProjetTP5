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
public class Lapin extends Monstre{
     /* 
    Pas d'attributs supplémentaires
    Constructeurs avec tous les paramètres en entrée
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
    
    
    public Lapin(String nom,int pV,int pA,int pP,int dA,int ptPar,Point2D pos){
    super(nom,pV,pA,pP,dA,ptPar,pos);
}
    /*
    Constructeur sans paramètre
    */

    /**
     *
     */
    
    public Lapin(){
    this.setNom("Gollum");
    this.setPtVie(100);   
    this.setPourcentageAtt(0);
    this.setPourcentagePar(0); 
    this.setDegAtt(0);
    //l'utilisation de this va permettre d'éviter le masquage ici
    this.pos.setAbcisse(0);
    this.pos.setOrdonnee(0);
}
     /*
    Méthode d'affichage
    surclassage de l'affichage normal
    */

    /**
     *
     */
    
    @Override
    public void affiche(){
            System.out.println(getNom());
            System.out.println(" ");
            System.out.println("Position actuelle ["+pos.getAbcisse()+","+pos.getOrdonnee()+"]");
            System.out.println("Points de vie "+getPtVie());
            System.out.println(" ");
}
}
