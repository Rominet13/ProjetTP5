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
public class Soin extends Potion {

    /**
     *
     * @param pt
     * @param posi
     */
    public Soin(int pt, Point2D posi) {
        super(pt, posi);
    }

    /**
     *
     */
    public void affiche(){
        System.out.println("T'as beaucoup de pôt: Ceci est une potion de Soin \n avec " + getPt() + " de points de Soin à donner" );
        affichePo();        
//System.out.println("   en position " + this.posi.afficheCoord());
    }
    }
