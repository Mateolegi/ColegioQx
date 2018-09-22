/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.metodos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * 
 * A tener en cuenta para repasar: http://www.chuidiang.org/java/layout/GridBagLayout/GridBagLayout.php
 * /**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class JPanelSaberMas extends JPanel{
    protected int width,height;
    
    JTextArea cajaTexto;
    JButton boton1,boton2,boton3,boton4;
    JTextField campoTexto;
    
    public JPanelSaberMas(){
        
    }
    public JPanelSaberMas(int width, int height,String titulo,String[] textosLabels){
        this.width=width;
        this.height=height;
        this.setLayout(new GridBagLayout());
    }
    
    public JPanelSaberMas(int width, int height){
        this.width=width;
        this.height=height;
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0; // El área de texto empieza en la columna cero.
            constraints.gridy = 0; // El área de texto empieza en la fila cero
            constraints.gridwidth = 2; // El área de texto ocupa dos columnas.
            constraints.gridheight = 2; // El área de texto ocupa 2 filas.
        
        cajaTexto = new JTextArea("Area texto"); 
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 2;
            constraints.gridheight = 2;
            // El area de texto debe estirarse en ambos sentidos. Ponemos el campo fill.
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weighty = 1.0; 
            this.add (cajaTexto, constraints); 
            constraints.weighty = 0.0;

        boton1 = new JButton ("Boton 1"); 
            constraints.gridx = 2;
            constraints.gridy = 0;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.weighty = 1.0;
            // El botón 1 debe ocupar la posición NORTH de su celda 
            constraints.anchor = GridBagConstraints.NORTH;
            // El botón 1 no debe estirarse. Habíamos cambiado este valor en el
            // area de texto, asi que lo restauramos.
            constraints.fill = GridBagConstraints.NONE;
            this.add (boton1, constraints);
            // Restauramos valores por defecto
            constraints.anchor = GridBagConstraints.CENTER; 
            constraints.weighty = 0.0; 

        boton2 = new JButton ("Boton 2");
            constraints.gridx = 2;
            constraints.gridy = 1; 
            constraints.gridwidth = 1; 
            constraints.gridheight = 1; 
            constraints.weighty = 1.0; 
            // El boton 2 debe ocupar la posición NORTH de su celda. 
            constraints.anchor = GridBagConstraints.NORTH;
            this.add (boton2, constraints);
            // Restauramos valores por defecto.
            constraints.weighty = 0.0; 
            constraints.anchor = GridBagConstraints.CENTER; 

        boton3 = new JButton ("Boton 3"); 
            constraints.gridx = 0;
            constraints.gridy = 2;
            constraints.gridwidth = 1; 
            constraints.gridheight = 1; 
            this.add (boton3, constraints); 

        boton4 = new JButton ("Boton 4");
            constraints.gridx = 2;
            constraints.gridy = 2; 
            constraints.gridwidth = 1; 
            constraints.gridheight = 1;
            this.add(boton4, constraints);

        campoTexto = new JTextField ("Campo texto");
            constraints.gridx = 1; 
            constraints.gridy = 2;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.weightx = 1.0;
            // El campo de texto debe estirarse sólo en horizontal.
            constraints.fill = GridBagConstraints.HORIZONTAL;
            this.add(campoTexto, constraints);
    }
    
}
