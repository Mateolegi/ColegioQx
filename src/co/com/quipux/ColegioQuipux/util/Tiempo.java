/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class Tiempo {
    public GregorianCalendar calendario = new GregorianCalendar();
    public static int ano,mes,dia,hora,minuto,segundo;
    public static String fecha,tiempo;
    
    public Tiempo(){
        ano = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH)+1;
        dia = calendario.get(Calendar.DATE);
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minuto = calendario.get(Calendar.MINUTE);
        segundo = calendario.get(Calendar.SECOND);
        
        tiempo=""+hora+":"+minuto+"."+segundo;
        fecha=""+dia+"/"+mes+"/"+ano;
    }

    public Calendar getCalendario() {
        return calendario;
    }

    public void setCalendario(GregorianCalendar calendario) {
        this.calendario = calendario;
    }

    public static int getAno() {
        return ano;
    }

    public static void setAno(int ano) {
        Tiempo.ano = ano;
    }

    public static int getMes() {
        return mes;
    }

    public static void setMes(int mes) {
        Tiempo.mes = mes;
    }

    public static int getDia() {
        return dia;
    }

    public static void setDia(int dia) {
        Tiempo.dia = dia;
    }

    public static int getHora() {
        return hora;
    }

    public static void setHora(int hora) {
        Tiempo.hora = hora;
    }

    public static int getMinuto() {
        return minuto;
    }

    public static void setMinuto(int minuto) {
        Tiempo.minuto = minuto;
    }

    public static int getSegundo() {
        return segundo;
    }

    public static void setSegundo(int segundo) {
        Tiempo.segundo = segundo;
    }

    public static String getFecha() {
        return fecha;
    }

    public static void setFecha(String fecha) {
        Tiempo.fecha = fecha;
    }

    public static String getTiempo() {
        return tiempo;
    }

    public static void setTiempo(String tiempo) {
        Tiempo.tiempo = tiempo;
    }
    
    
    
    
}
