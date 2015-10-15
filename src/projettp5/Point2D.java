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
public class Point2D {
    /** les attributs d'un point 2D
     * son abcisse 
     * son ordonnée
     */
    private double abcisse;
    private double ordonnee;
    
    /** un constructeur avec deux entiers en paramètre
     *
     * 
     * @param x
     * @param y
     */
    public Point2D(double x, double y)
    {
        abcisse= x;
        ordonnee= y;
    }
    
    /** un constructeur sans paramètre
     *
     * 
     */
    
    public Point2D()
    {
        abcisse = 0;
        ordonnee= 0;
    }
    /** un constructeur avec un autre point pour paramètre 
     * 
     */
    
    /**
     * un constructeur avec un autre point pour paramètre
     * @param Point
     */
    public Point2D( Point2D Point )
    {
        abcisse=Point.abcisse;
        ordonnee=Point.ordonnee;
    }
    /** Méthode d'affichage
     * 
     */
    public void afficheCoord()
    {
        System.out.println("coordonnées :[" + abcisse + ";" + ordonnee + "]");
      //System.out.println("[" + abcisse + " ; " + ordonnee + "]");
    }
    
    /** Accesseurs 
     * 
     * @return 
     */
    
    public double getAbcisse() 
    {
        return abcisse;
    }
    
    /**
     *
     * @return
     */
    public double getOrdonnee()
    {
        return ordonnee;
    }
    
    /** Modificateurs
     * 
     * @param x
     */
    
    public void setAbcisse(double x) 
    {
        abcisse= x;
       
    }
    
    /**
     *
     * @param y
     */
    public void setOrdonnee(double y) 
    {
        ordonnee= y;
       
    }
    
   /** Méthode de translation
    * 
     * @param i
     * @param j
    */
   
   public void translation(double i, double j)
   {
       abcisse=abcisse+i;
       ordonnee=ordonnee+j;
   }
   
   /** Méthode de changement des deux coordonnées
    * 
     * @param X
     * @param Y
    */
   
   public void changementCoord(double X,double Y)
   {
       abcisse=X;
       ordonnee=Y;
   }
   
   /*
   Méthode de calcul de la distance
   Paramètre d'entrée : un autre point
   */

    /**
     *
     * @param autrePoint
     * @return
     */
    
   public double distance(Point2D autrePoint){
      double dist;
      dist=Math.sqrt(Math.pow((abcisse-autrePoint.getAbcisse()),2)+Math.pow((ordonnee-autrePoint.getOrdonnee()),2));
       return dist;
       
   }
   
   public boolean equals(Point2D autrePoint)
   {
       boolean test;
       if((abcisse==autrePoint.abcisse)&&(ordonnee==autrePoint.ordonnee)){
       test=true;
   }
       else
       {
           test=false;
       }
       return test;
   }
}
