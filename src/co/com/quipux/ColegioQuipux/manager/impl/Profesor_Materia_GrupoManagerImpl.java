/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.manager.impl;

import co.com.quipux.ColegioQuipux.manager.Profesor_Materia_GrupoManager;
import co.com.quipux.ColegioQuipux.manager.sql.Profesor_Materia_GrupoManagerSQL;
import co.com.quipux.ColegioQuipux.models.dto.Profesor_Materia_GrupoDTO;
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
public class Profesor_Materia_GrupoManagerImpl implements Profesor_Materia_GrupoManager{

    Profesor_Materia_GrupoDTO daoGradoMateria = new Profesor_Materia_GrupoDTO();
    ArrayList<Profesor_Materia_GrupoDTO> consulta = new ArrayList<Profesor_Materia_GrupoDTO>();
    
    @Override
    public Profesor_Materia_GrupoDTO llenarDatosGradoMateriaDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Profesor_Materia_GrupoDTO> consultarTodosLosGrupos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Profesor_Materia_GrupoDTO> consultarGruposPorCampos(String Campo, int index, String valor) {
        consulta = new ArrayList<Profesor_Materia_GrupoDTO>();
        //ArrayList<ProfesorEntity> nombres = new ArrayList<ProfesorEntity>();
        BDConexion c = new BDConexion();
        try (Connection con = c.getCon();PreparedStatement stm = c.getCon().
        prepareStatement(Profesor_Materia_GrupoManagerSQL.getGrupo(Campo,index,valor));){

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Profesor_Materia_GrupoDTO grupo=new Profesor_Materia_GrupoDTO();
                
                grupo.setNombreProfesor(rs.getString("ps.nombre"));
                grupo.setApellidoProfesor(rs.getString("ps.apellido"));
                grupo.setGrado(rs.getString("gd.numeroGrado"));
                grupo.setGrupo(rs.getString("gp.idGrupo"));
                grupo.setMateria(rs.getString("ma.nombreMateria"));
                

                consulta.add(grupo);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "!Error¡ Clase: ProfesorDaoImpl. Metodo: getNombreDeProfesor. tipo de Error: " + ex.getMessage() + "\n");
            System.out.println("!Error¡ Clase: ProfesorDaoImpl. Metodo: getNombreDeProfesor. tipo de Error: " + ex.getMessage() + "\n");
            ex.printStackTrace();
        }
        return consulta;
    }
    
    public String generarTablaDeConsulta(String campo,int index, String valor) {
        //TR Filas TV Columnas
        String tabla = "<html><body><table>";

        tabla += "<tr bgcolor= \"#f4ea6a\"><td> Profesor </td><td> Grado </td>"
            +"<td> Código de grupo </td><td> Materia </td> </tr>";

        ArrayList<Profesor_Materia_GrupoDTO> LU = consultarGruposPorCampos(campo,index,valor);

        for (Profesor_Materia_GrupoDTO u : LU) {
            tabla += "<tr><td>" + u.getNombreProfesor()+" "+u.getApellidoProfesor()+"</td><td>"
                    + u.getGrado() + "</td><td>"
                    + u.getGrupo()+ "</td><td>"
                    + u.getMateria()+ "</td></tr>";
        }
        tabla += "</table></body></html>";
        return tabla;
    }
    
}
