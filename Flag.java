import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flag extends Actor
{
    GreenfootImage image;
    Mensaje mensaje;

    /**
     * Constructor de la clase Flag
     * @param aMassage recibe una cadena para ponerla como mensaje
     * junto con una imagen escalada.
     */
    public Flag(String aMassage)
    {
        image = new GreenfootImage("flag.png");
        image.scale(100,100);
        setImage (image);
        mensaje = new Mensaje(aMassage, 50, -20);
    }

    /**
     * Act - do whatever the Flag wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getWorld()!=null)
            moveFlag();
        if (mensaje.getWorld() != null)
            mensaje.setLocation(getX(),getY()-20);
    }    

    /**
     * redefinicion el metodo
     */
    protected void addedToWorld(World world) 
    {
        getWorld().addObject(mensaje, getX() - 50, getY()-50);
    }

    /**
     * Mueve la bandera y el mensaje hacia la izquierda.
     * hasta que desaparecen
     */
    public void moveFlag()
    {
        setLocation(getX() - ((Pista)getWorld()).getVScroll() , getY());
        if ( 0 >= getX() )
        {
            getWorld().removeObject(mensaje);
            getWorld().removeObject(this);

        }
    }
}
