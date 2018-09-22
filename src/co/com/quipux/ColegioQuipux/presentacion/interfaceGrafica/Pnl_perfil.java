package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;
import co.com.quipux.ColegioQuipux.models.dto.SesionDto;
//import co.com.quipux.ColegioQuipux.presentacion.metodos.DarEdad;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JButtonArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JEditorPaneArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JLabelArje;
import co.com.quipux.ColegioQuipux.util.Colores;
import co.com.quipux.ColegioQuipux.util.Fonts;
import co.com.quipux.ColegioQuipux.util.Tiempo;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class Pnl_perfil extends JPanel implements ActionListener{
    protected Control_Instancias pp;
    protected int width, heigth;
    /*JLABLE ARJE*/
    private JLabelArje lbl_titulo;
    /*JEditor Pane*/
    private JEditorPaneArje txt_informacion;
    /*JButtonArje*/
    private JButtonArje btn_cerrarSesion;
    
    Tiempo t = new  Tiempo();
    //DarEdad ed = new DarEdad();
    
    //String edad = ed.edad();
    
    public Pnl_perfil(Control_Instancias instancias,int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        pp=instancias;
        
        System.out.println("Sistema: Año "+t.getAno()+" Mes "+t.getMes()+" Día "+t.getDia());
        
        lbl_titulo=  new JLabelArje();
            lbl_titulo.setTexto("Sección: Perfil", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_titulo);
        
        txt_informacion = new JEditorPaneArje();
            txt_informacion.setTexto("<b>Nombres:</b> "+SesionDto.getNombre()+".<br><br>"
                +"<b>Apellidos: </b>"+SesionDto.getApellido()+".<br><br>"
                +"<b>"+SesionDto.getIdTipoDocumento()+": </b>"+SesionDto.getNumeroDocumento()+".<br><br>"
                +"<b>Edad: </b>.<br><br>"
                +"<b>Correo: </b>"+SesionDto.getCorreo()+".<br>");
            this.add(txt_informacion);
            
        btn_cerrarSesion = new JButtonArje("Cerrar Sesión",Colores.pantone276C, Colores.pantone388C, Colores.pantone388C,Colores.pantone276C);
            btn_cerrarSesion.addActionListener(this);
            btn_cerrarSesion.setFonts(0, 16, 1);
            this.add(btn_cerrarSesion);
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Colores.blanco);
        setSize(width,heigth);
        
        lbl_titulo.setBounds(10, 0, 500, 25);
        
        txt_informacion.setBounds(10, 50, 500, 500);
        
        btn_cerrarSesion.setBounds(width-250, 600, 150, 25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_cerrarSesion){
            pp.getContenedor().ValidarCerrarSeccion();
        }
    }
}
