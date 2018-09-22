/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.metodos;

import co.com.quipux.ColegioQuipux.presentacion.util.Colores;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class JComboboxArje extends JComboBox<Object>{
    
    public JComboboxArje(){
        
    }
    
    public JComboboxArje(String[] datos){
        this.setForeground(Colores.pantone1645C);
        this.setModel(new DefaultComboBoxModel(datos));
        this.setFont(new Font("Lato",Font.BOLD,18));
        this.setFocusable(false);
        this.setBackground(Color.white);
    }
    
    public void setTexto(String[] datos){
        this.setModel(new DefaultComboBoxModel(datos));
    }
    
    
}
