/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

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
    
    //set of tile images
    public Tile[] tileSet;
    
    //2D array representing the map
    //how it works:
    /**
     * mapData[3][4] = 1 means that at x = 4 and y = 5, tileSet[1] will display
     */
    public int mapData[][];
    
    public TileManager(GamePanel gp, String map) {
        this.gp = gp;
        tileSet = new Tile[3]; //2 total tiles in tile set
        mapData = new int[gp.WORLD_COLS][gp.WORLD_ROWS];
        getTileImage();
        loadMap(map);
    }
    
    public void getTileImage() {
        //reads tile images from file
        tileSet[0] = new Tile("00_void.png", false);
        tileSet[1] = new Tile("01_grass.png", false);
        tileSet[2] = new Tile("02_wall.png", true);
    }
    
    public void loadMap(String map) {
        //reads the map text file and loads it into mapData[][]
        try {
            // NOTE: map00 and bigmap00 are for testing purposes only
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
        } catch (IOException e) {
        }
    }
    
    public void draw(Graphics2D g2) {
        //uses mapData to draw the tiles
        int col = 0, row = 0;
        while (col < gp.WORLD_COLS && row < gp.WORLD_ROWS) {
            int tileData = mapData[col][row];
            
            int mapX = col * gp.FINAL_SIZE;
            int mapY = row * gp.FINAL_SIZE;
            int camX = mapX - gp.player.worldX + gp.player.screenX;
            int camY = mapY - gp.player.worldY + gp.player.screenY;
            
            //TileManager only renders visible portion of the map for better performance
            if (mapX + gp.FINAL_SIZE > gp.player.worldX - gp.player.screenX &&
                mapX - gp.FINAL_SIZE < gp.player.worldX + gp.player.screenX &&
                mapY + gp.FINAL_SIZE > gp.player.worldY - gp.player.screenY &&
                mapY - gp.FINAL_SIZE < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tileSet[tileData].image, camX, camY, 
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
