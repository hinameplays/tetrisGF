import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LRblock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LRblock extends Block
{
    final String t = "lr";
    

    /**
     * Act - do whatever the LRblock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.fall();
    }    
}
