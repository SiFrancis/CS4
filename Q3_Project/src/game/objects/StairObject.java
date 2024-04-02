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
public class StairObject extends SuperObject {
    // 0 = upstairs to downstairs, 1 = down to upstairs
    
    public StairObject(int type){
        collision = false;
        this.type = type;
        name = "Stairs";
        setDialogue(0, "Ikaw ay bumaba sa unang palapag.");
        setDialogue(1, "Ikaw ay umakyat sa itaas na palapag.");
        try {
            switch (type) {
                case 0 -> image = ImageIO.read(getClass().getResourceAsStream("/assets/game/tiles/render/055.png"));
                case 1 -> image = ImageIO.read(getClass().getResourceAsStream("/assets/game/tiles/render/070.png"));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
