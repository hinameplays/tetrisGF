import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Makes em'
 * Shakes em'
 * Destroys em'
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Listener extends World
{
    public boolean on = true;
    public Listener()
    {   
        //creates new listener w/ greenfoot propertys
        //die Werte müssen erstmal so bleiben, da noch keine Sprites mit 
        //Scaling existieren
        super(16, 24, 25); 
        
    }
    public void drawGrid(){
        if (on) {
            
        }
    }
    
}
