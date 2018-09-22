/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.metodos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class JButtonArje extends JButton implements MouseListener,FocusListener{
    String rutaImagen1="",rutaImagen2="",formatoImagen1="",formatoImagen2="";
    boolean habilitarCambio = true;
    //Selección solo con letras.
    Color colorLetra1,colorLetra2;
    Color colorFondo1,colorFondo2;
    //INDEX DE CASOS
    int index=0;
    //ICONOS, IMAGEN ESCALADA y TAMAÑOS A ESCALAR-----------
    Icon iconoEscalado;
    Image imgEscalada;
    ImageIcon imgIcon;
    int width=0,height=0;
    
    public JButtonArje(){
        
    }
    
    public JButtonArje(String texto, int propiedad,int tamano,int index,
        Color colorTexto,Color colorBoton){
        this.setText(texto);
        this.setFonts(propiedad, tamano, index);
        this.setBackground(colorBoton);
        this.setForeground(colorTexto);
        this.setFocusPainted(false);
    }
    
    public JButtonArje(String rutaImagen1, String rutaImagen2, String formatoImagen1,String formatoImagen2){
        this.rutaImagen1=rutaImagen1;
        this.rutaImagen2=rutaImagen2;
        this.formatoImagen1=formatoImagen1;
        this.formatoImagen2=formatoImagen2;
        
        this.addMouseListener(this);
        this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+rutaImagen1+"."+formatoImagen1+"")));
        
        this.setBorderPainted(false);
        this.setFocusable(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        
        index=0;
    }// Fin btn Imagen sin tamaño
    
    public JButtonArje(String rutaImagen1, String rutaImagen2, String formatoImagen1,String formatoImagen2,boolean habilitarCambio){
        this.rutaImagen1=rutaImagen1;
        this.rutaImagen2=rutaImagen2;
        this.formatoImagen1=formatoImagen1;
        this.formatoImagen2=formatoImagen2;
        
        
        if(habilitarCambio){
            this.addMouseListener(this);
            this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+rutaImagen1+"."+formatoImagen1+"")));    
        }else{
            this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+rutaImagen2+"."+formatoImagen2+"")));    
        }
        
        
        this.setBorderPainted(false);
        this.setFocusable(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        
        index=4;
    }// Fin btn Imagen sin tamaño
    
    public JButtonArje(String rutaImagen1, String rutaImagen2, String formatoImagen1,String formatoImagen2,int width, int height){
        this.rutaImagen1=rutaImagen1;
        this.rutaImagen2=rutaImagen2;
        this.formatoImagen1=formatoImagen1;
        this.formatoImagen2=formatoImagen2;
        this.width=width;
        this.height=height;
        
        this.addMouseListener(this);
        this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+rutaImagen1+"."+formatoImagen1+"")));
        
        this.setBorderPainted(false);
        this.setFocusable(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        
        index=2;
        
        try{
        imgIcon = new ImageIcon(getClass().getResource("/"+rutaImagen1+"."+formatoImagen1+""));
        
        imgEscalada = imgIcon.getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH);
        
        iconoEscalado = new ImageIcon(imgEscalada);
        this.setIcon(iconoEscalado);
        }catch(Exception ex){
            System.out.println("Error en clase JButtonArje; Constructor Imagen con tamaño escalado; Tipo de error: "
            +ex.getMessage());
        }
        
        
    }//FIN btn Imagen con tamaño
    
    public JButtonArje(Color colorLetra1, Color colorLetra2, Font tipoGrafia,String texto){
        this.colorLetra1=colorLetra1;
        this.colorLetra2=colorLetra2;
        
        this.setBorderPainted(false);
        this.setFocusable(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        
        this.setText(texto);
        
        this.addMouseListener(this);
        
        this.setForeground(colorLetra1);
        this.setFont(tipoGrafia);
        index=1;
    }
    
    public JButtonArje(String texto,Color colorFondo1, Color colorFondo2,Color colorLetra1,Color colorLetra2){
        this.colorLetra1=colorLetra1;
        this.colorLetra2=colorLetra2;
        this.colorFondo1=colorFondo1;
        this.colorFondo2=colorFondo2;
        
        this.addMouseListener(this);
        this.setFocusPainted(false);
        
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, colorFondo2));
        this.setText(texto);
        
        this.setForeground(colorLetra1);
        this.setBackground(colorFondo1);
        index=3;
    }
    
    public JButtonArje(String texto,Color colorFondo1, Color colorFondo2,Color colorLetra1,Color colorLetra2,boolean habilitarCambio){
        this.colorLetra1=colorLetra1;
        this.colorLetra2=colorLetra2;
        this.colorFondo1=colorFondo1;
        this.colorFondo2=colorFondo2;
        
        this.addMouseListener(this);
        this.setFocusPainted(false);
        
        
        this.setText(texto);
        
        if(!habilitarCambio){
            this.setForeground(colorLetra2);
            this.setBackground(colorFondo2);
            this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, colorFondo1));
            System.out.println("Entro a if, en contructor");
        }else{
            this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, colorFondo2));
            this.setForeground(colorLetra1);
            this.setBackground(colorFondo1);
            System.out.println("Entro a else, en contructor");
        }
        
        index=5;
    }
    
    public void setTexto(String texto,int propiedad,int tamanoLetra,int index){
        switch(index){
            case 0:
                this.setFont(new Font ("Lato",propiedad,tamanoLetra));
                this.setText(texto);
                break;
            case 1:
                this.setFont(new Font ("Microsoft New Tai Lue",propiedad,tamanoLetra));
                break;
                
            case 3:
                this.setText(texto);
                this.setFont(new Font ("Lato",propiedad,tamanoLetra));
            default:
                System.out.println("Indice no encontrado");
                break;
        }
        
    }
    
    public void setFonts(int propiedad,int tamanoLetra,int index){
        switch(index){
            case 0:
                this.setFont(new Font ("Lato",propiedad,tamanoLetra));
                break;
            case 1:
                this.setFont(new Font ("Microsoft New Tai Lue",propiedad,tamanoLetra));
                break;
            default:
                System.out.println("Indice no encontrado");
                break;
        }
        
    }
    
    public JButtonArje(String rutaImagen1, String rutaImagen2, String formatoImagen1,String formatoImagen2,String a){
        this.rutaImagen1=rutaImagen1;
        this.rutaImagen2=rutaImagen2;
        this.formatoImagen1=formatoImagen1;
        this.formatoImagen2=formatoImagen2;
        
        this.addMouseListener(this);
        this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+rutaImagen1+"."+formatoImagen1+"")));
        
        this.setBorderPainted(false);
        this.setFocusable(true);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        
        this.addFocusListener(this);
        
        index=0;
    }// Fin btn Imagen sin tamaño
    

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        switch(index){
            case 0:
                this.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
                this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+rutaImagen2+"."+formatoImagen2+"")));
                break;
                
            case 1:
                this.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
                this.setForeground(colorLetra2);
                break;
            case 2:
                this.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
                imgIcon = new ImageIcon(getClass().getResource("/"+rutaImagen2+"."+formatoImagen2+""));
        
                imgEscalada = imgIcon.getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH);
        
                iconoEscalado = new ImageIcon(imgEscalada);
                this.setIcon(iconoEscalado);
                
                this.repaint();
                break;
            case 3:
                this.setBackground(colorFondo2);
                this.setForeground(colorLetra2);
                break;
            case 4:
                if(!habilitarCambio){
                    
                }else{
                    this.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
                    this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+rutaImagen2+"."+formatoImagen2+"")));
                }
                break;
            case 5:
                    this.setBackground(colorFondo2);
                    this.setForeground(colorLetra2);
                    System.out.println("Entro ");
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        switch(index){
            case 0:
                this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+rutaImagen1+"."+formatoImagen1+"")));
                this.setBorderPainted(false);
                break;
                
            case 1:
                this.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
                this.setForeground(colorLetra1);
                break;
            case 2:
                this.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
                imgIcon = new ImageIcon(getClass().getResource("/"+rutaImagen1+"."+formatoImagen1+""));
        
                imgEscalada = imgIcon.getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH);
        
                iconoEscalado = new ImageIcon(imgEscalada);
                this.setIcon(iconoEscalado);
                
                this.repaint();
                
            break;
            
            case 3:
                this.setBackground(colorFondo1);
                this.setForeground(colorLetra1);
                break;
            case 4:
                if(!habilitarCambio){
                    this.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
                    this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+rutaImagen2+"."+formatoImagen2+"")));
                }else{
                    this.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
                    this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+rutaImagen1+"."+formatoImagen1+"")));
                }
                break;
            case 5:
                if(!habilitarCambio){
                    this.setBackground(colorFondo2);
                    this.setForeground(colorLetra2);
                    System.out.println("Entro a if, mouseExited");
                }else{
                    this.setBackground(colorFondo1);
                    this.setForeground(colorLetra1);
                    System.out.println("Entro a else, mouseExited");
                }
                
                break;
        }
    }

    @Override
    public void focusGained(FocusEvent fe) {
        switch(index){
            case 0:
                this.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
                this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+rutaImagen2+"."+formatoImagen2+"")));
                break;
                
            case 1:
                this.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
                this.setForeground(colorLetra2);
                break;
            case 2:
                this.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
                imgIcon = new ImageIcon(getClass().getResource("/"+rutaImagen2+"."+formatoImagen2+""));
        
                imgEscalada = imgIcon.getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH);
        
                iconoEscalado = new ImageIcon(imgEscalada);
                this.setIcon(iconoEscalado);
                
                this.repaint();
                break;
            case 3:
                this.setBackground(colorFondo2);
                this.setForeground(colorLetra2);
                break;
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
        switch(index){
            case 0:
                this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/"+rutaImagen1+"."+formatoImagen1+"")));
                this.setBorderPainted(false);
                break;
                
            case 1:
                this.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
                this.setForeground(colorLetra1);
                break;
            case 2:
                this.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
                imgIcon = new ImageIcon(getClass().getResource("/"+rutaImagen1+"."+formatoImagen1+""));
        
                imgEscalada = imgIcon.getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH);
        
                iconoEscalado = new ImageIcon(imgEscalada);
                this.setIcon(iconoEscalado);
                
                this.repaint();
                
            break;
            
            case 3:
                this.setBackground(colorFondo1);
                this.setForeground(colorLetra1);
                break;
        }
    }

    public boolean isHabilitarCambio() {
        return habilitarCambio;
    }

    public void setHabilitarCambio(boolean habilitarCambio) {
        this.habilitarCambio = habilitarCambio;
    }
    
    
    
}
