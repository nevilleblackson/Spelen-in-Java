import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private GreenfootImage[] images;
    private int action,increment;
    private boolean geluid;
    
    public Explosion(){
        GreenfootImage baseImage;
        int size, baseSize, verschil, teller;

        images = new GreenfootImage[8];
        baseImage = new GreenfootImage("explosion.png");
        
        
        baseSize = baseImage.getWidth();
        verschil = baseSize / 8;
        size = 0;
        for(teller = 0; teller < 8; teller++){
            size += verschil;
            images[teller] = new GreenfootImage(baseImage);
            images[teller].scale(size, size);
        }
        action = 0;
        increment = 1;
        geluid = true;
        
    }
    public void act() 
    {
        // Add your action code here.
        setImage(images[action]);
        action +=increment;
        if(geluid){
            Greenfoot.playSound("musicmix.mp3");
            geluid = false;
        }
        if  (action > 7){
            increment = -1;
            action += increment;
        }
        if (action <0){
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }
}
