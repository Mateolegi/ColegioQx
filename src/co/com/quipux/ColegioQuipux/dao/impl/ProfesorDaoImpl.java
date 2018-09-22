/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao.impl;

import co.com.quipux.ColegioQuipux.dao.ProfesorDAO;
import co.com.quipux.ColegioQuipux.dao.sql.ProfesorSQL;
import co.com.quipux.ColegioQuipux.models.entity.ProfesorEntity;
import co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica.BDConexion;
import co.com.quipux.ColegioQuipux.util.Tiempo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebas
 */
public class ProfesorDaoImpl implements ProfesorDAO {

    private ArrayList<ProfesorEntity> ArrayProfesores = new ArrayList<ProfesorEntity>();

    @Override
    public boolean registrarProfesor(ProfesorEntity profesor) {
        boolean validacion = false;
        BDConexion c = new BDConexion();
        String resultado = "";
        Tiempo t = new Tiempo();
        try (Connection con = c.getCon(); PreparedStatement pst = con.prepareStatement(ProfesorSQL.insertarProfesor());) {

            pst.setString(1, null);
            pst.setInt(2, profesor.getIdTipoDocumento());
            pst.setString(3, profesor.getNumeroDocumento());
            pst.setString(4, profesor.getNombre());
            pst.setString(5, profesor.getApellido());
            pst.setString(6, profesor.getCorreo());
            pst.setString(7, profesor.getClave());
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
    public ProfesorEntity consultarProfesor(int idProfesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProfesorEntity> getNombreDeProfesores() {
        ArrayProfesores = new ArrayList<ProfesorEntity>();
        //ArrayList<ProfesorEntity> nombres = new ArrayList<ProfesorEntity>();
        BDConexion c = new BDConexion();
        try {
            PreparedStatement stm = c.getCon().prepareStatement(ProfesorSQL.getNombreProfesores());

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                ProfesorEntity objU = new ProfesorEntity();
                objU.setIdProfesor(rs.getInt("idProfesor"));
                objU.setNombre(rs.getString("nombre"));
                objU.setApellido(rs.getString("apellido"));

                ArrayProfesores.add(objU);
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
        return ArrayProfesores;
    }

    @Override
    public String[] getListadoProfesor() {
        //TR Filas TV Columnas
        ArrayProfesores = getNombreDeProfesores();
        String[] tabla = new String[ArrayProfesores.size()];
        int i = 0;
        for (ProfesorEntity u : ArrayProfesores) {
            tabla[i] = "" + u.getNombre() + " " + u.getApellido();
            i++;
        }

        return tabla;
    }

    @Override
    public int[] getCodigoProfesor() {
        //TR Filas TV Columnas
        ArrayProfesores = getNombreDeProfesores();

        int[] tabla = new int[ArrayProfesores.size()];

        int i = 0;
        for (ProfesorEntity u : ArrayProfesores) {
            tabla[i] = u.getIdProfesor();
            i++;
        }

        return tabla;
    }

    public ArrayList<ProfesorEntity> getArrayProfesores() {
        return ArrayProfesores;
    }

    public void setArrayProfesores(ArrayList<ProfesorEntity> ArrayProfesores) {
        this.ArrayProfesores = ArrayProfesores;
    }

}
