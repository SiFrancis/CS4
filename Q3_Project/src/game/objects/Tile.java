/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objects;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author user
 */
public class Tile {
    //Tiles have two proeprties; tile image and collision
    //If collision = true, entities can collide with the tile (and thus cannot pass through)
    public BufferedImage image;
    public boolean collision;
    
    public Tile(String path, boolean collision) {
        this.collision = collision;
        try {
            this.image = ImageIO.read(
                getClass().getResourceAsStream("/game/res/tiles/"+path)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
