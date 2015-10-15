/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettp5;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Quentin DLMR et Romain DEL GUICIDE
 */
public class Mage extends Personnage implements Combattant{
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
    
    public Mage(String nom,int pV,int pMana,int pA,int pP,int pM,int rM,int dA,int dM,int distMax,int pPar,Point2D pos){
        super(nom,pV,pMana,pA,pP,pM,rM,dA,dM,distMax,pPar,pos);
    }
    
    /*
    Constructeurs sans paramètre
    */

    /**
     *
     */
    
    public Mage(){
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
    surclassage de affiche()
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
            System.out.println("Points de Mana "+getPtMana());
            System.out.println(" ");
}
    
    /**
     *
     * @param autreCreature
     */
    public void combattre(Creature autreCreature){
       System.out.println("Attaque du mage "+getNom());
       if (this.pos.distance(autreCreature.pos)>(getDistAttMax()+0.5)){
            System.out.println("Cible hors de portée");
            
        }    
       else{
       Random genAlea= new Random();
            int jetde;
            jetde= genAlea.nextInt(101);
           if(getPtMana()>0){
               if(jetde>getPourcentageMag())
            {
                System.out.println("Sort raté");
            }
            else
            {
              System.out.println("Sort réussi");
                    autreCreature.setPtVie(autreCreature.getPtVie()-getDegMag()); 
                    System.out.println("degats infliges : "+getDegMag());
            }
         setPtMana(getPtMana()-1);
           }
            else
           {
               System.out.println("Impossible de jeter un sort: pas de mana");
           }
       }
           System.out.println("Fin sort");
           System.out.println("");
    }
    
 public void combattreIA(World monde){
   ArrayList<Creature> TablAPorter=new ArrayList<Creature>();

   for(int i=0;i<monde.getlArcher().size();i++){
       if(((getPos().distance(monde.getlArcher().get(i).pos))<(getDistAttMax()+0.5))){
        TablAPorter.add((monde.getlArcher().get(i)));    
       }
   }
   for(int j=0;j<monde.getlGuerrier().size();j++){
       if(((getPos().distance(monde.getlGuerrier().get(j).pos))<(getDistAttMax()+0.5))){
        TablAPorter.add((monde.getlGuerrier().get(j)));    
       }   
   }
   for(int k=0;k<monde.getlMage().size();k++){
       if(((getPos().distance(monde.getlMage().get(k).pos))<(getDistAttMax()+0.5))&&(this!=monde.getlMage().get(k))){
        TablAPorter.add((monde.getlMage().get(k)));    
       }    
   }
   for(int p=0;p<monde.getlPaysan().size();p++){
       if(((getPos().distance(monde.getlPaysan().get(p).pos))<(getDistAttMax()+0.5))){
        TablAPorter.add((monde.getlPaysan().get(p)));    
       }    
   } 
   for(int n=0;n<monde.getlLoup().size();n++){
       if(((getPos().distance(monde.getlLoup().get(n).pos))<(getDistAttMax()+0.5))){
        TablAPorter.add((monde.getlLoup().get(n)));    
       }    
   } 
   for(int m=0;m<monde.getlLapin().size();m++){
       if(((getPos().distance(monde.getlLapin().get(m).pos))<(getDistAttMax()+0.5))){
        TablAPorter.add((monde.getlLapin().get(m)));    
       }    
   }
   Random choixIndice=new Random();
   this.combattre(TablAPorter.get(choixIndice.nextInt(TablAPorter.size())));

   }   
    
    
    
}
