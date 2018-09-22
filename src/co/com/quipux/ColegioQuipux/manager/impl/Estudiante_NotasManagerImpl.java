/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.manager.impl;

import co.com.quipux.ColegioQuipux.manager.Estudiante_NotasManager;
import co.com.quipux.ColegioQuipux.manager.sql.Estudiante_NotasManagerSQL;
import co.com.quipux.ColegioQuipux.models.dto.Estudiante_NotasDTO;
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
public class Estudiante_NotasManagerImpl implements Estudiante_NotasManager{
    
    Estudiante_NotasDTO daoGradoMateria = new Estudiante_NotasDTO();
    ArrayList<Estudiante_NotasDTO> consulta = new ArrayList<Estudiante_NotasDTO>();

    @Override
    public Estudiante_NotasDTO llenarDatosGradoMateriaDTO() {
        return null;
    }

    @Override
    public ArrayList<Estudiante_NotasDTO> consultarNotasDeEstudiantes(int index, String valor) {
        consulta = new ArrayList<Estudiante_NotasDTO>();
        BDConexion c = new BDConexion();
        try (Connection con = c.getCon();PreparedStatement stm = c.getCon().
        prepareStatement(Estudiante_NotasManagerSQL.getGradosCursados(index, valor));){

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Estudiante_NotasDTO gradosCu=new Estudiante_NotasDTO();
                /*es.nombre,es.apellido,ma.nombreMateria,notas.valorNota, 
                tiNo.tipoNota,tiNo.nombreNota, tiNo.FechaEntrega*/
                
                gradosCu.setNombreEstudiante(rs.getString("es.nombre"));
                gradosCu.setApellidoEstudiante(rs.getString("es.apellido"));
                gradosCu.setNombreMateria(rs.getString("ma.nombreMateria"));
                gradosCu.setValorNota(rs.getDouble("notas.valorNota"));
                gradosCu.setTipoNota(rs.getString("tiNo.tipoNota"));
                gradosCu.setNombreNota(rs.getString("tiNo.nombreNota"));
                gradosCu.setDescripcionNota(rs.getString("tiNo.FechaEntrega"));

                consulta.add(gradosCu);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "!Error¡ Clase: Estudiante_NotasManagerImpl. Metodo: consultarNotasDeEstudiantes. tipo de Error: " + ex.getMessage() + "\n");
            System.out.println("!Error¡ Clase: Estudiante_NotasManagerImpl. Metodo: consultarNotasDeEstudiantes. tipo de Error: " + ex.getMessage() + "\n");
            ex.printStackTrace();
        }
        return consulta;
    }
    @Override
    public String generarTablaDeConsulta(int index, String valor) {
        //TR Filas TV Columnas
        String tabla = "<html><body><table>";
        
        /*es.nombre,es.apellido,ma.nombreMateria,notas.valorNota, 
                tiNo.tipoNota,tiNo.nombreNota, tiNo.descripcion"*/
        System.out.println(""+index);
        
        tabla += "<tr bgcolor= \"#f4ea6a\" ><td> Estudiante </td><td> Materia </td><td> Valor de nota </td>"
            +"<td> Tipo de Nota </td><td> Nombre de nota </td><td> Fecha de Entrega </td> </tr>";

        ArrayList<Estudiante_NotasDTO> LU = consultarNotasDeEstudiantes(index, valor);

        for (Estudiante_NotasDTO u : LU) {
            tabla += "<tr><td>" + u.getNombreEstudiante()+" "+u.getApellidoEstudiante() +"</td>" +u.getNombreMateria()+ "</td><td>"
                    + u.getValorNota()+ "</td><td>"
                    + u.getTipoNota()+ "</td><td>"
                    + u.getNombreNota()+ "</td><td>"
                    + u.getDescripcionNota()+ "</td></tr>";
        }
        tabla += "</table></body></html>";
        return tabla;
    }
    
}
