/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package q4_project;

import java.awt.HeadlessException;
import javax.swing.*;

/**
 *
 * @author user
 */
public class Main extends JFrame {

    public Main() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Bicbic, Sitchon, Rosalejos - 4th Quarter CS-Math Project");
        
        GamePanel gp = new GamePanel();
        frame.add(gp);
        frame.pack();
        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
    
}
