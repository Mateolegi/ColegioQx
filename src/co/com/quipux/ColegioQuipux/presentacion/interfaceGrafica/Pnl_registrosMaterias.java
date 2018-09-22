/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;

import co.com.quipux.ColegioQuipux.dao.impl.MateriasDaoImpl;
import co.com.quipux.ColegioQuipux.models.entity.MateriasEntity;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JButtonArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JComboboxArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JEditorPaneArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JLabelArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JTextFieldHint;
import co.com.quipux.ColegioQuipux.util.Colores;
import co.com.quipux.ColegioQuipux.util.Fonts;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Sebas
 */
public class Pnl_registrosMaterias extends JPanel implements ActionListener{
    /**/
    protected int width, height;
    protected Control_Instancias pp;
    /*Titulo etc...*/
    private JLabelArje lbl_titulo,lbl_codigo,lbl_nodo,lbl_nombreMateria,lbl_descripcion;
    /*Areas de texto*/
    private JTextFieldHint txt_Codigo,txt_nombreMateria;
    /*Radio Button*/
    private JRadioButton rbtn_sexto,rbtn_septimo,rbtn_octavo,rbtn_noveno,
            rbtn_decimo,rbtn_undecimo;
    private JComboboxArje cbx_Nodo;
    String []Nodos={"MAT","SOC","IDM","EDF"};
    /*JBUTTONARJE*/
    private JButtonArje btn_enviar;
    private JEditorPaneArje txt_descripcion;
    
    String sexto="",septimo="",octavo="",noveno="",decimo="",undecimo="";
    
    String prefijo="",nombreProfesor="";
    
    MateriasDaoImpl daoMaterias=new MateriasDaoImpl();
    
            
    public Pnl_registrosMaterias(Control_Instancias instancia, int width, int height){
        this.width=width;
        this.height=height;
        pp=instancia;
        
        Arrays.sort(Nodos);
        
        lbl_titulo=new JLabelArje();
            lbl_titulo.setTexto("Sección: Registro - Materias", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_titulo);
            
        lbl_nombreMateria=new JLabelArje();
            lbl_nombreMateria.setTexto("Nombre de Materia: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_nombreMateria);
            
        lbl_codigo=new JLabelArje();
            lbl_codigo.setTexto("Código: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_codigo);
            
        lbl_nodo=new JLabelArje();
            lbl_nodo.setTexto("Prefijo de Materia: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_nodo);
            
        lbl_descripcion=new JLabelArje();
            lbl_descripcion.setTexto("Descripción: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_descripcion);
            
        cbx_Nodo= new JComboboxArje(Nodos);
            this.add(cbx_Nodo);
            
        prefijo =(String) cbx_Nodo.getSelectedItem();
            
        txt_Codigo = new JTextFieldHint(1);
            txt_Codigo.setHint(daoMaterias.generarCodigoDeMateria(prefijo));
            txt_Codigo.setEditable(false);
            this.add(txt_Codigo);   
            
        txt_nombreMateria=new JTextFieldHint();
            txt_nombreMateria.setHint("Matemáticas");
            this.add(txt_nombreMateria);
            
        txt_descripcion= new JEditorPaneArje("",Colores.pantone100C);
            this.add(txt_descripcion);
            
        rbtn_sexto=new JRadioButton("6",false);
            rbtn_sexto.setBackground(Colores.pantone276C);
            rbtn_sexto.setForeground(Colores.pantone388C);
            rbtn_sexto.setFocusPainted(false);
            this.add(rbtn_sexto);
            
        rbtn_septimo=new JRadioButton("7",false);
            rbtn_septimo.setBackground(Colores.pantone276C);
            rbtn_septimo.setForeground(Colores.pantone388C);
            rbtn_septimo.setFocusPainted(false);
            this.add(rbtn_septimo);
            
        rbtn_octavo=new JRadioButton("8",false);
            rbtn_octavo.setBackground(Colores.pantone276C);
            rbtn_octavo.setForeground(Colores.pantone388C);
            rbtn_octavo.setFocusPainted(false);
            this.add(rbtn_octavo);
            
        rbtn_noveno=new JRadioButton("9",false);
            rbtn_noveno.setBackground(Colores.pantone276C);
            rbtn_noveno.setForeground(Colores.pantone388C);
            rbtn_noveno.setFocusPainted(false);
            this.add(rbtn_noveno);
            
        rbtn_decimo=new JRadioButton("10",false);
            rbtn_decimo.setBackground(Colores.pantone276C);
            rbtn_decimo.setForeground(Colores.pantone388C);
            rbtn_decimo.setFocusPainted(false);
            this.add(rbtn_decimo);
            
        rbtn_undecimo=new JRadioButton("11",false);
            rbtn_undecimo.setBackground(Colores.pantone276C);
            rbtn_undecimo.setForeground(Colores.pantone388C);
            rbtn_undecimo.setFocusPainted(false);
            this.add(rbtn_undecimo);
            
        btn_enviar=new JButtonArje("Enviar", 1, 16, 1, Colores.pantone319C, Colores.pantone276C);
            btn_enviar.addActionListener(this);
            this.add(btn_enviar);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Color.white);
        this.setSize(width, height);
        
        lbl_titulo.setBounds(10, 0, 500, 25);
        
        int x=20;
        
        lbl_codigo.setBounds(x, 50, 150, 25);
        txt_Codigo.setBounds(x, 75, 150, 25);
        
        lbl_nodo.setBounds(x, txt_Codigo.getY()+25, 150, 25);
        cbx_Nodo.setLocation(x, txt_Codigo.getY()+50);
        
        lbl_nombreMateria.setBounds(x, cbx_Nodo.getY()+30, 200, 25);
        txt_nombreMateria.setBounds(x, cbx_Nodo.getY()+55, 150, 25);
        
        lbl_descripcion.setBounds(x, txt_nombreMateria.getY()+30, 150, 25);
        txt_descripcion.setBounds(x, txt_nombreMateria.getY()+55, 600, 250);
        
        rbtn_sexto.setLocation(x, 500);
        rbtn_septimo.setLocation(x+rbtn_sexto.getX()+20, 500);
        rbtn_octavo.setLocation(x+rbtn_septimo.getX()+20, 500);
        rbtn_noveno.setLocation(x+rbtn_octavo.getX()+20, 500);
        rbtn_decimo.setLocation(x+rbtn_noveno.getX()+20, 500);
        rbtn_undecimo.setLocation(x+rbtn_decimo.getX()+30, 500);
        
        btn_enviar.setBounds(x, rbtn_sexto.getY()+150, 150, 25);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btn_enviar){
        if (rbtn_sexto.isSelected()) {
            sexto="x";
        }
        if (rbtn_septimo.isSelected()) {
            septimo="x";
        }
        if (rbtn_octavo.isSelected()) {
            octavo="x";
        }
        if (rbtn_noveno.isSelected()) {
            noveno="x";
        }
        if (rbtn_decimo.isSelected()) {
            decimo="x";
        }
        if (rbtn_undecimo.isSelected()) {
            undecimo="x";
        }
        
        prefijo=(String) cbx_Nodo.getSelectedItem();
        
        MateriasEntity ma = new MateriasEntity();
        
        //Codigo,nombreMateria,descripcion
        
        ma.setIdMateria(daoMaterias.generarCodigoDeMateria(prefijo));
        ma.setNombreMateria(txt_nombreMateria.getText());
        ma.setDescripcion(txt_descripcion.getText());
        
        if(daoMaterias.registrarMaterias(ma)){
                JOptionPane.showMessageDialog(null, "Datos Correctos","Aviso",JOptionPane.INFORMATION_MESSAGE);
                txt_Codigo.setText(daoMaterias.generarCodigoDeMateria(prefijo));
            }else{
                JOptionPane.showMessageDialog(null, "Datos incorrectos, revise la información de nuevo por favor","Mensaje Error",JOptionPane.ERROR_MESSAGE);    
            }
        
        }
        
    }
    
}
