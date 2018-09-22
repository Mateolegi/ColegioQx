/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.manager.impl;

import co.com.quipux.ColegioQuipux.dao.impl.GrupoDaoImpl;
import co.com.quipux.ColegioQuipux.manager.GrupoManager;
import co.com.quipux.ColegioQuipux.manager.sql.GrupoManagerSQL;
import co.com.quipux.ColegioQuipux.models.dto.GradoMateriaDTO;
import co.com.quipux.ColegioQuipux.models.dto.GrupoDTO;
import co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica.BDConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebas
 */
public class GrupoManagerImpl implements GrupoManager{
    GrupoDaoImpl daoGradoMateria = new GrupoDaoImpl();
    ArrayList<GrupoDTO> consulta = new ArrayList<GrupoDTO>();

    @Override
    public GrupoDTO llenarDatosGradoMateriaDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<GrupoDTO> consultarTodosLosGrupos() {
        consulta = new ArrayList<GrupoDTO>();
        //ArrayList<ProfesorEntity> nombres = new ArrayList<ProfesorEntity>();
        BDConexion c = new BDConexion();
        try {
            PreparedStatement stm = c.getCon().prepareStatement(GrupoManagerSQL.getGrupo());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                GrupoDTO grupo=new GrupoDTO();
                
                grupo.setIdGrupo(rs.getString("idGrupo"));
                grupo.setNombreProfesor(rs.getString("gr.nombre"));
                grupo.setNumeroGrado(rs.getString("gd.numeroGrado"));
                grupo.setCantidadEstudiantes(rs.getInt("cantidadEstudiantes"));
                grupo.setJornada(rs.getString("jornada"));
                

                consulta.add(grupo);
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
    public ArrayList<GrupoDTO> consultarGruposPorCampos(String campo,int index, String valor) {
        consulta = new ArrayList<GrupoDTO>();
        //ArrayList<ProfesorEntity> nombres = new ArrayList<ProfesorEntity>();
        BDConexion c = new BDConexion();
        try (Connection con = c.getCon();PreparedStatement stm = c.getCon().
        prepareStatement(GrupoManagerSQL.getGrupo(campo,index,valor));){

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                GrupoDTO grupo=new GrupoDTO();
                
                grupo.setIdGrupo(rs.getString("idGrupo"));
                grupo.setNombreProfesor(rs.getString("gr.nombre"));
                grupo.setNumeroGrado(rs.getString("gd.numeroGrado"));
                grupo.setCantidadEstudiantes(rs.getInt("cantidadEstudiantes"));
                grupo.setJornada(rs.getString("jornada"));
                

                consulta.add(grupo);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "!Error¡ Clase: ProfesorDaoImpl. Metodo: getNombreDeProfesor. tipo de Error: " + ex.getMessage() + "\n");
            System.out.println("!Error¡ Clase: ProfesorDaoImpl. Metodo: getNombreDeProfesor. tipo de Error: " + ex.getMessage() + "\n");
            ex.printStackTrace();
        }
        return consulta;
    }
    
    public String generarTablaDeConsulta() {
        //TR Filas TV Columnas
        String tabla = "<html><body><table>";

        tabla += "<tr bgcolor= \"#f4ea6a\"><td> Código </td><td> Coordinador </td><td> Grado </td>"
            +"<td> # Estudiantes </td><td> Jornada </td> </tr>";

        ArrayList<GrupoDTO> LU = consultarTodosLosGrupos();

        for (GrupoDTO u : LU) {
            tabla += "<tr><td>" + u.getIdGrupo()+ "</td><td>"
                    + u.getNombreProfesor() + "</td><td>"
                    + u.getNumeroGrado() + "</td><td>"
                    + u.getCantidadEstudiantes() + "</td><td>"
                    + u.getJornada() + "</td></tr>";
        }
        tabla += "</table></body></html>";
        return tabla;
    }
    
    public String generarTablaDeConsulta(String campo,int index, String valor) {
        //TR Filas TV Columnas
        String tabla = "<html><body><table>";

        tabla += "<tr bgcolor= \"#f4ea6a\"><td> Código </td><td> Coordinador </td><td> Grado </td>"
            +"<td> # Estudiantes </td><td> Jornada </td> </tr>";

        ArrayList<GrupoDTO> LU = consultarGruposPorCampos(campo,index,valor);

        for (GrupoDTO u : LU) {
            tabla += "<tr><td>" + u.getIdGrupo()+ "</td><td>"
                    + u.getNombreProfesor() + "</td><td>"
                    + u.getNumeroGrado() + "</td><td>"
                    + u.getCantidadEstudiantes() + "</td><td>"
                    + u.getJornada() + "</td></tr>";
        }
        tabla += "</table></body></html>";
        return tabla;
    }
    
}
