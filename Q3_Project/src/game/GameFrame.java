/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package game;

import javax.swing.*;

/**
 *
 * @author Acer
 */
public class GameFrame extends JFrame {
    //GameFrame's sole purpose is to run GamePanel
    public GameFrame() {
        JFrame gwindow = new JFrame();
        gwindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gwindow.setResizable(false);
        gwindow.setTitle("Game Window");
        
        GamePanel gpanel = new GamePanel();
        gwindow.add(gpanel);
        gwindow.pack();
        
        gwindow.setVisible(true);
        gwindow.setLocationRelativeTo(null);
        
        gpanel.startGameThread();
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
    }
}
