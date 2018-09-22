/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;
import co.com.quipux.ColegioQuipux.dao.impl.SesionDaoImpl;
import co.com.quipux.ColegioQuipux.models.dto.SesionDto;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JButtonArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JComboboxArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JLabelArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JPasswordFieldHint;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JTextFieldHint;
import co.com.quipux.ColegioQuipux.presentacion.util.Colores;
import co.com.quipux.ColegioQuipux.presentacion.util.Fonts;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 * 
 * Las clases contenidas en los paquetes de Utilidades y Metodos son de autoria propia
 * Normalmente terminan en Arje.
 */
public class Pnl_login extends JPanel implements ActionListener{
    protected int width,height;
    protected Control_Instancias pp;
    /*JLABELARJE (Creación de clase personalizada autoria Jhon Sebastian Agudelo Sierra)*/
    private JLabelArje lbl_titulo;
    /*JTexfieldHint lo mismo que el de arriba @Jhon Sebastian Agudelo Sierra*/
    private JTextFieldHint txt_documentoUsuario;
    /*JPasswordFieldHint lo mismo que el de arriba @Jhon Sebastian Agudelo Sierra*/
    private JPasswordFieldHint pwt_clave;
    /*JButtonArje lo mismo que el primero @Jhon Sebastian Agudelo Sierra*/
    private JButtonArje btn_ingresar,btn_volver;
    /*JLabelArje lo mismo que el primero @Jhon Sebastian Agudelo Sierra*/
    private JLabelArje lbl_tipoUsuario,lbl_documentoUsuario,lbl_clave;
    /*Enteros*/
    String [] ary_tipoUsuario={"Estudiante","Profesor","Administrador"};
    /*Datos para validar*/
    public static String tipoUsuario="";
    public String documento="",clave="";
    
    public Pnl_login(Control_Instancias instancia,int width,int height){
        this.width=width;
        this.height=height;
        this.pp=instancia;
        
        lbl_titulo=new JLabelArje();
            lbl_titulo.setTexto("Quik Academy", Fonts.Lato, 1, 50, Colores.pantone388C, 1);
            this.add(lbl_titulo);
            
        lbl_tipoUsuario=new JLabelArje();
            lbl_tipoUsuario.setTexto("Tipo de usuario: "+tipoUsuario, Fonts.Lato, 0, 15, Colores.pantone276C, 0);
            this.add(lbl_tipoUsuario);
            
        lbl_documentoUsuario=new JLabelArje();
            lbl_documentoUsuario.setTexto("Número de documento: ", Fonts.Lato, 0, 14, Colores.pantone276C, 0);
            this.add(lbl_documentoUsuario);
            
        lbl_clave=new JLabelArje();
            lbl_clave.setTexto("Clave: ", Fonts.Lato, 0, 14, Colores.pantone276C, 0);
            this.add(lbl_clave);
            
        txt_documentoUsuario=new JTextFieldHint();
            txt_documentoUsuario.setHint("Número de documento");
            this.add(txt_documentoUsuario);
            
        pwt_clave=new JPasswordFieldHint();
            pwt_clave.setHint("Holacomoesta");
            this.add(pwt_clave);
            
        btn_ingresar=new JButtonArje("Btn_flechaDerecha", "Btn_flechaDerechaSeleccion", "png", "png","a");
            btn_ingresar.addActionListener(this);
            this.add(btn_ingresar);
            
        btn_volver=new JButtonArje();
            btn_volver.addActionListener(this);
            btn_volver.setBackground(Colores.pantone276C);
            btn_volver.setForeground(Colores.pantone388C);
            btn_volver.setText("Regresar");
            btn_volver.setFonts(0, 16,0);
            this.add(btn_volver);
            
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Color.white);
        this.setSize(width, height);
        
        lbl_titulo.setLocation((width-lbl_titulo.getWidth())/2, 100);
        
        lbl_documentoUsuario.setBounds((width-200)/2, (height-200)/2-25, 200, 25);
        txt_documentoUsuario.setBounds((width-200)/2, (height-200)/2, 200, 25);
        
        lbl_clave.setBounds((width-200)/2, txt_documentoUsuario.getY()+25, 200, 25);
        pwt_clave.setBounds((width-200)/2, txt_documentoUsuario.getY()+50, 200, 25);
        
        lbl_tipoUsuario.setLocation((width-lbl_tipoUsuario.getWidth())/2, pwt_clave.getY()+50);
        btn_ingresar.setBounds((width-175)/2, lbl_tipoUsuario.getY()+75, 175, 175);
        
        btn_volver.setBounds(20, height-65, 150, 25);
        
    }
    
    public static void setUsuario(String Usuario){
       tipoUsuario=Usuario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_volver){
            tipoUsuario="";
            pp.getContenedor().setPantallaLogin(0);
        }
        
        if(e.getSource()==btn_ingresar){
            //pp.getContenedor().validarInicioDeSeccion();
            documento=txt_documentoUsuario.getText();
            clave=pwt_clave.getText();
            SesionDto usuario= new SesionDto();
            
            SesionDaoImpl dao = new SesionDaoImpl();
            
            usuario.setNumeroDocumento(txt_documentoUsuario.getText());
            usuario.setClave(pwt_clave.getText());
            
            if(tipoUsuario.equals("Estudiante")){
                if(dao.validacionSesionEstudiante()){
                System.out.println("¡Ingreso de usuario! 2.5");
                
                pp.getContenedor().validarInicioDeSeccion();
                usuario.setNumeroDocumento(documento);
                
                }else{
                
                System.out.println("Usuario: "+usuario.getNumeroDocumento()+" Clave: "+usuario.getClave());    
                    
                System.out.println("Else Estudiante");
                JOptionPane.showMessageDialog(null, "Ingreso de sesión no valido");
                txt_documentoUsuario.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red));
                pwt_clave.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red));
                }
            }
            if(tipoUsuario.equals("Profesor")){
                if(dao.validacionSesionProfesores()){
                System.out.println("¡Ingreso de usuario! 2.5");
                
                pp.getContenedor().validarInicioDeSeccion();
                usuario.setNumeroDocumento(documento);
                
                }else{
                    
                System.out.println("Usuario: "+usuario.getNumeroDocumento()+" Clave: "+usuario.getClave());
                
                System.out.println("Else Profesor");
                JOptionPane.showMessageDialog(null, "Ingreso de sesión no valido");
                txt_documentoUsuario.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red));
                pwt_clave.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red));
                }
            }
            
            if(tipoUsuario.equals("Administrador")){
                if(dao.validacionSesionAdministrador()){
                System.out.println("¡Ingreso de usuario! 2.5");
                
                pp.getContenedor().validarInicioDeSeccion();
                usuario.setNumeroDocumento(documento);
                
                }else{
                    
                    System.out.println("Usuario: "+usuario.getNumeroDocumento()+" Clave: "+usuario.getClave());
                    
                System.out.println("Else Administrador");
                JOptionPane.showMessageDialog(null, "Ingreso de sesión no valido");
                txt_documentoUsuario.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red));
                pwt_clave.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red));
                }
            }
            
            
        }
    
    }
    
}
