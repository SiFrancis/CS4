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
    
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaults();
        getImage();
    }
    
    public void setDefaults() {
        //player movement (initial position and speed)
        x = gp.FINAL_SIZE;
        y = gp.FINAL_SIZE;
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
        
        if (colliding == false && moving == true) {
            switch (direction) {
                case "up" -> {y -= speed; keyH.upPress = false; moving = false;}
                case "down" -> {y += speed; keyH.downPress = false; moving = false;}
                case "left" -> {x -= speed; keyH.leftPress = false; moving = false;}
                case "right" -> {x += speed; keyH.rightPress = false; moving = false;}
            }
        }
        
        if (x > gp.SCREEN_W - gp.FINAL_SIZE) {x = gp.SCREEN_W - gp.FINAL_SIZE;}
        if (y > gp.SCREEN_H - gp.FINAL_SIZE) {y = gp.SCREEN_H - gp.FINAL_SIZE;}
        if (x < 0) {x = 0;}
        if (y < 0) {y = 0;}
    }
    
    public void draw(Graphics2D g2){
        BufferedImage img = null;
        switch (direction) {
            case "up" -> img = up;
            case "down" -> img = down;
            case "left" -> img = left;
            case "right" -> img = right;
        }
        g2.drawImage(img, x, y, gp.FINAL_SIZE, gp.FINAL_SIZE, null);
    }
}
