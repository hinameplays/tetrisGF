import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Piece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    /**
     * Act - do whatever the Piece wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Block(int x, int y, int variation) {
        setBlockTexture(variation);
        setLocation(x, y);
    }
    
    public void setBlockTexture(int variant) {
        setImage("block_default.png");
    }
    
    public boolean canGoLeft() {
        if (getObjectsAtOffset(-1,0,null).isEmpty()) {
            if (getX() != 1) return true;
        } return false;
    }
    
    public void goLeft() {
        if (canGoLeft()) setLocation(getX()-1, getY());
    }
    
    public boolean canGoRight() {
        if (getObjectsAtOffset(1,0,null).isEmpty()) {
            if (getX() != 11) return true;
        } return false;
    }
    
    public void goRight() {
        if (canGoRight()) setLocation(getX()+1, getY());
    }
    
    public boolean canFall() {
        if (getObjectsAtOffset(0, 1, null).isEmpty()) {
            if (getY() != 23) return true;
        } return false;
    }
    
    public void fall() {
        if (canFall()) setLocation(getX(), getY()+1);
    }
}
