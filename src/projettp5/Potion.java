/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettp5;

/**
 *
 * @author Quentin
 */
public class Potion {
    private int pt;
    private Point2D posi;

    /**
     *
     * @param pt
     * @param posi
     */
    public Potion(int pt, Point2D posi) {
        this.pt = pt;
        this.posi = posi;
    }
    
    /**
     *
     */
    public void affichePo(){
        //System.out.println("   en position ");
        //posi.afficheCoord();
        System.out.println("Ceci est un objet");
        System.out.println("   en position :[" + posi.getAbcisse() + ";" + posi.getOrdonnee() + "]");
    }
    
    /**
     *
     * @return
     */
    public int getPt() {
        return pt;
    }

    /**
     *
     * @return
     */
    public Point2D getPosi() {
        return posi;
    }

    /**
     *
     * @param pt
     */
    public void setPt(int pt) {
        this.pt = pt;
    }

    /**
     *
     * @param posi
     */
    public void setPosi(Point2D posi) {
        this.posi = posi;
    }
        
}

      