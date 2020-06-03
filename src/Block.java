import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Pieces to handle blocks.
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
    
    private int initx,inity, type;
    
    public Block(int x, int y, int variation) {
        initx = x; inity = y;
        setBlockTexture(variation);
        type = variation;
        setLocation(x, y);
    }
    
    public int getType() {
        return type;
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
    
    public boolean canGoLeft(List<Block> CurrentBlocks) {
        List<Object> f = getObjectsAtOffset(-1, 0, null);
        for (Block n : CurrentBlocks) {
            if(f.contains(n)&&n.getX()!=1) {
                f.remove(n);
            }
        }
        
        if (f.isEmpty()) {
            if (getX() != 1) return true;
        } return false;
    }
    
    public void goLeft(List<Block> CurrentBlocks) {
               
        if (canGoLeft(CurrentBlocks)) setLocation(getX()-1, getY());
    }
    
    public boolean canGoRight(List<Block> CurrentBlocks) {
        List<Object> f = getObjectsAtOffset(1, 0, null);
        for (Block n : CurrentBlocks) {
            if(f.contains(n)&&n.getX()!=10) {
                f.remove(n);
            }
        }
        if (f.isEmpty()) {
            if (getX() != 10) return true;
        } return false;
    }
    
    public void goRight(List<Block> CurrentBlocks) {
        if (canGoRight(CurrentBlocks)) setLocation(getX()+1, getY());
    }
    
    public boolean canFall(List<Block> CurrentBlocks) {
        List<Object> f = getObjectsAtOffset(0, 1, null);
        for (Block n : CurrentBlocks) {
            if(f.contains(n)&&n.getY()!=23) {
                f.remove(n);
            }
        }
        
        if (f.isEmpty()){
            if (getY() != 23) {return true;}
        } return false;
    }
    
    public void fall(List<Block> CurrentBlocks) {
        if (canFall(CurrentBlocks)) setLocation(getX(), getY()+1);
    }
    
    public int getInitX() { return initx; }
    
    public int getInitY() { return inity; }
}
