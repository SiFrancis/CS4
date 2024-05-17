/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q4_project;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author user
 */
public class InputHandler implements KeyListener {
    public boolean hitPress;
    
    final int hitKey = KeyEvent.VK_SPACE;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case hitKey -> hitPress = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case hitKey -> hitPress = false;
        }
    }
    
    
}
