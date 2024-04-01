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
        tileSet = new Tile[100];
        mapData = new int[gp.MAX_MAPS][gp.WORLD_COLS][gp.WORLD_ROWS];
        getTileImage();
        loadMap("room1.txt", 0);
        loadMap("automation.txt", 1);
    }
    
    public void getTileImage() {
        //reads tile images from file
        
        //placeholders
        tileSet[0] = new Tile("00_void.png", false);
        tileSet[1] = new Tile("01_grass.png", false);
        tileSet[2] = new Tile("02_wall.png", true);
        tileSet[3] = new Tile("03_stairs.png", false);
        
        //final tile designs
        tileSet[10] = new Tile("render/00.png", false);
        tileSet[11] = new Tile("render/11.png", true);
        tileSet[12] = new Tile("render/12.png", true);
        tileSet[13] = new Tile("render/13.png", false);
        tileSet[14] = new Tile("render/14.png", true);
        tileSet[15] = new Tile("render/15.png", false);
        tileSet[16] = new Tile("render/16.png", false);
        tileSet[17] = new Tile("render/17.png", false);
        tileSet[18] = new Tile("render/18.png", false);
        tileSet[19] = new Tile("render/19.png", false);
        tileSet[20] = new Tile("render/20.png", false);
        tileSet[21] = new Tile("render/21.png", false);
        tileSet[22] = new Tile("render/22.png", false);
        tileSet[23] = new Tile("render/23.png", false);
        tileSet[24] = new Tile("render/24.png", false);
        tileSet[25] = new Tile("render/25.png", false);
        tileSet[26] = new Tile("render/26.png", false);
        tileSet[27] = new Tile("render/27.png", false);
        tileSet[28] = new Tile("render/28.png", false);
        tileSet[29] = new Tile("render/29.png", false);
        tileSet[30] = new Tile("render/30.png", false);
        tileSet[31] = new Tile("render/31.png", false);
        tileSet[32] = new Tile("render/32.png", false);
        tileSet[33] = new Tile("render/33.png", false);
        tileSet[34] = new Tile("render/34.png", false);
        tileSet[35] = new Tile("render/35.png", false);
        tileSet[36] = new Tile("render/36.png", false);
        tileSet[37] = new Tile("render/37.png", false);
        tileSet[38] = new Tile("render/38.png", false);
        tileSet[39] = new Tile("render/39.png", false);
        tileSet[40] = new Tile("render/40.png", false);
        tileSet[44] = new Tile("render/44.png", false);
        tileSet[45] = new Tile("render/45.png", false);
        tileSet[46] = new Tile("render/46.png", false);
        tileSet[47] = new Tile("render/47.png", false);
        tileSet[48] = new Tile("render/48.png", false);
        tileSet[49] = new Tile("render/49.png", false);
        tileSet[50] = new Tile("render/50.png", false);
        tileSet[51] = new Tile("render/51.png", false);
        tileSet[52] = new Tile("render/52.png", false);
        tileSet[53] = new Tile("render/53.png", false);
        tileSet[54] = new Tile("render/54.png", false);
        tileSet[55] = new Tile("render/55.png", false);
        tileSet[56] = new Tile("render/56.png", false);
        tileSet[57] = new Tile("render/57.png", false);
        tileSet[58] = new Tile("render/58.png", false);
        tileSet[59] = new Tile("render/59.png", false);
        tileSet[60] = new Tile("render/60.png", true);
        tileSet[61] = new Tile("render/61.png", true);
        tileSet[62] = new Tile("render/62.png", true);
        tileSet[63] = new Tile("render/63.png", true);
        tileSet[64] = new Tile("render/64.png", true);
        tileSet[65] = new Tile("render/65.png", true);
        tileSet[66] = new Tile("render/66.png", false);
        tileSet[67] = new Tile("render/67.png", false);
    }
    
    public void loadMap(String maptext, int mapnum) {
        //reads the map text file and loads it into mapData[][]
        try {
            InputStream inp = getClass().getResourceAsStream("/assets/game/maps/"+maptext);
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
