/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettp5;

//helo
//test de remote...1 fetch...to be continued....final
/**
 *
 * @author Quentin
 */
public class Projettp5 {
//salut
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        // TODO code application logic here
//        System.out.println("*******************************************");
//        System.out.println("Bienvenue dans World of ECN (Romain et Quentin, tous droits réservés)");
//        System.out.println("*******************************************");
       World WOECN= new World(40,24);
//        WOECN.tourDeJeu(10);
       
        SauvegardePartie svP = new SauvegardePartie("testSauvegarde1");  
      svP.sauvegardePartie(WOECN);

        
    }
    
}
