import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Score
{
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int score;
    
    public Counter(){
        String scoreText;
        GreenfootImage image;
        Dimension dim;
        
        score = 0;
        scoreText = "Aantal diamanten:    0";
        image = new GreenfootImage(100,150);
        dim = getTextDimensions(image, scoreText);
        image.scale(dim.width,dim.height);
        setImage(image);
        image.setColor(new Color(0,0,0));
        image.drawString(scoreText, 0, dim.height);
    }
    public void act() 
    {
        // Add your action code here.
    }    
    public void addScore() {
        score ++;
        updateImage();
    }
    protected void updateImage() {
        String scoreText;
        GreenfootImage image;
        Dimension dim;
        
        image = getImage();
        image.clear();
        scoreText ="Aantal diamanten   " + score;
        dim = getTextDimensions(image, scoreText);
        image.setColor(new Color(0,0,0));
        image.drawString(scoreText,0,dim.height);
    }
    public int getScore() {
        return this.score;
    }
}
