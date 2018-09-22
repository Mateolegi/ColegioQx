/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.manager.impl;

import co.com.quipux.ColegioQuipux.manager.EstudianteManager;
import co.com.quipux.ColegioQuipux.manager.sql.EstudianteManagerSQL;
import co.com.quipux.ColegioQuipux.models.dto.EstudianteDTO;
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
public class EstudianteManagerImpl implements EstudianteManager {

    EstudianteDTO daoGradoMateria = new EstudianteDTO();
    ArrayList<EstudianteDTO> consulta = new ArrayList<EstudianteDTO>();

    @Override
    public EstudianteDTO llenarDatosGradoMateriaDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<EstudianteDTO> consultarEstudiantes(int index, String valor) {
        consulta = new ArrayList<EstudianteDTO>();
        BDConexion c = new BDConexion();
        try (Connection con = c.getCon(); PreparedStatement stm = c.getCon().
                prepareStatement(EstudianteManagerSQL.getEstudiante(index, valor));) {

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                EstudianteDTO Estudiante = new EstudianteDTO();

                Estudiante.setIdEstudiante(rs.getInt("es.idEstudiante"));
                Estudiante.setNombreEstudiante(rs.getString("es.nombre"));
                Estudiante.setApellidoEstudiante(rs.getString("es.apellido"));
                Estudiante.setSiglas(rs.getString("td.siglas"));
                Estudiante.setNumeroDocumento(rs.getString("es.numeroDocumento"));
                Estudiante.setFechaNacimiento(rs.getString("es.fechaNacimiento"));
                Estudiante.setSexo(rs.getString("es.sexo"));
                Estudiante.setNombreCiudad(rs.getString("cd.nombreCiudad"));
                Estudiante.setTelefonoResidencial(rs.getString("es.telefonoResidencial"));
                Estudiante.setTelefonoCelular(rs.getString("es.telefonoCelular"));
                Estudiante.setCorreo(rs.getString("es.correo"));
                consulta.add(Estudiante);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "!Error¡ Clase: EstudianteManagerImpl. Metodo: consultarEstudiantes. tipo de Error: " + ex.getMessage() + "\n");
            System.out.println("!Error¡ Clase: EstudianteManagerImpl. Metodo: consultarEstudiantes. tipo de Error: " + ex.getMessage() + "\n");
            ex.printStackTrace();
        }
        return consulta;
    }

    @Override
    public String generarTablaDeConsulta(int index, String valor) {
        String tabla = "<html><body><table>";
        System.out.println("" + index);

        tabla += "<tr bgcolor= \"#f4ea6a\"><td> ID </td>"
                + "<td> Estudiante </td>"
                + "<td> TD </td>"
                + "<td> # Documento </td>"
                + "<td> Fecha Nacimiento </td>"
                + "<td> Sexo </td>"
                + "<td> Ciudad Residencia </td>"
                + "<td> Teléfono Residencial </td>"
                + "<td> Teléfono Celular </td>"
                + "<td> Correo </td></tr>";

        ArrayList<EstudianteDTO> LU = consultarEstudiantes(index, valor);

        for (EstudianteDTO u : LU) {
            tabla += "<tr><td>" + u.getIdEstudiante()+ "</td><td>"
                    + u.getNombreEstudiante()+" "+ u.getApellidoEstudiante() + "</td><td>"
                    + u.getSiglas()+ "</td><td>"
                    + u.getNumeroDocumento()+ "</td><td>"
                    + u.getFechaNacimiento()+ "</td><td>"
                    + u.getSexo()+ "</td><td>"
                    + u.getNombreCiudad()+ "</td><td>"
                    + u.getTelefonoResidencial()+ "</td><td>"
                    + u.getTelefonoCelular()+ "</td><td>"
                    + u.getCorreo()+ "</td></tr>";
        }
        tabla += "</table></body></html>";
        return tabla;
    }

}
