/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.entity;

import game.GamePanel;
import game.KeyHandler;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Acer
 */
public class Player extends Entity {
    //for key events (e.g. motion)
    KeyHandler keyH;
    
    boolean moving;
    
    //sprites for four directions
    public BufferedImage up_00, down_00, left_00, right_00;
    public BufferedImage up_01, down_01, left_01, right_01;
    public BufferedImage up_02, down_02, left_02, right_02;
    public BufferedImage up_03, down_03, left_03, right_03;
    
    //determines camera position
    public final int screenX;
    public final int screenY;
    
    public int progress = 0;
    
    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        
        this.keyH = keyH;
        
        //centers camera on screen
        screenX = (gp.SCREEN_W - gp.TILE_SIZE)/2;
        screenY = (gp.SCREEN_H - gp.TILE_SIZE)/2;
        
        setDefaults(2, 3, gp.TILE_SIZE, "down");
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        getImage();
    }
    
    
    
    public void getImage(){
        // reads the image sprite files
        try {
            up_00 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/up_00.png"));
            down_00 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/down_00.png"));
            left_00 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/left_00.png"));
            right_00 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/right_00.png"));
            
            up_01 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/up_01.png"));
            down_01 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/down_01.png"));
            left_01 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/left_01.png"));
            right_01 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/right_01.png"));
            
            up_02 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/up_02.png"));
            down_02 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/down_02.png"));
            left_02 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/left_02.png"));
            right_02 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/right_02.png"));
            
            up_03 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/up_03.png"));
            down_03 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/down_03.png"));
            left_03 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/left_03.png"));
            right_03 = ImageIO.read(getClass().getResourceAsStream("/assets/game/sprites/player/right_03.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void stopMoving () {
        switch (direction) {
            case "up" -> {keyH.upPress = false; moving = false;}
            case "down" -> {keyH.downPress = false; moving = false;}
            case "left" -> {keyH.leftPress = false; moving = false;}
            case "right" -> {keyH.rightPress = false; moving = false;}
        }
    }
    
    public void interactObject(int i) {
        if (i != 999) {
            String objName = gp.obj[gp.currentMap][i].name;
            switch (objName) {
                case "Start Bed" -> {
                    //exit dialog?
                }
                case "Stairs" -> {
                    switch (gp.obj[gp.currentMap][i].type) {
                        case 0 -> {
                            stopMoving();
                            if (this.worldX == 24*gp.TILE_SIZE && this.worldY == 5*gp.TILE_SIZE && direction.equals("left")) {
                                this.worldX = 3*gp.TILE_SIZE; this.worldY = 17*gp.TILE_SIZE;
                            }
                        }
                        case 1 -> {
                            stopMoving();
                            if (this.worldX == 3*gp.TILE_SIZE && this.worldY == 17*gp.TILE_SIZE && direction.equals("right")) {
                                this.worldX = 24*gp.TILE_SIZE; this.worldY = 5*gp.TILE_SIZE;
                            }
                        }
                    }
                }
                case "Door" -> {    
                    switch (gp.obj[gp.currentMap][i].type) {
                        case 0 -> {
                            stopMoving();
                            //first room to downstairs
                            if (this.worldX == 6*gp.TILE_SIZE && this.worldY == 2*gp.TILE_SIZE) {
                                this.worldX = 26*gp.TILE_SIZE; this.worldY = 5*gp.TILE_SIZE;
                            } else if (this.worldX == 26*gp.TILE_SIZE && this.worldY == 3*gp.TILE_SIZE) {
                                this.worldX = 27*gp.TILE_SIZE; this.worldY = 24*gp.TILE_SIZE;
                            } 
                        }
                        case 1 -> {
                            stopMoving();
                            if (this.worldX == 26*gp.TILE_SIZE && this.worldY == 5*gp.TILE_SIZE) {
                                this.worldX = 6*gp.TILE_SIZE; this.worldY = 2*gp.TILE_SIZE;
                            } else if (this.worldX == 27*gp.TILE_SIZE && this.worldY == 24*gp.TILE_SIZE) {
                                this.worldX = 26*gp.TILE_SIZE; this.worldY = 3*gp.TILE_SIZE;
                            } 
                        }
                    }
                    
                }
            }
        }
    }
    
    public void update(){
        //handles player movement
        
        //collision status
        colliding = false;
        //movement status
        moving = false;
        
        //pressing WASD keys immediately changes the direction of the player
        if (keyH.upPress) {
            direction = "up";
            moving = true;
        }
        if (keyH.downPress) {
            direction = "down";
            moving = true;
        }
        if (keyH.leftPress) {
            direction = "left";
            moving = true;
        }
        if (keyH.rightPress) {
            direction = "right";
            moving = true;
        }
        //checks for collision before moving, using the direction indicated by above if ladder
        gp.collH.checkTile(this);
        
        //event handling
        gp.eventH.checkEvent();
        
        //object collision handling
        int objIndex = gp.collH.checkObject(this);
        interactObject(objIndex);
        
        //will only move player if there is no collision and WASD keys are being pressed
        if (colliding == false && moving == true) {
            switch (direction) {
                //setting key press and movement status to false makes player move only one grid space at a time
                case "up" -> {worldY -= speed; keyH.upPress = false; moving = false;}
                case "down" -> {worldY += speed; keyH.downPress = false; moving = false;}
                case "left" -> {worldX -= speed; keyH.leftPress = false; moving = false;}
                case "right" -> {worldX += speed; keyH.rightPress = false; moving = false;}
            }
        }

        //prevents player from going out of bounds
        if (worldX > gp.WORLD_W - gp.TILE_SIZE) {worldX = gp.WORLD_W - gp.TILE_SIZE;}
        if (worldY > gp.WORLD_H - gp.TILE_SIZE) {worldY = gp.WORLD_H - gp.TILE_SIZE;}
        if (worldX < 0) {worldX = 0;}
        if (worldY < 0) {worldY = 0;}
        

        if (keyH.movePress) {
            spriteCounter++;
            if (spriteCounter > 10) {
                spriteNum = (spriteNum % 4) + 1;
                spriteCounter = 0;
            }
        } else spriteCounter = 0;
    }
    
    public void draw(Graphics2D g2){
        //changes sprite based on direction
        BufferedImage img = null;
        switch (direction) {
            case "up" -> {
                if (keyH.movePress) {
                    switch (spriteNum) {
                        case 1 -> img = up_01;
                        case 2 -> img = up_02;
                        case 3 -> img = up_03;
                        case 4 -> img = up_00;
                    }
                } else img = up_00;
            }
            case "down" -> {
                if (keyH.movePress) {
                    switch (spriteNum) {
                        case 1 -> img = down_01;
                        case 2 -> img = down_02;
                        case 3 -> img = down_03;
                        case 4 -> img = down_00;
                    }
                } else img = down_00;
            }
            case "left" -> {
                if (keyH.movePress) {
                    switch (spriteNum) {
                        case 1 -> img = left_01;
                        case 2 -> img = left_02;
                        case 3 -> img = left_03;
                        case 4 -> img = left_00;
                    }
                } else img = left_00;
            }
            case "right" -> {
                if (keyH.movePress) {
                    switch (spriteNum) {
                        case 1 -> img = right_01;
                        case 2 -> img = right_02;
                        case 3 -> img = right_03;
                        case 4 -> img = right_00;
                    }
                } else img = right_00;
            }
        }
        
        //draws player character
        g2.drawImage(img, screenX, screenY, gp.TILE_SIZE, gp.TILE_SIZE, null);
    }
}
