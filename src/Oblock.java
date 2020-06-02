import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Oblock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oblock extends Block
{
    final String t = "o";
    
  
    /**
     * Act - do whatever the Oblock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.fall();
    }    
}
