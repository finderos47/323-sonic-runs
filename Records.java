import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Records contiene una GreenfootImage que es la encargada de la imagen del boton records del escenario.
 * Si se presiono entonces cambia su valor de false a true, con un mensaje a la superclase.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Records extends Button
{
    GreenfootImage image;
    
    /**
     * Constructor de la clase Records
     * Lee una imagen y despues la escala.
     */
    public Records()
    {
        image = new GreenfootImage ("records.jpg");
        image.scale(110, 80);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Records wants to do. This method is called whenever
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
