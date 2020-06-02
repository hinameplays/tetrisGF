import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hier wird ein Einzelblock definiert
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Block extends Actor
{
    
    public boolean movable;
    
    public Block() {
        movable = true;
    }
    
    public void setImg(String type) {
        this.setImage(type+"-block.jpg");
    }
    
    public void testMov() {
        Actor a = getOneObjectAtOffset​(0, 25, null);
        if (a!=null||this.getY()>=22*25) {
            this.movable = false;
        } else {
            this.movable = true;
        }
    }
    
    public void fall() {
        if(movable){
            this.setLocation(this.getX(), this.getY()+25);
        }
    }
    
    public void act() {
        this.fall();
    }    
}
