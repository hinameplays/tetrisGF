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
    

    /**
     * Act - do whatever the Tblock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.fall();
    }    
}
