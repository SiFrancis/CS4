/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q4_project;

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
    // Music Credits:
    // Menu Music: MeowSynth cover of HOME by Resonance (cover by Tori Kenyon)
    // https://www.youtube.com/watch?v=oq7aGYmxUvw
    // Game Music: MeowSynth cover of Night of Nights by COOL&CREATE/beatMARIO (cover by Zahmbie02)
    // https://www.youtube.com/watch?v=YFj33iuWMXQ
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
        URL soundURL = getClass().getResource("/assets/click.aiff");
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL);
            Clip clip = AudioSystem.getClip();  
            clip.open(ais);
            clip.start();
        } catch (Exception ex) {
        }
    }
}
