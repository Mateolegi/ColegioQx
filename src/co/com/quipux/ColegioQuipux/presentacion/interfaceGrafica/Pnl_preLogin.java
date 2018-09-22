/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;

import co.com.quipux.ColegioQuipux.presentacion.metodos.JButtonArje;
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
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 * 
 * Las clases contenidas en los paquetes de Utilidades y Metodos son de autoria propia
 * Normalmente terminan en Arje.
 */
public class Pnl_preLogin extends JPanel implements ActionListener{
    protected int width,height;
    protected Control_Instancias pp;
    /*JButtonArje*/
    private JButtonArje btn_estudiante,btn_profesor,btn_administrador;
    /*JLabelArje*/
    private JLabelArje lbl_informacion,lbl_estudiante,lbl_profesor,lbl_administrador;
    
    public Pnl_preLogin(Control_Instancias instancia,int width,int height){
        this.width=width;
        this.height=height;
        this.pp=instancia;
        
        lbl_informacion=new JLabelArje();
            lbl_informacion.setTexto("Selecciona tu tipo de usuario: ", Fonts.Lato, 1, 20, Colores.pantone276C, 1);
            this.add(lbl_informacion);
            
        lbl_estudiante=new JLabelArje();
            lbl_estudiante.setTexto("Estudiante", Fonts.Lato, 1, 20, Colores.pantone276C, 1);
            this.add(lbl_estudiante);
            
        lbl_profesor=new JLabelArje();
            lbl_profesor.setTexto("Profesor", Fonts.Lato, 1, 20, Colores.pantone276C, 1);
            this.add(lbl_profesor);
            
        lbl_administrador=new JLabelArje();
            lbl_administrador.setTexto("Administrador", Fonts.Lato, 1, 20, Colores.pantone276C, 1);
            this.add(lbl_administrador);
        
        btn_estudiante=new JButtonArje("Btn_estudiante", "Btn_estudianteSeleccion", "png", "png","a");
            btn_estudiante.addActionListener(this);
            this.add(btn_estudiante);
            
        btn_profesor=new JButtonArje("Btn_profesor","Btn_profesorSeleccion","png","png","a");
            btn_profesor.addActionListener(this);
            this.add(btn_profesor);
            
        btn_administrador=new JButtonArje("Btn_administrador","Btn_administradorSeleccion","png","png","a");
            btn_administrador.addActionListener(this);
            this.add(btn_administrador);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Color.white);
        this.setSize(width, height);
        
        lbl_informacion.setBounds((width-300)/2, 20, 300, 25);
        
        lbl_estudiante.setBounds((width-150)/4, (height-150)/2-50, 150, 25);
        btn_estudiante.setBounds((width-150)/4, (height-150)/2, 150, 150);
        
        lbl_profesor.setBounds((width-150)/2, (height-150)/2-50, 150, 25);
        btn_profesor.setBounds((width-150)/2, (height-150)/2, 150, 150);
        
        lbl_administrador.setBounds((width-150)/4+((width-150)/2), (height-150)/2-50, 150, 25);
        btn_administrador.setBounds((width-150)/4+((width-150)/2), (height-150)/2, 150, 150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_estudiante){
            Pnl_login.setUsuario("Estudiante");
            pp.getContenedor().setPantallaLogin(1);
        }
        if(e.getSource()==btn_profesor){
            Pnl_login.setUsuario("Profesor");
            pp.getContenedor().setPantallaLogin(1);
        }
        if(e.getSource()==btn_administrador){
            Pnl_login.setUsuario("Administrador");
            pp.getContenedor().setPantallaLogin(1);
        }
    }
}
