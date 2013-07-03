import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lives extends Actor
{
    GreenfootImage image;

    /**
     * Constructor de la clase Lives
     * Carga una imagen, la escala y enseguida la muestra.
     */
    public Lives()
    {
        image = new GreenfootImage("corazon.png");
        image.scale(60,60);
        setImage(image);
    }

    /**
     * Act - do whatever the Lives wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.moveLives();
        if (getWorld() != null)
            this.checkIsTouching();
    }  

    /**
     * Determina si esta tocando a un objecto de la clase Player, si lo encuentra entonces le suma una vida.
     */
    public void checkIsTouching()
    {
        if (getWorld() != null)
        {
            java.util.List players = getObjectsInRange( image.getWidth() , Player.class );

            if ( !players.isEmpty() )
            {
                java.util.List lives = getWorld().getObjects (Counter.class);
                ((Counter)(lives.get(0))).add(1);

                getWorld().removeObject(this);
            }
        }
    }

    /**
     * Mueve el objeto de la clase Bonus
     */
    public void moveLives()
    {
        setLocation( getX() - ((Pista)getWorld()).getVScroll(), getY() );
        if ( getX() < (image.getWidth())/2 )
        {
            getWorld().removeObject(this);
        }
    }
}
