/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;

import co.com.quipux.ColegioQuipux.presentacion.metodos.JLabelArje;
import co.com.quipux.ColegioQuipux.util.Colores;
import co.com.quipux.ColegioQuipux.util.Fonts;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Sebas
 */
public class Pnl_registrosNotas extends JPanel implements ActionListener{
    protected int width, height;
    protected Control_Instancias pp;
    /*Titulo etc...*/
    private JLabelArje lbl_titulo;
    
    public Pnl_registrosNotas(Control_Instancias instancias, int width, int heigth){
        this.width=width;
        this.height=heigth;
        pp=instancias;
        
        lbl_titulo=new JLabelArje();
            lbl_titulo.setTexto("Sección: Registro - Materias", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_titulo);
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Color.white);
        this.setSize(width, height);
        
        lbl_titulo.setBounds(10, 0, 500, 25);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
