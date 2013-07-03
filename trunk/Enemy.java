import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Enemy here.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Enemy extends Element
{
    private int sizeW;
    private int sizeH;

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 

    /**
     * Realiza el movimiento de un objeto de la clase Enemy y si llega a
     * la orilla izquierda del escenario se remueve.
     */
    public void moveEnemy()
    {
        setLocation (getX() - ((Pista)getWorld()).getVScroll(), getY());
        if ( 0 >= getX() )
        {
            getWorld().removeObject(this);
        }
    }

    /**
     * Resta vidas a un objeto de clase Counter, que es el que lleva la cuenta
     * de cuantas vidas tiene el jugador.
     * Y despues de restarle vida, utiliza el metodo goHome().
     */
    public void leftLives()
    {        
        java.util.List lives = getWorld().getObjects (Counter.class);
        ((Counter)(lives.get(0))).add(-1);
        this.goHome();        
    }

    /**
     * Busca a un objeto de la clase Player y lo mueve a una
     * cierta localizacion.
     */
    private void goHome()
    {
        Player sonic = (Player)(((getWorld().getObjects (Player.class)).get(0)));
        sonic.setLocation (getX(), 100 );
        sonic.setIsJumping(false);  
    }

    /**
     * Indica cual es la medida de la imagen, el alto y el ancho.
     */
    public void setSize(int aWidth, int aHeight)
    {
        sizeW = aWidth;
        sizeH = aHeight;
    }

    /**
     * @return sizeW la medida del ancho de la imagen
     */
    public int getSizeW()
    {
        return sizeW;
    }

    /**
     * @return sizeH que es la medida de la altura de la imagen
     */
    public int getSizeH()
    {
        return sizeH;
    }
}
