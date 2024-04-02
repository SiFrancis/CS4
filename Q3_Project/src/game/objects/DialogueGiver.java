/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objects;

/**
 *
 * @author user
 */
public class DialogueGiver extends SuperObject {
    public DialogueGiver(){
        name = "Start Dialogue";
        setDialogue(0, "Ano nga yung utos ni Itay sa akin?");
        setDialogue(1, "Ay oo nga! May pinakuha siya mula sa kuwarto\nniya dito sa kabilang pinto.");
        setDialogue(2, "Nasa lamesa lang daw yun ni Itay.");
        setDialogue(3, "Teka, parang nakakandando ata to...\nPaano ko kaya mabuksan?");
    }
}
