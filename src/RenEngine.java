import greenfoot.*;

/**
 * Write a description of class RenEngine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RenEngine  
{
    public static boolean focussed = false;

    static void spawnTet(){
        int type = Greenfoot.getRandomNumber(7);
        Listener w = Listener.getWorld();
        int x = Greenfoot.getRandomNumber(5)+4;
        
        switch (type) {
        
            case 0:
                //oBlock wird gespawnt
                Oblock Oblock1 = new Oblock();
                Oblock Oblock2 = new Oblock();
                Oblock Oblock3 = new Oblock();
                Oblock Oblock4 = new Oblock();
                w.addObject(Oblock1, x, 0);
                w.addObject(Oblock2, x, 1);
                w.addObject(Oblock3, x+1, 0);
                w.addObject(Oblock4, x+1, 1);
                
            case 1:
                //iBlock wird gespawnt
                Iblock Iblock1 = new Iblock();
                Iblock Iblock2 = new Iblock();
                Iblock Iblock3 = new Iblock();
                Iblock Iblock4 = new Iblock();
                w.addObject(Iblock1, x-1, 0);
                w.addObject(Iblock2, x, 0);
                w.addObject(Iblock3, x+1, 0);
                w.addObject(Iblock4, x+2, 0);
                
            case 2:
                //tBlock wird gespawnt
                Tblock Tblock1 = new Tblock();
                Tblock Tblock2 = new Tblock();
                Tblock Tblock3 = new Tblock();
                Tblock Tblock4 = new Tblock();
                w.addObject(Tblock1, x-1, 0);
                w.addObject(Tblock2, x, 0);
                w.addObject(Tblock3, x+1, 0);
                w.addObject(Tblock4, x, 1);
                
            case 3:
                //llBlock wird gespawnt
                LLblock LLblock1 = new LLblock();
                LLblock LLblock2 = new LLblock();
                LLblock LLblock3 = new LLblock();
                LLblock LLblock4 = new LLblock();
                w.addObject(LLblock1, x-1, 0);
                w.addObject(LLblock2, x-1, 1);
                w.addObject(LLblock3, x, 1);
                w.addObject(LLblock4, x+1, 1);
                
            case 4:
                //lrBlock wird gespawnt
                LRblock LRblock1 = new LRblock();
                LRblock LRblock2 = new LRblock();
                LRblock LRblock3 = new LRblock();
                LRblock LRblock4 = new LRblock();
                w.addObject(LRblock1, x-1, 1);
                w.addObject(LRblock2, x, 1);
                w.addObject(LRblock3, x+1, 1);
                w.addObject(LRblock4, x+1, 0);
                
            case 5:
                //zlBlock wird gespawnt
                ZLblock ZLblock1 = new ZLblock();
                ZLblock ZLblock2 = new ZLblock();
                ZLblock ZLblock3 = new ZLblock();
                ZLblock ZLblock4 = new ZLblock();
                w.addObject(ZLblock1, x-1, 0);
                w.addObject(ZLblock2, x, 0);
                w.addObject(ZLblock3, x, 1);
                w.addObject(ZLblock4, x+1, 1);
                
            case 6:
                //zrBlock wird gespawnt
                ZRblock ZRblock1 = new ZRblock();
                ZRblock ZRblock2 = new ZRblock();
                ZRblock ZRblock3 = new ZRblock();
                ZRblock ZRblock4 = new ZRblock();
                w.addObject(ZRblock1, x-1, 1);
                w.addObject(ZRblock2, x, 1);
                w.addObject(ZRblock3, x, 0);
                w.addObject(ZRblock4, x+1, 0);
                
            default:
                Greenfoot.stop();
            
        }
    }
        
        
    public static void run() {
        while (Listener.on) {
            if(!focussed) {
                spawnTet();
            }
        }
    }
}

