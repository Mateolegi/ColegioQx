/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;

import co.com.quipux.ColegioQuipux.dao.impl.GradoDaoImpl;
import co.com.quipux.ColegioQuipux.dao.impl.GrupoDaoImpl;
import co.com.quipux.ColegioQuipux.dao.impl.ProfesorDaoImpl;
import co.com.quipux.ColegioQuipux.models.entity.GrupoEntity;
import co.com.quipux.ColegioQuipux.models.entity.MateriasEntity;
import co.com.quipux.ColegioQuipux.models.entity.ProfesorEntity;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JButtonArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JComboboxArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JLabelArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JTextFieldHint;
import co.com.quipux.ColegioQuipux.util.Colores;
import co.com.quipux.ColegioQuipux.util.Fonts;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Sebas
 */
public class Pnl_registrosGrupos extends JPanel implements ActionListener{
    /**/
    protected int width, height;
    protected Control_Instancias pp;
    /*Titulo etc...*/
    private JLabelArje lbl_titulo,lbl_codigo,lbl_nodo,lbl_nombreMateria,lbl_jornada;
    /*Areas de texto*/
    private JTextFieldHint txt_Codigo;
    /*DAOS*/
    GrupoDaoImpl daoGrupo = new GrupoDaoImpl();
    ProfesorDaoImpl daoProfesor= new ProfesorDaoImpl();
    GradoDaoImpl daoGrado= new GradoDaoImpl();
    /**/
    private JComboboxArje cbx_grado,cbx_jornada,cbx_nombreProfesor;
    String []Grados=daoGrado.getListadoDeGrados();
    int [] codigoGrado=daoGrado.getCodigoGrado();
    
    String []Jornadas = {"Mañana","Tarde","Noche"};
    String []nombreProfesores= daoProfesor.getListadoProfesor();
    
    int []codigoProfesores= daoProfesor.getCodigoProfesor();
    /*JBUTTONARJE*/
    private JButtonArje btn_enviar;
    
    int idGrado=0;
    String grado="";
    String jornada="";
    int idProfesor=0;
            
    public Pnl_registrosGrupos(Control_Instancias instancia, int width, int height){
        this.width=width;
        this.height=height;
        pp=instancia;
        
        Arrays.sort(Jornadas);
        
        lbl_titulo=new JLabelArje();
            lbl_titulo.setTexto("Sección: Registro - Materias", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_titulo);
            
        lbl_nombreMateria=new JLabelArje();
            lbl_nombreMateria.setTexto("Nombres y apellidos de coordinador: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_nombreMateria);
            
        lbl_codigo=new JLabelArje();
            lbl_codigo.setTexto("Código: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_codigo);
            
        lbl_nodo=new JLabelArje();
            lbl_nodo.setTexto("Prefijo de Materia: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_nodo);
            
        lbl_jornada=new JLabelArje();
            lbl_jornada.setTexto("Jornada: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_jornada);
            
        cbx_grado= new JComboboxArje(Grados);
            this.add(cbx_grado);
            
        cbx_jornada= new JComboboxArje(Jornadas);
            this.add(cbx_jornada);
            
        grado = (String) cbx_grado.getSelectedItem();
        
        jornada = (String) cbx_jornada.getSelectedItem();
            
        txt_Codigo = new JTextFieldHint(1);
            txt_Codigo.setHint(Integer.toString(daoGrupo.getCodigoGrupo(grado)));
            txt_Codigo.setEditable(false);
            this.add(txt_Codigo);
        
        cbx_nombreProfesor= new JComboboxArje(nombreProfesores);
            this.add(cbx_nombreProfesor);
            
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
        cbx_grado.setLocation(x, txt_Codigo.getY()+50);
        
        lbl_nombreMateria.setBounds(x, cbx_grado.getY()+30, 300, 25);
        cbx_nombreProfesor.setLocation(x, cbx_grado.getY()+55);
        
        lbl_jornada.setBounds(x, cbx_nombreProfesor.getY()+30, 150, 25);
        cbx_jornada.setLocation(x, cbx_nombreProfesor.getY()+55);
        
        btn_enviar.setBounds(x, cbx_nombreProfesor.getY()+150, 150, 25);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btn_enviar){
        
        jornada = (String) cbx_jornada.getSelectedItem();
        
        idGrado = codigoGrado[cbx_grado.getSelectedIndex()];
        
        grado=(String) cbx_grado.getSelectedItem();
        
        idProfesor = codigoProfesores[cbx_nombreProfesor.getSelectedIndex()];
            System.out.println("Código: "+idProfesor);
            
        //subCoordinador = Integer.parseInt(idProfesor.substring(8,12));
        
        GrupoEntity gp = new GrupoEntity();
        
        gp.setIdGrupo(daoGrupo.getCodigoGrupo(grado));
        gp.setIdProfesor(idProfesor);
        gp.setIdGrado(idGrado);
        gp.setCantidadEstudiantes(0);
        gp.setJornada(jornada);
        
        if(daoGrupo.registrarGrupo(gp)){
                JOptionPane.showMessageDialog(null, "Datos Correctos","Aviso",JOptionPane.INFORMATION_MESSAGE);
                txt_Codigo.setText(Integer.toString(daoGrupo.getCodigoGrupo(grado)));
            }else{
                JOptionPane.showMessageDialog(null, "Datos incorrectos, revise la información de nuevo por favor","Mensaje Error",JOptionPane.ERROR_MESSAGE);    
            }
        
        }
        
    }
    
    
}
