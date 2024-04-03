/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import game.puzzles.*;
import javax.swing.Timer;
import main.automations.*;

/**
 *
 * @author user
 */
public class EventHandler {
    
    GamePanel gp;
    EventRect eventRect[][];
    Puzzle1 p1 = new Puzzle1();
    Puzzle2 p2 = new Puzzle2();
    
    int prevEventX, prevEventY;
    boolean canTouchEvent;
    
    public EventHandler(GamePanel gp) {
        this.gp = gp;
        eventRect = new EventRect[gp.WORLD_COLS][gp.WORLD_ROWS];
        int col = 0, row = 0;
        while (col < gp.WORLD_COLS && row < gp.WORLD_ROWS) {
            eventRect[col][row] = new EventRect(22, 22, 10, 10);
            eventRect[col][row].defaultX = eventRect[col][row].x;
            eventRect[col][row].defaultY = eventRect[col][row].y;
            
            col++;
            if (col == gp.WORLD_COLS) {col = 0; row++;}
        }
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
            
            //tp to automation
            if (hit(0, 1, 7, "any") == true ||
                hit(0, 2, 7, "any") == true) {
                gp.obj[0][1].hintDialogue(gp, 0);
                if (gp.keyH.interactPress) {
                    gp.currentMap = 1;
                    gp.player.worldX = 6 * gp.TILE_SIZE;
                    gp.player.worldY = 8 * gp.TILE_SIZE;
                    gp.player.stopMoving();
                    canTouchEvent = false;
                }
            //automation 1
            } else if(hit(1, 2, 8, "any") == true) {
                gp.obj[1][1].hintDialogue(gp, 0);
                if (gp.keyH.interactPress == true) {
                    gp.player.stopMoving();
                    gp.gameState = gp.PAUSE_STATE;
                    new Automation1().setVisible(true);
                    canTouchEvent = false;
                }
            //automation 2
            } else if(hit(1, 6, 4, "any") == true) {
                gp.obj[1][2].hintDialogue(gp, 0);
                if (gp.keyH.interactPress == true) {
                    gp.player.stopMoving();
                    gp.gameState = gp.PAUSE_STATE;
                    new Automation2().setVisible(true);
                    canTouchEvent = false;
                }
            //automation 3
            } else if(hit(1, 10, 8, "any") == true) {
                gp.obj[1][3].hintDialogue(gp, 0);
                if (gp.keyH.interactPress == true) {
                    gp.player.stopMoving();
                    gp.gameState = gp.PAUSE_STATE;
                    new Automation3().setVisible(true);
                    canTouchEvent = false;
                }
            //exit automation
            } else if(hit(1, 6, 12, "any") == true) {
                gp.obj[1][0].hintDialogue(gp, 0);
                if (gp.keyH.interactPress) {
                    gp.currentMap = 0;
                    gp.player.worldX = 2 * gp.TILE_SIZE;
                    gp.player.worldY = 6 * gp.TILE_SIZE;
                    gp.player.stopMoving();
                    canTouchEvent = false;
                }
            // starting dialogue
            } else if(hit(0, 26, 5, "any") == true) {
                gp.obj[0][8].talkDialogue(gp, 1); 
                if (gp.gameState!=gp.DIALOGUE_STATE) eventRect[26][5].eventDone = true;
            } else if(hit(0, 3, 17, "any") == true) {
                gp.obj[0][8].talkDialogue(gp, 2); 
                if (gp.gameState!=gp.DIALOGUE_STATE) eventRect[3][17].eventDone = true;
            } 
            //puzzle 1
            else if(hit(0, 5, 19, "any") == true ||
                    hit(0, 6, 19, "any") == true) {
                gp.player.direction = "up";
                gp.obj[0][8].talkDialogue(gp, 3);
                if (gp.gameState!=gp.DIALOGUE_STATE) {
                    gp.gameState = gp.HINT_STATE; 
                    if (p1.solved == true) {
                        gp.obj[0][8].talkDialogue(gp, 9);
                        if (gp.obj[0][8].dialogueIndex > 9) {
                            eventRect[5][19].eventDone = true;
                            eventRect[6][19].eventDone = true;
                        }
                    } else p1.setVisible(true);
                }
            } 
            //talking to dad scene
            else if(hit(0, 24, 23, "any") == true && p1.solved == true && gp.obj[0][9] != null) {
                gp.obj[0][9].getImage("/assets/game/sprites/dadfull/dadfull_2.png");
                gp.player.direction = "left";
                gp.obj[0][9].talkDialogue(gp, 12); 
                if (gp.gameState!=gp.DIALOGUE_STATE) eventRect[24][23].eventDone = true;
                //teleport back to main room
                if (gp.obj[0][9].dialogueIndex > 12 && gp.obj[0][9] != null) {
                    Timer timer = new Timer(1000, (java.awt.event.ActionEvent e) -> {
                        gp.obj[0][8].talkDialogue(gp, 10);
                        gp.player.worldX = 2*gp.TILE_SIZE; gp.player.worldY = 3*gp.TILE_SIZE;
                        gp.player.direction = "down";
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            //post teleport dialogue
            } else if (hit(0, 2, 3, "any") == true && gp.obj[0][8].dialogueIndex > 10) {
                gp.obj[0][8].talkDialogue(gp, 14); 
                if (gp.gameState!=gp.DIALOGUE_STATE) eventRect[3][17].eventDone = true;
                gp.obj[0][9] = null;
            //puzzle 2
            } else if (hit(0, 22, 23, "any") == true
                    || hit(0, 23, 23, "any") == true
                    || hit(0, 24, 23, "any") == true
                    && p1.solved == true) {
                gp.player.direction = "down";
                gp.obj[0][8].talkDialogue(gp, 16);
                if (gp.gameState != gp.DIALOGUE_STATE) {
                    gp.gameState = gp.HINT_STATE;
                    if (p2.solved == true) {
                            eventRect[22][23].eventDone = true;
                            eventRect[23][23].eventDone = true;
                            eventRect[24][23].eventDone = true;
                    } else p2.setVisible(true);
                }
            }
            
            else gp.gameState = gp.PLAY_STATE;
        }
    }
    
    public boolean hit(int mapNum, int col, int row, String reqDirection) {
        boolean isHit = false;
        gp.player.solidArea.x += gp.player.worldX;
        gp.player.solidArea.y += gp.player.worldY;
        
        eventRect[col][row].x += col * gp.TILE_SIZE;
        eventRect[col][row].y += row * gp.TILE_SIZE;
        
        if (gp.player.solidArea.intersects(eventRect[col][row]) && 
            gp.currentMap == mapNum &&
           (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) &&
            eventRect[col][row].eventDone == false) {
            isHit = true;
            prevEventX = gp.player.worldX;
            prevEventY = gp.player.worldY;
        }
        
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[col][row].x = eventRect[col][row].defaultX;
        eventRect[col][row].y = eventRect[col][row].defaultY;
        
        return isHit;
    }
    
}
