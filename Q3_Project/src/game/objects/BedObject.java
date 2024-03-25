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
        name = "Bed";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/game/res/objects/bed.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
