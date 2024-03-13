/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Acer
 */
public class KeyHandler implements KeyListener {
    
    public boolean upPress, downPress, leftPress, rightPress;

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        int code = e.getKeyCode();
//        
//        switch (code) {
//            case KeyEvent.VK_W -> upPress = true;
//            case KeyEvent.VK_S -> downPress = true;
//            case KeyEvent.VK_A -> leftPress = true;
//            case KeyEvent.VK_D -> rightPress = true;
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        switch (code) {
            case KeyEvent.VK_W -> upPress = true;
            case KeyEvent.VK_S -> downPress = true;
            case KeyEvent.VK_A -> leftPress = true;
            case KeyEvent.VK_D -> rightPress = true;
        }
    } 
}