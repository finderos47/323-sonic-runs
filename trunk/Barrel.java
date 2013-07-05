import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Barrel contiene no contiene variables, depende de su imagen de fondo que fue seleccionada con setImage cuando se 
 * creo esta clase, se toma la imagen y se escala a un tamaño.
 * Heredo los metodos del movimiento del obstaculo y de checar que si toca a un objeto de la clase Player.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Barrel extends Obstacle
{
    /**
     * Constructor de la clase Barrel
     * Toma la imagen que tiene y enseguida la escala y la muestra en pantalla.
     */
    public Barrel()
    {
        super(30);
        getImage().scale(100,100);
    }
    
    /**
     * Act - do whatever the Barrel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.moveObstacle();
        this.checkIsTouching();
    }    
    
    /**
     * Checa si un objecto de la clase Player toca a este objecto de la clase Barrel
     * Si lo toca entonces le quita una vida.
     */
    public void checkIsTouching()
    {
        if (getWorld() != null)
        {
            java.util.List players = getObjectsInRange( getImage().getWidth()/2 , Player.class );
            if (!players.isEmpty())
            {
                super.leftLives();
            }
        }
    }
}
