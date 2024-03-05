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
    public String getAttackName(int atk_num) {return (String)this.attackSet.keySet().toArray()[atk_num];}
    public int getAttackDmg(String atk_name){return attackSet.get(atk_name);}
}

public class class_defs {
    Random rand = new Random();
    
//  PLAYER PYGOMON MOVES
    Map<String, Integer> triwhale_atks = Map.of(
        "TRIPLE SPLASH", (5 + rand.nextInt(3) - 1), //dmg: 4-6
        "PYTHAGO-WAVE", (7 + rand.nextInt(5) - 1) //dmg: 4-8
    );
    Map<String, Integer> trat_atks = Map.of(
        "TRI-TAIL CUT", 3, //dmg: 3
        "VICIOUS BITE", (9 + rand.nextInt(6) - 6) //dmg: 3-8
    );
    Map<String, Integer> obama_atks = Map.of(
        "MYSTERIOUS GAZE", (5 + rand.nextInt(3) - 1), //dmg: 4-6
        "PRISMIC BEAM", (5 + rand.nextInt(6)) //dmg: 5-10
    );
//  PLAYER PYGOMON              
    Pygomon triwhale = new Pygomon("TRIWHALE", 15, triwhale_atks);
    Pygomon trat = new Pygomon("TRAT", 8, trat_atks);
    Pygomon obama = new Pygomon("OBAMA", 10, obama_atks);
    
//  ENEMY PYGOMON
    Pygomon enemy =new Pygomon("LITERAL TEST DUMMY", 25, Map.of("STAND THERE", 0));
}
