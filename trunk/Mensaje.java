import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * La clase Mensaje contiene un constructor que recibe una cadena que sera el mensaje a mostrar, un entero
 * que es la medida del letrero, y los grados a rotar el mensaje.
 * Tiene un fondo transparente. Por defecto el color del mensaje es Blanco.
 * 
 * @author (Angel Isai Zavala Cano) 
 * @version (03 07 2013)
 */
public class Mensaje extends Actor
{
    /**
     * Constructor de la clase Mensaje
     * @param m es el mensaje a poner en el mensaje
     * @param size es la medida del letrero
     * @param grades es los grados de rotacion que se quiere para el cartel.
     */
    public Mensaje(String m, int size, int grades)
    {
        GreenfootImage letrero = new GreenfootImage (m, size, Color.white, new Color(0, 0, 0, 0));
        setImage( letrero) ;
        turn (grades);
    }
}
