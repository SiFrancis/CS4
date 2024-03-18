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
    
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tileset = new Tile[2]; //2 total tiles in tile set
        mapData = new int[gp.SCREEN_COLS][gp.SCREEN_ROWS];
        getTileImage();
        loadMap("map00.txt");
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
            while (col < gp.SCREEN_COLS && row < gp.SCREEN_ROWS) {
                String line = br.readLine();
                while (col < gp.SCREEN_COLS) {
                    String nums[] = line.split(" ");
                    int num = Integer.parseInt(nums[col]);
                    mapData[col][row] = num;
                    col++;
                }
                if (col == gp.SCREEN_COLS) {col = 0; row++;}
            }
            br.close();
        } catch (Exception e) {
        }
    }
    
    public void draw(Graphics2D g2) {
        int col = 0, row = 0, tileX = 0, tileY = 0;
        while (col < gp.SCREEN_COLS && row < gp.SCREEN_ROWS) {
            int tileData = mapData[col][row];
            
            g2.drawImage(
                    tileset[tileData].image, tileX, tileY, 
                    gp.FINAL_SIZE, gp.FINAL_SIZE, null
            );
            col++;
            tileX += gp.FINAL_SIZE;
            
            if (col == gp.SCREEN_COLS) {
                col = 0; tileX = 0;
                row++;
                tileY += gp.FINAL_SIZE;
            }
        }
    }
}
