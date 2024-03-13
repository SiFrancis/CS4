/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Acer
 */
public class GamePanel extends JPanel implements Runnable {
    //tile settings
    final int BASE_SIZE = 32; //3.52x32 tiles
    final float TILE_SCALE = 2;
    final int FINAL_SIZE = (int) (BASE_SIZE * TILE_SCALE);
    
    //screen display settings
    final int SCREEN_COLS = 12;
    final int SCREEN_ROWS = 9;
    final int SCREEN_W = FINAL_SIZE * SCREEN_COLS; //768px wide
    final int SCREEN_H = FINAL_SIZE * SCREEN_ROWS; //576 px tall
    
    // game loop related
    Thread gameThread;
    KeyHandler keyH = new KeyHandler();
    
    //player movement (initial position and speed)
    int initX = FINAL_SIZE;
    int initY = FINAL_SIZE;
    int speed = FINAL_SIZE;
    
    //FPS
    int FPS = 60;
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void update(){
        if (keyH.upPress) {initY -= speed;  keyH.upPress = false;}
        if (keyH.downPress) {initY += speed;  keyH.downPress = false;}
        if (keyH.leftPress) {initX -= speed;  keyH.leftPress = false;}
        if (keyH.rightPress) {initX += speed; keyH.rightPress = false;}
        if (initX > SCREEN_W - FINAL_SIZE) {initX = SCREEN_W - FINAL_SIZE;}
        if (initY > SCREEN_H - FINAL_SIZE) {initY = SCREEN_H - FINAL_SIZE;}
        if (initX < 0) {initX = 0;}
        if (initY < 0) {initY = 0;}
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(initX, initY, FINAL_SIZE, FINAL_SIZE);
        g2.dispose();
    }
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_W, SCREEN_H));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    @Override
    public void run() {
        double drawInterval = 1000/FPS;
        double delta = 0;
        long timePrev = System.currentTimeMillis();
        long timeNow;
        
        while (gameThread != null) {
            timeNow = System.currentTimeMillis();
            delta += (timeNow - timePrev) / drawInterval;
            timePrev = timeNow;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
}
