package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;
import co.com.quipux.ColegioQuipux.models.dto.SesionDto;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JEditorPaneArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JLabelArje;
import co.com.quipux.ColegioQuipux.presentacion.util.Colores;
import co.com.quipux.ColegioQuipux.presentacion.util.Fonts;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class Pnl_inicio extends JPanel{
    protected Control_Instancias pp;
    protected int width, heigth;
    /*JLABLE ARJE*/
    private JLabelArje lbl_titulo;
    /*JEditor Pane*/
    private JEditorPaneArje txt_informacion,txt_sobreApp;
    
    boolean estudiante,profesor,adiministrador;
    
    String inforExclusiva="<b>Registros:</b> Sección exclusiva de administradores y profesores, "
                +"se encontrara todo lo concerniente a ingreso de registros a "
                +"la Base de Datos.";
    
    
    public Pnl_inicio(Control_Instancias instancias,int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        pp=instancias;
        
        lbl_titulo=  new JLabelArje();
            lbl_titulo.setTexto("Sección: Inicio", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_titulo);
        
        txt_informacion = new JEditorPaneArje();
            txt_informacion.setTexto("<b>Bienvenid@ </b>"+
                Pnl_login.tipoUsuario+" "+SesionDto.getNombre()+".");
            this.add(txt_informacion);
        if(Pnl_login.tipoUsuario.equals("Estudiante")){
            txt_sobreApp= new JEditorPaneArje();
            txt_sobreApp.setTexto("<b>Secciones: </b><br><br>"
                +"<b>Planillas:</b> Ver notas y podium.<br>"
                +"<b>Perfil:</b> Información personal.");
            this.add(txt_sobreApp);
        }else{
            txt_sobreApp= new JEditorPaneArje();
            txt_sobreApp.setTexto("<b>Secciones: </b><br><br>"
                +"<b>Registros:</b> Sección exclusiva de administradores y profesores, "
                +"se encontra todo lo concerniente a ingreso de registros a "
                +"la Base de Datos.<br>"
                +"<b>Planillas:</b> Permite ver las planillas de notas de los alumnos"
                +" vinculados a el grupo de cada profesor.<br>"
                +"<b>Perfil:</b> Información personal.");
            this.add(txt_sobreApp);
        }
        
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Colores.blanco);
        setSize(width,heigth);
        
        lbl_titulo.setBounds(10, 0, 500, 25);
        
        txt_informacion.setBounds(10, 50, 500, 25);
        txt_sobreApp.setBounds(10,100,500,400);
    }
}
