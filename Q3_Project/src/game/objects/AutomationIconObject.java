/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objects;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Acer
 */
public class AutomationIconObject extends SuperObject {
    // 0 = exit, 1, 2, 3 = respective automation numbers (on math doc)
    
    public AutomationIconObject(int type) {
        collision = true;
        this.type = type;
        name = "Automation Icon";
        String imgname = String.format("/autom_icons/icon%d.png", type);
        getImage(imgname);
        
        hintText = (type == 0) ? "Pindutin ang [E] upang bumalik sa silid." : String.format("Pindutin ang [E] upang buksan ang Automation %d.", type);
        setDialogue(0, hintText);
    }
}
