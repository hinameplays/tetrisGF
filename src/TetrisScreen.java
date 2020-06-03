import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Makes em'
 * Shakes em'
 * Destroys em'
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TetrisScreen extends World
{
    public boolean debug = true;
    
    
    
    private boolean gameRunning = false, gameOver = false;
    private List<Block> BlockList = new ArrayList<Block>(); //Stores all static Blocks
    private Structure structureMaker = new Structure();
    // These Variables are used during Gameplay.
    
    
    public TetrisScreen()
    {   
        super(17, 25, 24); 
        this.setBackground("background.png"); // Default Tetris Background
        Greenfoot.setSpeed(50); //SEts the Speed to a reasonable Level for 60 FPS gameplay. This is Important for the frame-dependant Block falling methods.
        addObject(structureMaker,0,0);
        showText("Press Enter to start the game.",8,12);
    }
    
    public void addBlocks() {
        structureMaker.spawnStructure();
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("ENTER")&& !gameOver && !gameRunning) {
            gameRunning = true;
            showText("",8,12); // Hides the Game Start Text
            addBlocks();
        }
        
        if (gameRunning) {
            structureMaker.blockFalling();
            structureMaker.playerInputs();
            
            
        }
    }
    
    public void saveStaticBlock(Block block) {
        BlockList.add(block);
    }
    
    public void remLine(){
        for (Block b : BlockList) {
            
            }
    }
    
    public void pleaseAddActor(Actor a, int x, int y){
        addObject(a, x, y);
    }
}
