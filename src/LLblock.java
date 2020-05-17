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
    
    @Override
    public void move(String d) {
        //Implementation mit override
    }
    @Override
    public void rotate() {
        //Implementation mit override
    }
    /**
     * Act - do whatever the LLblock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.fall();
    }    
}
