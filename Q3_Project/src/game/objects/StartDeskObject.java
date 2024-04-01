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
public class StartDeskObject extends SuperObject {
    public StartDeskObject() {
        collision = true;
        name = "Start Desk";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/game/res/objects/table.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
