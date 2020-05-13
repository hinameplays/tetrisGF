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
    public static boolean on = true;
    static Listener w = null;
    
    public Listener()
    {   
        //creates new listener w/ greenfoot propertys
        //die Werte müssen erstmal so bleiben, da noch keine Sprites mit 
        //Scaling existieren
        super(16, 24, 25); 

        prepare();
        w = this;
        
    }
    
    // returns the current world
    static Listener getWorld() {
        return w;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        this.setBackground("background.png");
        Greenfoot.setSpeed(40);
    }
}
