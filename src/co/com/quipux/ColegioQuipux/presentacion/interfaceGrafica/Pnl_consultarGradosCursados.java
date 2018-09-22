/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;

import co.com.quipux.ColegioQuipux.dao.impl.GradoDaoImpl;
import co.com.quipux.ColegioQuipux.dao.impl.GradosCursadosDaoImpl;
import co.com.quipux.ColegioQuipux.dao.impl.MateriasDaoImpl;
import co.com.quipux.ColegioQuipux.manager.impl.GradoMateriaManagerImpl;
import co.com.quipux.ColegioQuipux.manager.impl.GradosCursadosManagerImpl;
import co.com.quipux.ColegioQuipux.manager.impl.GrupoManagerImpl;
import co.com.quipux.ColegioQuipux.manager.impl.ProfesorManagerImpl;
import co.com.quipux.ColegioQuipux.manager.impl.Profesor_Materia_GrupoManagerImpl;
import co.com.quipux.ColegioQuipux.models.dto.ProfesorConsultaSimpleDTO;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Sebas
 */
public class Pnl_consultarGradosCursados extends JPanel implements ActionListener{
    protected int width, height;
    protected Control_Instancias pp;
    /*JLABLE ARJE*/
    private JLabelArje lbl_titulo,lbl_informacion,lbl_dato,lbl_consultarPor;
    /*JButtonArje*/
    private JButtonArje btn_buscar,btn_todo;
    /*DAO y DTO*/
    GradoDaoImpl daoGrado = new GradoDaoImpl();
    GradosCursadosManagerImpl managerProMaGru = new GradosCursadosManagerImpl();
    MateriasDaoImpl daoMateria = new MateriasDaoImpl();
    /*JTextFieldHint*/
    private JTextFieldHint txt_consulta;
    /*JComboboxArje*/
    private JComboboxArje cbx_consultar;
    
    JScrollPane ScrollPane;
    
    String[] mostrarGrupo = {"Código","Número de Grado",
        "Estudiante","Año","Estado","NotaPromedio"};
    
    public Pnl_consultarGradosCursados(Control_Instancias instancia, int width,int height){
        this.width=width;
        this.height=height;
        pp=instancia;
        
        lbl_titulo =  new JLabelArje();
            lbl_titulo.setTexto("Sección: Consultar - Profesor Materia Grupo.", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_titulo);
            
        lbl_dato =  new JLabelArje();
            lbl_dato.setTexto("Dato: ", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_dato);
            
        lbl_consultarPor =  new JLabelArje();
            lbl_consultarPor.setTexto("Consultar por: ", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_consultarPor);
            
        lbl_informacion = new JLabelArje();
            lbl_informacion.setText("");
            lbl_informacion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            
        txt_consulta=new JTextFieldHint();
            txt_consulta.setHint("Ingresa busqueda");
            this.add(txt_consulta);
            
        cbx_consultar=new JComboboxArje(mostrarGrupo);
            this.add(cbx_consultar);
          
        ScrollPane = new javax.swing.JScrollPane();
            ScrollPane.setViewportView(lbl_informacion);
            ScrollPane.setBackground(Color.white);
            ScrollPane.getViewport().setBackground(Color.white);
            this.add(ScrollPane);
            
        btn_buscar = new JButtonArje("Buscar",0,16,1,Colores.pantone319C,Colores.pantone276C);
            btn_buscar.addActionListener(this);
            this.add(btn_buscar);
            
        btn_todo = new JButtonArje("Todos",0,16,1,Colores.pantone319C,Colores.pantone276C);
            btn_todo.addActionListener(this);
            this.add(btn_todo);
            
        
    }
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Color.white);
        setSize(width,height);
        
        lbl_titulo.setBounds(10, 0, 500, 25);
        
        lbl_consultarPor.setBounds(20, 75, 150, 25);
        cbx_consultar.setLocation(20, 100);
        
        lbl_dato.setBounds(cbx_consultar.getWidth()+30, 75, 150, 25);
        txt_consulta.setBounds(cbx_consultar.getWidth()+30, 105, 150, 25);
        
        btn_buscar.setBounds(txt_consulta.getWidth()+txt_consulta.getX()+30, 105, 150, 25);
        btn_todo.setBounds(btn_buscar.getWidth()+btn_buscar.getX()+30, 105, 150, 25);
        
        ScrollPane.setBounds(20,btn_buscar.getY()+50,700,300);
        lbl_informacion.setLocation(0, 0);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btn_buscar){
       
            String texto = txt_consulta.getText();
            String textoSeleccionado = (String) cbx_consultar.getSelectedItem();
            /*String[] mostrarGrupo = {"Código","Número de Grado",
                "Estudiante","Año","Estado","NotaPromedio"};
            /*0: TODO, 1: Grupo, 2: Estudiante, 3: Año, 4: Estado, 5: NotaPromedio 6: Código*/
            if(textoSeleccionado.equals("Código")){
                lbl_informacion.setText(managerProMaGru.generarTablaDeConsulta(6,texto));
                System.out.println("Entro a código");
            }
            if(textoSeleccionado.equals("Número de Grado")){
                lbl_informacion.setText(managerProMaGru.generarTablaDeConsulta(1,texto));
                System.out.println("Entro a Número de grado");
            }
            if(textoSeleccionado.equals("Estudiante")){
                lbl_informacion.setText(managerProMaGru.generarTablaDeConsulta(2,texto));
                System.out.println("Entro a Estudiante");
            }
            if(textoSeleccionado.equals("Año")){
                lbl_informacion.setText(managerProMaGru.generarTablaDeConsulta(3,texto));
                System.out.println("Entro a Año");
            }
            if(textoSeleccionado.equals("Estado")){
                lbl_informacion.setText(managerProMaGru.generarTablaDeConsulta(4,texto));
                System.out.println("Entro a Estado");
            }
            if(textoSeleccionado.equals("NotaPromedio")){
                lbl_informacion.setText(managerProMaGru.generarTablaDeConsulta(5,texto));
                System.out.println("Entro a NotaPromedio");
            }
            
        }
        if(ae.getSource()==btn_todo){
            lbl_informacion.setText(managerProMaGru.generarTablaDeConsulta(0,""));
        }
        
    }
    
    
}
