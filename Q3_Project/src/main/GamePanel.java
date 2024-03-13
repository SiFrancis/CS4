/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Acer
 */
public class GamePanel extends JPanel {
    //tile settings
    final int BASE_SIZE = 32; //32x32 tiles
    final float TILE_SCALE = 1.5f;
    final int FINAL_TILE_SIZE = (int) (BASE_SIZE * TILE_SCALE);
    
    //screen display settings
    final int SCREEN_COLS = 16;
    final int SCREEN_ROWS = 12;
    final int SCREEN_W = FINAL_TILE_SIZE * SCREEN_COLS; //768px wide
    final int SCREEN_H = FINAL_TILE_SIZE * SCREEN_ROWS; //576 px tall
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_W, SCREEN_H));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
}
