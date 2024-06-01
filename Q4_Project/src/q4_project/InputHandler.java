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
    public boolean helpPress;
    
    final int hitKey = KeyEvent.VK_SPACE;
    final int numpadKey = KeyEvent.VK_N;
    final int automKey = KeyEvent.VK_A;
    final int helpKey = KeyEvent.VK_H;
    
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case hitKey -> hitPress = true;
            case numpadKey -> numpadPress = true;
            case automKey -> automPress = true;
            case helpKey -> helpPress = true;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case hitKey -> hitPress = false;
            case numpadKey -> numpadPress = false;
            case automKey -> automPress = false;
            case helpKey -> helpPress = false;

        }
    }
    
    
}
