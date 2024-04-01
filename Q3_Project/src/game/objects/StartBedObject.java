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
public class StartBedObject extends SuperObject {
    public StartBedObject() {
        collision = true;
        name = "Start Bed";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/game/res/objects/bed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
