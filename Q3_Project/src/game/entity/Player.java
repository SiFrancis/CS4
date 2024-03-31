/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.entity;

import game.GamePanel;
import game.KeyHandler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.automations.*;

/**
 *
 * @author Acer
 */
public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    
    boolean moving;
    
    //sprites for four directions
    public BufferedImage up, down, left, right;
    
    //determines camera position
    public final int screenX;
    public final int screenY;
    
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        
        //centers camera on screen
        screenX = (gp.SCREEN_W - gp.TILE_SIZE)/2;
        screenY = (gp.SCREEN_H - gp.TILE_SIZE)/2;
        
        solidArea = new Rectangle();
        solidArea.x = 0;
        solidArea.y = 0;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = gp.TILE_SIZE;
        solidArea.height = gp.TILE_SIZE;
        
        setDefaults();
        getImage();
    }
    
    public void setDefaults() {
        //sets player position and speed
        worldX = 4*gp.TILE_SIZE;
        worldY = 4*gp.TILE_SIZE;
        speed = gp.TILE_SIZE;
        direction = "right";
    }
    
    public void getImage(){
        // reads the image sprite files
        try {
            up = ImageIO.read(getClass().getResourceAsStream("/game/res/player/up.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/game/res/player/down.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/game/res/player/left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/game/res/player/right.png"));
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
                case "Start Door" -> {
                    // enter game
                }
                case "Start Desk" -> {
                    //go to automations
                    gp.currentMap = 1;
                    this.worldX = 6*gp.TILE_SIZE; this.worldY = 6*gp.TILE_SIZE;
                    stopMoving();
                }
                case "Automation Icon" -> {
                    switch (gp.obj[gp.currentMap][i].type) {
                        case 0 -> {
                            gp.currentMap = 0;
                            this.worldX = 4*gp.TILE_SIZE; this.worldY = 4*gp.TILE_SIZE;
                            stopMoving();
                        }
                        case 1 -> {
                            stopMoving();
                            gp.gameState = gp.PAUSE_STATE;
                            new Automation1().setVisible(true);
                        }
                        case 2 -> {
                            stopMoving();
                            gp.gameState = gp.PAUSE_STATE;
                            new Automation2().setVisible(true);
                        }
                        case 3 -> {System.out.println("autom3");}
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
