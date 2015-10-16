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
public class Loup extends Monstre implements Combattant{
     /* 
    Pas d'attributs supplémentaires
    Constructeurs avec tous les paramètres en entrée
    */

    /**
     *
     * @param nom
     * @param pV
     * @param pA
     * @param pP
     * @param dA
     * @param ptP
     * @param pos
     */
    
    
    public Loup(String nom,int pV,int pA,int pP,int dA,int ptP,Point2D pos){
    super(nom,pV,pA,pP,dA,ptP,pos);
}
    /*
    Constructeur sans paramètre
    */

    /**
     *
     */
    
    public Loup(){
    this.setNom("Gollum");
    this.setPtVie(100);   
    this.setPourcentageAtt(0);
    this.setPourcentagePar(0); 
    this.setDegAtt(0);
    //l'utilisation de this va permettre d'éviter le masquage ici
    this.pos.setAbcisse(0);
    this.pos.setOrdonnee(0);
}
    
    /**
     *
     * @param autreCreature
     */
    public void combattre(Creature autreCreature){
        System.out.println("Attaque du monstre : "+getNom());
        if (this.pos.distance(autreCreature.pos)>(1.5)){
            System.out.println("Cible hors de portée");
        }
        else
        {
            Random genAlea= new Random();
            int jetde;
            jetde= genAlea.nextInt(101);
            if(jetde>getPourcentageAtt())
            {
                System.out.println("Attaque ratée");
            }
            else
            {
                jetde= genAlea.nextInt(101);
                if(jetde>autreCreature.getPourcentagePar())
                {
                    autreCreature.setPtVie(autreCreature.getPtVie()-getDegAtt());
                     System.out.println("degats infliges : "+getDegAtt());
                }
                else
                {
                    autreCreature.setPtVie(autreCreature.getPtVie()-getDegAtt()+autreCreature.getPtPar());
                     System.out.println("degats infliges : "+(getDegAtt()-autreCreature.getPtPar()));
                }
            }
            
        }
        System.out.println("Fin de l'attaque");
         System.out.println("");
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
    public void combattreIA(World monde){
   ArrayList<Creature> TablAPorter=new ArrayList<Creature>();

   for(int i=0;i<monde.getlArcher().size();i++){
       if(((getPos().distance(monde.getlArcher().get(i).pos))<(1.5))){
        TablAPorter.add((monde.getlArcher().get(i)));    
       }
   }
   for(int j=0;j<monde.getlGuerrier().size();j++){
       if(((getPos().distance(monde.getlGuerrier().get(j).pos))<(1.5))){
        TablAPorter.add((monde.getlGuerrier().get(j)));    
       }   
   }
   for(int k=0;k<monde.getlMage().size();k++){
       if(((getPos().distance(monde.getlMage().get(k).pos))<(1.5))){
        TablAPorter.add((monde.getlMage().get(k)));    
       }    
   }
   for(int p=0;p<monde.getlPaysan().size();p++){
       if(((getPos().distance(monde.getlPaysan().get(p).pos))<(1.5))){
        TablAPorter.add((monde.getlPaysan().get(p)));    
       }    
   } 
   for(int n=0;n<monde.getlLoup().size();n++){
       if(((getPos().distance(monde.getlLoup().get(n).pos))<(1.5))&&(this!=monde.getlLoup().get(n))){
        TablAPorter.add((monde.getlLoup().get(n)));    
       }    
   } 
   for(int m=0;m<monde.getlLapin().size();m++){
       if(((getPos().distance(monde.getlLapin().get(m).pos))<(1.5))){
        TablAPorter.add((monde.getlLapin().get(m)));    
       }    
   }
   Random choixIndice=new Random();
   this.combattre(TablAPorter.get(choixIndice.nextInt(TablAPorter.size())));

   }   
    public boolean APorter(World monde){
    boolean test;
    test= false;
    for(int i1=0;i1<monde.getlArcher().size();i1++){
                if((this.pos.distance(monde.getlArcher().get(i1).pos)<(1.5))){
                    test=true;
            }
            }
    for(int i2=0;i2<monde.getlGuerrier().size();i2++){
                if((this.pos.distance(monde.getlGuerrier().get(i2).pos)<(1.5))){
                    test=true;
            }
            }
    for(int i3=0;i3<monde.getlMage().size();i3++){
                if((this.pos.distance(monde.getlMage().get(i3).pos)<(1.5))){
                    test=true;
            }
            }
    for(int i4=0;i4<monde.getlPaysan().size();i4++){
                if((this.pos.distance(monde.getlPaysan().get(i4).pos)<(1.5))){
                    test=true;
            }
            }
    for(int i5=0;i5<monde.getlLoup().size();i5++){
                if((this.pos.distance(monde.getlLoup().get(i5).pos)<(1.5))&&(this!=monde.getlLoup().get(i5))){
                    test=true;
            }
            }  
    for(int i6=0;i6<monde.getlLapin().size();i6++){
                if((this.pos.distance(monde.getlLapin().get(i6).pos)<(1.5))){
                    test=true;
            }
            } 
    for(int i7=0;i7<monde.getlJoueur().size();i7++){
                if((this.pos.distance(monde.getlJoueur().get(i7).getPersonnageChoisi().pos)<(1.5))){
                    test=true;
            }
            } 
    return test;
}
}
