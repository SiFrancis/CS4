/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q4_project;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author user
 */
public class GamePanel extends JPanel implements Runnable {

    public final int SCREEN_W = 800;
    public final int SCREEN_H = 600;
    
    public final int FPS = 60;
    public Thread gameThread;
    
    int origX = 100; int origY = 500; 
    double initAngle = -45; double currentAngle = initAngle;
    int pathRadius = 60; int ballRadius = 20;
    double rotateSpeed = 2.75;
    
    boolean rotateBack = false;
    
    public void update() {
        if (rotateBack) currentAngle -= rotateSpeed;
        else currentAngle += rotateSpeed;
        if (currentAngle >= 0 || currentAngle <= -90) rotateBack = !rotateBack;
    }
    
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.white);
        g.drawOval(origX  - pathRadius, origY - pathRadius, pathRadius*2, pathRadius*2);
        
        int ballX = (int) (pathRadius * Math.cos(Math.toRadians(currentAngle)));
        int ballY = (int) (pathRadius * Math.sin(Math.toRadians(currentAngle)));
        
        g.setColor(Color.red);
        g.fillOval(origX + ballX - ballRadius, origY + ballY - ballRadius, ballRadius*2, ballRadius*2);
    }
    
    public GamePanel() {

        gameThread = new Thread(this);
        gameThread.start();

        //sets screen dimension
        this.setPreferredSize(new Dimension(SCREEN_W, SCREEN_H));

        //sets black background
        this.setBackground(Color.black);

        //for graphics optimization apparently
        this.setDoubleBuffered(true);

        //setting focusable to true makes the window able to accept key input
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
