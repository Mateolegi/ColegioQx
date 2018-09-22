/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.metodos;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class IconAjustado {
    public Icon iconoEscalado;
    
    public IconAjustado(){
        
    }
    
    public  void setTamano(String ruta,String formato,JLabel lbImage) {
        try{
            ImageIcon imgIcon = new ImageIcon(getClass().getResource("/Imagenes/"+ruta+"."+formato+""));
        
        Image imgEscalada = imgIcon.getImage().getScaledInstance(lbImage.getWidth(),
            lbImage.getHeight(), Image.SCALE_SMOOTH);
        
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        
        lbImage.setIcon(iconoEscalado);
        }catch(Exception ex){
            System.out.println("Clase: IconAjustado, Metodo: setTamano, Tipo de error: "+ex.getMessage()+"\n"+ex.getLocalizedMessage());
        }
    }
    
    public ImageIcon setTamano(String ruta,String formato,int ancho, int alto) {
        try{
            ImageIcon imgIcon = new ImageIcon(getClass().getResource("/Imagenes/"+ruta+"."+formato+""));
        
        Image imgEscalada = imgIcon.getImage().getScaledInstance(ancho,
            alto, Image.SCALE_SMOOTH);
        
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        
        }catch(Exception ex){
            System.out.println("Clase: IconAjustado, Metodo: setTamano, Tipo de error: "+ex.getMessage()+"\n"+ex.getLocalizedMessage());
        }
        return (ImageIcon) iconoEscalado;
    }
    
    public ImageIcon setTamano(String clase,String ruta,String formato,int ancho, int alto) {
        try{
            ImageIcon imgIcon = new ImageIcon(getClass().getResource("/"+clase+"/"+ruta+"."+formato+""));
        
        Image imgEscalada = imgIcon.getImage().getScaledInstance(ancho,
            alto, Image.SCALE_SMOOTH);
        
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        
        }catch(Exception ex){
            System.out.println("Clase: IconAjustado, Metodo: setTamano, Tipo de error: "+ex.getMessage()+"\n"+ex.getLocalizedMessage());
        }
        return (ImageIcon) iconoEscalado;
    }
    
}
