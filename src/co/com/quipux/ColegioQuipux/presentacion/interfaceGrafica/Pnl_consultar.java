/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;

import co.com.quipux.ColegioQuipux.presentacion.metodos.JButtonArje;
import co.com.quipux.ColegioQuipux.presentacion.metodos.JLabelArje;
import co.com.quipux.ColegioQuipux.util.Colores;
import co.com.quipux.ColegioQuipux.util.Fonts;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Sebas
 */
public class Pnl_consultar extends JPanel implements ActionListener {

    protected int width, height;
    protected Control_Instancias pp;
    /*JLABLE ARJE*/
    private JLabelArje lbl_titulo,lbl_buscarProfesor,lbl_gradoMateria,lbl_profesorMateriaGrupo,
            lbl_grupo,lbl_notasEstudiante,lbl_gradosCursados,lbl_estudiante;
    /*JButtonArje*/
    private JButtonArje btn_Buscarprofesor, btn_gradoMateria, btn_ProfesorMateriaGrupo,
            btn_grupo, btn_notasEstudiante, btn_gradosCursados,btn_estudiante;
    int alineacion=0;

    public Pnl_consultar(Control_Instancias instancia, int width, int height) {
        this.width = width;
        this.height = height;
        pp = instancia;

        lbl_titulo = new JLabelArje();
            lbl_titulo.setTexto("Sección: Consultar.", Fonts.Lato, 1, 14, Colores.pantone276C, 0);
            this.add(lbl_titulo);
           
        lbl_buscarProfesor = new JLabelArje();
            lbl_buscarProfesor.setTexto("Profesores: ", Fonts.Lato, 1, 14, Colores.pantone1645C, alineacion);
            this.add(lbl_buscarProfesor);
            
        lbl_gradoMateria = new JLabelArje();
            lbl_gradoMateria.setTexto("Materias por grado:", Fonts.Lato, 1, 14, Colores.pantone1645C, alineacion);
            this.add(lbl_gradoMateria);
            
        lbl_profesorMateriaGrupo = new JLabelArje();
            lbl_profesorMateriaGrupo.setTexto("Materias que da un profesor y a que grados: ", Fonts.Lato, 1, 14, Colores.pantone1645C, alineacion);
            this.add(lbl_profesorMateriaGrupo);
            
        lbl_grupo = new JLabelArje();
            lbl_grupo.setTexto("Grupos: ", Fonts.Lato, 1, 14, Colores.pantone1645C, alineacion);
            this.add(lbl_grupo);
            
        lbl_notasEstudiante = new JLabelArje();
            lbl_notasEstudiante.setTexto("Notas de estudiantes: ", Fonts.Lato, 1, 14, Colores.pantone1645C, alineacion);
            this.add(lbl_notasEstudiante);
            
        lbl_gradosCursados = new JLabelArje();
            lbl_gradosCursados.setTexto("Grados cursados por estudiantes: ", Fonts.Lato, 1, 14, Colores.pantone1645C, alineacion);
            this.add(lbl_gradosCursados);
            
        lbl_estudiante = new JLabelArje();
            lbl_estudiante.setTexto("Estudiantes: ", Fonts.Lato, 1, 14, Colores.pantone1645C, alineacion);
            this.add(lbl_estudiante);

        btn_Buscarprofesor = new JButtonArje("Profesor", 0, 16, 1, Colores.pantone319C, Colores.pantone276C);
            btn_Buscarprofesor.addActionListener(this);
            this.add(btn_Buscarprofesor);

        btn_gradoMateria = new JButtonArje("Grado Materia", 0, 16, 1, Colores.pantone319C, Colores.pantone276C);
            btn_gradoMateria.addActionListener(this);
            this.add(btn_gradoMateria);
            
        btn_grupo = new JButtonArje("Grupo", 0, 16, 1, Colores.pantone319C, Colores.pantone276C);
            btn_grupo.addActionListener(this);
            this.add(btn_grupo);
            
        btn_ProfesorMateriaGrupo = new JButtonArje("Pro.Mat.Gru", 0, 16, 1, Colores.pantone319C, Colores.pantone276C);
            btn_ProfesorMateriaGrupo.addActionListener(this);
            this.add(btn_ProfesorMateriaGrupo);
            
        btn_gradosCursados = new JButtonArje("Gra.Cursados", 0, 16, 1, Colores.pantone319C, Colores.pantone276C);
            btn_gradosCursados.addActionListener(this);
            this.add(btn_gradosCursados);
            
        btn_notasEstudiante = new JButtonArje("Not.Estudiantes", 0, 16, 1, Colores.pantone319C, Colores.pantone276C);
            btn_notasEstudiante.addActionListener(this);
            this.add(btn_notasEstudiante);
            
        btn_estudiante = new JButtonArje("Estudiante", 0, 16, 1, Colores.pantone319C, Colores.pantone276C);
            btn_estudiante.addActionListener(this);
            this.add(btn_estudiante);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.setBackground(Color.white);
        setSize(width, height);

        lbl_titulo.setBounds(10, 0, 500, 25);
        int disIni=20;
        lbl_buscarProfesor.setBounds(disIni, 100-25, 500, 25);
        btn_Buscarprofesor.setBounds(disIni, 100, 150, 25);
        lbl_gradoMateria.setBounds(disIni, 100+60-25, 500, 25);
        btn_gradoMateria.setBounds(disIni, 100+60, 150, 25);
        lbl_grupo.setBounds(disIni, 100+60*2-25, 500, 25);
        btn_grupo.setBounds(disIni, 100+60*2, 150, 25);
        lbl_profesorMateriaGrupo.setBounds(disIni, 100+60*3-25, 500, 25);
        btn_ProfesorMateriaGrupo.setBounds(disIni, 100+60*3, 150, 25);
        lbl_gradosCursados.setBounds(disIni, 100+60*4-25, 500, 25);
        btn_gradosCursados.setBounds(disIni, 100+60*4, 150, 25);
        lbl_notasEstudiante.setBounds(disIni, 100+60*5-25, 500, 25);
        btn_notasEstudiante.setBounds(disIni, 100+60*5, 150, 25);
        lbl_estudiante.setBounds(disIni, 100+60*6-25, 500, 25);
        btn_estudiante.setBounds(disIni, 100+60*6, 150, 25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_Buscarprofesor) {
            pp.getContenedor().setPantallasConsultar(0);
        }
        if (e.getSource() == btn_gradoMateria) {
            pp.getContenedor().setPantallasConsultar(1);
        }
        if (e.getSource() == btn_grupo) {
            pp.getContenedor().setPantallasConsultar(2);
        }
        if (e.getSource() == btn_ProfesorMateriaGrupo) {
            pp.getContenedor().setPantallasConsultar(3);
        }
        if (e.getSource() == btn_gradosCursados) {
            pp.getContenedor().setPantallasConsultar(4);
        }
        if (e.getSource() == btn_notasEstudiante) {
            pp.getContenedor().setPantallasConsultar(5);
        }
        if (e.getSource() == btn_estudiante) {
            pp.getContenedor().setPantallasConsultar(6);
        }
        
    }

}
