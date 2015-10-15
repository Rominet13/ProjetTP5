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
public class Paysan extends Personnage{
    /*
    Pas d'attributs supplémentaires
    Constructeur avec tous les paramètres
    */

    /**
     *
     * @param nom
     * @param pV
     * @param pMana
     * @param pA
     * @param pP
     * @param pM
     * @param rM
     * @param dA
     * @param dM
     * @param distMax
     * @param pPar
     * @param pos
     */
    
    public Paysan(String nom,int pV,int pMana,int pA,int pP,int pM,int rM,int dA,int dM,int distMax,int pPar,Point2D pos){
        super(nom,pV,pMana,pA,pP,pM,rM,dA,dM,distMax,pPar,pos);
    }
    
    /*
    Constructeurs sans paramètre
    */

    /**
     *
     */
    
    public Paysan(){
        this.setNom("smith");
    this.setPtVie(100);   
    this.setPtMana(0);
    this.setPourcentageAtt(0);
    this.setPourcentagePar(0); 
    this.setPourcentageMag(0);
    this.setPourcentageResMag(0);
    this.setDegAtt(0);
    this.setDegMag(0);
    this.setDistAttMax(0);
        this.setPtPar(0);
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
