import java.util.*;
import greenfoot.*;
import java.awt.Color;

/**
 * 
 */
public class Gnobus extends Actor
{
    /**
     * Act - do whatever the dont wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    
      public void act() 
    {  
        if(Greenfoot.isKeyDown("shift")) {
        if(Greenfoot.isKeyDown("d")) { 
            setRotation(0);
            move(5);
        }
        if(Greenfoot.isKeyDown("a")) {    
            setRotation(0);
            move(-5);
        }
        if(Greenfoot.isKeyDown("w")) {
            setRotation(-90);
            move(5);
        }
        if(Greenfoot.isKeyDown("s")) {
            setRotation(90);
            move(5);
        }
        }else{
            move(15);
        }
        if(atWorldEdge()) {
           if(Greenfoot.getRandomNumber(100) < 50) {
               setRotation(getRotation() + Greenfoot.getRandomNumber(180));
           }else {
               setRotation(getRotation() - Greenfoot.getRandomNumber(180)); 
           }
          }
       }
        protected boolean atWorldEdge(){
        
        int x,y,z,i,t,wx,wy;
        x = getX();
        y = getY();
        
        
        i = getImage().getWidth() /2;
        if (x <= i){
            return true;
        }
        wx = getWorld().getWidth() -i;
        if(x >= wx){
           return true;
        }
        
        t = getImage().getHeight() /2;
        if(y <= t){
           return true;
        }
        
        wy = getWorld().getHeight () -t;
        if(y >= wy){
           return true;
        }
        
        if(foundActor()) {
            return true;
        }
        return false;
    }
        protected boolean foundActor(){
        Actor actor; 
        actor = getOneObjectAtOffset(0, 0, Actor.class);

        if(actor != null) {  
        return true;
        }
        return false;
    }
    protected void getGarp(){
        Actor garp;
        garp = getOneObjectAtOffset(0, 0, Garp.class);
        int x,y;
        
        x = garp.getX();
        y = garp.getY();
        
    }
}
