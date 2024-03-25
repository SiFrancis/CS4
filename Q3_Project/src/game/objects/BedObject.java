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
public class BedObject extends SuperObject {
    public BedObject() {
        collision = true;
        name = "Bed";
        sizeX = 96;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/game/res/objects/bed2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
