/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author user
 */
public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font pause_txt;
    
    public UI (GamePanel gp) {
        this.gp = gp;
        
        pause_txt = new Font("Arial", Font.PLAIN, 50);
    }
    
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        
        g2.setFont(pause_txt);
        g2.setColor(Color.white);
        
        if (gp.gameState == gp.PLAY_STATE) {
            String text = gp.player.worldX/gp.TILE_SIZE + " " + gp.player.worldY/gp.TILE_SIZE;
            g2.drawString(text, 100, 100);
        }
        if (gp.gameState == gp.PAUSE_STATE) {
            String text = "PAUSED";
            int x = getCenteredTextX(text);
            int y = gp.SCREEN_H/2;
            
            g2.drawString(text, x, y);
        }
    }
    
    public int getCenteredTextX(String text) {
        int len = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int centered_x  = (gp.SCREEN_W - len)/2;
        return centered_x;
    }
}
