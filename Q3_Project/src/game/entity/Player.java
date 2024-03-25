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
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Acer
 */
public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    
    //sprites for four directions
    public BufferedImage up, down, left, right;
    
    public boolean exits = false;
    
    //determines camera position
    public final int screenX;
    public final int screenY;
    
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        
        //centers camera on screen
        screenX = (gp.SCREEN_W - gp.FINAL_SIZE)/2;
        screenY = (gp.SCREEN_H - gp.FINAL_SIZE)/2;
        
        setDefaults();
        getImage();
    }
    
    public void setDefaults() {
        //sets player position and speed
        worldX = 4*gp.FINAL_SIZE;
        worldY = 4*gp.FINAL_SIZE;
        speed = gp.FINAL_SIZE;
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
    
    public void interactObject(int i) {
        if (i != 999) {
            String objName = gp.obj[i].name;
            switch (objName) {
                case "Bed" -> {
                    //exit dialog?
                    System.out.println(Math.random());
                }
                case "Start Door" -> {
                    // enter game
                }
                case "Desk" -> {
                    //go to automations
                }
            }
        }
    }
    
    public void update(){
        //handles player movement
        
        //collision status
        colliding = false;
        //movement status
        boolean moving = false;
        
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
        if (worldX > gp.WORLD_W - gp.FINAL_SIZE) {worldX = gp.WORLD_W - gp.FINAL_SIZE;}
        if (worldY > gp.WORLD_H - gp.FINAL_SIZE) {worldY = gp.WORLD_H - gp.FINAL_SIZE;}
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
        g2.drawImage(img, screenX, screenY, gp.FINAL_SIZE, gp.FINAL_SIZE, null);
    }
}
