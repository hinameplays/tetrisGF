/**
 * Write a description of class Target here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Target extends Special 
{
    // instance variables - replace the example below with your own
    private int x;
    private String attachedFile;

    /**
     * Constructor for objects of class Target
     */
    public Target()
    {
    }
    public String getFile() {
        if (attachedFile!= null) {
            return attachedFile;
        } else {return null;}
    }
}
