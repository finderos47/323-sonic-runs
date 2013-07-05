import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * La clase Bonus contiene una GifImagen que es la encargada de la imagen del bonus de fuerza de salto,
 * desde esta clase se le manda un mensaje al Contador del mundo "force Jump" que aumente en una unidad.
 * 
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Bonus extends Actor
{
    private GifImage image;
    /**
     * Constructor de la clase Bonus
     * Carga un gif para despues escalarlo y mostrarlo en pantalla.
     */
    public Bonus()
    {
        image = new GifImage("ringgif.gif");

        java.util.ArrayList array = (ArrayList)image.getImages();
        for (int i=0; i < array.size(); i++)
        {
            GreenfootImage temp = (GreenfootImage) array.get(i);
            temp.scale(30,30);
        }

        setImage( image.getCurrentImage() );

    }

    /**
     * Act - do whatever the Bonus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {      
        if (getWorld() != null)
        {   setImage( image.getCurrentImage());

            this.moveBonus();
        }

        if (getWorld() != null)
            this.checkIsTouching();
    }

    /**
     * Determina si esta tocando a un objecto de la clase Player, si lo encuentra entonces le suma
     * fuerza de salto en una unidad.
     */
    public void checkIsTouching()
    {
        if (getWorld() != null)
        {
            java.util.List players = getObjectsInRange( image.getCurrentImage().getWidth() , Player.class );

            if ( !players.isEmpty() )
            {
                java.util.List forceJump = getWorld().getObjects (Counter.class);
                ((Counter)(forceJump.get(1))).add(1);

                Player sonic = (Player) players.get(0);
                sonic.setForceJump( sonic.getForceJump() + 1);

                getWorld().removeObject(this);
            }
        }
    }

    /**
     * Mueve el objeto de la clase Bonus
     */
    public void moveBonus()
    {
        setLocation( getX() - ((Pista)getWorld()).getVScroll(), getY() );
        if ( getX() < (image.getCurrentImage().getWidth())/2 )
        {
            getWorld().removeObject(this);
        }
    }
}
