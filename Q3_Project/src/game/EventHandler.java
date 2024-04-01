/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.Rectangle;
import main.automations.*;

/**
 *
 * @author user
 */
public class EventHandler {
    
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;
    
    int prevEventX, prevEventY;
    boolean canTouchEvent;
    
    public EventHandler(GamePanel gp) {
        this.gp = gp;
        eventRect = new Rectangle(20, 20, 12, 12);
    }
    
    public void checkEvent() {
        int distanceX = Math.abs(prevEventX - gp.player.worldX);
        int distanceY = Math.abs(prevEventY - gp.player.worldY);
        int distance = Math.max(distanceX, distanceY);
        
        if (distance > gp.TILE_SIZE) {
            canTouchEvent = true;
        }
        
        if (canTouchEvent == true) {
            //there has to be a better way to do this, right
            if (hit(0, 1, 7, "any") == true ||
                hit(0, 2, 7, "any") == true) {
                gp.obj[0][1].showHintDialog(gp, 0);
                if (gp.keyH.interactPress) {
                    gp.currentMap = 1;
                    gp.player.worldX = 6 * gp.TILE_SIZE;
                    gp.player.worldY = 6 * gp.TILE_SIZE;
                    gp.player.stopMoving();
                    canTouchEvent = false;
                }
            } else if(hit(1, 2, 6, "any") == true) {
                gp.obj[1][1].showHintDialog(gp, 0);
                if (gp.keyH.interactPress == true) {
                    gp.player.stopMoving();
                    gp.gameState = gp.PAUSE_STATE;
                    new Automation1().setVisible(true);
                    canTouchEvent = false;
                }
            } else if(hit(1, 6, 2, "any") == true) {
                gp.obj[1][2].showHintDialog(gp, 0);
                if (gp.keyH.interactPress == true) {
                    gp.player.stopMoving();
                    gp.gameState = gp.PAUSE_STATE;
                    new Automation2().setVisible(true);
                    canTouchEvent = false;
                }
            } else if(hit(1, 10, 6, "any") == true) {
                gp.obj[1][3].showHintDialog(gp, 0);
                if (gp.keyH.interactPress == true) {
                    gp.player.stopMoving();
                    gp.gameState = gp.PAUSE_STATE;
                    new Automation3().setVisible(true);
                    canTouchEvent = false;
                }
            } else if(hit(1, 6, 10, "any") == true) {
                gp.obj[1][0].showHintDialog(gp, 0);
                if (gp.keyH.interactPress) {
                    gp.currentMap = 0;
                    gp.player.worldX = 3 * gp.TILE_SIZE;
                    gp.player.worldY = 6 * gp.TILE_SIZE;
                    gp.player.stopMoving();
                    canTouchEvent = false;
                }
            } else gp.gameState = gp.PLAY_STATE;
        }
    }
    
    public boolean hit(int mapNum, int eventCol, int eventRow, String reqDirection) {
        boolean isHit = false;
        gp.player.solidArea.x += gp.player.worldX;
        gp.player.solidArea.y += gp.player.worldY;
        
        eventRect.x += eventCol * gp.TILE_SIZE;
        eventRect.y += eventRow * gp.TILE_SIZE;
        
        if (gp.player.solidArea.intersects(eventRect) && 
            gp.currentMap == mapNum &&
           (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any"))) {
            isHit = true;
            prevEventX = gp.player.worldX;
            prevEventY = gp.player.worldY;
        }
        
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;
        
        return isHit;
    }
    
}
