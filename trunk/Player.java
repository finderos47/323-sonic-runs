import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList; // Para escalar las imagenes del jugador

/**
 * Write a description of class Player here.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Player extends Element
{
    private GreenfootImage imagesSonic[];
    private GifImage standByImage;
    private GifImage sonicRunLeft;
    private GreenfootImage sonicFall;
    private int numImagen;
    private boolean doAnything = true;
    private boolean dirLeft = false;

    /**
     * Constructor de la clase Player:
     * 
     * Lee las imagenes necesarias para los movimientos derecha, izquierda y fase de espera.
     * 
     * Inicializa numImagen en 0, sirve para cambiar de imagen al jugador.
     * 
     * utiliza el metodo setForceJump para inicializar la fuerza de salto del jugador.
     */
    public Player()
    {
        numImagen = 0;
        imagesSonic = new GreenfootImage[8];
        super.setForceJump(10); 
        for (int i = 0; i < imagesSonic.length ; i++)
        {
            imagesSonic[i] = new GreenfootImage("sonic_" + i + ".png");
            imagesSonic[i].scale(100,100);
        }

        standByImage = new GifImage("sonicstandbygif.gif");
        java.util.ArrayList array = (ArrayList)standByImage.getImages();

        for (int i=0; i < array.size(); i++)
        {
            GreenfootImage temp = (GreenfootImage) array.get(i);
            temp.scale(80,80);
        }

        sonicRunLeft = new GifImage("sonicrunleft.gif");
        java.util.ArrayList array2 = (ArrayList)sonicRunLeft.getImages();
        for (int i=0; i < array2.size(); i++)
        {
            GreenfootImage temp = (GreenfootImage) array2.get(i);
            temp.scale(100,100);
        }

        sonicFall = new GreenfootImage("sonicfall.png");
        sonicFall.scale(90,90);

        setImage( standByImage.getCurrentImage() );        
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.checkOnGround();
        this.checkKey();

        if ( ((Pista)getWorld()).getVScroll() == 0)
            doAnything = true;
        else doAnything = false;

        if (!doAnything && !dirLeft)
        {
            numImagen = (numImagen + 1) % imagesSonic.length;        
            setImage( imagesSonic[numImagen] );
        }

        if (dirLeft && !doAnything)
        {
            setImage( sonicRunLeft.getCurrentImage());
            if ( ((Pista)getWorld()).getVScroll() > 0) 
                ((Pista)getWorld()).setVScroll(-1);
        }

        if (doAnything && !super.getIsJumping())
            setImage( standByImage.getCurrentImage());

        if ( super.getIsJumping())            
            setImage( sonicFall );

        Greenfoot.delay(2);
    }    

    /**
     * Determina cual tecla esta presionada
     */
    public void checkKey()
    {
        if (Greenfoot.isKeyDown("right"))
        {
            if ( ((Pista)getWorld()).getVScroll() < 30)
            {
                doAnything = false;
                dirLeft = false;
                setLocation( getX() + 4, getY() );
                ((Pista)getWorld()).setVScroll(1);
            }
        }

        if (Greenfoot.isKeyDown("left"))
        {
            doAnything = false;
            dirLeft = true;
            if ( ((Pista)getWorld()).getVScroll() != 0)
                setLocation( getX() - 4, getY());
        }

        if (! super.getIsJumping() )
        {
            if (Greenfoot.isKeyDown("up"))
            {
                super.jump();
                super.setIsJumping (true);
            }
        }            
    }
}

