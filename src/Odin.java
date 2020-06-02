import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Odin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Odin extends Actor
{
    int fallStep = 0;
    int execTime = 0;
    
    public static void spawnOdin() {
        int g = Greenfoot.getRandomNumber(7);
        int xe = Greenfoot.getRandomNumber(5);
        Listener w = Listener.getWorld();
        Odin aO;
        
        switch(g){
        case 0:
            aO = new IOdin();
            
        case 1:
            aO= new TOdin();
        
        default:
            aO = new IOdin();
          
        }
        w.addObject(aO,xe*25+112, 75);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
