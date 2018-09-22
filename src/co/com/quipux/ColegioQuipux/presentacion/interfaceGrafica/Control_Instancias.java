/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class Control_Instancias {
    protected Menu menu;
    protected Contenedor contenedor;
    protected JFrame frame;
    protected JPanel contenido;
            
        
    public Control_Instancias() {
        menu = null;
        contenedor = null;
        frame = null;
        contenido = null;
    }
    
    /**
     * Guarda la instancia de los elementos
     * @param contenedor Object Contendor
     */
    public void update(Contenedor contenedor){
        this.contenedor = contenedor;
    }
    
    /**
     * Guarda la instancia de los elementos
     * @param menu Object menu
     */
    public void update(Menu menu){
        this.menu = menu;
    }
    
    /**
     * Guarda instancias de un objecto
     * @param frame Object - JFrame
     */
    public void update(JFrame frame){
        this.frame = frame;
    }
    
    /**
     * Guarda instancias de un obejto
     * @param panel Object - JPanel
     */
    public void update(JPanel contenido){
        this.contenido = contenido;
    }

    public Menu getMenu() {
        return menu;
    }

    public Contenedor getContenedor() {
        return contenedor;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getContenido() {
        return contenido;
    }
    
    
}
