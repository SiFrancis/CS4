/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.Rectangle;

/**
 *
 * @author user
 */
public class EventRect extends Rectangle {
    int defaultX, defaultY;
    boolean eventDone = false;
    
    public EventRect(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }
}
