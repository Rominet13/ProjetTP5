/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettp5;

import java.io.*;

/**
 *
 * @author Romain
 */
public class SauvegardePartie {

    String nomSauvegarde;//à demander à l'utilisateur
    BufferedWriter bufferedWriter;

    public SauvegardePartie(String nom) {
        nom = nom + ".txt";
        nomSauvegarde = nom;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(nomSauvegarde));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void sauvegardePartie(World jeu) {  
        double nb = jeu.getNbPersonnage();
        nb/=6;
        int nbj = jeu.getlJoueur().size();
              try {
            bufferedWriter = new BufferedWriter(new FileWriter(nomSauvegarde));
            bufferedWriter.write("Taille "+jeu.getTailleMonde()+" "+jeu.getTailleMonde());
            bufferedWriter.newLine();
            bufferedWriter.write("NombreJoueur "+jeu.getNbPersonnage());
           bufferedWriter.newLine();
           
           for(int j = 0; j<nbj;j++) {
           bufferedWriter.write("Joueur "+jeu.getlJoueur().get(j).getPersonnageChoisi().getNom()+" "+jeu.getlArcher().get(j).getPtVie()+" "+jeu.getlArcher().get(j).getPtMana()+" "+jeu.getlArcher().get(j).getDegAtt()+" "+jeu.getlArcher().get(j).getPos().getAbcisse()+" "+jeu.getlArcher().get(j).getPos().getOrdonnee());
           bufferedWriter.newLine();
                   }
//           for(int compteur = 0; compteur<nb;compteur++) {
           for(int j = 0; j<nb;j++) {
           bufferedWriter.write(jeu.getlArcher().get(j).getNom()+" "+jeu.getlArcher().get(j).getPtVie()+" "+jeu.getlArcher().get(j).getPtMana()+" "+jeu.getlArcher().get(j).getDegAtt()+" "+jeu.getlArcher().get(j).getPos().getAbcisse()+" "+jeu.getlArcher().get(j).getPos().getOrdonnee());
           bufferedWriter.newLine();
                   }
//           }
            for(int j = 0; j<nb;j++) {
           bufferedWriter.write(jeu.getlGuerrier().get(j).getNom()+" "+jeu.getlGuerrier().get(j).getPtVie()+" "+jeu.getlGuerrier().get(j).getPtMana()+" "+jeu.getlGuerrier().get(j).getDegAtt()+" "+jeu.getlGuerrier().get(j).getPos().getAbcisse()+" "+jeu.getlGuerrier().get(j).getPos().getOrdonnee());
           bufferedWriter.newLine();
                   }
           
                for(int j = 0; j<nb;j++) {
           bufferedWriter.write(jeu.getlMage().get(j).getNom()+" "+jeu.getlMage().get(j).getPtVie()+" "+jeu.getlMage().get(j).getPtMana()+" "+jeu.getlMage().get(j).getDegAtt()+" "+jeu.getlMage().get(j).getPos().getAbcisse()+" "+jeu.getlMage().get(j).getPos().getOrdonnee());
           bufferedWriter.newLine();
                   }
                
              for(int j = 0; j<nb;j++) {
           bufferedWriter.write(jeu.getlPaysan().get(j).getNom()+" "+jeu.getlPaysan().get(j).getPtVie()+" "+jeu.getlPaysan().get(j).getPtMana()+" "+jeu.getlPaysan().get(j).getDegAtt()+" "+jeu.getlPaysan().get(j).getPos().getAbcisse()+" "+jeu.getlPaysan().get(j).getPos().getOrdonnee());
           bufferedWriter.newLine();
                   }
               for(int j = 0; j<nb;j++) {
           bufferedWriter.write(jeu.getlLoup().get(j).getNom()+" "+jeu.getlLoup().get(j).getPtVie()+" "+jeu.getlLoup().get(j).getDegAtt()+" "+jeu.getlLoup().get(j).getPos().getAbcisse()+" "+jeu.getlLoup().get(j).getPos().getOrdonnee());
           bufferedWriter.newLine();
                   }
                  for(int j = 0; j<nb;j++) {
           bufferedWriter.write(jeu.getlLapin().get(j).getNom()+" "+jeu.getlLapin().get(j).getPtVie()+" "+jeu.getlLapin().get(j).getDegAtt()+" "+jeu.getlLapin().get(j).getPos().getAbcisse()+" "+jeu.getlLapin().get(j).getPos().getOrdonnee());
           bufferedWriter.newLine();
                   }
            
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    // je force l'écriture dans le fichier
                    bufferedWriter.flush();
                    // puis je le ferme
                    bufferedWriter.close();
                }
            } // on attrape l'exception potentielle 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
