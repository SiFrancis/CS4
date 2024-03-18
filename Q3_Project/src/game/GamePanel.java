/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import game.objects.Player;
import game.objects.TileManager;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Acer
 */
public class GamePanel extends JPanel implements Runnable {
    //tile settings
    final int BASE_SIZE = 32; //32x32 tiles
    final float TILE_SCALE = 2;
    public final int FINAL_SIZE = (int) (BASE_SIZE * TILE_SCALE);
    
    //screen display settings
    public final int SCREEN_COLS = 16;
    public final int SCREEN_ROWS = 12;
    public final int SCREEN_W = FINAL_SIZE * SCREEN_COLS;
    public final int SCREEN_H = FINAL_SIZE * SCREEN_ROWS;
    
    // game loop related
    Thread gameThread;
    KeyHandler keyH = new KeyHandler();
    Player player = new Player(this, keyH);
    TileManager tileM = new TileManager(this);
    public CollisionHandler collH = new CollisionHandler(this);
    
    //FPS
    int FPS = 60;
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void update(){
        player.update();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        tileM.draw(g2);
        player.draw(g2);
        
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
