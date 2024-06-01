/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package q4_project;

import java.awt.HeadlessException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author user
 */
public class GameFrame extends JFrame {
    MusicPlayer mp;
    public GameFrame(MusicPlayer mp) throws IOException {
        this.mp = mp;
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Bicbic, Sitchon, Rosalejos - 4th Quarter CS-Math Project");
        
        GamePanel gp = new GamePanel(mp);
        frame.add(gp);
        frame.pack();
        gp.setup();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GameFrame(new MusicPlayer());
                } catch (IOException ex) {
                    Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
    
