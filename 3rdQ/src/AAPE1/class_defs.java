/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AAPE1;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author user
 */

class Pygomon {
    private String name;
    private int level = 1;
    private int base_hp;
    private int max_hp = base_hp + 5 * (level - 1);
    private int current_hp = max_hp;
    private int base_dmg;
    public HashMap<String, Integer> attackSet = new HashMap<>();
    
    public Pygomon(String name, int base_hp, int base_dmg) {
        this.name = name;
        this.base_hp = base_hp;
        this.base_dmg = base_dmg;
    }
    
    public void setName(String name){this.name = name;}
    public void setLevel(int level) {this.level = level;}
    public void setCurrentHP(int current_hp) {this.current_hp = current_hp;}
    public void addAttack(String atkName, int atkDmg){
        this.attackSet.put(atkName, atkDmg);
    }
    
    public String getName(){return this.name;}
    public int getLevel(){return this.level;}
    public int getCurrentHP(){return this.current_hp;}
    public HashMap getAttacks(){return this.attackSet;}
    public int getBaseDmg(){return this.base_dmg;}
}

public class class_defs {
    public static void main(String[] args) {
        Random rand = new Random();
        Pygomon current_pygomon; // used in switching between pygomon

        //DECLARING PYGOMON:
        Pygomon triwhale = new Pygomon("TRIWHALE", 15, 5);
        triwhale.addAttack("TRIPLE SPLASH", triwhale.getBaseDmg() + rand.nextInt(3) - 1); //dmg: 4-6
        triwhale.addAttack("PYTHAGO-WAVE", triwhale.getBaseDmg() + rand.nextInt(5) - 1); //dmg: 4-8
        
        Pygomon trat = new Pygomon("TRAT", 8, 3);
        trat.addAttack("TRI-TAIL CUT", trat.getBaseDmg()); // dmg: 3
        trat.addAttack("VICIOUS BITE", (trat.getBaseDmg() * 3) + rand.nextInt(7) - 5); //dmg: 4-10
        
        Pygomon obama = new Pygomon("OBAMA", 10, 5);
        obama.addAttack("MYSTERIOUS GAZE", obama.getBaseDmg() + rand.nextInt(3)); //dmg (default): 5-7
        obama.addAttack("PRISMIC BEAM", obama.getBaseDmg() + rand.nextInt(obama.getBaseDmg())); //dmg (default): 5-10
        obama.addAttack("RECONFIGURE", 0); //NOTE: this changes OBAMA's base damage to a random value from 2-7
        
        current_pygomon = triwhale;
    }
}