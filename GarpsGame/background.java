import java.util.*;
import greenfoot.*;
import java.awt.Color;
import greenfoot.GreenfootImage;
import greenfoot.Actor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Dimension;

/**
 * 
 */
public class background extends World
{
    /**
     * Constructor for objects of class background.
     */
    
    private GreenfootSound sound;
    private Counter counter;
    private endScore endScore;
    public background(){

     // Create a new world with 700x500 cells with a cell size of 1x1 pixels.
     
     super(1400, 1000, 1); 
     populateTheWorld();
     sound = new GreenfootSound("Cat.mp3");
     
    }
    protected void populateTheWorld(){
        int teller;
        int regel,kolom;
        
       addObject(new Garp(), 700, 500);
       for(teller = 0; teller < 2; teller ++) {
           addObject(new dont(), Greenfoot.getRandomNumber(700),Greenfoot.getRandomNumber(500));
       }
       for(teller = 0; teller < 15; teller ++) {
           addObject(new rupee(), Greenfoot.getRandomNumber(1400), 
           Greenfoot.getRandomNumber(1000));
        }
       for(teller = 0; teller < 12; teller ++) {
           addObject(new Rock(), Greenfoot.getRandomNumber(1400), 
           Greenfoot.getRandomNumber(1000));
       }
       for(teller = 0; teller < 12; teller ++) {
           addObject(new bomb(), Greenfoot.getRandomNumber(1400), 
           Greenfoot.getRandomNumber(1000));
       }
       counter = new Counter();
       regel = getHeight() - counter.getImage().getHeight() /2 -2;
       kolom = counter.getImage().getWidth() /2 + 1;
       addObject(counter, kolom, regel);
       setPaintOrder(Counter.class, Garp.class, dont.class, rupee.class, bomb.class, Rock.class);
    }
    public void started()
    {

     sound.playLoop();
     endScore = new endScore();
    } 
    public void stopped()
    {
     int score;
     
     score = counter.getScore();
     endScore.setEndImage(score);
     addObject(endScore, getWidth() / 2 , getHeight() / 2);
     sound.stop();
    }   
}
