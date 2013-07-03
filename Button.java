import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Button extends Actor
{
    private boolean pressed;
    
    /**
     * Constructor de la clase Button
     * Inicializa pressed en false, que es si esta presionado un boton o no.
     */
    public Button()
    {
        pressed = false;
    }
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    
    /**
     * Remueve un objeto de la clase Button
     */
    public void remove()
    {
        if (this.getWorld() != null)
         getWorld().removeObject(this);
    }
    
    /**
     * Cambia el valor de pressed.
     * @param isPressed es booleano.
     */
    public void setPressed(boolean isPressed)
    {
        pressed = isPressed;
    }
    
    /**
     * Determina si esta presionado o no un boton.
     * @return pressed que es booleano.
     */
    public boolean getPressed()
    {
        return pressed;
    }
}
