import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Button
{
    private GreenfootImage image;
    
    /**
     * Constructor de la clase Play
     * Lee una imagen para despues interactuar con ella.
     */
    public Play()
    {
        image = new GreenfootImage("play.png");
        image.scale(150,100);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mousePressed(this))
        {
            super.setPressed(true);
        }
    } 
}
