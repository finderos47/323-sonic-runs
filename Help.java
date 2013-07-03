import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Help here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Help extends Button
{
    private GreenfootImage image;

    /**
     * Constructor de la clase Help
     * Lee una imagen para despues escalarla y mostrarla.
     */
    public Help()
    {
        image = new GreenfootImage("help.png");
        image.scale(90,90);
        setImage(image);
    }

    /**
     * Act - do whatever the Help wants to do. This method is called whenever
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
