/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objects;

import game.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Acer
 */
public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public int sizeW = 64, sizeH = 64;
    public Rectangle solidArea;
    public int solidAreaDefaultX = 0, solidAreaDefaultY = 0;
    //used for automation icon for now; might be useful for other things
    public int type = 0;
    String[] dialogues = new String[20];
    int dialogueIndex = 0;
    String hintText;
    
    public void placeAndSize(GamePanel gp, int x, int y, int width, int height) {
        this.worldX = x*gp.TILE_SIZE; this.worldY = y*gp.TILE_SIZE;
        this.sizeW = width*gp.TILE_SIZE; this.sizeH = height*gp.TILE_SIZE;
        solidArea = new Rectangle(0, 0, sizeW, sizeH);
    }
    
    public void setDialogue(int i, String text) {dialogues[i] = text;}
    
    public void hintDialogue(GamePanel gp, int i) {gp.ui.currentDialog = dialogues[i]; gp.gameState = gp.HINT_STATE;}
    
    public void talkDialogue(GamePanel gp, int end) {
        if (dialogues[dialogueIndex] != null && dialogueIndex <= end) {
            gp.ui.currentDialog = dialogues[dialogueIndex]; 
            dialogueIndex++;
            gp.gameState = gp.DIALOGUE_STATE;
        }
    }
    
    public void getImage(String imageName) {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/assets/game/objects/"+imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        // similar code to TileManager
        if (worldX + gp.TILE_SIZE > gp.player.worldX - gp.player.screenX &&
            worldX - gp.TILE_SIZE < gp.player.worldX + gp.player.screenX &&
            worldY + gp.TILE_SIZE > gp.player.worldY - gp.player.screenY &&
            worldY - gp.TILE_SIZE < gp.player.worldY + gp.player.screenY) {
            g2.drawImage(image, screenX, screenY, 
                sizeW, sizeH, null
            );
        }
    }
}
