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

/**
 *
 * @author Acer
 */
public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    
    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
    }
    
    public void setDefaults() {
        //player movement (initial position and speed)
        this.initX = gp.FINAL_SIZE;
        this.initY = gp.FINAL_SIZE;
        this.speed = gp.FINAL_SIZE;
    }
    
    public void update(){
        if (keyH.upPress) {initY -= speed;  keyH.upPress = false;}
        if (keyH.downPress) {initY += speed;  keyH.downPress = false;}
        if (keyH.leftPress) {initX -= speed;  keyH.leftPress = false;}
        if (keyH.rightPress) {initX += speed; keyH.rightPress = false;}
        if (initX > gp.SCREEN_W - gp.FINAL_SIZE) {initX = gp.SCREEN_W - gp.FINAL_SIZE;}
        if (initY > gp.SCREEN_H - gp.FINAL_SIZE) {initY = gp.SCREEN_H - gp.FINAL_SIZE;}
        if (initX < 0) {initX = 0;}
        if (initY < 0) {initY = 0;}
    }
    
    public void draw(Graphics2D g2){
        
        g2.setColor(Color.white);
        g2.fillRect(initX, initY, gp.FINAL_SIZE, gp.FINAL_SIZE);
    }
}
