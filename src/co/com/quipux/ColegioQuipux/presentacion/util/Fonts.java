/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.util;

import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class Fonts {
    public static String txt_inicio="<FONT FACE=\"Lato\" color=\"464646\" font size=\"4\">"
        ,txt_final="</FONT><br>";
    
    public static Font font_titulos=new Font("Microsoft New Tai Lue",Font.BOLD,14),
            font_normal=new Font("Microsoft New Tai Lue",0,14);
    
    public static String Lato="Lato";
    
    public Fonts() {
        
    }
    
    public static void setFonts(JLabel lbl,int propiedad, int tamano){
        lbl.setFont(new Font("Microsoft New Tai Lue", propiedad, tamano));
    }
}
