import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LLblock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LLblock extends Block
{
    final String t = "ll";
    

    /**
     * Act - do whatever the LLblock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.fall();
    }    
}
