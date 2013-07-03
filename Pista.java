import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
//import java.util.*;

/**
 * Write a description of class Pista here.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Pista extends World
{
    private Counter lives;
    private Counter forceJump;
    private Counter distance;
    private Counter speed;
    private int vScroll;
    private int floor;
    private Player player;
    private Bonus bonus;
    private Rock rock;
    private Barrier barrier;
    private Wall wall;
    private Barrel barrel;
    private Adel adel;
    private Flag flag;
    private Lives life;
    private Kratos kratos;
    private Mensaje mensaje;
    private Play play;
    private Records records;
    private Help help;
    private Credits credits;
    private Back back;
    private boolean nivel1 = true;
    private boolean nivel2 = false;
    private boolean start = false;
    private boolean ayuda = false;
    private boolean rec = false;
    private boolean cred = false;
    private GreenfootImage recordsImage;
    private GreenfootImage helpImage;
    private GreenfootImage menuImage;
    private GreenfootImage creditsImage;

    /**
     * Constructor for objects of class Pista.
     * 
     */
    public Pista()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.

        super(800, 400, 1, true);
        play = new Play();
        records = new Records();
        help = new Help();
        credits = new Credits();
        back = new Back();
        floor = getHeight()-15;
        helpImage = new GreenfootImage ("helpsonic2.jpg");
        helpImage.scale(800,400);
        recordsImage = new GreenfootImage ("recsonic.jpg");
        recordsImage.scale(800,450);
        menuImage = new GreenfootImage ("menuimage.jpg");
        menuImage.scale(800,400);
        creditsImage = new GreenfootImage ("soniccredits2.jpg");
        creditsImage.scale(800,400);        
        flag = new Flag("Level 1, Luck!");
        rock = new Rock(35);
        bonus = new Bonus ();
        barrier = new Barrier ();
        adel = new Adel();
        life = new Lives();
        kratos = new Kratos();
        wall = new Wall(30);
        player = new Player();
        lives = new Counter("Lives= ");
        forceJump = new Counter ("Force Jump= ");
        distance = new Counter ("Distance= ");
        speed = new Counter ("Speed= ");
        barrel = new Barrel();
        setBackground ("menuimage.jpg");
        showMenu();
    }

    public void act()
    {
        if (!start)
            this.showMenu();

        if ( start )
        {
            speed.setValue(vScroll);

            if (vScroll != 0)
            {
                scrollWorld();
                distance.add( 1 );
            }

            if (nivel1)
                this.level1();
            if (nivel2)
                this.level2();

            if (0 >= lives.getValue() || distance.getValue() == 2000)
            {
                if ( 0 >= lives.getValue() )
                {
                    mensaje = new Mensaje("Game Over", 80, 0);
                }
                else mensaje = new Mensaje ("You Win!", 80, 0);
                
                UserInfo myInfo = UserInfo.getMyInfo();
                myInfo.setScore(distance.getValue());

                if (UserInfo.isStorageAvailable()) 
                   {
                       ArrayList array = (ArrayList)(UserInfo.getTop(10));
                       if ( !array.isEmpty())
                       {
                           for (int i =0; i < array.size(); i++)
                           {
                                if ( ((UserInfo)(array.get(i))).getScore() < myInfo.getScore())
                                {
                                    ((UserInfo)(array.get(i))).setInt(i, myInfo.getScore());
                                    ((UserInfo)(array.get(i))).setString(i, myInfo.getUserName());
                                    myInfo.store();
                                    break;
                                }
                           }

                        }else 
                        {   
                            Mensaje nada = new Mensaje( "Empty records", 50, 0);
                            addObject(nada, getWidth() /2, getHeight() /2);
                            myInfo.store();
                        }
                    }
                  

                if (distance.getValue() >= myInfo.getScore()) 
                {
                    myInfo.setScore(distance.getValue());
                    myInfo.store();
                }

                addObject (mensaje, getWidth() /2 , getHeight() / 2);
                Greenfoot.delay(6);
                cleanEscene();
                start = false;
                showMenu();
            }

        }
    }
    
    /**
     * Remueve todos los objetos del escenario que esten creados.
     */
    public void cleanEscene()
    {

        ArrayList array4 = (ArrayList) getObjects(Element.class);
        if (!array4.isEmpty())
        {
            for(int i=0; i< array4.size() ; i++)
                removeObject((Element)(array4.get(i))) ;
        }

        if (mensaje.getWorld() != null)
            removeObject(mensaje);

        if (bonus.getWorld() != null)
            removeObject(bonus);

        ArrayList array= (ArrayList)(getObjects(Counter.class) );
        if (! array.isEmpty())
        {
            for (int i = 0; i<array.size(); i++)
                removeObject ((Counter)(array.get(i)));
        }

        ArrayList array2 = (ArrayList)(getObjects(Obstacle.class) );
        if ( !array2.isEmpty())
        {
            for (int i = 0; i<array2.size(); i++)
                removeObject ((Obstacle)(array2.get(i)));
        }

        ArrayList array3 = (ArrayList)(getObjects(Enemy.class) );
        if ( !array3.isEmpty())
        {
            for (int i = 0; i<array3.size(); i++)
                removeObject ((Enemy)(array3.get(i)));
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        setBackground("forestloop.png");
        getBackground().scale(800,400);

        addObject(flag, getWidth()/2, getHeight()/2 );

        addObject(player, 120, floor - 30 );

        addObject(lives, 700, 50);

        forceJump.setValue(player.getForceJump());
        addObject(forceJump, 725, 90);

        addObject(distance, 710, 130);

        addObject(speed, 700, 172);

        addObject(wall, 710, floor - 5);

        vScroll = 0;
        distance.setValue(0);
        speed.setValue(0);
        forceJump.setValue(10);
        lives.setValue(3);

    }

    /**
     * Muestra el menu principal donde se escojera alguna opcion, pueden ser:
     * Creditos
     * Jugar
     * Records
     * Ayuda
     */
    public void showMenu()
    {
        buttonPressed();
        if (!start && !rec && !ayuda && !cred)
        {
            setBackground(menuImage);
            addObject(play, 78, 346);
            addObject(records, 206, 346);
            addObject(help, 316, 346);
            addObject(credits, 425, 346);
        }
        if (!rec && ayuda && !cred)
        {
            showHelp();
            if (back.getPressed())
            {
                ayuda = false;
                help.setPressed(false);
                back.setPressed(false);
                back.remove();
            }
        }
        if (rec && !ayuda && !cred)
        {
            showRecords();
            if (back.getPressed())
            {
                rec = false;
                records.setPressed(false);
                back.setPressed(false);
                back.remove();
                ArrayList array = (ArrayList)(getObjects(Mensaje.class) );
                if ( !array.isEmpty())
                {
                    for (int i = 0; i<array.size(); i++)
                        removeObject ((Mensaje)(array.get(i)));
                }
            }
        }
        if (!rec && !ayuda && cred)
        {
            showCredits();
            if (back.getPressed())
            {
                cred = false;
                credits.setPressed(false);
                back.setPressed(false);
                back.remove();
                ArrayList array = (ArrayList)(getObjects(Mensaje.class) );
                if ( !array.isEmpty())
                {
                    for (int i = 0; i<array.size(); i++)
                        removeObject ((Mensaje)(array.get(i)));
                }
            }
        }
        
    }
    
    /**
     * Muestra el escenario de Creditos
     */
    public void showCredits()
    {
        removeButtons();
        setBackground(creditsImage);
        if (back.getWorld() == null)
            addObject(back, 606, 349);
    }
    
    /**
     * Muestra el escenario de Ayuda.
     */
    public void showHelp()
    {
        removeButtons();
        setBackground(helpImage);
        if (back.getWorld() == null)
            addObject(back, 709, 64);
    }

    /**
     * Muestra el escenario Records
     */
    public void showRecords()
    {
        removeButtons();
        setBackground(recordsImage);
        if (back.getWorld() == null)
            addObject(back, 709, 64);

        if (UserInfo.isStorageAvailable()) 
        {
            ArrayList array = (ArrayList)(UserInfo.getTop(10));
            if ( !array.isEmpty())
            {
                for (int i =0; i < array.size(); i++)
                {
                    Mensaje name = new Mensaje( (((UserInfo)(array.get(i))).getUserName()), 30, 0);
                    addObject(name, 100, (100 + (i*20)) );
                    String cadena = "" + (((UserInfo)(array.get(i))).getScore());
                    name = new Mensaje ( cadena , 30, 0 );
                    addObject(name, 300, (100 + (i*20))); 
                }
            }else 
            {   
                Mensaje nada = new Mensaje( "Empty records", 50, 0);
                addObject(nada, getWidth() /2, getHeight() /2);
            }

        }
        else 
        {
            Mensaje men = new Mensaje ("Server Unavailable", 50,-20);
            addObject(men, getWidth() /2, getHeight() /2);
        }
    }
    
    /**
     * Determina si un boton fue presionado.
     */
    public void buttonPressed()
    {
        if (play.getPressed())
        {
            removeButtons();
            start = true;
            play.setPressed(false);
            prepare();
        }

        if (help.getPressed())
        {
            ayuda = true;
        }

        if (records.getPressed())
        {
            rec = true;
        }
        
        if (credits.getPressed())
        {
            cred = true;
        }
    }

    /**
     * Realiza el apararente movimiento del mundo.
     */
    private void scrollWorld()  
    {  
        GreenfootImage bg = new GreenfootImage(getBackground());  
        getBackground().drawImage(bg, -1, 0);  
        getBackground().drawImage(bg, getWidth()-1, 0);  
    }

    /**
     * @return vScrolll que es la velocidad de Scroll del mundo.
     */
    public int getVScroll()
    {
        return vScroll;
    }

    /**
     * @param increment se suma a la velocidad de vScroll.
     */
    public void setVScroll(int increment)
    {
        vScroll+=increment;
    }

    /**
     * Realiza las validaciones para el nivel 2.
     */
    public void level2()
    {
        if (distance.getValue() % 70 == 0 && distance.getValue() != 0)
        {
            this.choiseOne();
        }

        if (distance.getValue() == 1100)
            this.makeBonus();

        if (distance.getValue() == 1150)
            this.makeWall();

        if (distance.getValue() == 1200)
            this.makeLives();

        if (distance.getValue() == 1230)
            this.makeBonus();

        if (distance.getValue() == 1250)
            this.makeBarrel();

        if (distance.getValue() == 1300)
            this.makeBarrier();

        if (distance.getValue() == 1350)
            this.makeBarrel();

        if (distance.getValue() == 1340)
            this.makeRock();

        if (distance.getValue() == 1400)
            this.makeLives();

        if (distance.getValue() == 1450)
            this.makeBarrel();

        if (distance.getValue() == 1500)
            this.makeAdel();

        if (distance.getValue() == 1540)
            this.makeBarrier();

        if (distance.getValue() == 1560)
            this.makeBarrel();

        if (distance.getValue() == 1600)
            this.makeRock();

        if (distance.getValue() == 1650)
            this.makeBonus();    

        if (distance.getValue() == 1700)
            this.makeBarrier();

        if (distance.getValue() == 1710)
            this.makeBonus();

        if (distance.getValue() == 1750)
            this.makeBarrel();

        if (distance.getValue() == 1770)
            this.makeBarrel();

        if (distance.getValue() == 1775)
            this.makeBarrel();

        if (distance.getValue() == 1800)
            this.makeBarrel();

        if (distance.getValue() == 1950)
            this.makeAdel();

    }

    /**
     * Realiza las validaciones para el nivel 1.
     */
    public void level1()
    {
        if (distance.getValue() > 1000)
        {
            nivel1 = false;
            vScroll = 0;

            nivel2 = true;
            Greenfoot.delay(2);
            Flag f = new Flag("Level 2, Luck!");
            addObject(f, getWidth()/2, getHeight()/2 );

            vScroll = 0;
            player.setLocation(120, floor - 30);
            setBackground("pasto.jpg");

            return;
        }

        if ( distance.getValue() == 60)
        {
            this.choiseOne();
        }

        if ( distance.getValue() == 100)
        {
            this.makeBonus();
        }

        if (distance.getValue() % 400 == 0 && distance.getValue() !=0)
            this.makeLives();

        if ( distance.getValue() == 140)
        {
            this.makeRock();
        }

        if ( distance.getValue() == 162)
        {
            this.makeBarrier();
        }

        if ( distance.getValue() == 202)
        {
            this.makeBarrier();
        }

        if ( distance.getValue() == 225)
            this.makeBonus();

        if ( distance.getValue() == 255)
            this.makeRock();

        if ( distance.getValue() == 265)
            this.makeBarrier();

        if ( distance.getValue() == 270)
            this.makeBonus();

        if ( distance.getValue() == 275)
            this.makeRock();

        if ( distance.getValue() == 285)
            this.makeRock();

        if ( distance.getValue() == 295)
            this.makeRock();

        if ( distance.getValue() == 325)
            this.makeBarrier();

        if ( distance.getValue() == 345)
            this.makeRock();

        if ( distance.getValue() == 365)
            this.makeRock();   

        if ( distance.getValue() == 395)
            this.makeBonus();

        if ( distance.getValue() == 410)
            this.makeBarrier();

        if ( distance.getValue() == 430)
            this.makeRock();

        if ( distance.getValue() == 450)
            this.makeBarrier();

        if ( distance.getValue() == 480)
            this.makeRock();

        if ( distance.getValue() == 500)
            this.makeKratos();

        if ( distance.getValue() == 520)
        {
            this.makeRock();
            this.makeBarrier();
        }

        if ( distance.getValue() == 530)
            this.choiseOne();

        if ( distance.getValue() == 550)
            this.choiseOne();

        if (distance.getValue() % 100 == 0 && distance.getValue() !=0 && distance.getValue() != 1000)
        {
            this.choiseOne();
        }

        if (distance.getValue() == 920)
        {
            this.makeKratos();
        }
    }

    /**
     * @return floor es una variable que indica a que altura se encuentra el suelo.
     */
    public int getFloor()
    {
        return floor;
    }

    /**
     * Coloca un objeto de la clase Rock en el escenario.
     */
    public void makeRock()
    {
        if (rock.getWorld() == null)
        {
            addObject(rock, getWidth()+10, floor); 
        }
    }

    /**
     * Coloca un objeto de la clase Rock en el escenario.
     */
    public void makeBarrel()
    {
        if (barrel.getWorld() == null)
        {
            addObject(barrel, getWidth()+10, floor-10); 
        }
    }

    /**
     * Coloca un objeto de la clase Bonus en el escenario.
     */
    public void makeBonus()
    {
        if(bonus.getWorld() == null)
        {
            addObject(bonus, getWidth()+5, floor-35);
        }
    }

    /**
     * Coloca un objeto de la clase Barrier en el escenario.
     */
    public void makeBarrier()
    {
        if (barrier.getWorld() == null)
        {
            addObject(barrier, getWidth()+10, floor);
        }
    }

    /**
     * Coloca un objeto de la clase Adel en el escenario.
     */
    public void makeAdel()
    {
        if (adel.getWorld() == null)
        {
            addObject(adel, getWidth()+10, 338);
        }
    }

    /**
     * Coloca un objeto de la clase Wall en el escenario.
     */
    public void makeWall()
    {
        if (wall.getWorld() == null)
        {
            addObject(wall, getWidth()+10, floor -5);
        }
    }

    /**
     * Coloca un objeto de la clase Lives en el escenario.
     */
    public void makeLives()
    {
        if (life.getWorld() == null)
        {
            addObject(life, getWidth()+10, floor -35);
        }
    }

    /**
     * Coloca un objeto de la clase Kratos en el escenario
     */
    public void makeKratos()
    {
        if (kratos.getWorld() == null)
        {
            addObject(kratos, getWidth()+10, floor -35);
        }
    }

    /**
     * Determina cual sera el objeto a colocar en el escenario.
     */
    public void choiseOne()
    {
        int num = Greenfoot.getRandomNumber(4);
        switch(num)
        {
            case 0: this.makeRock();
            break;
            case 1: this.makeBarrier();
            break;
            case 2: this.makeBonus();
            break;
            case 3: this.makeWall();
            break;
        }

    }
    
    /**
     * Remueve a los objetos de clase Button
     */
    public void removeButtons()
    {
        play.remove();
        records.remove();
        help.remove();
        credits.remove();
    }
}
