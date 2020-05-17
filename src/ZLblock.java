import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ZLblock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZLblock extends Block
{
    final String t = "zl";
    
    @Override
    public void move(String d) {
        //Implementation mit override
    }
    @Override
    public void rotate() {
        //Implementation mit override
    }
    /**
     * Act - do whatever the ZLblock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.fall();
    }    
}
