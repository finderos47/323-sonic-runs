import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Credits contiene una GreenfootImage que es la encargada de la imagen del boton creditos del escenario
 * En el actua pregunta si se esta presionando este boton, si es verdadero entonces manda un mensaje a la superclase
 * de que cambie su valor de false a true.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
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
