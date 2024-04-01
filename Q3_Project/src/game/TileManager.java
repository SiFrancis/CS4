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
    public int mapData[][][];
    
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tileSet = new Tile[4]; //2 total tiles in tile set
        mapData = new int[gp.MAX_MAPS][gp.WORLD_COLS][gp.WORLD_ROWS];
        getTileImage();
        loadMap("house.txt", 0);
        loadMap("automation.txt", 1);
    }
    
    public void getTileImage() {
        //reads tile images from file
        tileSet[0] = new Tile("00_void.png", false);
        tileSet[1] = new Tile("01_grass.png", false);
        tileSet[2] = new Tile("02_wall.png", true);
        tileSet[3] = new Tile("03_stairs.png", false);
    }
    
    public void loadMap(String maptext, int mapnum) {
        //reads the map text file and loads it into mapData[][]
        try {
            // NOTE: map00 and bigmap00 are for testing purposes only
            InputStream inp = getClass().getResourceAsStream("/game/res/maps/"+maptext);
            BufferedReader br = new BufferedReader(new InputStreamReader(inp));
            int col = 0, row = 0;
            while (col < gp.WORLD_COLS && row < gp.WORLD_ROWS) {
                String line = br.readLine();
                while (col < gp.WORLD_COLS) {
                    String nums[] = line.split(" ");
                    int num = Integer.parseInt(nums[col]);
                    mapData[mapnum][col][row] = num;
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
            int tileData = mapData[gp.currentMap][col][row];
            
            int worldX = col * gp.TILE_SIZE;
            int worldY = row * gp.TILE_SIZE;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            //TileManager only renders visible portion of the map for better performance
            if (worldX + gp.TILE_SIZE > gp.player.worldX - gp.player.screenX &&
                worldX - gp.TILE_SIZE < gp.player.worldX + gp.player.screenX &&
                worldY + gp.TILE_SIZE > gp.player.worldY - gp.player.screenY &&
                worldY - gp.TILE_SIZE < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tileSet[tileData].image, screenX, screenY, 
                    gp.TILE_SIZE, gp.TILE_SIZE, null
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
