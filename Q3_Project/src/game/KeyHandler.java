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
            case KeyEvent.VK_W -> upPress = true;
            case KeyEvent.VK_S -> downPress = true;
            case KeyEvent.VK_A -> leftPress = true;
            case KeyEvent.VK_D -> rightPress = true;
            case KeyEvent.VK_ESCAPE -> {
                if (gp.gameState == gp.PLAY_STATE) gp.gameState = gp.PAUSE_STATE;
                else if (gp.gameState == gp.PAUSE_STATE) gp.gameState = gp.PLAY_STATE;
            }
        }
    }
    
    //stops motion upon releasing keys

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        switch (code) {
            case KeyEvent.VK_W -> upPress = false;
            case KeyEvent.VK_S -> downPress = false;
            case KeyEvent.VK_A -> leftPress = false;
            case KeyEvent.VK_D -> rightPress = false;
        }
    } 
}