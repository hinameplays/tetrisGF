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
    public boolean movable = true;
    
    public void setImg(String type) {
        this.setImage(type+"-block.jpg");
    }
    
    public void testMov() {
        Actor a = getOneObjectAtOffset​(0, 1, null);
        if (a!=null||this.getY()>=22||RenEngine.STOP) {
            this.movable = false;
        } else {
            this.movable = true;
        }
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
            fallStep += 1 + execTime/200; 
            execTime +=1; 
            Greenfoot.delay(2);
        }
        if (fallStep%5==0) {
            this.testMov();
            if(movable) {
                fallStep = 0;
                this.setLocation(this.getX(), this.getY()+1);
            }
        }
       
    }
    
    public void act() {
        this.fall();
        if (!movable) {
            RenEngine.spawnTet();
        }
    }    
}
