import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IOdin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IOdin extends Odin
{
    boolean orientation = true; //save memory kids, use bools; true |; false --
    
    public IOdin() {
        orientation = false;
    }
    
    void split() {
        Listener w = Listener.getWorld();
        Iblock i1 = new Iblock();
        Iblock i2 = new Iblock();
        Iblock i3 = new Iblock();
        Iblock i4 = new Iblock();
        if (this.orientation) {
            w.addObject(i1, this.getX(), this.getY()-37);
            w.addObject(i2, this.getX(), this.getY()-12);
            w.addObject(i3, this.getX(), this.getY()+13);
            w.addObject(i4, this.getX(), this.getY()+38);
        } else {
            w.addObject(i1, this.getX()-37, this.getY());
            w.addObject(i2, this.getX()-12, this.getY());
            w.addObject(i3, this.getX()+13, this.getY());
            w.addObject(i4, this.getX()+38, this.getY());
        }
        w.removeObject(this);
        
    }
    
    public void rotate() {
        if (this.getY()>=75) {
            this.turn(90);
            if (this.getX()<55) {
                this.setLocation(this.getX()+50, this.getY());
            } else if (this.getX()>345) {
                this.setLocation(this.getX()+50, this.getY());                
            }
            Greenfoot.delay(2);
            orientation = !orientation;
        }
    }
    
    private void move(char dir) {
        switch(dir){
            case 'L':
                if(this.getX()>62) {
                    this.setLocation(this.getX()-25, this.getY());
                }
            case 'R':
                if(this.getX()<348) {
                    this.setLocation(this.getX()+25, this.getY());
                }
            case 'D':
                Actor a = getOneObjectAtOffset​(0, 25, null);
                if (a==null && this.getY()>545) {
                    this.setLocation(this.getX(), this.getY()+25);
                }
            default:
                
        }
    }
    
    public void act() 
    {
        if (Greenfoot.isKeyDown("up")||Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("down")) {
            if(Greenfoot.isKeyDown("up")){
                rotate();
                Greenfoot.delay(1);
            }
            if(Greenfoot.isKeyDown("left")){
                move('L');
                Greenfoot.delay(3);
            }
            if(Greenfoot.isKeyDown("right")){
                move('R');
                Greenfoot.delay(3);
            }
            if(Greenfoot.isKeyDown("down")){
                move('D');
                Greenfoot.delay(1);
            }
            
        } else { 
            fallStep += 1 + execTime/200; 
            execTime +=1; 
            Greenfoot.delay(1);
        }
        if (fallStep%5==0) {
            this.move('D');
        }
       
    }    
}
