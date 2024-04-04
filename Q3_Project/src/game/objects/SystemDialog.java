/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objects;

/**
 *
 * @author Acer
 */
public class SystemDialog extends SuperObject {
    public SystemDialog(){
        //"you picked up 3 pages" type dialogue
        // now that i think about it, it was probably a better idea to put all the dialogue in one file lol
        name = "System Dialog";
        setDialogue(0, "[Nakakuha ng tatlong PAHINA.]");
        setDialogue(1, "[UNA: Ang kabuhayang hindi ginugugol\nsa isang malaki at banal na kadahilanan ay\nkahoy na walang lilim, kundi damong\nmakamandag.]");
        setDialogue(2, "[PANGALAWA: Ang gawang magaling na\nnagbubuhat ng pagpipita sa sarili, at hindi\nsa talagang nasang gumawa ng kagalingan,\nay di kabaitan.]");
        setDialogue(3, "[PANGATLO: Ang tunay na kabanalan ay ang\npagkakawang gawa, ang pag-ibig sa kapwa\nat ang isukat ang bawat kilos, gawa at\npangungusap sa talagang katwiran.]");
    }
}
