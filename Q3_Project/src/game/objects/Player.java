/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objects;

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
    
    public BufferedImage up, down, left, right;
    
    public final int screenX;
    public final int screenY;
    
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = (gp.SCREEN_W - gp.FINAL_SIZE)/2;
        screenY = (gp.SCREEN_H - gp.FINAL_SIZE)/2;
        
        setDefaults();
        getImage();
    }
    
    public void setDefaults() {
        //player movement (initial position and speed)
        worldX = 10*gp.FINAL_SIZE;
        worldY = 9*gp.FINAL_SIZE;
        speed = gp.FINAL_SIZE;
        direction = "right";
    }
    
    public void getImage(){
        try {
            up = ImageIO.read(getClass().getResourceAsStream("/game/res/player/up.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/game/res/player/down.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/game/res/player/left.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/game/res/player/right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update(){
        colliding = false;
        boolean moving = false;
        
        if (!colliding) {
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
        }
        
        gp.collH.checkTile(this);
        
//        if (colliding == false && moving == true) {
//            switch (direction) {
//                case "up" -> {worldY -= speed;}
//                case "down" -> {worldY += speed;}
//                case "left" -> {worldX -= speed;}
//                case "right" -> {worldX += speed;}
//            }
//        }
        
        if (colliding == false && moving == true) {
            switch (direction) {
                case "up" -> {worldY -= speed; keyH.upPress = false; moving = false;}
                case "down" -> {worldY += speed; keyH.downPress = false; moving = false;}
                case "left" -> {worldX -= speed; keyH.leftPress = false; moving = false;}
                case "right" -> {worldX += speed; keyH.rightPress = false; moving = false;}
            }
        }

        
        if (worldX > gp.WORLD_W - gp.FINAL_SIZE) {worldX = gp.SCREEN_W - gp.FINAL_SIZE;}
        if (worldY > gp.WORLD_H - gp.FINAL_SIZE) {worldY = gp.SCREEN_H - gp.FINAL_SIZE;}
        if (worldX < 0) {worldX = 0;}
        if (worldY < 0) {worldY = 0;}
        System.out.println(worldX/gp.FINAL_SIZE+" "+worldY/gp.FINAL_SIZE);
    }
    
    public void draw(Graphics2D g2){
        BufferedImage img = null;
        switch (direction) {
            case "up" -> img = up;
            case "down" -> img = down;
            case "left" -> img = left;
            case "right" -> img = right;
        }
        g2.drawImage(img, screenX, screenY, gp.FINAL_SIZE, gp.FINAL_SIZE, null);
    }
}
