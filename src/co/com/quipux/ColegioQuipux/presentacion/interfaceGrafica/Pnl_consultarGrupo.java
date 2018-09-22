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
import co.com.quipux.ColegioQuipux.manager.impl.GrupoManagerImpl;
import co.com.quipux.ColegioQuipux.manager.impl.ProfesorManagerImpl;
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
public class Pnl_consultarGrupo extends JPanel implements ActionListener{
    protected int width, height;
    protected Control_Instancias pp;
    /*JLABLE ARJE*/
    private JLabelArje lbl_titulo,lbl_informacion,lbl_dato,lbl_consultarPor;
    /*JButtonArje*/
    private JButtonArje btn_buscar,btn_todo;
    /*DAO y DTO*/
    GradoDaoImpl daoGrado= new GradoDaoImpl();
    GrupoManagerImpl managerGrupo =new GrupoManagerImpl();
    MateriasDaoImpl daoMateria = new MateriasDaoImpl();
    /*JTextFieldHint*/
    private JTextFieldHint txt_consulta;
    /*JComboboxArje*/
    private JComboboxArje cbx_consultar;
    
    JScrollPane ScrollPane;
    
    String[] EnviarGrupo = {"idGrupo","gr.nombre","gd.numeroGrado","cantidadEstudiantes","Jornada"};
    String[] mostrarGrupo = {"Código de grupo", "Coordinador","#Grado",
        "Cantidad de estudiantes","Jornada"};
    
    public Pnl_consultarGrupo(Control_Instancias instancia, int width,int height){
        this.width=width;
        this.height=height;
        pp=instancia;
        
        lbl_titulo =  new JLabelArje();
            lbl_titulo.setTexto("Sección: Consultar - Grupo.", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
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
            String campo = EnviarGrupo[cbx_consultar.getSelectedIndex()];
            String texto = txt_consulta.getText();
            
            if(EnviarGrupo[cbx_consultar.getSelectedIndex()].equals("gr.nombre")){
                lbl_informacion.setText(managerGrupo.generarTablaDeConsulta(campo, 0, texto));
                System.out.println("Entro al gr.nombre");
            }
            if(EnviarGrupo[cbx_consultar.getSelectedIndex()].equals("gd.numeroGrado")){
                lbl_informacion.setText(managerGrupo.generarTablaDeConsulta(campo, 1, texto));
                System.out.println("Entro al gr.nombre");
            }
            if(!EnviarGrupo[cbx_consultar.getSelectedIndex()].equals("gd.numeroGrado") && !EnviarGrupo[cbx_consultar.getSelectedIndex()].equals("gr.nombre")){
                lbl_informacion.setText(managerGrupo.generarTablaDeConsulta(campo, 2, texto));
                System.out.println("Entro al gr.nombre");
            }
        }
        if(ae.getSource()==btn_todo){
            lbl_informacion.setText(managerGrupo.generarTablaDeConsulta());
        }
        
    }
    
    
}
