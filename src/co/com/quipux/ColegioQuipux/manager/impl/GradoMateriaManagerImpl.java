/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.manager.impl;

import co.com.quipux.ColegioQuipux.dao.impl.GradoMateriaDaoImpl;
import co.com.quipux.ColegioQuipux.manager.GradoMateriaManager;
import co.com.quipux.ColegioQuipux.manager.sql.GradoMateriaManagerSQL;
import co.com.quipux.ColegioQuipux.models.dto.GradoMateriaDTO;
import co.com.quipux.ColegioQuipux.models.entity.GradoMateriaEntity;
import co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica.BDConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebas
 */
public class GradoMateriaManagerImpl implements GradoMateriaManager{

    GradoMateriaDaoImpl daoGradoMateria = new GradoMateriaDaoImpl();
    ArrayList<GradoMateriaDTO> consulta = new ArrayList<GradoMateriaDTO>();
    

    @Override
    public ArrayList<GradoMateriaDTO> consultarTodoGradoPorMateria() {
        consulta = new ArrayList<GradoMateriaDTO>();
        //ArrayList<ProfesorEntity> nombres = new ArrayList<ProfesorEntity>();
        BDConexion c = new BDConexion();
        try {
            PreparedStatement stm = c.getCon().prepareStatement(GradoMateriaManagerSQL.getGradoMateria());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                GradoMateriaDTO graMa=new GradoMateriaDTO();
                
                graMa = new GradoMateriaDTO();
                graMa.setNumeroGrado(rs.getString("gr.numeroGrado"));
                graMa.setIdMateria(rs.getString("ma.nombreMateria"));

                consulta.add(graMa);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "!Error¡ Clase: ProfesorDaoImpl. Metodo: getNombreDeProfesor. tipo de Error: " + ex.getMessage() + "\n");
            System.out.println("!Error¡ Clase: ProfesorDaoImpl. Metodo: getNombreDeProfesor. tipo de Error: " + ex.getMessage() + "\n");
            ex.printStackTrace();
        } finally {
            try {
                c.getCon().close();
            } catch (Exception e) {

            }
        }// Finaliza un bloque de excepciones
        return consulta;
    }

    @Override
    public ArrayList<GradoMateriaDTO> consultarPorGradoOMateria(String valorCampo,int GradoOMateria) {
        consulta = new ArrayList<GradoMateriaDTO>();
        BDConexion c = new BDConexion();
        try {
            PreparedStatement stm = c.getCon().prepareStatement(GradoMateriaManagerSQL.getGradoMateriaPorGrado(valorCampo));
            if(GradoOMateria==0){
                stm = c.getCon().prepareStatement(GradoMateriaManagerSQL.getGradoMateriaPorGrado(valorCampo));
                System.out.println("Entro al if");
            }
            else if(GradoOMateria==1){
                stm = c.getCon().prepareStatement(GradoMateriaManagerSQL.getGradoMateriaPorMateria(valorCampo));
                System.out.println("Entro al Else");
            }
            

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                GradoMateriaDTO graMa=new GradoMateriaDTO();
                
                graMa = new GradoMateriaDTO();
                graMa.setNumeroGrado(rs.getString("gr.numeroGrado"));
                graMa.setIdMateria(rs.getString("ma.nombreMateria"));

                consulta.add(graMa);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "!Error¡ Clase: ProfesorDaoImpl. Metodo: getNombreDeProfesor. tipo de Error: " + ex.getMessage() + "\n");
            System.out.println("!Error¡ Clase: ProfesorDaoImpl. Metodo: getNombreDeProfesor. tipo de Error: " + ex.getMessage() + "\n");
            ex.printStackTrace();
        } finally {
            try {
                c.getCon().close();
            } catch (Exception e) {

            }
        }
        return consulta;
    }
    
     public String generarTablaDeConsulta(String valor, int tipo) {
        //TR Filas TV Columnas
        String tabla = "<html><body><table>";

        tabla += "<tr bgcolor= \"#f4ea6a\"><td> Grado </td><td> Materia </td> </tr>";

        ArrayList<GradoMateriaDTO> LU = consultarPorGradoOMateria(valor, tipo);

        for (GradoMateriaDTO u : LU) {
            tabla += "<tr><td>" + u.getNumeroGrado()+ "</td><td>"
                    + u.getIdMateria() + "</td></tr>";
        }
        tabla += "</table></body></html>";
        return tabla;
    }
    
    public String generarTablaDeConsulta() {
        //TR Filas TV Columnas
        String tabla = "<html><body><table>";

        tabla += "<tr bgcolor= \"#f4ea6a\"><td> Grado </td><td> Materia </td> </tr>";

        ArrayList<GradoMateriaDTO> LU = consultarTodoGradoPorMateria();

        for (GradoMateriaDTO u : LU) {
            tabla += "<tr><td>" + u.getNumeroGrado()+ "</td><td>"
                    + u.getIdMateria() + "</td></tr>";
        }
        tabla += "</table></body></html>";
        return tabla;
    }
    
}
