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
public class Mana extends Potion {

    /**
     *
     * @param pt
     * @param posi
     */
    public Mana(int pt, Point2D posi) {
        super(pt, posi);
    }
    
    /**
     *
     */
    public void affiche(){
        System.out.println("T'as du pôt: Ceci est une potion de Mana \n avec " + getPt() + " de points de Mana à donner" );
        affichePo();
    }
    
}
