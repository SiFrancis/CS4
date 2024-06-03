/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q4_project;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author user
 */
public class GamePanel extends JPanel implements Runnable {

    public final int SCREEN_W = 800;
    public final int SCREEN_H = 600;
    
    public final int FPS = 60;
    public Thread gameThread;
    
    InputHandler input = new InputHandler();
    Random rand = new Random();
    
    // xy measurements of player object
    int origX = 100; int origY = 550; 
    // starting angle of player object
    double initAngle = -45; double currentAngle = initAngle;
    // measures angle of launched projectile
    double aimAngle = 9999; // arbitrary start value
    // used to draw guide lines
    int pathRadius = 120; int ballRadius = 10; int pathArc = 90;
    // catapult rotation speed
    double rotateSpeed = 1.5;
    
    // distance between player and spotter
    int groundDistance;
    
    // spotter coordinates
    int spotterX;
    int spotterY;
    
    // coordinates of target
    // target coordinates are used for angle computation
    // targetPoint coordinates are used for drawing
    double targetX;
    double targetPointX;
    double targetY;
    double targetPointY;
    
    // spotter
    int spotterAngle;
    int spotterDistance;
    
    int targetAngle, targetRadius;
    
    int goalAngle;
    double goalDrawAngle;
    int goalDistance;
    
    int hitX, hitY, hitPointX, hitPointY;
    
    double hitThresh = 10;
    
    boolean rotateBack = false;
    
    // score
    int score = 0;
    int scoreChange;
    ArrayList<Integer> scoresList = new ArrayList<>();
    final String RESOURCES_DIR = System.getProperty("user.dir") + File.separator;
    
    // timer
    int maxTime = 120;
    int currentTime = maxTime;
    
    // numpad
    public int numpadVal = 100;
    Numpad numpad = new Numpad(this);
    
    // loading pics
    BufferedImage catimg, bg_img, sat_img, catapult_img;
    Image portal_img;
    
    // game done or not
    boolean isPlaying = true;
    ScoreDialog sd;
    
    //sound
    MusicPlayer mp;
    
    public void generateTriangle() throws IOException {
        
        // generating points
        groundDistance = rand.nextInt(40, 120) * 5;
        targetX = rand.nextDouble(40, 120) * 5;
        targetY = rand.nextInt(50, 70) * 5;
        
        targetPointX = origX + targetX;
        targetPointY = origY - targetY;
        
        // calculating spotter angle
        spotterX = origX + groundDistance;
        spotterY = origY;
        if (targetPointX <= spotterX) {
            spotterAngle = (int)Math.toDegrees(Math.atan(Math.abs(spotterY-targetPointY)/Math.abs(spotterX-targetPointX)));
            sat_img = ImageIO.read(getClass().getResourceAsStream("/assets/satleft.png"));
        }
        else {
            spotterAngle = 180 - (int)Math.toDegrees(Math.atan(Math.abs(spotterY-targetPointY)/Math.abs(spotterX-targetPointX)));
            sat_img = ImageIO.read(getClass().getResourceAsStream("/assets/satright.png"));
        }
        spotterDistance = (int)Math.sqrt((spotterY-targetPointY)*(spotterY-targetPointY)+(spotterX-targetPointX)*(spotterX-targetPointX));
        
        // calculating goal angle and distance
        goalAngle = (int)Math.toDegrees(Math.atan(targetY/targetX));
        goalDrawAngle = -1*goalAngle;
        goalDistance = (int)Math.sqrt(targetX*targetX+targetY*targetY);
        
        targetRadius = ballRadius + (int)(targetY - goalDistance*Math.sin(Math.toRadians(goalAngle-hitThresh)));
        targetAngle = 180 - spotterAngle - goalAngle;
        
    }
    
    public void update() throws IOException{
        if (isPlaying) {
            if (rotateBack) {
                currentAngle -= rotateSpeed;
            } else {
                currentAngle += rotateSpeed;
            }
            if (currentAngle >= 0 || currentAngle <= -1 * pathArc) {
                rotateBack = !rotateBack;
            }
            if (input.hitPress) {
                mp.click_sound();
                aimAngle = currentAngle;
                scoreChange = 0;
                catimg = ImageIO.read(getClass().getResourceAsStream("/assets/catpics/cat" + rand.nextInt(10) + ".png"));
                
                //System.out.println(String.format("Current Angle: %1$.2f | Difference: %2$.2f (%3$.2f%%)", -1*aimAngle, angleDiff, percentAngleDiff));
                hitX = (int) (numpadVal * Math.cos(aimAngle * Math.PI / 180));
                hitY = (int) (numpadVal * Math.sin(aimAngle * Math.PI / 180));
                hitPointX = origX + hitX - ballRadius;
                hitPointY = origY + hitY - ballRadius;
                int ddist = (int) Math.sqrt(Math.abs(targetX - hitX) * Math.abs(targetX - hitX) + Math.abs(targetY + hitY) * Math.abs(targetY + hitY));
                if (ddist <= targetRadius) {
                    generateTriangle();
                    if (ddist <= 0.25 * targetRadius) {
                        scoreChange = 120;
                    } else {
                        scoreChange = 100;
                    }
                } else {
                    scoreChange = -150;
                }
                score += scoreChange;
                input.hitPress = false;
            }

            if (input.automPress) {
                mp.click_sound();
                new Automation().run();
                input.automPress = false;
            }

            if (input.numpadPress) {
                mp.click_sound();
                numpad.run();
                input.numpadPress = false;
            }
            
            if (input.helpPress) {
                mp.click_sound();
                new GameHelp().setVisible(true);
                input.helpPress = false;
            }
            sd.setScore(score);
        }
    }
    
    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(bg_img, 0, 0, null);
        
        // drawing guide lines
        g.setColor(Color.black);
        g.drawArc(origX - pathRadius, origY - pathRadius, pathRadius*2, pathRadius*2, 0, pathArc);
        g.drawLine(origX, origY, spotterX, origY);
        g.drawLine(origX, origY, origX, origY-150);
        
        // drawing player object
        g.drawImage(catapult_img, origX-15, origY-120, 140, 140, null);
        
        int catX = (int) (pathRadius * Math.cos(currentAngle * Math.PI / 180));
        int catY = (int) (pathRadius * Math.sin(currentAngle * Math.PI / 180));
        
        g.drawImage(catimg, origX + catX - 30, origY + catY - 30, 60, 60, null);
        
        // drawing spotter ball and line
        g.setColor(new Color(255, 153, 0));
        g.drawImage(sat_img, spotterX - 50, origY-85, 100, 100, null);
        g.drawLine((int)targetPointX, (int)targetPointY, 
                spotterX, spotterY);
        
        // drawing target
        targetRadius = ballRadius + (int)(targetY - goalDistance*Math.sin(Math.toRadians(goalAngle-hitThresh)));
        g.drawImage(portal_img, (int)targetPointX - targetRadius, (int)targetPointY - targetRadius, targetRadius*2, targetRadius*2, null);
         
        // drawing target line
        g.setColor(Color.red);
        g.drawLine(origX, origY,
                origX + (int)(150 * Math.cos(goalDrawAngle * Math.PI / 180)),
                origY + (int)(150 * Math.sin(goalDrawAngle * Math.PI / 180))
        );
        
        // drawing hit line
        if (aimAngle != 9999) {
            g.setColor(Color.lightGray);
            g.drawLine(origX, origY,
                origX + (int)(150 * Math.cos(aimAngle * Math.PI / 180)),
                origY + (int)(150 * Math.sin(aimAngle * Math.PI / 180)));
            g.drawImage(catimg, hitPointX, hitPointY, 60, 60, null);
        }
        
        // drawing score
        g.setColor(Color.black);
        g.setFont(g.getFont().deriveFont(20f));
        g.drawString(String.format("Score: %1$d (%2$d)", score, scoreChange), origX, 30);
        g.drawString("Top Score: \n\n"+scoresList.getFirst(), 500, 30);
        g.drawString("Time: "+Integer.toString(currentTime), origX, 60);
        
        // skibidi]
        g.setFont(g.getFont().deriveFont(15f));
        g.drawString(String.format("Distance to Satellite: %3$d | Angle of Satellite: %2$d° | Angle to Target: %1$d°", goalAngle, spotterAngle, spotterDistance), origX, 110);
        g.setColor(Color.white);
        g.drawString("Press [N] to open the numpad (change catapult distance)       Press [A] to open automation", origX, 570);
        g.drawString("Press [H] to review how to play", origX, 590);
    }
    
    public void setup() throws IOException {
        bg_img = ImageIO.read(getClass().getResourceAsStream("/assets/background.png"));
        portal_img = ImageIO.read(getClass().getResourceAsStream("/assets/portal.png"));
        catimg = ImageIO.read(getClass().getResourceAsStream("/assets/catpics/cat"+ rand.nextInt(10)+".png"));
        catapult_img = ImageIO.read(getClass().getResourceAsStream("/assets/catapult.png"));
        
        //reading default file
        InputStream inp = getClass().getResourceAsStream("/assets/scores_default.txt");
        BufferedReader bf_def = new BufferedReader(new InputStreamReader(inp));
        
        // copying default file to a .txt file outside the .jar
        if (new File(RESOURCES_DIR+"scores.txt").exists()) {
            String line = "placeholder:1";
            BufferedReader bf_actual = new BufferedReader(new FileReader(new File(RESOURCES_DIR+"scores.txt")));
            while (line != null) {
                System.out.println(line);
                int lineScore = Integer.parseInt(line.substring(line.indexOf(":")+1));
                line = bf_actual.readLine();
                scoresList.add(lineScore);
            }
        } else {
            File scoresActual = new File(RESOURCES_DIR+"scores.txt");
            FileWriter fw = new FileWriter(scoresActual, true);
            String line = "placeholder:0";
            while (line != null) {
                int lineScore = Integer.parseInt(line.substring(line.indexOf(":")+1));
                fw.append(line+"\n");
                line = bf_def.readLine();
                scoresList.add(lineScore);
            }
            fw.close();
        }
        bf_def.close();
        Collections.sort(scoresList, Collections.reverseOrder());
        
        gameThread = new Thread(this);
        gameThread.start();
        
        generateTriangle();
    }
    
    public GamePanel(MusicPlayer mp) throws IOException {
        this.mp = mp;
        this.mp.clip = mp.clip;
        
        System.out.println();
        
        this.sd = new ScoreDialog(new JFrame(), false);

        //sets screen dimension
        this.setPreferredSize(new Dimension(SCREEN_W, SCREEN_H));

        //for graphics optimization apparently
        this.setDoubleBuffered(true);
        
        //activates key listener
        this.addKeyListener(input);

        //setting focusable to true makes the window able to accept key input
        this.setFocusable(true);
        
    }        
            
    @Override
    public void run() {
        double drawInterval = 1000/FPS;
        double delta = 0;
        double secondCounter = 0;
        long timePrev = System.currentTimeMillis();
        long timeNow;
        
        while (gameThread != null) {
            timeNow = System.currentTimeMillis();
            delta += (timeNow - timePrev) / drawInterval;
            secondCounter += (timeNow - timePrev) / drawInterval;
            timePrev = timeNow;
            if (delta >= 1) {
                try {
                    update();
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                repaint();
                delta--;
            }
            if (secondCounter >= FPS) {
                if (isPlaying) currentTime--;
                if (currentTime <= 0) {
                    isPlaying = false;
                    if (!sd.entered) {
                        sd.setVisible(true);
                    }
                    mp.clip.stop();
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    frame.dispose();
                }
                secondCounter -= FPS;
            }
        }
    }
}
