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
public class Projettp5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("*******************************************");
        System.out.println("Bienvenue dans World of ECN (Romain et Quentin, tous droits réservés)");
        System.out.println("*******************************************");
        World WOECN= new World(3,6);
        WOECN.affichePlateauDeJeu();
//        System.out.println(WOECN.getlArcher().get(3));
        WOECN.getlLoup().get(0).deplacerIA(WOECN.plateauDeJeu);
//        WOECN.tourDeJeu(10);
    }
    
}
