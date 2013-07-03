import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Kratos here.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Adel extends Enemy
{
    private GifImage image;

    /**
     * Constructor de la clase Adel
     * Carga la imagen del gif del enemigo, enseguida la escala a una medida.
     */
    public Adel()
    {
        image = new GifImage ("adelgif.gif");

        java.util.ArrayList array = (ArrayList)image.getImages();
        for (int i=0; i < array.size(); i++)
        {
            GreenfootImage temp = (GreenfootImage) array.get(i);
            temp.scale(120,120);
        }

        
        setImage( image.getCurrentImage() );        
        super.setSize(image.getCurrentImage().getWidth(), image.getCurrentImage().getHeight());

    }

    /**
     * Act - do whatever the Kratos wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage( image.getCurrentImage() );
        super.moveEnemy();
        this.checkIsTouching();
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
