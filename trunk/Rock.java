import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Roca here.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Rock extends Obstacle
{
    private GreenfootImage rock;

    /**
     * Constructor de la clase Rock.
     * @param aSize recibe una medida de la roca para despues escalarla
     * a esa medida.
     */
    public Rock(int aSize)
    {
        super(aSize);
        int size = getSize();
        rock = new GreenfootImage("rock.png");
        rock.scale(size,size);
        setImage(rock);
    }

    /**
     * Act - do whatever the Roca wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {      
        super.moveObstacle();
        this.checkIsTouching();
    }

    /**
     * Checa si esta tocando a un objeto de la clase Player, si lo esta tocando
     * entonces llama al metodo leftLives de la clase padre.
     */
    public void checkIsTouching()
    {
        if (getWorld() != null)
        {
            java.util.List players = getObjectsInRange( rock.getWidth() , Player.class );

            if (!players.isEmpty())
            {
                super.leftLives();
            }
        }
    }
}
