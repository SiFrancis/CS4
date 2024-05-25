/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q4_project;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class InputHandler implements KeyListener {
    public boolean hitPress;
    public boolean numpadPress;
    public boolean automPress;
    public boolean pausePress;
    
    final int hitKey = KeyEvent.VK_SPACE;
    final int numpadKey = KeyEvent.VK_N;
    final int automKey = KeyEvent.VK_A;
    final int pauseKey = KeyEvent.VK_ESCAPE;
    
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case hitKey -> hitPress = true;
            case numpadKey -> numpadPress = true;
            case automKey -> automPress = true;
            case pauseKey -> pausePress = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case hitKey -> hitPress = false;
            case numpadKey -> numpadPress = false;
            case automKey -> automPress = false;
            case pauseKey -> pausePress = false;
        }
    }
    
    
}
