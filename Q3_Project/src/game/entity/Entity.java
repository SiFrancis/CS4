/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.entity;

import game.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Acer
 */
public class Entity {
    /**
     * used for players and NPCs
     * might remove this if final game has no NPCs
     */
    
    GamePanel gp;
    
    //world coordinates
    public int worldX, worldY, speed;
    
    //direction of motion
    public String direction;
    
    //collision status
    public boolean colliding = false;
    
    //sets default solid area for entities (1 tile x 1 tile)
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    
    //sprite image
    public BufferedImage image;
    
    public void setDefaults(int x, int y, int speed, String dir) {
        //sets entity position and speed
        solidArea = new Rectangle(0, 0, gp.TILE_SIZE, gp.TILE_SIZE);
        this.worldX = x*gp.TILE_SIZE;
        this.worldY = y*gp.TILE_SIZE;
        this.speed = speed;
        this.direction = dir;
    }
    
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    public Entity (GamePanel gp) {this.gp = gp;}
}
