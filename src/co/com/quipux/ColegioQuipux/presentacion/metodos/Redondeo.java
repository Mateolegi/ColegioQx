/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.metodos;

import java.text.DecimalFormat;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class Redondeo {
    DecimalFormat df = new DecimalFormat("########.00");
    //System.out.println(df.format(number));
        /* Salida : 1.42*/
    
    public static String getRedondeo(double valor){
        String resultado="";
        
        resultado=Double.toString(Math.round(valor* 100d / 100d));
        
        return resultado;
    }
}
