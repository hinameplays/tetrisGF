import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
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
    
    private int initx,inity;
    
    public Block(int x, int y, int variation) {
        initx = x; inity = y;
        setBlockTexture(variation);
        setLocation(x, y);
    }
    
    public void setBlockTexture(int variant) {
        switch (variant) {
            case 1:
                setImage("1.jpg");
                break;
            case 2:
                setImage("2.jpg");
                break;
            case 3:
                setImage("3.jpg");
                break;
            case 4:
                setImage("4.jpg");
                break;
            case 5:
                setImage("5.jpg");
                break;
            case 6:
                setImage("6.jpg");
                break;
            case 7:
                setImage("7.jpg");
                break;
            default:
                setImage("block_default.png");
            }
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
            if (getX() != 10) return true;
        } return false;
    }
    
    public void goRight() {
        if (canGoRight()) setLocation(getX()+1, getY());
    }
    
    public boolean canFall(List<Block> CurrentBlocks) {
        if (getObjectsAtOffset(0, 1, null).isEmpty() || CurrentBlocks.contains(getObjectsAtOffset(0, 1, null))) {
            if (getY() != 23) return true;
        } return false;
    }
    
    public void fall(List<Block> CurrentBlocks) {
        if (canFall(CurrentBlocks)) setLocation(getX(), getY()+1);
    }
    
    public int getInitX() { return initx; }
    
    public int getInitY() { return inity; }
}
