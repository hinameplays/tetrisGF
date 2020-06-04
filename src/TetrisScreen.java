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
    public boolean debug = false;    

    private boolean gameRunning = false, gameOver = false;
    private List<Block> BlockList = new ArrayList<Block>(); //Stores all static Blocks
    private Structure structureMaker = new Structure();
    Counter c = new Counter("");
    // These Variables are used during Gameplay.

    public TetrisScreen()
    {   
        super(17, 25, 24); 
        this.setBackground("background.png"); // Default Tetris Background
        Greenfoot.setSpeed(50); //Sets the Speed to a reasonable Level for 60 FPS gameplay. This is Important for the frame-dependant Block falling methods.
        addObject(structureMaker,0,0);
        showText("Press Enter to start the game.",8,12);

        
        addObject(c,13,7);
        showText("Points \n gained:",13,5);
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
            if (!structureMaker.fallable) {
                checkRows();
                structureMaker.spawnStructure();
                structureMaker.fallable = true;
                Greenfoot.delay(2);
            }
            checkRunning();
        }

        if (gameOver) {
            showText("Game Over! restart the Game via UI!",8,12);

        }
    }

    public void saveStaticBlock(Block block) {
        BlockList.add(block);
    }

    void checkRows() { // checks whether there exists completed rows which can be removed
        int rows = 0;
        int found = 0;
        int deleted = 0; //int to keep track of points awardable

        for (int r = 0; r<=23; r++) { //iterate rows
            for (int c = 0; c<=10; c++) { //iterate cols
                java.util.List l = getObjectsAt(c+1, r+1, Block.class);
                if (l.size() != 0) {
                    found ++;
                }
            }
            if (found == 10) {
                // if enough were found, nuke these
                clearRow(rows);
                pushDown(rows);
                deleted++;
            } 
            found = 0;
            rows ++;
        }
        if (deleted == 1) {
                c.setValue(c.getValue()+40);
        } else if (deleted == 2) {
                c.setValue(c.getValue()+100);
        } else if (deleted == 3) {
                c.setValue(c.getValue()+300);
        } else if (deleted == 4) {
                c.setValue(c.getValue()+1200);
        }
        deleted = 0;
    }

    void clearRow(int row) {
        for (int c = 0; c < 10; c++) {
            removeObjects(getObjectsAt(c+1, row+1, Block.class)); // removes the blocks of a row
        }
    }

    void pushDown(int row) {
        for (int r = row; r >= 0; r--) {
            for (int c = 0; c < 11; c++) {
                java.util.List blocks = getObjectsAt(c, r, Block.class);
                if (blocks.size() > 0) {
                    Block block = (Block) blocks.get(0);
                    block.setLocation(block.getX(), block.getY() + 1);
                }
            }
        }
    }

    // checks whether the game has completed
    private void checkRunning() {
        for (int i = 0; i < 10; i++) {
            java.util.List l = getObjectsAt(1+i, 1, Block.class);
            if (l.size() > 1) {
                gameRunning = false;
                Greenfoot.stop();
                gameOver = true;
            }

        }
    }

}
