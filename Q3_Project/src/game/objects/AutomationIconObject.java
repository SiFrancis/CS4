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
        String filepath = String.format("/game/res/objects/autom_icons/icon%d.png", type);
        try {
            image = ImageIO.read(getClass().getResourceAsStream(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
