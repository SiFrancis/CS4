/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import game.entity.Player;
import javax.swing.*;
import java.awt.*;
import game.objects.SuperObject;

/**
 *
 * @author Acer
 */

//most of the code in the game section is derived from RyiSnow's YouTube tutorials:
//https://www.youtube.com/watch?v=om59cwR7psI&list=PL_QPQmz5C6WUF-pOQDsbsKbaBZqXj4qSq&pp=iAQB

public class GamePanel extends JPanel implements Runnable {
    //tile settings
    final int BASE_SIZE = 32; //32x32 tile textures
    final float TILE_SCALE = 2;
    public final int FINAL_SIZE = (int) (BASE_SIZE * TILE_SCALE); //scaled tiles
    
    //screen display settings
    public final int SCREEN_COLS = 16; //screen is 16 grid spaces wide
    public final int SCREEN_ROWS = 12; //screen is 12 grid spaces tall
    public final int SCREEN_W = FINAL_SIZE * SCREEN_COLS; // 1024 px wide
    public final int SCREEN_H = FINAL_SIZE * SCREEN_ROWS; // 768 px tall
    
    // game loop related
    Thread gameThread;
    
    //see classes for description
    
    //instantiates key handler
    KeyHandler keyH = new KeyHandler();
    
    //new object manager
    public SuperObject obj[] = new SuperObject[10];
    ObjectManager objM = new ObjectManager(this);
    
    //instantiates new Player object
    public Player player = new Player(this, keyH);
    
    //instantiates tile manager
    public String map = "room.txt";
    TileManager tileM = new TileManager(this, map);
    
    //instantiates new collision handler
    public CollisionHandler collH = new CollisionHandler(this);
    
    //settings for world map
    //all maps will have this fixed size
    //very inflexible pero sige nalang
    public final int WORLD_COLS = 50;
    public final int WORLD_ROWS = 50;
    public final int WORLD_W = WORLD_COLS * FINAL_SIZE;
    public final int WORLD_H = WORLD_ROWS * FINAL_SIZE;
    
    //FPS
    int FPS = 60;
    
    public void setup() {
        objM.placeObjects();
    }
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void endGameThread() {
        gameThread.interrupt();
    }
    
    //updates player position
    public void update(){
        player.update();
    }
    
    //updates graphics
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        tileM.draw(g2);
        
        for (SuperObject o : obj) {
            if (o != null) {o.draw(g2, this);}
        }
        
        player.draw(g2);
        
        g2.dispose();
    }
    
    public GamePanel() {
        //sets screen dimension
        this.setPreferredSize(new Dimension(SCREEN_W, SCREEN_H));
        
        //sets black background
        this.setBackground(Color.black);
        
        //for graphics optimization apparently
        this.setDoubleBuffered(true);
        
        //activates key listener
        this.addKeyListener(keyH);
        
        //setting focusable to true makes the window able to accept key input
        this.setFocusable(true);
    }

    @Override
    public void run() {
        //this function is called every 60 frames as per FPS setting
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
