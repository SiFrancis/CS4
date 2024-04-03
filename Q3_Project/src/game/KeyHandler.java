/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Acer
 */
public class KeyHandler implements KeyListener {
    
    GamePanel gp;
    
    //act as 'signals' to tell other classes that the WASD keys are pressed
    public boolean upPress, downPress, leftPress, rightPress;
    
    //trigger for object interaction in some objects (e.g. puzzles)
    public boolean interactPress;
    
    //sprite animation trigger
    public boolean movePress;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    //starts motion upon pressing keys

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        switch (code) {
            case KeyEvent.VK_W -> {upPress = true; movePress = true;}
            case KeyEvent.VK_S -> {downPress = true; movePress = true;}
            case KeyEvent.VK_A -> {leftPress = true; movePress = true;}
            case KeyEvent.VK_D -> {rightPress = true; movePress = true;}
            case KeyEvent.VK_ESCAPE -> {
                interactPress = false;
                if (gp.gameState == gp.PLAY_STATE) gp.gameState = gp.PAUSE_STATE;
                else if (gp.gameState == gp.PAUSE_STATE || gp.gameState == gp.HINT_STATE) 
                    gp.gameState = gp.PLAY_STATE;
            }
            case KeyEvent.VK_ENTER -> {
                if (gp.gameState == gp.DIALOGUE_STATE) gp.gameState = gp.PLAY_STATE;
                interactPress = true;
            }
        }
    }
    
    //stops motion upon releasing keys

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        switch (code) {
            case KeyEvent.VK_W -> {upPress = false; movePress = false;}
            case KeyEvent.VK_S -> {downPress = false; movePress = false;}
            case KeyEvent.VK_A -> {leftPress = false; movePress = false;}
            case KeyEvent.VK_D -> {rightPress = false; movePress = false;}
            case KeyEvent.VK_ENTER -> interactPress = false;
        }
    } 
}