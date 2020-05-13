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
        //Ich bin ein Viereck, wieso sollte mich irgendwer drehen wollen?
    }    
    /**
     * Act - do whatever the Oblock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
