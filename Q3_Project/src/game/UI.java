/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.BasicStroke;
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
    Font base_font;
    public String currentDialog = "";
    Color dialog_bg = new Color(255, 253, 208, 250);
    Color dialog_acc = new Color(93, 25, 22);
    
    public UI (GamePanel gp) {
        this.gp = gp;
        base_font = new Font("Arial", Font.PLAIN, 30);
    }
    
    public void drawPauseScreen(){
        Font pause_bigfont = base_font.deriveFont(70f);
        g2.setFont(pause_bigfont);
        g2.setColor(new Color(0, 0, 0, 200));
        g2.fillRect(0, 0, gp.SCREEN_W, gp.SCREEN_H);
        g2.setColor(Color.white);
        String maintxt = "NAKAHINTO";
        String subtxt = "Pindutin ang [Esc] upang magpatuloy";
        int x = getCenteredX(maintxt);
        int y = gp.SCREEN_H/2;
        g2.drawString(maintxt, x, y);

        Font pause_subfont = base_font.deriveFont(25f);
        g2.setFont(pause_subfont);
        int x2 = getCenteredX(subtxt);
        g2.drawString(subtxt, x2, y+50);
    }
    
    public void drawDialogWindow() {
        int win_w = gp.SCREEN_W - (gp.TILE_SIZE * 4);
        int win_h = gp.TILE_SIZE*4;
        int x = 2*gp.TILE_SIZE;
        int y = gp.SCREEN_H - (win_h + gp.TILE_SIZE/2);
        
        drawSubWindow(x, y, win_w, win_h);
        
        int dialogX = x + gp.TILE_SIZE/2;
        int dialogY = y + 3*gp.TILE_SIZE/4;
        g2.setColor(dialog_acc);
        g2.drawString(currentDialog, dialogX, dialogY);
    }
    
    public void drawSubWindow(int x, int y, int width, int height) {
        //main rectangle
        g2.setColor(dialog_bg);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        
        //outline
        g2.setColor(dialog_acc);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(x+8, y+8, width-16, height-16, 25, 25);
    }
    
    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(base_font);
        g2.setColor(Color.white);
        if (gp.gameState == gp.PLAY_STATE) {
            String text = gp.player.worldX/gp.TILE_SIZE + " " + gp.player.worldY/gp.TILE_SIZE;
            g2.drawString(text, 100, 100);
        }
        if (gp.gameState == gp.PAUSE_STATE) {
            drawPauseScreen();
        }
        if (gp.gameState == gp.DIALOGUE_STATE) {
            drawDialogWindow();
        }
    }
    
    public int getCenteredX(String text) {
        int len = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int centered_x  = (gp.SCREEN_W - len)/2;
        return centered_x;
    }
}
