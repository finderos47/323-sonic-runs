import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Play contiene una GreenfootImage que es la encargada de la imagen del boton play del juego.
 * En actua pregunta si se esta tocando este boton, si es verdadero entonces cambia su valor pressed
 * que heredo de la clase Button en verdadero, sino, entonces no hace nada ya que por defaul esta en pressed = false.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
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
