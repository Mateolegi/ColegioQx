/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.util;

import java.awt.Color;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class Colores {
    public static Color 
        /*Colores primarios manual de marca quipux*/
        pantone276C=new Color(38,34,54),
        pantone388C=new Color(226,230,63),
        pantone319C=new Color(118,201,210),
        blanco = new Color(255,255,255),
        /*Colores secundarios*/
        pantone100C = new Color(244,234,106),
        pantone1645C = new Color(233,107,60),
        pantone5315C = new Color(216,213,221);
    
    public Colores() {
        pantone276C=new Color(122,212,52);
    }
    
    //GETTER
    public static Color getColor_verdeClaro() {
        return pantone276C;
    }

    public static Color getColor_verdeOscuro() {
        return pantone388C;
    }
    
    
    
    //SETTER
    public static void setColor_verdeClaro(Color color_verdeClaro) {
        Colores.pantone276C = color_verdeClaro;
    }

    public static void setColor_verdeOscuro(Color color_verdeOscuro) {
        Colores.pantone388C = color_verdeOscuro;
    }
    
    
    
    
    
    
}
