/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objects;

import game.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author Acer
 */
public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public int sizeX = 64, sizeY = 64;
    
    public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        // similar code to TileManager
        if (worldX + gp.FINAL_SIZE > gp.player.worldX - gp.player.screenX &&
            worldX - gp.FINAL_SIZE < gp.player.worldX + gp.player.screenX &&
            worldY + gp.FINAL_SIZE > gp.player.worldY - gp.player.screenY &&
            worldY - gp.FINAL_SIZE < gp.player.worldY + gp.player.screenY) {
            g2.drawImage(image, screenX, screenY, 
                sizeX, sizeY, null
            );
        }
    }
}
