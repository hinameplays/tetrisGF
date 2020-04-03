//package libGdx.hinGdx.Special;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UIElement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UIElement extends Actor
{
    int x;
    int y;
    String type;
    String typeIMG = "blockDEBUG.jpg";
    
    public void chDrawState(boolean s) {
        if (s) {
            this.setImage(typeIMG);
        } else {
            this.setImage("null.jpg");
        }
    }
    private static void LOIC() {
        Greenfoot.stop();
    }
}
