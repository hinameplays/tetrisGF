import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * this makes blocks, structures; and can destroy them;
 * also does key input processing
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Structure extends Actor
{
    private List<Block> StructureBlocks;
    public boolean fallable=true;
    
    private int KeyCooldown = 30; // The amount of act-cycles before the autorepeating starts
    private int AutoRepeatSpeed = 10; // The amount of act-cycles it takes for a piece to autoshift with DAS.
    private int AutoRepeatSpeedDownOriginal = 5; // Drop Button is faster than piece shifting.
    
    private boolean KeyStorageLeft = false, KeyStorageRight = false, KeyStorageDown = false, KeyStorageUp = false; // Helper variables for Key Cooldown and Repeating
    private int KeyCooldownLeft = KeyCooldown, KeyCooldownRight = KeyCooldown, KeyCooldownDown = KeyCooldown, KeyCooldownUp = KeyCooldown; 
    private int AutoRepeatSpeedUp = AutoRepeatSpeed, AutoRepeatSpeedLeft = AutoRepeatSpeed, AutoRepeatSpeedRight = AutoRepeatSpeed, AutoRepeatSpeedDown = AutoRepeatSpeedDownOriginal;
    /*
     * These Settings are needed for an Authentic NES Tetris Feel, which this game is trying to replicate.
     * They may be tweaked to the users liking for hypertap-emulation.
     * Lookup specific code explanations to get a better understanding of how Tetris was designed around these
     */
    
    private int BlockFallTimer = 60, Score = 0;
    
    private List<Block> CurrentBlocks = new ArrayList<Block>(); //Stores all moving Blocks
    
    public void playerInputs() { // This input implementation replicates the Nintendo NES Tetris piece movement DAS mechanics.
        
        if (Greenfoot.isKeyDown("UP")) {
            if (!KeyStorageUp) {
                rotate();
                KeyStorageUp = true; // Set this to true for DAS cooldown
            } else if (KeyCooldownUp == 0) {
                if (AutoRepeatSpeedUp == 0) {
                    rotate();
                    AutoRepeatSpeedUp = AutoRepeatSpeed;
                } else { AutoRepeatSpeedUp--; }
            } else {
                KeyCooldownUp--;
            }
        } else { // Reset all repeating counters
            KeyStorageUp = false;
            KeyCooldownUp = KeyCooldown; 
            AutoRepeatSpeedUp = AutoRepeatSpeed;
        }
        
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
                    AutoRepeatSpeedDown = AutoRepeatSpeedDownOriginal;
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
        boolean leftable = true;
        for (Block b : CurrentBlocks) {
            if (!b.canGoLeft(CurrentBlocks)) {
                leftable = false;
            } 
        } // Go left, dont do anything else.
        
        if (leftable) {
            for (Block b : CurrentBlocks) {
                b.goLeft(CurrentBlocks);
            }
        }
    }
           
    private void shiftAllRight() {
        boolean rightable = true;
        for (Block b : CurrentBlocks) {
            if (!b.canGoRight(CurrentBlocks)) {
                rightable=false;
            }
        }// Go right, dont do anything else.
        
        if (rightable) {
            for (Block b : CurrentBlocks) {
                b.goRight(CurrentBlocks);
            }
        }
    }
    
    private void fallOnce() {
        
        try {
            for (Block b : CurrentBlocks) {
                if (!b.canFall(CurrentBlocks)) {
                    fallable = false;
                }
                    
            }
            for (Block b : CurrentBlocks) {
                if (!fallable) {
                    ((TetrisScreen)getWorld()).saveStaticBlock(b);
                    CurrentBlocks.remove(b);
                } else {
                    b.fall(CurrentBlocks);
                }
            }
        } catch (Exception e) {
            while (true) {
                try{
                    for (Block b : CurrentBlocks) {
                    
                        ((TetrisScreen)getWorld()).saveStaticBlock(b);
                        CurrentBlocks.remove(b);
                    
                    }
                    break;
                } catch (Exception g) {}
            }
        }
        
    }

    public void blockFalling() {
        BlockFallTimer--;
        if (BlockFallTimer == 0) {
            fallOnce();
            BlockFallTimer = 60;
        } 
        getWorld().showText(String.valueOf(BlockFallTimer),3,3);
    }
    
    public List<Block> getCurrentBlocks() {
        return CurrentBlocks;
    }
    
    public void spawnStructure() {
        int type = Greenfoot.getRandomNumber(7);
        StructureBlocks = getSpawnList(type);
        //System.out.println(StructureBlocks);
        CurrentBlocks.clear();
        for (Block b : StructureBlocks) {
            CurrentBlocks.add(b);
            getWorld().addObject(b,b.getInitX(), b.getInitY());
        }
    }
    
    private void rotate() {
        
        Block h = CurrentBlocks.get(0);
        Block j = CurrentBlocks.get(1);
        Block k = CurrentBlocks.get(2);
        Block l = CurrentBlocks.get(3);
        
        int t = CurrentBlocks.get(0).type;
        
        
            
        if (t==1) { // i block
                //depending on previous rotation, turn 90 degrees
                //k is root -> not to be changed
            if(h.orientation == 1){
                h.setLocation(h.rootX, h.rootY-2);
                j.setLocation(j.rootX, j.rootY-1);
                k.setLocation(k.rootX, k.rootY);
                l.setLocation(l.rootX, l.rootY+1);
            } else if(h.orientation == 2){
                h.setLocation(h.rootX+2, h.rootY);
                j.setLocation(j.rootX+1, j.rootY);
                k.setLocation(k.rootX, k.rootY);
                l.setLocation(l.rootX-1, l.rootY);
            } else if(h.orientation == 3){
                h.setLocation(h.rootX, h.rootY+2);
                j.setLocation(j.rootX, j.rootY+1);
                k.setLocation(k.rootX, k.rootY);
                l.setLocation(l.rootX, l.rootY-1);
            } else if(h.orientation == 4) {
                h.setLocation(h.rootX-2, h.rootY);
                j.setLocation(j.rootX-1, j.rootY);
                k.setLocation(k.rootX, k.rootY);
                l.setLocation(l.rootX+1, l.rootY);
            }
            
        } else if (t==2) { // j block, j is root
            if(h.orientation == 1){
                h.setLocation(h.rootX+1, h.rootY);
                j.setLocation(j.rootX, j.rootY);
                k.setLocation(k.rootX, k.rootY+1);
                l.setLocation(l.rootX, l.rootY+2);
            } else if(h.orientation == 2){
                h.setLocation(h.rootX, h.rootY+1);
                j.setLocation(j.rootX, j.rootY);
                k.setLocation(k.rootX-1, k.rootY);
                l.setLocation(l.rootX-2, l.rootY);
            } else if(h.orientation == 3){
                h.setLocation(h.rootX-1, h.rootY);
                j.setLocation(j.rootX, j.rootY);
                k.setLocation(k.rootX, k.rootY-1);
                l.setLocation(l.rootX, l.rootY-2);
            } else if(h.orientation == 4) {
                h.setLocation(h.rootX, h.rootY-1);
                j.setLocation(j.rootX, j.rootY);
                k.setLocation(k.rootX+1, k.rootY);
                l.setLocation(l.rootX+2, l.rootY);
            }
        } else if (t==3) { // l block, l is root
            if(h.orientation == 1){
                h.setLocation(h.rootX+1, h.rootY);
                j.setLocation(j.rootX, j.rootY);
                k.setLocation(k.rootX, k.rootY-1);
                l.setLocation(l.rootX, l.rootY-2);
            } else if(h.orientation == 2){
                h.setLocation(h.rootX, h.rootY+1);
                j.setLocation(j.rootX, j.rootY);
                k.setLocation(k.rootX+1, k.rootY);
                l.setLocation(l.rootX+2, l.rootY);
            } else if(h.orientation == 3){
                h.setLocation(h.rootX-1, h.rootY);
                j.setLocation(j.rootX, j.rootY);
                k.setLocation(k.rootX, k.rootY+1);
                l.setLocation(l.rootX, l.rootY+2);
            } else if(h.orientation == 4) {
                h.setLocation(h.rootX, h.rootY-1);
                j.setLocation(j.rootX, j.rootY);
                k.setLocation(k.rootX-1, k.rootY);
                l.setLocation(l.rootX-2, l.rootY);
            }
            //condition four (o block) is jumped, because turning doesn't yield anything
        } else if (t==5) { // s block, h is root
            if(h.orientation == 1){
                h.setLocation(h.rootX, h.rootY);
                j.setLocation(j.rootX, j.rootY+1);
                k.setLocation(k.rootX-1, k.rootY-1);
                l.setLocation(l.rootX-1, l.rootY);
            } else if(h.orientation == 2){
                h.setLocation(h.rootX, h.rootY);
                j.setLocation(j.rootX-1, j.rootY);
                k.setLocation(k.rootX+1, k.rootY-1);
                l.setLocation(l.rootX, l.rootY-1);
            } else if(h.orientation == 3){
                h.setLocation(h.rootX, h.rootY);
                j.setLocation(j.rootX, j.rootY-1);
                k.setLocation(k.rootX+1, k.rootY+1);
                l.setLocation(l.rootX+1, l.rootY);
            } else if(h.orientation == 4) {
                h.setLocation(h.rootX, h.rootY);
                j.setLocation(j.rootX+1, j.rootY);
                k.setLocation(k.rootX-1, k.rootY+1);
                l.setLocation(l.rootX, l.rootY+1);
            }
        } else if (t==6) { // t block, l is root
            if(h.orientation == 1){
                h.setLocation(h.rootX+1, h.rootY);
                j.setLocation(j.rootX, j.rootY+1);
                k.setLocation(k.rootX, k.rootY-1);
                l.setLocation(l.rootX, l.rootY);
            } else if(h.orientation == 2){
                h.setLocation(h.rootX, h.rootY+1);
                j.setLocation(j.rootX-1, j.rootY);
                k.setLocation(k.rootX+1, k.rootY);
                l.setLocation(l.rootX, l.rootY);
            } else if(h.orientation == 3){
                h.setLocation(h.rootX-1, h.rootY);
                j.setLocation(j.rootX, j.rootY-1);
                k.setLocation(k.rootX, k.rootY+1);
                l.setLocation(l.rootX, l.rootY);
            } else if(h.orientation == 4) {
                h.setLocation(h.rootX, h.rootY-1);
                j.setLocation(j.rootX+1, j.rootY);
                k.setLocation(k.rootX-1, k.rootY);
                l.setLocation(l.rootX, l.rootY);
            }
        } else if (t==7) { // z block, l is root
            if(h.orientation == 1){
                h.setLocation(h.rootX-1, h.rootY);
                j.setLocation(j.rootX-1, j.rootY+1);
                k.setLocation(k.rootX, k.rootY-1);
                l.setLocation(l.rootX, l.rootY);
            } else if(h.orientation == 2){
                h.setLocation(h.rootX, h.rootY-1);
                j.setLocation(j.rootX-1, j.rootY-1);
                k.setLocation(k.rootX+1, k.rootY);
                l.setLocation(l.rootX, l.rootY);
            } else if(h.orientation == 3){
                h.setLocation(h.rootX+1, h.rootY);
                j.setLocation(j.rootX+1, j.rootY-1);
                k.setLocation(k.rootX, k.rootY+1);
                l.setLocation(l.rootX, l.rootY);
            } else if(h.orientation == 4) {
                h.setLocation(h.rootX, h.rootY+1);
                j.setLocation(j.rootX+1, j.rootY+1);
                k.setLocation(k.rootX-1, k.rootY);
                l.setLocation(l.rootX, l.rootY);
            }
        }
        if (h.orientation == 4) {
            h.orientation = 1;
            j.orientation = 1;
            k.orientation = 1;
            l.orientation = 1;
        } else {
            h.orientation++;
            j.orientation++;
            k.orientation++;
            l.orientation++;
        }
                
        CurrentBlocks.set(0, h);
        CurrentBlocks.set(1, j);
        CurrentBlocks.set(2, k);
        CurrentBlocks.set(3, l);
        
        checkLegal();
    }
     
    private void checkLegal() {
        for (Block b : CurrentBlocks) {
            if (b.getX()>11) {
                shiftAllLeft();
            } else if (b.getX()<2) {
                shiftAllRight();
            }
            if (b.getY()>24) {
                //do noting yet                
            }
        }
    }
    
    
    private List<Block> getSpawnList(int StructureNumber) {
        List<Block> BlockList = new ArrayList<Block>();
        switch (StructureNumber) { //switch  based on RNG from upward
            case 0: // i block
                BlockList.add(new Block(4,1,1,5,1));
                BlockList.add(new Block(5,1,1,5,1));
                BlockList.add(new Block(6,1,1,5,1));
                BlockList.add(new Block(7,1,1,5,1));
                break;
            case 1: // j block
                BlockList.add(new Block(5,1,2,5,2));
                BlockList.add(new Block(5,2,2,5,2));
                BlockList.add(new Block(6,2,2,5,2));
                BlockList.add(new Block(7,2,2,5,2));
                break;
            case 2: // l block
                BlockList.add(new Block(7,1,3,7,2));
                BlockList.add(new Block(5,2,3,7,2));
                BlockList.add(new Block(6,2,3,7,2));
                BlockList.add(new Block(7,2,3,7,2));
                break;
            case 3: // owo block
                BlockList.add(new Block(5,1,4,5,1));
                BlockList.add(new Block(5,2,4,5,1));
                BlockList.add(new Block(6,1,4,5,1));
                BlockList.add(new Block(6,2,4,5,1));
                break;
            case 4: // s block
                BlockList.add(new Block(6,1,5,6,1));
                BlockList.add(new Block(7,1,5,6,1));
                BlockList.add(new Block(5,2,5,6,1));
                BlockList.add(new Block(6,2,5,6,1));
                break;
            case 5: // t block
                BlockList.add(new Block(6,1,6,6,2));
                BlockList.add(new Block(7,2,6,6,2));
                BlockList.add(new Block(5,2,6,6,2));
                BlockList.add(new Block(6,2,6,6,2));
                break;
            case 6: // z block
                BlockList.add(new Block(6,2,7,6,1));
                BlockList.add(new Block(7,2,7,6,1));
                BlockList.add(new Block(5,1,7,6,1));
                BlockList.add(new Block(6,1,7,6,1));
                break;
            default: // just an extra i block, thats always good. Ofc this should never happen, but does, tf?
                BlockList.add(new Block(4,1,1,5,1));
                BlockList.add(new Block(5,1,1,5,1));
                BlockList.add(new Block(6,1,1,5,1));
                BlockList.add(new Block(7,1,1,5,1));
                break;
        }
        //System.out.println(BlockList); //debug statement, enable if wrong things get spawned
        return BlockList;
    }
}
