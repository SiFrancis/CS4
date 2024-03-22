/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.entity;

/**
 *
 * @author Acer
 */
public class Entity {
    /**
     * used for players and NPCs
     * might remove this if final game has no NPCs
     */
    
    //world coordinates
    public int worldX, worldY, speed;
    
    //direction of motion
    public String direction;
    
    //collision status
    public boolean colliding = false;
}
