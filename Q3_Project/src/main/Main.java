/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package main;

import game.GamePanel;
import javax.swing.*;

/**
 *
 * @author Acer
 */
public class Main extends JFrame {
    public Main() {
        JFrame gwindow = new JFrame();
        gwindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gwindow.setResizable(false);
        gwindow.setTitle("Grupong Proyekto sa CS, Math, Fili, at VE - Bicbic, Rosalejos, Sitchon");
        
        GamePanel gpanel = new GamePanel();
        gwindow.add(gpanel);
        gwindow.pack();
        
        gwindow.setVisible(true);
        gwindow.setLocationRelativeTo(null);
        
        gpanel.setup();
        gpanel.startGameThread();
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
