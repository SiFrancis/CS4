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
        tileSet = new Tile[200];
        mapData = new int[gp.MAX_MAPS][gp.WORLD_COLS][gp.WORLD_ROWS];
        getTileImage();
        loadMap("room1.txt", 0);
        loadMap("automation.txt", 1);
    }
    
    public void getTileImage() {
        //reads tile images from file
        
        //final tile designs
        tileSet[0] = new Tile("render/000.png", false);
        tileSet[1] = new Tile("render/001.png", true);
        tileSet[2] = new Tile("render/002.png", true);
        tileSet[3] = new Tile("render/003.png", true);
        tileSet[4] = new Tile("render/004.png", true);
        tileSet[5] = new Tile("render/005.png", true);
        tileSet[6] = new Tile("render/006.png", false);
        tileSet[7] = new Tile("render/007.png", false);
        tileSet[8] = new Tile("render/008.png", false);
        tileSet[9] = new Tile("render/009.png", false);
        tileSet[10] = new Tile("render/010.png", false);
        tileSet[11] = new Tile("render/011.png", false);
        tileSet[12] = new Tile("render/012.png", false);
        tileSet[13] = new Tile("render/013.png", false);
        tileSet[14] = new Tile("render/014.png", false);
        tileSet[15] = new Tile("render/015.png", false);
        tileSet[16] = new Tile("render/016.png", false);
        tileSet[17] = new Tile("render/017.png", false);
        tileSet[18] = new Tile("render/018.png", false);
        tileSet[19] = new Tile("render/019.png", false);
        tileSet[20] = new Tile("render/020.png", false);
        tileSet[21] = new Tile("render/021.png", false);
        tileSet[22] = new Tile("render/022.png", false);
        tileSet[23] = new Tile("render/023.png", false);
        tileSet[24] = new Tile("render/024.png", false);
        tileSet[25] = new Tile("render/025.png", false);
        tileSet[26] = new Tile("render/026.png", false);
        tileSet[27] = new Tile("render/027.png", false);
        tileSet[28] = new Tile("render/028.png", false);
        tileSet[29] = new Tile("render/029.png", false);
        tileSet[30] = new Tile("render/030.png", false);
        tileSet[34] = new Tile("render/034.png", false);
        tileSet[35] = new Tile("render/035.png", false);
        tileSet[36] = new Tile("render/036.png", false);
        tileSet[37] = new Tile("render/037.png", false);
        tileSet[38] = new Tile("render/038.png", false);
        tileSet[39] = new Tile("render/039.png", false);
        tileSet[40] = new Tile("render/040.png", false);
        tileSet[41] = new Tile("render/041.png", false);
        tileSet[42] = new Tile("render/042.png", false);
        tileSet[43] = new Tile("render/043.png", false);
        tileSet[44] = new Tile("render/044.png", false);
        tileSet[45] = new Tile("render/045.png", false);
        tileSet[46] = new Tile("render/046.png", false);
        tileSet[47] = new Tile("render/047.png", false);
        tileSet[48] = new Tile("render/048.png", false);
        tileSet[49] = new Tile("render/049.png", false);
        tileSet[50] = new Tile("render/050.png", true);
        tileSet[51] = new Tile("render/051.png", true);
        tileSet[52] = new Tile("render/052.png", true);
        tileSet[53] = new Tile("render/053.png", true);
        tileSet[54] = new Tile("render/054.png", true);
        tileSet[55] = new Tile("render/055.png", true);
        tileSet[56] = new Tile("render/056.png", false);
        tileSet[57] = new Tile("render/057.png", false);
        tileSet[58] = new Tile("render/058.png", false);
        tileSet[59] = new Tile("render/059.png", true);
        tileSet[60] = new Tile("render/060.png", true);
        tileSet[61] = new Tile("render/061.png", true);
        tileSet[62] = new Tile("render/062.png", true);
        tileSet[63] = new Tile("render/063.png", true);
        tileSet[64] = new Tile("render/064.png", true);
        tileSet[65] = new Tile("render/065.png", true);
        tileSet[66] = new Tile("render/066.png", true);
        tileSet[67] = new Tile("render/067.png", true);
        tileSet[68] = new Tile("render/068.png", false);
        tileSet[69] = new Tile("render/069.png", false);
        tileSet[70] = new Tile("render/070.png", false);
        tileSet[71] = new Tile("render/071.png", true);
        tileSet[72] = new Tile("render/072.png", true);
        tileSet[73] = new Tile("render/073.png", true);
        tileSet[74] = new Tile("render/074.png", false);
        tileSet[75] = new Tile("render/075.png", false);
        tileSet[76] = new Tile("render/076.png", false);
        tileSet[77] = new Tile("render/077.png", true);
        tileSet[78] = new Tile("render/078.png", true);
        tileSet[79] = new Tile("render/079.png", false);
        tileSet[80] = new Tile("render/080.png", false);
        tileSet[81] = new Tile("render/081.png", false);
        tileSet[82] = new Tile("render/082.png", false);
        tileSet[83] = new Tile("render/083.png", false);
        tileSet[84] = new Tile("render/084.png", false);
        tileSet[85] = new Tile("render/085.png", true);
        tileSet[86] = new Tile("render/086.png", true);
        tileSet[87] = new Tile("render/087.png", true);
        tileSet[88] = new Tile("render/088.png", false);
        tileSet[89] = new Tile("render/089.png", false);
        tileSet[90] = new Tile("render/090.png", true);
        tileSet[91] = new Tile("render/091.png", true);
        tileSet[92] = new Tile("render/092.png", true);
        tileSet[93] = new Tile("render/093.png", true);
        tileSet[94] = new Tile("render/094.png", false);
        tileSet[95] = new Tile("render/095.png", false);
        tileSet[96] = new Tile("render/096.png", false);
        tileSet[97] = new Tile("render/097.png", false);
        tileSet[98] = new Tile("render/098.png", false);
        tileSet[99] = new Tile("render/099.png", false);
        tileSet[100] = new Tile("render/100.png", false);
        tileSet[101] = new Tile("render/101.png", false);
        tileSet[102] = new Tile("render/102.png", false);
        tileSet[103] = new Tile("render/103.png", false);
        tileSet[104] = new Tile("render/104.png", false);
        tileSet[105] = new Tile("render/105.png", false);
        tileSet[106] = new Tile("render/106.png", false);
        tileSet[107] = new Tile("render/107.png", false);
        tileSet[108] = new Tile("render/108.png", false);
        tileSet[109] = new Tile("render/109.png", false);
        tileSet[110] = new Tile("render/110.png", false);
        tileSet[111] = new Tile("render/111.png", false);
        tileSet[112] = new Tile("render/112.png", false);
        tileSet[113] = new Tile("render/113.png", false);
        tileSet[114] = new Tile("render/114.png", false);
        tileSet[115] = new Tile("render/115.png", false);
        tileSet[116] = new Tile("render/116.png", false);
        tileSet[117] = new Tile("render/117.png", false);
        tileSet[118] = new Tile("render/118.png", false);
        tileSet[119] = new Tile("render/119.png", false);
        tileSet[120] = new Tile("render/120.png", false);
        tileSet[121] = new Tile("render/121.png", false);
        tileSet[122] = new Tile("render/122.png", false);
        tileSet[123] = new Tile("render/123.png", false);
        tileSet[124] = new Tile("render/124.png", false);
        tileSet[125] = new Tile("render/125.png", false);
        tileSet[126] = new Tile("render/126.png", false);
        tileSet[127] = new Tile("render/127.png", false);
        tileSet[128] = new Tile("render/128.png", false);
        tileSet[129] = new Tile("render/129.png", false);
        tileSet[130] = new Tile("render/130.png", false);
        tileSet[131] = new Tile("render/131.png", false);
        tileSet[132] = new Tile("render/132.png", false);
        tileSet[133] = new Tile("render/133.png", false);
        tileSet[134] = new Tile("render/134.png", false);
        tileSet[135] = new Tile("render/135.png", false);
        tileSet[136] = new Tile("render/136.png", false);
        tileSet[137] = new Tile("render/137.png", false);
        tileSet[138] = new Tile("render/138.png", false);
        tileSet[139] = new Tile("render/139.png", false);
        tileSet[140] = new Tile("render/140.png", false);
        tileSet[141] = new Tile("render/141.png", false);
        tileSet[142] = new Tile("render/142.png", false);
        tileSet[143] = new Tile("render/143.png", false);
        tileSet[144] = new Tile("render/144.png", false);
        tileSet[145] = new Tile("render/145.png", false);
        tileSet[146] = new Tile("render/146.png", false);
        tileSet[147] = new Tile("render/147.png", false);
        tileSet[148] = new Tile("render/148.png", false);
        tileSet[149] = new Tile("render/149.png", false);
        tileSet[150] = new Tile("render/150.png", false);
        tileSet[151] = new Tile("render/151.png", false);
        tileSet[152] = new Tile("render/152.png", false);
        tileSet[153] = new Tile("render/153.png", false);
        tileSet[154] = new Tile("render/154.png", false);
        tileSet[155] = new Tile("render/155.png", false);
        tileSet[156] = new Tile("render/156.png", false);
        tileSet[157] = new Tile("render/157.png", false);
        tileSet[158] = new Tile("render/158.png", false);
        tileSet[159] = new Tile("render/159.png", false);
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
