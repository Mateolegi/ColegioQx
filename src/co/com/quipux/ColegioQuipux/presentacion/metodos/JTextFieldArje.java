/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.metodos;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class JTextFieldArje extends JTextField{
    int tamanoBorde1,tamanoBorde2;
    
    public JTextFieldArje(){
        
    }
    
    public JTextFieldArje(Color colorLetra){
        this.setForeground(colorLetra);
        this.setOpaque(false);
    }
    
    public void setFonts(int propiedad,int tamanoLetra){
        this.setFont(new Font ("Microsoft New Tai Lue",propiedad,tamanoLetra));
    }
    
    public void setTexto(String texto, String tipoGrafia, int propiedad, int tamano,Color color,int index){
        try{
            this.setText(texto);
            this.setFont(new Font(tipoGrafia,propiedad,tamano));
            this.setForeground(color);
        
            switch(index){
                case 0:
                    this.setHorizontalAlignment(SwingConstants.LEFT);
                    break;
                case 1:
                    this.setHorizontalAlignment(SwingConstants.CENTER);
                    break;
                case 2:
                    this.setHorizontalAlignment(SwingConstants.RIGHT);
                    break;
            }
        }catch(Exception ex){
            System.out.println("Clase:"+"\n"+"JLabelArje, Metodo:"+"\n"+"setTextosetTexto"
                +"(String texto, String tipoGrafia, int propiedad, int tamano,Color color,int index)."+
                "\n"+"Tipo de erro: "+ex.getMessage());
        }
    }
}
