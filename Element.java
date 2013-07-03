import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Element here.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Element extends Actor
{
    private int forceJump;
    private boolean isJumping = false;
    private int vSpeed = 0;
    private int ground = 355;
    private int aceleracion = 2;

    /**
     * Constructor de la clase Element.
     * Inicializa forceJump en 0 para que no tenga fuerza de salto en un inicio.
     */
    public Element()
    {
        forceJump = 0;
    }

    /**
     * Act - do whatever the Element wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    

    /**
     * @return forceJump es el valor de la fuerza de salto.
     */
    public int getForceJump()
    {
        return forceJump;
    }

    /**
     * si vSpeed es positiva entonces pareciera que el jugador cae.
     * si vSpeed es negativa entonces pareciera que esta saltando.
     */
    public void fall()
    {
        setLocation( getX() , getY() + vSpeed);
        vSpeed+=aceleracion;
    }

    /**
     * Checa si esta en el suelo, si es verdadero entonces deja de caer, 
     * de lo contrario sigue cayendo.
     */
    public void checkOnGround()
    {
        if ( onGround() )
        {
            vSpeed = 0;
            isJumping = false;
        }
        else
            fall();
    }

    /** 
     * Determina si esta en el suelo o no.
     */
    public boolean onGround()
    {
        if ( getY() < ground)
            return false;
        return true;
    }

    /**
     * Con un valor negativo pareciera que esta subiendo el jugador.
     */
    public void jump()
    {
        vSpeed = -forceJump;
        fall();        
    }

    /**
     * @param aNumber tiene que ser positivo para darle un valor a forceJump
     * que es la fuerza de salto.
     */
    public void setForceJump(int aNumber)
    {
        forceJump = aNumber;
    }

    /**
     * @param aValue puede ser true o false.
     */
    public void setIsJumping(boolean aValue)
    {
        isJumping = aValue;
    }

    /**
     * @return isJumping que indica si esta saltando o no el objeto de la clase Element.
     */
    public boolean getIsJumping()
    {
        return isJumping;
    }
}
