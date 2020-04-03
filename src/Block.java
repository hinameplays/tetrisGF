import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Bodies
{
  
    int x;
    int y;
    
    public Block(String c) {
        for (int i = 0; i<type.length; i++) {
            if (c == type[i]) {
               this.typeID = i;
               this.typeIMG = typeI[i];
               this.setImage(this.typeIMG);
            }
        }
        
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
