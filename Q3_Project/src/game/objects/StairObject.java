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
    // 0 = upstairs to kitchen, 1 = kitchen to upstairs
    
    public StairObject(int type){
        collision = false;
        this.type = type;
        name = "Stairs";
        setDialog(0, "Ikaw ay bumaba sa unang palapag.");
        setDialog(1, "Ikaw ay umakyat sa itaas na palapag.");
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/game/tiles/02_wall.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
