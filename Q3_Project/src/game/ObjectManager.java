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
        //MAP 0 (ROOM)
        gp.obj[0][0] = new StartBedObject();
        gp.obj[0][0].placeAndSize(gp, 1, 2, 2, 1);
        
        gp.obj[0][1] = new StartDeskObject();
        gp.obj[0][1].placeAndSize(gp, 1, 8, 2, 1);
        
        gp.obj[0][2] = new DoorObject(0);
        gp.obj[0][2].placeAndSize(gp, 6, 1, 1, 1);
        
        gp.obj[0][3] = new DoorObject(1);
        gp.obj[0][3].placeAndSize(gp, 26, 6, 1, 1);
        
        gp.obj[0][3] = new DadObject();
        gp.obj[0][3].placeAndSize(gp, 5, 6, 1, 1);
        
        //====================================================================//
        
        //MAP 1 (AUTOMATIONS)
        gp.obj[1][0] = new AutomationIconObject(0);
        gp.obj[1][0].placeAndSize(gp, 6, 11, 1, 1);
        
        gp.obj[1][1] = new AutomationIconObject(1);
        gp.obj[1][1].placeAndSize(gp, 1, 6, 1, 1);
        
        gp.obj[1][2] = new AutomationIconObject(2);
        gp.obj[1][2].placeAndSize(gp, 6, 1, 1, 1);
        
        gp.obj[1][3] = new AutomationIconObject(3);
        gp.obj[1][3].placeAndSize(gp, 11, 6, 1, 1);
    }
}
