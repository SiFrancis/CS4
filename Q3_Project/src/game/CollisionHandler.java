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
        int entityCol = entity.x/gp.FINAL_SIZE;
        int entityRow = entity.y/gp.FINAL_SIZE;
        int checkNum = 0;
        switch (entity.direction) {
            case "up"    -> checkNum = gp.tileM.mapData[entityCol][entityRow-1];
            case "down"  -> checkNum = gp.tileM.mapData[entityCol][entityRow+1];
            case "left"  -> checkNum = gp.tileM.mapData[entityCol-1][entityRow];
            case "right" -> checkNum = gp.tileM.mapData[entityCol+1][entityRow];
        }
        entity.colliding = (gp.tileM.tileset[checkNum].collision == true);
    }
    
}
