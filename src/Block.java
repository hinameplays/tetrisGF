import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hier wird ein Einzelblock definiert
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Block extends Actor
{
    private int fallStep = 0;
    private int execTime = 0;
    
    public void setImg(String type) {
        this.setImage(type+"-block.jpg");
    }
    
    public Boolean testMov() {
        //Implementation mit override
        return false;
    }
    
    public void move(String d) {
        //Implementation mit override
    }
    
    public void rotate() {
        //Implementation mit override
    }
    
    
    public void fall() {
        if (Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("down")) {
            if(Greenfoot.isKeyDown("up")){
                rotate();
                Greenfoot.delay(1);
            }
            if(Greenfoot.isKeyDown("left")){
                move("l");
                Greenfoot.delay(1);
            }
            if(Greenfoot.isKeyDown("right")){
                move("r");
                Greenfoot.delay(1);
            }
            if(Greenfoot.isKeyDown("down")){
                move("d");
            }
            
        } else { 
            fallStep += 1 * execTime/200; 
            execTime +=1; 
            Greenfoot.delay(2);
        }
        if (fallStep%5==0) {
            if(testMov()) {
                fallStep = 0;
                this.setLocation(this.getX(), this.getY()+1);
            }
        }
       
    }
    
      
    
    public void act() {
        while (testMov()) {
            fall();
        }
        if (!testMov()) {
            //spawnTet();
        }
    }    
}
