package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JEditorPaneArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JLabelArje;
import co.com.quipux.ColegioQuipux.util.Colores;
import co.com.quipux.ColegioQuipux.util.Fonts;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class Pnl_planillas extends JPanel{
    protected Control_Instancias pp;
    protected int width, heigth;
    /*JLABLE ARJE*/
    private JLabelArje lbl_titulo;
    /*JEditor Pane*/
    private JEditorPaneArje txt_informacion;
    
    
    public Pnl_planillas(Control_Instancias instancias,int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
        pp=instancias;
        
        lbl_titulo=  new JLabelArje();
            lbl_titulo.setTexto("Sección: Planillas", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_titulo);
        
        txt_informacion = new JEditorPaneArje();
            txt_informacion.setTexto(Fonts.txt_inicio+"<b>Planillas</b>"+
                Pnl_login.tipoUsuario+Fonts.txt_final);
            this.add(txt_informacion);
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Colores.blanco);
        setSize(width,heigth);
        
        lbl_titulo.setBounds(10, 0, 500, 25);
        
        txt_informacion.setBounds(10, 50, 500, 25);
    }
}
