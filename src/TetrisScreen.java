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
    private boolean debug = true;
    
    
    private int KeyCooldown = 30; // The amount of act-cycles before the autorepeating starts
    private int AutoRepeatSpeed = 10; // The amount of act-cycles it takes for a piece to autoshift with DAS.
    private int AutoRepeatSpeedDownOriginal = 5; // Drop Button is faster than piece shifting.
    
    private boolean KeyStorageLeft = false, KeyStorageRight = false, KeyStorageDown = false; // Helper variables for Key Cooldown and Repeating
    private int KeyCooldownLeft = KeyCooldown, KeyCooldownRight = KeyCooldown, KeyCooldownDown = KeyCooldown; 
    private int AutoRepeatSpeedLeft = AutoRepeatSpeed, AutoRepeatSpeedRight = AutoRepeatSpeed, AutoRepeatSpeedDown = AutoRepeatSpeedDownOriginal;
    /*
     * These Settings are needed for an Authentic NES Tetris Feel, which this game is trying to replicate.
     * They may be tweaked to the users liking for hypertap-emulation.
     */
    
    private boolean gameRunning = false, gameOver = false;
    private List<Block> BlockList = new ArrayList<Block>(); //Stores all static Blocks
    private List<Block> CurrentBlocks = new ArrayList<Block>(); //Stores all moving Blocks
    
    // These Variables are used during Gameplay.
    
    private int BlockFallTimer = 60, Score = 0;
    
    public TetrisScreen()
    {   
        super(17, 25, 24); 
        this.setBackground("background.png"); // Default Tetris Background
        Greenfoot.setSpeed(50); //SEts the Speed to a reasonable Level for 60 FPS gameplay. This is Important for the frame-dependant Block falling methods.
        addBlock(); // Adds the default block for testing. This must be commented iotu for the full game
        showText("Press Enter to start the game.",8,12);
    }
    
    public void addBlock() {
        Block firstBlock = new Block(5,1,0);
        CurrentBlocks.add(firstBlock);
        addObject(firstBlock,5,1);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("ENTER")&& !gameOver) {
            gameRunning = true;
            showText("",8,12); // Hides the Game Start Text
        }
        
        if (gameRunning) {
            blockFalling();
            playerInputs();
            
            
        }
    }
    
    private void playerInputs() { // This input implementation replicates the Nintendo NES Tetris piece movement DAS mechanics.
        if (Greenfoot.isKeyDown("LEFT")) {
            if (!KeyStorageLeft) {
                shiftAllLeft();
                KeyStorageLeft = true; // Set this to true for DAS cooldown
            } else if (KeyCooldownLeft == 0) {
                if (AutoRepeatSpeedLeft == 0) {
                    shiftAllLeft();
                    AutoRepeatSpeedLeft = AutoRepeatSpeed;
                } else { AutoRepeatSpeedLeft--; }
            } else {
                KeyCooldownLeft--;
            }
        } else { // Reset all repeating counters
            KeyStorageLeft = false;
            KeyCooldownLeft = KeyCooldown; 
            AutoRepeatSpeedLeft = AutoRepeatSpeed;
        }
         
        if (Greenfoot.isKeyDown("RIGHT")) {
            if (!KeyStorageRight) {
                shiftAllRight();
                KeyStorageRight = true; // Set this to true for DAS cooldown
            } else if (KeyCooldownRight == 0) {
                if (AutoRepeatSpeedRight == 0) {
                    shiftAllRight();
                    AutoRepeatSpeedRight = AutoRepeatSpeed;
                } else { AutoRepeatSpeedRight--; }
            } else {
                KeyCooldownRight--;
            }
        } else { // Reset all repeating counters
            KeyStorageRight = false;
            KeyCooldownRight = KeyCooldown;
            AutoRepeatSpeedRight = AutoRepeatSpeed;
        }
        
        if (Greenfoot.isKeyDown("DOWN")) {
            if (!KeyStorageDown) {
                fallOnce();
                KeyStorageDown = true; // Set this to true for DAS cooldown
            } else if (KeyCooldownDown == 0) {
                if (AutoRepeatSpeedDown == 0) {
                    fallOnce();
                    AutoRepeatSpeedDown = AutoRepeatSpeed;
                } else { AutoRepeatSpeedDown--; }
            } else {
                KeyCooldownDown--;
            }
            BlockFallTimer = 40; // This is done in Trey Harrison's NES Tetris Mod to make Hypertap Stalls possible
        } else { // Reset all repeating counters
            KeyStorageDown = false;
            KeyCooldownDown = KeyCooldown;
            AutoRepeatSpeedDown = AutoRepeatSpeedDownOriginal;
        }
            
    }
    
    private void shiftAllLeft() {
        for (Block b : CurrentBlocks) {
            if (b.canGoLeft()) {
                b.goLeft();
            } // Go left, dont do anything else.
        }
    }
           
    private void shiftAllRight() {
        for (Block b : CurrentBlocks) {
            if (b.canGoRight()) {
                b.goRight();
            } // Go left, dont do anything else.
        }
    }
    
    private void fallOnce() {
        try {
            for (Block b : CurrentBlocks) {
                if (b.canFall()) {
                    b.fall();
                } else {
                    BlockList.add(b);
                    CurrentBlocks.remove(b);
                }
                    
            }
        } catch (Exception e) {}
    }

    private void blockFalling() {
        BlockFallTimer--;
        if (BlockFallTimer == 0) {
            fallOnce();
            BlockFallTimer = 60;
        } 
        if (debug) showText(String.valueOf(BlockFallTimer),3,3);
    }
}
