/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import game.objects.Entity;

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
        int entityCol = entity.worldX/gp.FINAL_SIZE;
        int entityRow = entity.worldY/gp.FINAL_SIZE;
        int checkNum = 0;
        switch (entity.direction) {
            case "up"    -> checkNum = gp.tileM.mapData[entityCol][Math.max(0, entityRow-1)];
            case "down"  -> checkNum = gp.tileM.mapData[entityCol][Math.min(gp.WORLD_ROWS - 1, entityRow+1)];
            case "left"  -> checkNum = gp.tileM.mapData[Math.max(0, entityCol-1)][entityRow];
            case "right" -> checkNum = gp.tileM.mapData[Math.min(gp.WORLD_COLS - 1, entityCol+1)][entityRow];
        }
        entity.colliding = (gp.tileM.tileSet[checkNum].collision == true);
    }
    
}
