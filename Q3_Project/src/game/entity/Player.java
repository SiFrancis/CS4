/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.entity;

import game.GamePanel;
import game.KeyHandler;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Acer
 */
public class Player extends Entity {
    //for key events (e.g. motion)
    KeyHandler keyH;
    
    boolean moving;
    
    //sprites for four directions
    public BufferedImage up, down, left, right;
    
    //determines camera position
    public final int screenX;
    public final int screenY;
    
    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        
        this.keyH = keyH;
        
        //centers camera on screen
        screenX = (gp.SCREEN_W - gp.TILE_SIZE)/2;
        screenY = (gp.SCREEN_H - gp.TILE_SIZE)/2;
        
        setDefaults(4, 4, gp.TILE_SIZE, "right");
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        getImage();
    }
    
    
    
    public void getImage(){
        // reads the image sprite files
        try {
            up = ImageIO.read(getClass().getResourceAsStream("/assets/game/player/up.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/assets/game/player/down.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/assets/game/player/left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/assets/game/player/right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void stopMoving () {
        switch (direction) {
            case "up" -> {keyH.upPress = false; moving = false;}
            case "down" -> {keyH.downPress = false; moving = false;}
            case "left" -> {keyH.leftPress = false; moving = false;}
            case "right" -> {keyH.rightPress = false; moving = false;}
        }
    }
    
    public void interactObject(int i) {
        if (i != 999) {
            String objName = gp.obj[gp.currentMap][i].name;
            switch (objName) {
                case "Start Bed" -> {
                    //exit dialog?
                }
                case "Stairs" -> {
                    switch (gp.obj[gp.currentMap][i].type) {
                        case 0 -> {
                            stopMoving();
                            if (this.worldX == 1*gp.TILE_SIZE && this.worldY == 14*gp.TILE_SIZE) {
                                this.worldX = 29*gp.TILE_SIZE; this.worldY = 15*gp.TILE_SIZE;
                            }
                        }
                        case 1 -> {
                            stopMoving();
                            if (this.worldX == 29*gp.TILE_SIZE && this.worldY == 15*gp.TILE_SIZE) {
                                this.worldX = 1*gp.TILE_SIZE; this.worldY = 14*gp.TILE_SIZE;
                            }
                        }
                    }
                }
                case "Dad" -> {
                    gp.obj[gp.currentMap][i].showTalkDialog(gp);
                }
                case "Door" -> {
                    switch (gp.obj[gp.currentMap][i].type) {
                        case 0 -> {
                            stopMoving();
                            if (this.worldX == 6*gp.TILE_SIZE && this.worldY == 2*gp.TILE_SIZE) {
                                this.worldX = 26*gp.TILE_SIZE; this.worldY = 5*gp.TILE_SIZE;
                            } else if (this.worldX == 26*gp.TILE_SIZE && this.worldY == 3*gp.TILE_SIZE) {
                                System.out.println("coming soon");
                            } 
                        }
                        case 1 -> {
                            stopMoving();
                            if (this.worldX == 26*gp.TILE_SIZE && this.worldY == 5*gp.TILE_SIZE) {
                                this.worldX = 6*gp.TILE_SIZE; this.worldY = 2*gp.TILE_SIZE;
                            } 
                        }
                    }
                    
                }
            }
        }
    }
    
    public void update(){
        //handles player movement
        
        //collision status
        colliding = false;
        //movement status
        moving = false;
        
        //pressing WASD keys immediately changes the direction of the player
        if (keyH.upPress) {
            direction = "up";
            moving = true;
        }
        if (keyH.downPress) {
            direction = "down";
            moving = true;
        }
        if (keyH.leftPress) {
            direction = "left";
            moving = true;
        }
        if (keyH.rightPress) {
            direction = "right";
            moving = true;
        }
        //checks for collision before moving, using the direction indicated by above if ladder
        gp.collH.checkTile(this);
        
        //event handling
        gp.eventH.checkEvent();
        
        //object collision handling
        int objIndex = gp.collH.checkObject(this);
        interactObject(objIndex);
        
        //will only move player if there is no collision and WASD keys are being pressed
        if (colliding == false && moving == true) {
            switch (direction) {
                //setting key press and movement status to false makes player move only one grid space at a time
                case "up" -> {worldY -= speed; keyH.upPress = false; moving = false;}
                case "down" -> {worldY += speed; keyH.downPress = false; moving = false;}
                case "left" -> {worldX -= speed; keyH.leftPress = false; moving = false;}
                case "right" -> {worldX += speed; keyH.rightPress = false; moving = false;}
            }
        }

        //prevents player from going out of bounds
        if (worldX > gp.WORLD_W - gp.TILE_SIZE) {worldX = gp.WORLD_W - gp.TILE_SIZE;}
        if (worldY > gp.WORLD_H - gp.TILE_SIZE) {worldY = gp.WORLD_H - gp.TILE_SIZE;}
        if (worldX < 0) {worldX = 0;}
        if (worldY < 0) {worldY = 0;}
    }
    
    public void draw(Graphics2D g2){
        //changes sprite based on direction
        BufferedImage img = null;
        switch (direction) {
            case "up" -> img = up;
            case "down" -> img = down;
            case "left" -> img = left;
            case "right" -> img = right;
        }
        
        //draws player character
        g2.drawImage(img, screenX, screenY, gp.TILE_SIZE, gp.TILE_SIZE, null);
    }
}
