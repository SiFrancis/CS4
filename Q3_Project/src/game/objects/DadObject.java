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
        getImage("/npc/npc0.png");
        setDialog(0, "AMA:\nNak, nasaan na yung papeles na hiningi ko?");
        setDialog(1, "IKAW:\nNandito po.. may nakita din po akong libro\nsa kuwarto niyo.");
        setDialog(2, "IKAW:\nTalagang gisi at sira, at halos walang \npahinang naiwan...");
    }
}
