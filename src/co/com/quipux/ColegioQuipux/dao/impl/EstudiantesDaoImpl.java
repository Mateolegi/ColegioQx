/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao.impl;

import co.com.quipux.ColegioQuipux.dao.EstudianteDAO;
import co.com.quipux.ColegioQuipux.dao.sql.EstudianteSQL;
import co.com.quipux.ColegioQuipux.dao.sql.MateriasSQL;
import co.com.quipux.ColegioQuipux.models.entity.EstudianteEntity;
import co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica.BDConexion;
import co.com.quipux.ColegioQuipux.util.Tiempo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
public class EstudiantesDaoImpl implements EstudianteDAO {

    private ArrayList<EstudianteEntity> listaEstudiante = new ArrayList<EstudianteEntity>();

    @Override
    public boolean registrarEstudiante(EstudianteEntity estudiante) {
        boolean validacion = false;
        BDConexion c = new BDConexion();
        String resultado = "";
        Tiempo t = new Tiempo();
        try (Connection con = c.getCon(); PreparedStatement pst = con.prepareStatement(EstudianteSQL.getInsertarEstudiante());) {

            pst.setInt(1, estudiante.getIdEstudiante());
            pst.setInt(2, estudiante.getIdTipoDocumento());
            pst.setInt(3, estudiante.getIdCiudadResidencial());
            pst.setString(4, estudiante.getNumeroDocumento());
            pst.setString(5, estudiante.getNombre());
            pst.setString(6, estudiante.getApellido());
            pst.setString(7, estudiante.getFechaNacimiento());
            pst.setString(8, estudiante.getSexo());
            pst.setString(9, estudiante.getDireccionResidencial());
            pst.setString(10, estudiante.getTelefonoResidencial());
            pst.setString(11, estudiante.getTelefonoCelular());
            pst.setString(12, estudiante.getCorreo());
            pst.setString(13, estudiante.getClave());
            pst.execute();

            if (pst.getUpdateCount() >= 1) {
                resultado = "Usuario Almacenado";
                System.out.println(resultado);
                validacion = true;
            } else {
                resultado = "Error al guardar";
                System.out.println(resultado);
                validacion = false;
            }

        } catch (Exception ex) {

            resultado += "¡Error! clase: EstudiantesDaoImpl, Metodo: registrarEstudiante() Tipo de error:\n" + ex.getMessage() + "\n Line: \n";
            ex.printStackTrace();
            System.out.println(resultado);
        }

        return validacion;
    }

    @Override
    public EstudianteEntity consultarEstudiante(int idEstudiante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String generarCodigoEstudiante() {
        String Codigo = "";
        BDConexion conexion = new BDConexion();
        Tiempo t = new Tiempo();
        try {
            Connection conection = conexion.getCon();
            Statement st = conection.createStatement();
            ResultSet rs = st.executeQuery(EstudianteSQL.codigoEstudiante(t));
            if (rs.next()) {
                Codigo = rs.getString(1);
            } else {
                Codigo = "La consulta no ha funcionado";
            }
        } catch (Exception ex) {
            System.out.println("¡Error! clase: Dao, Metodo: getCodigoAlumno() Tipo de error:\n" + ex.getMessage() + "\n Line: \n");
            ex.printStackTrace();
        } finally {
            try {
                conexion.getCon().close();
                System.out.println("Se cerro la conexión");
            } catch (Exception ex) {
            }//FIN CATCH
        }//FIN FINALLY
        return Codigo;
    }

}
