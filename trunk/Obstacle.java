import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * La clase Obstacle contiene un constructor con una medida para los obstaculos.
 * Contiene diferentes metodos para acceder a las medidas del obstaculo, restar vidas al jugador si ha tocado 
 * algun obstaculo, y mandarle un mensaje al jugador goHome que le hace que se mueva hacia otro lado ya que ha tocado 
 * un obstaculo.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Obstacle extends Actor
{
    private int size;

    /**
     * Constructor de la clase Obstacle
     * @param aSize recibe una medida del obstaculo y despues lo asigna a size.
     */
    public Obstacle(int aSize)
    {
        size = aSize;
    }

    /**
     * Act - do whatever the Obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

    }

    /**
     * @return size que es la medida de la imagen de la clase Obstacle.
     */
    public int getSize()
    {
        return size;
    }

    /**
     * @param aSize recibe una medida y la asiga a size.
     */
    public void setSize(int aSize)
    {
        size = aSize;
    }

    /**
     * Busca a un objeto de la clase Counter, despues le suma un numero negativo a las vidas
     * y despues usa el metodo goHome
     */
    public void leftLives()
    {        
        java.util.List lives = getWorld().getObjects (Counter.class);
        ((Counter)(lives.get(0))).add(-1);
        this.goHome();        
    }

    /**
     * Busca a un objeto de la clase Player, si lo encuentra entonces lo manda a una cierta localizacion.
     */
    private void goHome()
    {
        Player sonic = (Player)(((getWorld().getObjects (Player.class)).get(0)));
        sonic.setLocation (getX(), 100 );
        sonic.setIsJumping(false);
    }

    /**
     * Mueve al objeto de la clase Obstacle hacia la izquierda, si sale del escenario
     * entonces se remueve.
     */
    public void moveObstacle()
    {
        setLocation(getX() - ((Pista)getWorld()).getVScroll() , getY());
        if ( 0 >= getX() )
        {
            getWorld().removeObject(this);
        }
    }
}

