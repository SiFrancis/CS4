/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objects;

import game.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author user
 */
public class TileManager {
    GamePanel gp;
    public Tile[] tileset;
    public int mapData[][];
    
    public TileManager(GamePanel gp, String map) {
        this.gp = gp;
        tileset = new Tile[2]; //2 total tiles in tile set
        mapData = new int[gp.WORLD_COLS][gp.WORLD_ROWS];
        getTileImage();
        loadMap(map);
    }
    
    public void getTileImage() {
        tileset[0] = new Tile("00_grass.png", false);
        tileset[1] = new Tile("01_wall.png", true);
    }
    
    public void loadMap(String map) {
        try {
            // NOTE: map00 is for testing purposes only
            InputStream inp = getClass().getResourceAsStream("/game/res/maps/"+map);
            BufferedReader br = new BufferedReader(new InputStreamReader(inp));
            int col = 0, row = 0;
            while (col < gp.WORLD_COLS && row < gp.WORLD_ROWS) {
                String line = br.readLine();
                while (col < gp.WORLD_COLS) {
                    String nums[] = line.split(" ");
                    int num = Integer.parseInt(nums[col]);
                    mapData[col][row] = num;
                    col++;
                }
                if (col == gp.WORLD_COLS) {col = 0; row++;}
            }
            br.close();
        } catch (Exception e) {
        }
    }
    
    public void draw(Graphics2D g2) {
        int col = 0, row = 0;
        while (col < gp.WORLD_COLS && row < gp.WORLD_ROWS) {
            int tileData = mapData[col][row];
            
            int mapX = col * gp.FINAL_SIZE;
            int mapY = row * gp.FINAL_SIZE;
            int camX = mapX - gp.player.worldX + gp.player.screenX;
            int camY = mapY - gp.player.worldY + gp.player.screenY;
            
            if (mapX + gp.FINAL_SIZE > gp.player.worldX - gp.player.screenX &&
                mapX - gp.FINAL_SIZE < gp.player.worldX + gp.player.screenX &&
                mapY + gp.FINAL_SIZE > gp.player.worldY - gp.player.screenY &&
                mapY - gp.FINAL_SIZE < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(
                    tileset[tileData].image, camX, camY, 
                    gp.FINAL_SIZE, gp.FINAL_SIZE, null
                );
            }
            
            col++;
            
            if (col == gp.WORLD_COLS) {
                col = 0;
                row++;
            }
        }
    }
}
