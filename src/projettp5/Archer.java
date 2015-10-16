/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettp5;
import java.util.Random;
import java.util.ArrayList; 
/**
 *
 * @author Quentin DLMR et Romain DEL GUICIDE
 */
public class Archer extends Personnage implements Combattant{
    /*
    attributs de la classe archer
    */
    private int nbFleche;
    
    /*
    Constructeur avec tous les attributs en paramètre
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
     * @param nF
     */
    
    
    public Archer(String nom,int pV,int pMana,int pA,int pP,int pM,int rM,int dA,int dM,int distMax,int pPar,Point2D pos,int nF){
        super(nom,pV,pMana,pA,pP,pM,rM,dA,dM,distMax,pPar,pos);
        this.nbFleche=nF;
    }
    /*
    Constructeur sans attribut
    */

    /**
     *
     */
    
    public Archer(){
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
    this.nbFleche=0;
    }
    
    /*
    Getter sur flèche
    */

    /**
     *
     * @return
     */
    

    public int getNbFleche() {
        return nbFleche;
    }
    /*
    Setter sur flèche
    */

    /**
     *
     * @param nbFleche
     */
    public void setNbFleche(int nbFleche) {
        this.nbFleche = nbFleche;
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
            System.out.println("nbFleche "+nbFleche);
            System.out.println(" ");
}
    
    /**
     *
     * @param autreCreature
     */

    public void combattre(Creature autreCreature){
        System.out.println("Tir de l'Archer "+getNom());
       if(nbFleche>0){
        
        if ((this.pos.distance(autreCreature.pos)<=1)||(this.pos.distance(autreCreature.pos)>(getDistAttMax()+0.5))){
            
            if(this.pos.distance(autreCreature.pos)<=1){
                System.out.println("Cible trop proche");
            }
            else
            {
                System.out.println("Cible hors de portée");
            }
            
            
        }
        else
        {
            
            Random genAlea= new Random();
            int jetde;
            jetde= genAlea.nextInt(101);
            if(jetde>getPourcentageAtt())
            {
                System.out.println("Tir raté");
            }
            else
            {
                    System.out.println("Tir réussi");
                    autreCreature.setPtVie(autreCreature.getPtVie()-getDegAtt()); 
                    System.out.println("degats infliges : "+getDegAtt());
            }
            nbFleche--;
            
        }
       }
       else{
           System.out.println("Tir annulé : pas de fleche");
       }
          
        System.out.println("fin du tir");
        System.out.println("");
       
    }

   
   public void combattreIA(World monde){
   ArrayList<Creature> TablAPorter=new ArrayList<Creature>();

   for(int i=0;i<monde.getlArcher().size();i++){
       if(((getPos().distance(monde.getlArcher().get(i).pos))<(getDistAttMax()+0.5))&&((getPos().distance(monde.getlArcher().get(i).pos))>1.5)&&(monde.getlArcher().get(i)!=this)){
        TablAPorter.add((monde.getlArcher().get(i)));    
       }
   }
   for(int j=0;j<monde.getlGuerrier().size();j++){
       if(((getPos().distance(monde.getlGuerrier().get(j).pos))<(getDistAttMax()+0.5))&&((getPos().distance(monde.getlGuerrier().get(j).pos))>1.5)){
        TablAPorter.add((monde.getlGuerrier().get(j)));    
       }   
   }
   for(int k=0;k<monde.getlMage().size();k++){
       if(((getPos().distance(monde.getlMage().get(k).pos))<(getDistAttMax()+0.5))&&((getPos().distance(monde.getlMage().get(k).pos))>1.5)){
        TablAPorter.add((monde.getlMage().get(k)));    
       }    
   }
   for(int p=0;p<monde.getlPaysan().size();p++){
       if(((getPos().distance(monde.getlPaysan().get(p).pos))<(getDistAttMax()+0.5))&&((getPos().distance(monde.getlPaysan().get(p).pos))>1.5)){
        TablAPorter.add((monde.getlPaysan().get(p)));    
       }    
   } 
   for(int n=0;n<monde.getlLoup().size();n++){
       if(((getPos().distance(monde.getlLoup().get(n).pos))<(getDistAttMax()+0.5))&&((getPos().distance(monde.getlLoup().get(n).pos))>1.5)){
        TablAPorter.add((monde.getlLoup().get(n)));    
       }    
   } 
   for(int m=0;m<monde.getlLapin().size();m++){
       if(((getPos().distance(monde.getlLapin().get(m).pos))<(getDistAttMax()+0.5))&&((getPos().distance(monde.getlLapin().get(m).pos))>1.5)){
        TablAPorter.add((monde.getlLapin().get(m)));    
       }    
   }
   
   if(TablAPorter.size()>0){
       Random choixIndice=new Random();
   int b=TablAPorter.size();
   int a=choixIndice.nextInt(b);
   this.combattre(TablAPorter.get(a));
   }
   }
   public boolean APorter(World monde){
    boolean test;
    test= false;
    for(int i1=0;i1<monde.getlArcher().size();i1++){
                if((this.pos.distance(monde.getlArcher().get(i1).pos)<(this.getDistAttMax()+0.5))&&(this.pos.distance(monde.getlArcher().get(i1).pos)>1.5)){
                    test=true;
            }
            }
    for(int i2=0;i2<monde.getlGuerrier().size();i2++){
                if((this.pos.distance(monde.getlGuerrier().get(i2).pos)<(this.getDistAttMax()+0.5))&&(this.pos.distance(monde.getlGuerrier().get(i2).pos)>1.5)){
                    test=true;
            }
            }
    for(int i3=0;i3<monde.getlMage().size();i3++){
                if((this.pos.distance(monde.getlMage().get(i3).pos)<(this.getDistAttMax()+0.5))&&(this.pos.distance(monde.getlMage().get(i3).pos)>1.5)){
                    test=true;
            }
            }
    for(int i4=0;i4<monde.getlPaysan().size();i4++){
                if((this.pos.distance(monde.getlPaysan().get(i4).pos)<(this.getDistAttMax()+0.5))&&(this.pos.distance(monde.getlPaysan().get(i4).pos)>1.5)){
                    test=true;
            }
            }
    for(int i5=0;i5<monde.getlLoup().size();i5++){
                if((this.pos.distance(monde.getlLoup().get(i5).pos)<(this.getDistAttMax()+0.5))&&(this.pos.distance(monde.getlLoup().get(i5).pos)>1.5)){
                    test=true;
            }
            }  
    for(int i6=0;i6<monde.getlLapin().size();i6++){
                if((this.pos.distance(monde.getlLapin().get(i6).pos)<(this.getDistAttMax()+0.5))&&(this.pos.distance(monde.getlLapin().get(i6).pos)>1.5)){
                    test=true;
            }
            } 
    for(int i7=0;i7<monde.getlJoueur().size();i7++){
                if((this.pos.distance(monde.getlJoueur().get(i7).getPersonnageChoisi().pos)<(this.getDistAttMax()+0.5))&&(this.pos.distance(monde.getlJoueur().get(i7).getPersonnageChoisi().pos)>1.5)){
                    test=true;
            }
            } 
    return test;
}
   
}