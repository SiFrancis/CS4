/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2PE4;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author user
 */
public class MusicPlayer {
    Clip clip;
    // Music Credit (Menu Music): Vanilla Cola by Cody O'Quinn 
    // https://youtu.be/dJFbnEY3tzQ
    // Music Credit (Battle Music): This is Our Only Chance! by Cody O'Quinn
    // https://youtu.be/FlK1wS94GD0
    public void loopMusic(String s) {
        URL soundURL = getClass().getResource(s);
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();  
            clip.open(ais);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
        }
    }
    // Sound Credit: taken from Interface Sounds by Kenney
    // https://kenney.nl/assets/interface-sounds
    public void click_sound() {
        URL soundURL = getClass().getResource("/Audio/click.aiff");
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL);
            Clip clip = AudioSystem.getClip();  
            clip.open(ais);
            clip.start();
        } catch (Exception ex) {
        }
    }
}
