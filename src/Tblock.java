import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tblock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tblock extends Block
{
    final String t = "t";
    @Override
    public Boolean testMov() {
        //Implementation mit override
        return false;
    }
    @Override
    public void move(String d) {
        //Implementation mit override
    }
    @Override
    public void rotate() {
        //Implementation mit override
    }
    /**
     * Act - do whatever the Tblock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
