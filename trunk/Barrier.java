import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barrier here.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Barrier extends Obstacle
{
    /**
     * Constructor de la clase Barrier
     * Por default el tamaño sera de 30 para posteriormente
     * escalarla a ese tamaño.
     */
    public Barrier()
    {
        super(30);        
    }

    /**
     * Act - do whatever the Barrier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.moveObstacle();
        this.checkIsTouching();
    }    

    /**
     * Checa si esta tocando a un objeto de la clase Player, si lo toca entonces
     * llama al metodo leftLives de la super clase.
     */
    public void checkIsTouching()
    {
        if (getWorld() != null)
        {
            java.util.List players = getNeighbours( this.getSize() , true, Player.class);
            if ( !players.isEmpty() )
            {            
                super.leftLives();            
            }
        }
    }
}
