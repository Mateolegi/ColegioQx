package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class Comienzo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int frame[] = {1100,700,pantalla.width,pantalla.height};
        
        
        Control_Instancias instancias = new Control_Instancias();
        Contenedor Lateral = new Contenedor(frame[0],frame[1],instancias);
        instancias.update(Lateral);
        
        JFrame ventana = new JFrame();
        instancias.update(ventana);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocation((frame[2]-frame[0])/2,(frame[3]-frame[1])/2);
        ventana.setSize(frame[0],frame[1]);
        ventana.add(Lateral);
        ventana.setVisible(true);
    }
    
}
