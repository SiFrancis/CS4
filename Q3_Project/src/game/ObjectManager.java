/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import game.objects.*;

/**
 *
 * @author Acer
 */
public class ObjectManager {
    GamePanel gp;
    
    public ObjectManager(GamePanel gp) {
        this.gp = gp;
    }
    
    public void placeObjects() {
        gp.obj[0] = new BedObject();
        gp.obj[0].mapX = gp.FINAL_SIZE;
        gp.obj[0].mapY = gp.FINAL_SIZE;
        
//        gp.obj[1] = new BedObject();
//        gp.obj[1].setPosition(5*gp.FINAL_SIZE, 3*gp.FINAL_SIZE);
    }
}
