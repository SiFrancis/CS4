/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.objects;

/**
 *
 * @author user
 */
public class DoorObject extends SuperObject {
    //0 = door, 1 = carpet
    public DoorObject(int type) {
        this.type = type;
        collision = true;
        name = "Door";
    }
}
