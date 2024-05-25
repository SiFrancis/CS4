/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q4_project;

import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author user
 */
public class GamePanel extends JPanel implements Runnable {

    public final int SCREEN_W = 800;
    public final int SCREEN_H = 600;
    
    public final int FPS = 60;
    public Thread gameThread;
    
    InputHandler input = new InputHandler();
    Random rand = new Random();
    
    // measurements of player object
    int origX = 100; int origY = 500; 
    double initAngle = -45; double currentAngle = initAngle; double hitAngle = 9999; // arbitrary start value
    int pathRadius = 100; int ballRadius = 10; int pathArc = 90;
    double rotateSpeed = 1;
    
    // distance between player and spotter
    int groundDistance;
    
    // spotter coordinates
    int spotterX;
    int spotterY;
    
    // coordinates of target
    // target coordinates are used for angle computation
    // targetPoint coordinates are used for drawing
    double targetX;
    double targetPointX;
    double targetY;
    double targetPointY;
    
    // 
    int spotterAngle;
    int spotterDistance;
    int spotterDrawAngle;
    
    int targetAngle;
    
    int goalAngle;
    double goalDrawAngle;
    int goalDistance;
    
    double hitThresh = 10.51;
    
    double angleDiff, percentAngleDiff;
    
    boolean rotateBack = false;
    
    public void generateTriangle() {
        // generating points
        groundDistance = rand.nextInt(10, 30) * 20;
        targetX = rand.nextDouble(150, 500);
        targetY = rand.nextInt(50, 90) * 5;
        
        // calculating spotter angle
        spotterX = origX + groundDistance;
        spotterY = origY;
        spotterAngle = (int)Math.toDegrees(Math.atan(Math.abs(spotterY-targetPointY)/Math.abs(spotterX-targetPointX)));
        spotterDistance = (int)Math.sqrt((spotterY-targetPointY)*(spotterY-targetPointY)+(spotterX-targetPointX)*(spotterX-targetPointX));
        spotterDrawAngle = -1 * (90 + spotterAngle);
        
        // calculating goal angle and distance
        goalAngle = (int)Math.toDegrees(Math.atan(targetY/targetX));
        goalDrawAngle = -1*goalAngle;
        goalDistance = (int)Math.sqrt(targetX*targetX + targetY*targetY);
        
        // calculating angle on target point
        targetPointX = origX + targetX;
        targetPointY = origY - targetY;
        
        System.out.println("Target Angle: " + targetAngle);
        System.out.println("Ground Ditance: " + groundDistance);
        System.out.println("Spotter Angle: " + spotterAngle);
        System.out.println("Spotter Distance: " + spotterDistance + "\n");
        System.out.println("Goal Angle: " + goalAngle);
        System.out.println("Goal Distance: " + goalDistance);
    }
    
    public void update() {
        if (rotateBack) currentAngle -= rotateSpeed;
        else currentAngle += rotateSpeed;
        if (currentAngle >= 0 || currentAngle <= -1*pathArc) rotateBack = !rotateBack;
        
        if (input.hitPress) {
            hitAngle = currentAngle;
            angleDiff = goalDrawAngle - hitAngle;
            percentAngleDiff = (-1*angleDiff/goalDrawAngle)*100;
            System.out.println(String.format("Current Angle: %1$.2f | Difference: %2$.2f (%3$.2f%%)", 
                    -1*hitAngle, angleDiff, percentAngleDiff));
            input.hitPress = false;
            if (Math.abs(angleDiff) < hitThresh) {generateTriangle();}
        }
    }
    
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        
        // drawing guide lines
        g.setColor(Color.white);
        g.drawArc(origX - pathRadius, origY - pathRadius, pathRadius*2, pathRadius*2, 0, pathArc);
        g.drawLine(origX, origY, spotterX, origY);
        g.drawLine(origX, origY, origX, origY-150);
        
        // drawing player object
        int ballX = (int) (pathRadius * Math.cos(currentAngle * Math.PI / 180));
        int ballY = (int) (pathRadius * Math.sin(currentAngle * Math.PI / 180));
        
        g.setColor(Color.red);
        g.fillOval(origX + ballX - ballRadius, origY + ballY - ballRadius, ballRadius*2, ballRadius*2);
        
        if (hitAngle != 9999) {
            g.drawLine(origX, origY,
                origX + (int)(150 * Math.cos(hitAngle * Math.PI / 180)),
                origY + (int)(150 * Math.sin(hitAngle * Math.PI / 180)));
        }
        
        // drawing spotter ball and line
        g.setColor(Color.CYAN);
        g.fillOval(spotterX - ballRadius, origY - ballRadius, ballRadius*2, ballRadius*2);
        g.drawLine((int)targetPointX, (int)targetPointY, 
                spotterX, spotterY);
        
        // drawing target
        g.setColor(new Color(150, 0, 255));
        g.fillOval((int)targetPointX - ballRadius, (int)targetPointY - ballRadius, ballRadius*2, ballRadius*2);
        //g.drawLine((int)targetPointX, (int)targetPointY, origX, origY);
        
         
        // drawing target line
        g.setColor(Color.yellow);
        g.drawLine(origX, origY,
                origX + (int)(150 * Math.cos(goalDrawAngle * Math.PI / 180)),
                origY + (int)(150 * Math.sin(goalDrawAngle * Math.PI / 180))
        );
    }
    
    public GamePanel() {

        
        gameThread = new Thread(this);
        gameThread.start();
        
        generateTriangle();

        //sets screen dimension
        this.setPreferredSize(new Dimension(SCREEN_W, SCREEN_H));

        //sets black background
        this.setBackground(Color.black);

        //for graphics optimization apparently
        this.setDoubleBuffered(true);
        
        //activates key listener
        this.addKeyListener(input);

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
