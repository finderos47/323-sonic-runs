import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La clase Wall contiene una GreenfootImage que es la encargada de la imagen del muro de tipo Obstaculo.
 * En el actua utiliza los metodos de la superclase Obstacle como el movimiento, y el checar si esta tocando
 * este obstaculo el jugador.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Wall extends Obstacle
{
    private GreenfootImage wall;

    /**
     * Constructor de la clase Wall
     * @param aSize recibe una medida para el objeto
     * Lee la imagen de la barda y despues la escala.
     */
    public Wall(int aSize)
    {
        super(aSize);
        int size = getSize();
        wall = new GreenfootImage("barda1.png");
        wall.scale(size,size);
        setImage(wall);
    }

    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.moveObstacle();
        this.checkIsTouching();
    }    

    /**
     * Checa si esta tocando a un objeto de la clase Player, si esta tocando
     * entonces manda llamar al metodo leftLives de la superclase.
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
