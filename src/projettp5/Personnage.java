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
public abstract class Personnage extends Creature{
    /*
    Attributs de la sous classe personnage (humain)
    */
    
    private int PtMana;
    private int pourcentageMag;
    private int pourcentageResMag;
    private int degMag;
    private double distAttMax;
    
    /*
    Constructeurs avec tous les attributs en paramètre
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
     * @param PtPar
     * @param pos
     */
    
     public Personnage(String nom,int pV,int pMana,int pA,int pP,int pM,int rM,int dA,int dM,double distMax,int PtPar,Point2D pos){
    
    super(nom,pV,pA,pP,dA,PtPar,pos);
    this.PtMana=pMana;
    this.pourcentageMag=pM;
    this.pourcentageResMag=rM;
    this.degMag=dM;
    this.distAttMax=distMax;
        
    //l'utilisation de this va permettre d'éviter le masquage ici
    }
    /*
     Constructeur sans paramètre
     */

    /**
     *
     */
    
    public Personnage(){
        this.setNom("smith");
    this.setPtVie(100);   
    this.PtMana= 0;
    this.setPourcentageAtt(0);
    this.setPourcentagePar(0); 
    this.pourcentageMag=0;
    this.pourcentageResMag=0;
    this.setDegAtt(0);
    this.degMag=0;
    this.distAttMax=0;
        this.setPtPar(0);
    this.pos.setAbcisse(0);
    this.pos.setOrdonnee(0);
    }
    /*
    Getters
    */

    /**
     *
     * @return
     */
    public int getPtMana() {
        return PtMana;
    }

    /**
     *
     * @return
     */
    public int getPourcentageMag() {
        return pourcentageMag;
    }

    /**
     *
     * @return
     */
    public int getPourcentageResMag() {
        return pourcentageResMag;
    }

    /**
     *
     * @return
     */
    public int getDegMag() {
        return degMag;
    }

    /**
     *
     * @return
     */
    public double getDistAttMax() {
        return distAttMax;
    }

    
    
    /*
    Setters
    */

    /**
     *
     * @param PtMana
     */
    

    public void setPtMana(int PtMana) {
        this.PtMana = PtMana;
    }

    /**
     *
     * @param pourcentageMag
     */
    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    /**
     *
     * @param pourcentageResMag
     */
    public void setPourcentageResMag(int pourcentageResMag) {
        this.pourcentageResMag = pourcentageResMag;
    }

    /**
     *
     * @param degMag
     */
    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    /**
     *
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

  
}
