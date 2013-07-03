import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Credits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credits extends Button
{
    private GreenfootImage image;
    
    /**
     * 
     */
    public Credits()
    {
        image = new GreenfootImage ("buttoncredits.jpg");
        image.scale(110,80);
        setImage (image);
    }
    
    /**
     * Act - do whatever the Credits wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if ( Greenfoot.mousePressed(this))
        {
            super.setPressed(true);
        }
    }    
}
