/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;

import co.com.quipux.ColegioQuipux.dao.impl.CiudadResidencialDaoImpl;
import co.com.quipux.ColegioQuipux.dao.impl.ProfesorDaoImpl;
import co.com.quipux.ColegioQuipux.dao.impl.TipoDocumentoDaoImpl;
import co.com.quipux.ColegioQuipux.models.entity.EstudianteEntity;
import co.com.quipux.ColegioQuipux.models.entity.ProfesorEntity;
import co.com.quipux.ColegioQuipux.models.dto.SesionDto;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JButtonArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JComboboxArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JLabelArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JTextFieldHint;
import co.com.quipux.ColegioQuipux.util.Tiempo;
import co.com.quipux.ColegioQuipux.util.Colores;
import co.com.quipux.ColegioQuipux.util.Fonts;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sebas
 */
public class Pnl_registrosProfesor extends JPanel implements ActionListener{
    protected Control_Instancias pp;
    protected int width, heigth;
    /*JLABLE ARJE*/
    private JLabelArje lbl_titulo,lbl_nombre,lbl_apellidos,lbl_numeroDocumento,
        lbl_correo,lbl_clave;
    /*JTextField*/
    private JTextFieldHint txt_nombre,txt_apellidos,txt_numeroDocumento,
        txt_correo,txt_clave;
    /*DAOS*/
    TipoDocumentoDaoImpl daoTipoDocumento=new TipoDocumentoDaoImpl();
    CiudadResidencialDaoImpl daoCiudadResidencial=new CiudadResidencialDaoImpl();
    ProfesorDaoImpl daoProfesoreDao= new ProfesorDaoImpl();
    /*JCOMBOARJE*/
    private JComboboxArje cbx_tipoDocumento;
        String[] TipoDocumento=daoTipoDocumento.getListadoSiglas();
        int[] codigoTipoDoc=daoTipoDocumento.getCodigoTipoDocumento();
        int idTipoDoc=0;
        /* Departamento, país, y ciudad.*/
    /*JBUTTONARJE*/
    private JButtonArje btn_enviar;
    
    /*CODIGO*/
    Tiempo t = new  Tiempo();
    
    public Pnl_registrosProfesor(Control_Instancias instancias,int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        pp=instancias;
        
        lbl_titulo=new JLabelArje();
            lbl_titulo.setTexto("Sección: Registro - Profesor", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_titulo);
            
        lbl_nombre=new JLabelArje();
            lbl_nombre.setTexto("Nombres: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_nombre);
            
        lbl_apellidos=new JLabelArje();
            lbl_apellidos.setTexto("Apellidos: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_apellidos);
            
        lbl_numeroDocumento=new JLabelArje();
            lbl_numeroDocumento.setTexto("Número documento: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_numeroDocumento);
            
        lbl_correo=new JLabelArje();
            lbl_correo.setTexto("Correo: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_correo);
            
        lbl_clave=new JLabelArje();
            lbl_clave.setTexto("clave: ", Fonts.Lato, 1, 13, Colores.pantone276C, 0);
            this.add(lbl_clave);
            
        txt_nombre=new JTextFieldHint();
            txt_nombre.setHint("Nombres");
            this.add(txt_nombre);
            
        txt_apellidos=new JTextFieldHint();
            txt_apellidos.setHint("Apellidos");
            this.add(txt_apellidos);
            
        cbx_tipoDocumento=new JComboboxArje(TipoDocumento);
            this.add(cbx_tipoDocumento);
            
        txt_numeroDocumento=new JTextFieldHint();
            txt_numeroDocumento.setHint("#Documento");
            this.add(txt_numeroDocumento);
            
        txt_correo=new JTextFieldHint();
            txt_correo.setHint("Ejemplo@gmail.com");
            this.add(txt_correo);
            
        txt_clave=new JTextFieldHint();
            txt_clave.setHint("Clave");
            this.add(txt_clave);
            
        btn_enviar=new JButtonArje("Enviar", 1, 16, 1, Colores.pantone319C, Colores.pantone276C);
            btn_enviar.addActionListener(this);
            this.add(btn_enviar);
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Colores.blanco);
        
        setSize(width,heigth);
        
        lbl_titulo.setBounds(10, 0, 500, 25);
        int x=20;
        
        lbl_nombre.setBounds(x, 50, 150, 25);
        txt_nombre.setBounds(x, 75, 150, 25);
        lbl_apellidos.setBounds(x+txt_nombre.getWidth()+20, 50, 150, 25);
        txt_apellidos.setBounds(x+txt_nombre.getWidth()+20, 75, 150, 25);
        
        cbx_tipoDocumento.setLocation(x, txt_nombre.getY()+45);
        lbl_numeroDocumento.setBounds(x+cbx_tipoDocumento.getWidth()+10, txt_nombre.getY()+25, 150, 25);
        txt_numeroDocumento.setBounds(x+cbx_tipoDocumento.getWidth()+10, txt_nombre.getY()+50, 150, 25);
        
        lbl_correo.setBounds(x, txt_numeroDocumento.getY()+25, 300, 25);
        txt_correo.setBounds(x, txt_numeroDocumento.getY()+50, 300, 25);
        
        lbl_clave.setBounds(x, txt_correo.getY()+25, 150, 25);
        txt_clave.setBounds(x, txt_correo.getY()+55, 150, 25);
        
        btn_enviar.setBounds(x, txt_clave.getY()+150, 150, 25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_enviar){
            ProfesorEntity es=new ProfesorEntity();
            
            idTipoDoc = codigoTipoDoc[cbx_tipoDocumento.getSelectedIndex()];
            
            es.setIdProfesor(1);
            es.setIdTipoDocumento(idTipoDoc);
            es.setNumeroDocumento(txt_numeroDocumento.getText());
            es.setNombre(txt_nombre.getText());
            es.setApellido(txt_apellidos.getText());
            es.setCorreo(txt_correo.getText());
            es.setClave(txt_clave.getText());
            
            if(daoProfesoreDao.registrarProfesor(es)){
                JOptionPane.showMessageDialog(null, "Datos Correcos","Aviso",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Datos incorrectos, revise la información de nuevo por favor","Mensaje Error",JOptionPane.ERROR_MESSAGE);    
            }
            
        }
        
    }
}
