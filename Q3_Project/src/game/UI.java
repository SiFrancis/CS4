/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author user
 */
public class UI {
    GamePanel gp;
    Graphics2D g2;
    
    // custom font
    Font base_font;
    
    // for printing text
    public String currentDialog = "";
    
    // dialog box colors
    Color dialog_bg = new Color(255, 253, 208, 250);
    Color dialog_acc = new Color(93, 25, 22);
    
    //showing/hiding page count
    public boolean showPageCount = false;
    
    public UI (GamePanel gp) {
        this.gp = gp;
        
        try {
            InputStream is = getClass().getResourceAsStream("/assets/font/_bitmap_font____romulus_by_pix3m-d6aokem.ttf");
            base_font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void drawPauseScreen(){
        g2.setFont(base_font.deriveFont(90f));
        g2.setColor(new Color(0, 0, 0, 200));
        g2.fillRect(0, 0, gp.SCREEN_W, gp.SCREEN_H);
        g2.setColor(Color.white);
        String maintxt = "NAKAHINTO";
        String subtxt = "Pindotin ang [Esc] upang magpatuloy";
        String guidetxt = "Pindotin ang [G] upang makakuha ng gabay";
        int x = getCenteredX(maintxt);
        int y = gp.SCREEN_H/2 - 100;
        g2.drawString(maintxt, x, y);

        g2.setFont(base_font.deriveFont(35f));
        int x2 = getCenteredX(subtxt);
        g2.drawString(subtxt, x2, y+50);
        
        g2.setFont(base_font.deriveFont(30f));
        int x3 = getCenteredX(guidetxt);
        g2.drawString(guidetxt, x3, y+170);
    }
    
    public void drawDialogWindow(String customText) {
        g2.setFont(base_font.deriveFont(35f));
        int win_w = gp.SCREEN_W - (gp.TILE_SIZE * 4);
        int win_h = gp.TILE_SIZE*4;
        int x = 2*gp.TILE_SIZE;
        int y = gp.SCREEN_H - (win_h + gp.TILE_SIZE/2);
        
        drawSubWindow(x, y, win_w, win_h);
        
        int dialogX = x + gp.TILE_SIZE/2;
        int dialogY = y + 3*gp.TILE_SIZE/4;
        g2.setColor(dialog_acc);
        g2.drawString(customText, dialogX, dialogY);
    }
    
    public void drawPageCounter() {
        try {
            BufferedImage page = ImageIO.read(getClass().getResourceAsStream("/assets/game/ui/page.png"));
            g2.setFont(base_font.deriveFont(50f));
            g2.drawImage(page, 100, 100, null);
            g2.drawString(String.format("%d/14", gp.player.pageCount), 160, 130);
        } catch (IOException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void drawDialogWindow() {
        g2.setFont(base_font.deriveFont(35f));
        int win_w = gp.SCREEN_W - (gp.TILE_SIZE * 4);
        int win_h = gp.TILE_SIZE*4;
        int x = 2*gp.TILE_SIZE;
        int y = gp.SCREEN_H - (win_h + gp.TILE_SIZE/2);
        
        drawSubWindow(x, y, win_w, win_h);
        
        int dialogX = x + gp.TILE_SIZE/2;
        int dialogY = y + 3*gp.TILE_SIZE/4;
        g2.setColor(dialog_acc);
        
        for (String line : currentDialog.split("\n")) {
            g2.drawString(line, dialogX, dialogY);
            dialogY += 40;
        }
        
        if (gp.gameState == gp.DIALOGUE_STATE) {
            g2.setFont(base_font.deriveFont(22f));
            dialogY = y + win_h - 30;
            g2.drawString("Pindotin ang [Enter] upang ipatuloy ang dayalogo.", dialogX, dialogY);
        }
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
            if (showPageCount == true) {drawPageCounter();}
        }
        if (gp.gameState == gp.PAUSE_STATE) {
            drawPauseScreen();
        }
        if ((gp.gameState == gp.DIALOGUE_STATE) || (gp.gameState == gp.HINT_STATE)) {
            drawDialogWindow();
        }
    }
    
    public int getCenteredX(String text) {
        int len = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int centered_x  = (gp.SCREEN_W - len)/2;
        return centered_x;
    }
}
