/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AAPE1;

import java.util.HashMap;

/**
 *
 * @author user
 */

abstract class Pygomon {
//  todo: add smth for the photo, maybe link it to name
    private String name;
    private int level = 1;
    private int max_hp = 15 + 5 * (level - 1);
    private int dmg = 4;
    public HashMap<String, Integer> attackSet = new HashMap<>();
    
    public void setName(String name){this.name = name;}
    public void setLevel(int level) {this.level = level;}
    public void addAttack(String atkName, int atkDmg){
        attackSet.put(atkName, atkDmg);
    }
    
    public String getName(){return this.name;}
    public int getLevel(){return this.level;}
    public HashMap getAttacks(){return this.attackSet;}
}