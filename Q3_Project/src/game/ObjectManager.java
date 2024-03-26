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
        gp.obj[0] = new StartBedObject();
        gp.obj[0].placeAndSize(gp.FINAL_SIZE, gp.FINAL_SIZE, 
                gp.FINAL_SIZE*2, gp.FINAL_SIZE);
        
        gp.obj[1] = new StartDeskObject();
        gp.obj[1].placeAndSize(gp.FINAL_SIZE, 6*gp.FINAL_SIZE, 
                gp.FINAL_SIZE, 2*gp.FINAL_SIZE);
    }
}
