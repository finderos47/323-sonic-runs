import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Back here.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Back extends Button
{
    private GreenfootImage image;
    
    /**
     * Constructor de la clase Back
     * Lee una imagen para despues escalarla y mostrarla.
     */
    public Back()
    {
        image = new GreenfootImage("back.png");
        image.scale (100,100);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Back wants to do. This method is called whenever
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
