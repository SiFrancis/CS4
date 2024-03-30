/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import game.entity.Entity;
import game.entity.Player;

/**
 *
 * @author user
 */
public class CollisionHandler {

    GamePanel gp;
    
    public CollisionHandler(GamePanel gp) {
        this.gp = gp;
    }
    
    public void checkTile(Entity entity) {
        //whenever the entity moves, checks if the tile it will move into has collision
        int entityCol = entity.worldX/gp.TILE_SIZE;
        int entityRow = entity.worldY/gp.TILE_SIZE;
        int checkNum = 0;
        switch (entity.direction) {
            case "up"    -> checkNum = gp.tileM.mapData[gp.currentMap][entityCol][Math.max(0, entityRow-1)];
            case "down"  -> checkNum = gp.tileM.mapData[gp.currentMap][entityCol][Math.min(gp.WORLD_ROWS - 1, entityRow+1)];
            case "left"  -> checkNum = gp.tileM.mapData[gp.currentMap][Math.max(0, entityCol-1)][entityRow];
            case "right" -> checkNum = gp.tileM.mapData[gp.currentMap][Math.min(gp.WORLD_COLS - 1, entityCol+1)][entityRow];
        }
        entity.colliding = (gp.tileM.tileSet[checkNum].collision);
    }
    
    public int checkObject(Entity entity) {
        int index = 999;
        for (int i = 0; i < gp.obj.length; i++) {
            int entityCol = entity.worldX/gp.TILE_SIZE;
            int entityRow = entity.worldY/gp.TILE_SIZE;
            if (gp.obj[gp.currentMap][i] != null) {
                entity.solidArea.x += entity.worldX;
                entity.solidArea.y += entity.worldY;
                
                gp.obj[gp.currentMap][i].solidArea.x += gp.obj[gp.currentMap][i].worldX;
                gp.obj[gp.currentMap][i].solidArea.y += gp.obj[gp.currentMap][i].worldY;
                
                int objCol = gp.obj[gp.currentMap][i].worldX/gp.TILE_SIZE;
                int objRow = gp.obj[gp.currentMap][i].worldY/gp.TILE_SIZE;
                switch (entity.direction) {
                    case "up" -> {
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)) {
                            entity.colliding = gp.obj[gp.currentMap][i].collision;
                            if (entity instanceof Player && gp.keyH.upPress) {index = i;}
                        }
                    }
                    case "down" -> {
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)) {
                            entity.colliding = gp.obj[gp.currentMap][i].collision;  
                            if (entity instanceof Player && gp.keyH.downPress) {index = i;}
                        }
                    }
                    case "left" -> {
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)) {
                            entity.colliding = gp.obj[gp.currentMap][i].collision;  
                            if (entity instanceof Player && gp.keyH.leftPress) {index = i;}
                        }
                    }
                    case "right" -> {
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)) {
                            entity.colliding = gp.obj[gp.currentMap][i].collision;  
                            if (entity instanceof Player && gp.keyH.rightPress) {index = i;}
                        }
                    }
                }                
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].solidAreaDefaultX;
                gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].solidAreaDefaultY;
            }
        }
        return index;
    }
    
}
