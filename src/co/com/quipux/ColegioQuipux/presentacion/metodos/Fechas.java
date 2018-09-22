/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.metodos;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class Fechas {
    private int hora,minuto,dia,mes;
    private Calendar calendario = new GregorianCalendar();
    
    //int hora = calendario.get(Calendar.HOUR_OF_DAY);

    public Fechas() {
        this.hora = calendario.get(Calendar.HOUR_OF_DAY);
    }
    
    
    
}
