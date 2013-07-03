import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Mensaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
