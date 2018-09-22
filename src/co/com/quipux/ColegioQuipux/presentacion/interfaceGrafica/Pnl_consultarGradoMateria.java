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
import co.com.quipux.ColegioQuipux.manager.impl.ProfesorManagerImpl;
import co.com.quipux.ColegioQuipux.models.dto.ProfesorConsultaSimpleDTO;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Sebas
 */
public class Pnl_consultarGradoMateria extends JPanel implements ActionListener{
    protected int width, height;
    protected Control_Instancias pp;
    /*JLABLE ARJE*/
    private JLabelArje lbl_titulo,lbl_informacion,lbl_dato,lbl_consultarPor;
    /*JButtonArje*/
    private JButtonArje btn_buscar,btn_todo,btn_actualizar;
    /*DAO y DTO*/
    GradoDaoImpl daoGrado= new GradoDaoImpl();
    GradoMateriaManagerImpl managerGradoMateria =new GradoMateriaManagerImpl();
    MateriasDaoImpl daoMateria = new MateriasDaoImpl();
    
    private JEditorPaneArje txt_informacion;
    /*JComboboxArje*/
    private JComboboxArje cbx_consultar,cbx_dato;
    
    String []Grados=daoGrado.getListadoDeGrados();
    int [] codigoGrado=daoGrado.getCodigoGrado();
    
    String [] Materias = daoMateria.getListadoDeMaterias();
    String [] codigoMateria= daoMateria.getCodigoMateria();
    
    JScrollPane ScrollPane;
    
    String[] porBusquedaProfesor = {"idGrupo","idMateria"};
    String[] mostrarGradoMateria = {"Grado", "Materia"};
    
    public Pnl_consultarGradoMateria(Control_Instancias instancia, int width,int height){
        this.width=width;
        this.height=height;
        pp=instancia;
        
        lbl_titulo =  new JLabelArje();
            lbl_titulo.setTexto("Sección: Consultar - Grado por materia.", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_titulo);
            
        txt_informacion = new JEditorPaneArje();
            txt_informacion.setTexto("Al cambiar el <b>consultar por</b>, recuerda darle al <b>botón actualizar.</b>");
            this.add(txt_informacion);
            
        lbl_dato =  new JLabelArje();
            lbl_dato.setTexto("Dato: ", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_dato);
            
        lbl_consultarPor =  new JLabelArje();
            lbl_consultarPor.setTexto("Consultar por: ", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_consultarPor);
            
        lbl_informacion = new JLabelArje();
            lbl_informacion.setText("");
            lbl_informacion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            
        cbx_consultar=new JComboboxArje(mostrarGradoMateria);
            this.add(cbx_consultar);
            
        cbx_dato= new JComboboxArje(Grados);
            this.add(cbx_dato);
          
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
            
        btn_actualizar = new JButtonArje("Actualizar",0,16,1,Colores.pantone319C,Colores.pantone276C);
            btn_actualizar.addActionListener(this);
            this.add(btn_actualizar);
            
        
    }
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Color.white);
        setSize(width,height);
        
        lbl_titulo.setBounds(10, 0, 500, 25);
        txt_informacion.setBounds(10, 40, 500, 25);
        
        lbl_consultarPor.setBounds(20, 75, 150, 25);
        cbx_consultar.setLocation(20, 100);
        
        lbl_dato.setBounds(cbx_consultar.getWidth()+30, 75, 150, 25);
        cbx_dato.setLocation(cbx_consultar.getWidth()+30, 100);
        
        btn_buscar.setBounds(cbx_dato.getWidth()+cbx_dato.getX()+30, 105, 150, 25);
        btn_todo.setBounds(btn_buscar.getWidth()+btn_buscar.getX()+30, 105, 150, 25);
        
        btn_actualizar.setBounds(btn_todo.getWidth()+btn_todo.getX()+30, 105, 150, 25);
        
        ScrollPane.setBounds(20,btn_buscar.getY()+50,700,300);
        lbl_informacion.setLocation(0, 0);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==btn_buscar){
            String campo = porBusquedaProfesor[cbx_consultar.getSelectedIndex()];
            
            if(cbx_consultar.getSelectedItem().equals("Grado")){
                String texto = Integer.toString(codigoGrado[cbx_dato.getSelectedIndex()]);
                lbl_informacion.setText(managerGradoMateria.generarTablaDeConsulta(texto,0));
            }
            if(cbx_consultar.getSelectedItem().equals("Materia")){
                String texto = codigoMateria[cbx_dato.getSelectedIndex()];
                lbl_informacion.setText(managerGradoMateria.generarTablaDeConsulta(texto,1));
            }
        }
        if(ae.getSource()==btn_todo){
            lbl_informacion.setText(managerGradoMateria.generarTablaDeConsulta());
        }
        if(ae.getSource()==btn_actualizar){
            if(cbx_consultar.getSelectedItem().equals("Grado")){
            cbx_dato.setTexto(Grados);
            }
            if(cbx_consultar.getSelectedItem().equals("Materia")){
                cbx_dato.setTexto(Materias);
            }
        }
        
    }
    
    
}
