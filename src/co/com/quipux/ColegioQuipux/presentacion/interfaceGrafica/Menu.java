package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;

import co.com.quipux.ColegioQuipux.presentacion.metodos.JButtonArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JLabelArje;
import co.com.quipux.ColegioQuipux.presentacion.util.Colores;
import co.com.quipux.ColegioQuipux.presentacion.util.Fonts;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class Menu extends JPanel implements ActionListener{
    protected final int width,height;
    protected Control_Instancias pp;
    private JButtonArje btn_inicio,btn_planillas,btn_perfil;
    private JButtonArje btn_registrar,btn_consultar;
    private JLabelArje lbl_title;
    private boolean inicio=false,planillas=true,perfil=true,registrar=true,consultar=false;
    
    public Menu(Control_Instancias instancias, int width, int height) {
        this.width = width;
        this.height = height;
        pp = instancias;
        
        lbl_title=  new JLabelArje();
            lbl_title.setTexto("Quik Academy", Fonts.Lato, 1, 20, Colores.pantone388C, 1);
            add(lbl_title);
        
        btn_inicio = new JButtonArje("Inicio",Colores.pantone276C, Colores.pantone388C, Colores.pantone388C,Colores.pantone276C);
            btn_inicio.addActionListener(this);
            btn_inicio.setFonts(0, 16, 1);
            add(btn_inicio);
        
        if(!Pnl_login.tipoUsuario.equals("Estudiante")){
            btn_registrar = new JButtonArje("Registrar",Colores.pantone276C, Colores.pantone388C, Colores.pantone388C,Colores.pantone276C);
                btn_registrar.addActionListener(this);
                btn_registrar.setFonts(0, 16, 1);
                this.add(btn_registrar);
                
            btn_consultar= new JButtonArje("Consultar",Colores.pantone276C, Colores.pantone388C, Colores.pantone388C,Colores.pantone276C);
                btn_consultar.addActionListener(this);
                btn_consultar.setFonts(0, 16, 1);
                this.add(btn_consultar);
        }
        
        
        btn_planillas = new JButtonArje("Planillas",Colores.pantone276C, Colores.pantone388C, Colores.pantone388C,Colores.pantone276C);
            btn_planillas.addActionListener(this);
            btn_planillas.setFonts(0, 16, 1);
            add(btn_planillas);
        
        btn_perfil= new JButtonArje("Perfil",Colores.pantone276C, Colores.pantone388C, Colores.pantone388C,Colores.pantone276C);
            btn_perfil.addActionListener(this);
            btn_perfil.setFonts(0, 16, 1);
            add(btn_perfil);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Colores.pantone276C);
        setSize(width, height);
        
        lbl_title.setBounds(0, 0, 275, 50);
        if(!Pnl_login.tipoUsuario.equals("Estudiante")){
            btn_registrar.setEnabled(true);
            btn_registrar.setVisible(true);
            
            btn_inicio.setBounds(((width/4)-180)/2, 100, 180, 40);
            btn_registrar.setBounds(((width/4)-180)/2, 100+48, 180, 40);
            btn_consultar.setBounds(((width/4)-180)/2, 100+48*2, 180, 40);
            btn_planillas.setBounds(((width/4)-180)/2, 100+48*3, 180, 40);
            btn_perfil.setBounds(((width/4)-180)/2, 100+48*4, 180, 40);
        }else{
            btn_registrar.setEnabled(false);
            btn_registrar.setVisible(false);
            
            btn_inicio.setBounds(((width/4)-180)/2, 100, 180, 40);
            btn_planillas.setBounds(((width/4)-180)/2, 100+48, 180, 40);
            btn_perfil.setBounds(((width/4)-180)/2, 100+48*2, 180, 40);
        }
        
        btn_inicio.setHabilitarCambio(inicio);
        btn_registrar.setHabilitarCambio(registrar);
        btn_planillas.setHabilitarCambio(planillas);
        btn_perfil.setHabilitarCambio(perfil);
        btn_consultar.setHabilitarCambio(consultar);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_inicio){
            pp.getContenedor().setPantallasPrincipales(0);
        }
        if(e.getSource() == btn_registrar){
            pp.getContenedor().setPantallasPrincipales(1);
            inicio=true;
        }
        
        if(e.getSource() == btn_planillas){
            pp.getContenedor().setPantallasPrincipales(2);
        }
        
        if(e.getSource()==btn_consultar){
            pp.getContenedor().setPantallasPrincipales(4);
        }
        
        if(e.getSource() == btn_perfil){
            pp.getContenedor().setPantallasPrincipales(3);
        }
    }
}
