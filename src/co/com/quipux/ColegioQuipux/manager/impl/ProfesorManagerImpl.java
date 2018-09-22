/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.manager.impl;

import co.com.quipux.ColegioQuipux.dao.impl.ProfesorDaoImpl;
import co.com.quipux.ColegioQuipux.dao.sql.EstudianteSQL;
import co.com.quipux.ColegioQuipux.manager.ProfesorManager;
import co.com.quipux.ColegioQuipux.manager.sql.ProfesorManagerSQL;
import co.com.quipux.ColegioQuipux.models.dto.ProfesorConsultaSimpleDTO;
import co.com.quipux.ColegioQuipux.models.dto.ProfesorDTO;
import co.com.quipux.ColegioQuipux.models.entity.ProfesorEntity;
import co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica.BDConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebas
 */
public class ProfesorManagerImpl implements ProfesorManager {

    ProfesorDaoImpl profesorDao = new ProfesorDaoImpl();

    ArrayList<ProfesorEntity> consulta = new ArrayList<ProfesorEntity>();

    @Override
    public ProfesorConsultaSimpleDTO consultaSimpleProfesor(int idProfesor) {
        ProfesorConsultaSimpleDTO profesorSimpleDto = new ProfesorConsultaSimpleDTO();

        ProfesorEntity profesorEntity = profesorDao.consultarProfesor(idProfesor);

        profesorSimpleDto.setNombre(profesorEntity.getNombre());
        profesorSimpleDto.setApellido(profesorEntity.getApellido());
        profesorSimpleDto.setCorreo(profesorEntity.getCorreo());

        return profesorSimpleDto;
    }

    @Override
    public boolean registrarProfesor(ProfesorDTO profesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<ProfesorEntity> getListaProfesorPorCampos(String campo, String valor) {
        // Crear Objetos en java
        consulta = new ArrayList<>();
        BDConexion c = new BDConexion();
        //Excepciones

        try {
            Connection conection = c.getCon();
            PreparedStatement st = conection.prepareStatement("SELECT idProfesor,idTipoDocumento,numeroDocumento,nombre,apellido,correo FROM tbl_profesor WHERE "+campo+" LIKE '%"+valor+"%'");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                //id_cedula,nombre,clave,correo,estado,estrato
                ProfesorEntity objU = new ProfesorEntity();
                objU.setIdProfesor(rs.getInt("idProfesor"));
                objU.setIdTipoDocumento(rs.getInt(2));
                objU.setNumeroDocumento(rs.getString(3));
                objU.setNombre(rs.getString("nombre"));
                objU.setApellido(rs.getString("apellido"));
                objU.setCorreo(rs.getString("correo"));

                consulta.add(objU);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                c.getCon().close();
            } catch (Exception e) {

            }

        }// Finaliza un bloque de excepciones

        return consulta;
    }

    public String generarTablaDeConsulta(String campo, String valor) {
        //TR Filas TV Columnas
        String tabla = "<html><body><table>";

        tabla += "<tr bgcolor= \"#f4ea6a\"><td> ID </td><td> Nombre </td><td> Apellido </td></td> Correo </td> </tr>";

        ArrayList<ProfesorEntity> LU = getListaProfesorPorCampos(campo, valor);

        for (ProfesorEntity u : LU) {
            tabla += "<tr><td>" + u.getIdProfesor() + "</td><td>"
                    + u.getNombre() + "</td><td>" + u.getApellido() + "</td><td>" + u.getCorreo() + "</td> </tr>";
        }
        tabla += "</table></body></html>";
        return tabla;
    }

    public ArrayList<ProfesorEntity> getListaProfesorPorCampos() {
        // Crear Objetos en java
        consulta = new ArrayList<>();
        BDConexion c = new BDConexion();
        //Excepciones

        try {
            Connection conection = c.getCon();
            Statement st = conection.createStatement();
            ResultSet rs = st.executeQuery(ProfesorManagerSQL.getProfesores());

            while (rs.next()) {
                //id_cedula,nombre,clave,correo,estado,estrato
                ProfesorEntity objU = new ProfesorEntity();
                objU.setIdProfesor(rs.getInt("idProfesor"));
                objU.setIdTipoDocumento(rs.getInt(2));
                objU.setNumeroDocumento(rs.getString(3));
                objU.setNombre(rs.getString("nombre"));
                objU.setApellido(rs.getString("apellido"));
                objU.setCorreo(rs.getString("correo"));

                consulta.add(objU);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                c.getCon().close();
            } catch (Exception e) {

            }

        }// Finaliza un bloque de excepciones

        return consulta;
    }

    public String generarTablaDeConsulta() {
        //TR Filas TV Columnas
        String tabla = "<html><body><table>";

        tabla += "<tr bgcolor= \"#f4ea6a\"><td> ID </td><td> Nombre </td><td> Apellido </td></td> Correo </td> </tr>";

        ArrayList<ProfesorEntity> LU = getListaProfesorPorCampos();

        for (ProfesorEntity u : LU) {
            tabla += "<tr><td>" + u.getIdProfesor() + "</td><td>"
                    + u.getNombre() + "</td><td>" + u.getApellido() + "</td><td>" + u.getCorreo() + "</td> </tr>";
        }
        tabla += "</table></body></html>";
        return tabla;
    }

    public ArrayList<String> getNombreDeProfesores(String busqueda) {
        ArrayList<String> ArrayProfesoress = new ArrayList<>();
        //ArrayList<ProfesorEntity> nombres = new ArrayList<ProfesorEntity>();
        BDConexion c = new BDConexion();
        try {
            PreparedStatement stm = c.getCon().prepareStatement("SELECT nombre,apellido FROM tbl_profesor WHERE idProfesor LIKE '%?%'");
            stm.setString(1, busqueda);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                ProfesorEntity objU = new ProfesorEntity();
                objU.setIdProfesor(rs.getInt("idProfesor"));
                objU.setNombre(rs.getString("nombre"));
                objU.setApellido(rs.getString("apellido"));

                ArrayProfesoress.add(rs.getString("nombre") + " " + rs.getString("apellido"));
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
        return ArrayProfesoress;
    }

    @Override
    public String[] nombreProfesores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
