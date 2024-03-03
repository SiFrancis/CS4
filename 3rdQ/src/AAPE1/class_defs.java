/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AAPE1;

import java.util.*;
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
    private Map<String, Integer> attackSet = new HashMap<>();
    
    public Pygomon(String name, int base_hp, Map<String, Integer> atks) {
        this.name = name;
        this.base_hp = base_hp;
        this.max_hp = base_hp + 5 * (level - 1);
        this.current_hp = max_hp;
        this.attackSet = atks;
    }
    
    public void setName(String name){this.name = name;}
    public void setLevel(int level) {this.level = level;}
    public void setCurrentHP(int current_hp) {this.current_hp = current_hp;}
    
    public String getName(){return this.name;}
    public String getImageLink(){return "/Images/" + this.name + ".png";}
    public int getLevel(){return this.level;}
    public int getCurrentHP(){return this.current_hp;}
    public int getMaxHP(){return this.max_hp;}
    public Map getAttackSet(){return this.attackSet;}
    public int getAttackDmg(String atk_name){return attackSet.get(atk_name);}
}

public class class_defs {
    Random rand = new Random();
    
    Map<String, Integer> triwhale_atks = Map.of(
        "TRIPLE SPLASH", (5 + rand.nextInt(3) - 1), //dmg: 4-6
        "PYTHAGO-WAVE", (7 + rand.nextInt(5) - 1) //dmg: 4-8
    );
    Pygomon triwhale = new Pygomon("TRIWHALE", 15, triwhale_atks);
    
    Map<String, Integer> trat_atks = Map.of(
        "TRI-TAIL CUT", 3, //dmg: 3
        "VICIOUS BITE", (9 + rand.nextInt(6) - 6) //dmg: 3-8
    );
    Pygomon trat = new Pygomon("TRAT", 8, trat_atks);
    
    int obama_dmg = 5;
    Map<String, Integer> obama_atks = Map.of(
        "MYSTERIOUS GAZE", (obama_dmg + rand.nextInt(3) - 1), //dmg (default): 4-6
        "PRISMIC BEAM", (obama_dmg + rand.nextInt(obama_dmg)), //dmg (default): 5-10
        "RECONFIGURE", 0 //no damage; changes base damage to a random value from 2-7
    );
    Pygomon obama = new Pygomon("OBAMA", 10, obama_atks);
    
    Pygomon current_pygomon = triwhale; // used for switching Pygomon
}
