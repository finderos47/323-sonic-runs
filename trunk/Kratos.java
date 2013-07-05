import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * La clase Kratos contiene una GifImage que es la encargada de la imagen del enemigo kratos,
 * que aparece en el primer nivel del juego.
 * Heredo metodos del movimiento y checar si esta tocando al jugador.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Kratos extends Enemy
{
    private GifImage image;

    /**
     * Constructor de la clase Kratos
     * 
     * Carga la imagen del personaje Kratos y despues escalarla a un cierto tamaño.
     * Y muestra la primera imagen del gif. 
     * 
     */
    public Kratos()
    {
        image = new GifImage ("kratosgif.gif");

        java.util.ArrayList array = (ArrayList)image.getImages();
        for (int i=0; i < array.size(); i++)
        {
            GreenfootImage temp = (GreenfootImage) array.get(i);
            temp.scale(70,120);
        }

        setImage( image.getCurrentImage() );     
        super.setForceJump(5);
    }

    /**
     * Act - do whatever the Kratos wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage( image.getCurrentImage() );
        this.checkIsTouching();
        super.moveEnemy();
    }    

    /**
     * Determina si esta tocando a un objecto de la clase Player, si lo encuentra entonces le resta vidas.
     */
    public void checkIsTouching()
    {
        if (getWorld() != null)
        {
            java.util.List players = getObjectsInRange( (image.getCurrentImage().getWidth())/2 , Player.class );
            if ( !players.isEmpty() )
            {            
                super.leftLives();            
            }
        }
    }
}
