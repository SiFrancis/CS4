/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objects;

/**
 *
 * @author user
 */
public class DadObject extends SuperObject {
    public DadObject() {
        name = "Dad";
        collision = true;
        getImage("/assets/game/sprites/dadfull/dadfull_0.png");
        setDialogue(0, "TATAY:\nNak, nandiyan ka pala! Hahanapin sana kita, \nakala ko natutulog ka pa.");
        setDialogue(1, "TATAY:\nNasa iyo na ba yung pinakuha ko?");
        setDialogue(2, "IKAW:\nTatay, nakita ko po itong libro sa silid ninyo.\nAno po ito?");
        setDialogue(3, "TATAY:\nAh, ang Kartilya... lumang luma na yan.");
        setDialogue(4, "TATAY:\nHalos tatlumpung taon na ang lumipas, noong \ntayo'y may pag-asa pa sa kalayaan...");
        setDialogue(5, "IKAW:\nTalaga? Hindi palaging ganito ang pagtrato \nng mga Kastila sa atin Tay?");
        setDialogue(6, "TATAY:\nMatagal na yun, anak. Mga guni-guni na \nlamang iyan.");
        setDialogue(7, "TATAY:\nMukhang matagal pa bago muling babalik ang \nmga tulad ni Emilio Jacinto...");
        setDialogue(8, "TATAY:\nO siya, atupagin mo muna yung trabaho mo,\ndadaan nanaman yung mga guardia civil na \nyun dito.");
        setDialogue(9, "TATAY:\nAyaw naman nating mag-alala yung ina mo \nsa Malolos.");
        setDialogue(10, "IKAW:\nOpo Tay, alam ko, alam ko., eto na...");
        setDialogue(11, "IKAW:\n(Emilio Jacinto... siya ba ang nagsulat ng aklat \nna ito? Ang Kartilya?)");
        setDialogue(12, " ");
    }
}
