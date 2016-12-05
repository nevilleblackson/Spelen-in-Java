import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Dimension;
import java.awt.Color;
import java.util.List;
/**
 * Write a description of class Garp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garp extends Actor{

    /**
     * Act - do whatever the Garp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private GreenfootImage imageLeft;
    private GreenfootImage imageRight;
    
    int bewegen ;
    
    public Garp(){
        imageLeft = new GreenfootImage("GarpLeft.png");
        imageRight = new GreenfootImage("GarpRight.png");
    }
    public void act(){
        movingAndTurning();
        collectingDiamonds();
        if(foundRock()){
            move(-5);
        }
        foundBomb();
        }
    protected void collectingDiamonds(){
        World world;
        Actor diamond;  
        Counter counter;
        List lijst; 
        
        diamond = getOneObjectAtOffset(0, 0, rupee.class);
        if(diamond != null) {
            world = getWorld();
            world.removeObject(diamond);
            lijst = world.getObjects(Counter.class);
            counter = (Counter)lijst.get(0);
            counter.addScore();
            if (counter.getScore() == 15){
                Greenfoot.stop();
            }
        }
        }
    protected void movingAndTurning(){
        {
            if(Greenfoot.isKeyDown("right")) {
                setImage(imageRight);
                setRotation(0);
                move(5);
            }
            if(Greenfoot.isKeyDown("left")) {
                setImage(imageLeft);
                setRotation(0);
                move(-5);
            }
            if(Greenfoot.isKeyDown("up")) {
                if(getImage() == imageLeft) {
                    setImage(imageRight);
                }
                setRotation(-90);
                move(5);
            }
            if(Greenfoot.isKeyDown("down")) {
                if(getImage() == imageLeft) {
                    setImage(imageRight);
                }
                setRotation(90);
                move(5);
            }
        }    
    }
    protected boolean foundRock(){
        Actor rock; 
        rock = getOneObjectAtOffset(0, 0, Rock.class);
        if(rock != null) {  
            return true;
        }
        return false;
    }
        public void foundBomb(){
        Actor bomb; 
        bomb = getOneObjectAtOffset(0, 0, bomb.class);

        if(bomb != null) {  
            getWorld().removeObject(bomb);
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(this);
        }
    }
}