import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import org.json.*;
import java.io.*;

/**
 * Diese Klasse dient dem Handling und dem Spawnen neuer Einzelblöcke, die 
 * einen großen ausmachen.
 * Die Klasse wird nachher in einen einzelnen Helper verschoben
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bodies extends UIElement
{
    //folgendes muss dringend in eine JSON:
    String[] type = {"null","2x2","leftL","rightL","4x1"};
    String[] typeI = {"blockDEBUG.jpg","blockDEBUG.jpg","blockDEBUG.jpg","blockDEBUG.jpg","blockDEBUG.jpg"};
    String[] blockConf = {"1"};
    
    int typeID;
    int baseX;
    int baseY;
    
    /**
     * Act - do whatever the Bodies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        // Add your action code here.
    }    
}
