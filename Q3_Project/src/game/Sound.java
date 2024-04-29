/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author user
 */
public class Sound {
    Clip clip;
    URL soundURL[] = new URL[10];

    public Sound() {
        // Music Credit: No Worries by Pix
        // https://youtu.be/Dw6J1EbrzI0
        soundURL[0] = getClass().getResource("/assets/game/sound/no-worries.aiff");
        // Sound Credit: taken from Interface Sounds by Kenney
        // https://kenney.nl/assets/interface-sounds
        soundURL[1] = getClass().getResource("/assets/game/sound/click.aiff");
    }
    
    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);  
            clip = AudioSystem.getClip();   
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void play() {
        clip.start();
    }
    
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void stop() {
        clip.stop();
    }
}
