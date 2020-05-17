import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ZRblock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZRblock extends Block
{
    final String t = "zr";
   
    @Override
    public void move(String d) {
        //Implementation mit override
    }
    @Override
    public void rotate() {
        //Implementation mit override
    }
    /**
     * Act - do whatever the ZRblock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.fall();
    }    
}
