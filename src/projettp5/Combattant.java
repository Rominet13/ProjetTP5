/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettp5;
import java.util.ArrayList;
/**
 *
 * @author Quentin
 */
public interface Combattant {
   
    void combattre(Creature autreCreature);
    void combattreIA(World monde);
    
    
}
