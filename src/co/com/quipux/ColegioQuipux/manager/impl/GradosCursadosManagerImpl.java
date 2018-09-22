/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.manager.impl;

import co.com.quipux.ColegioQuipux.manager.GradosCursadosManager;
import co.com.quipux.ColegioQuipux.manager.sql.GradosCursadosManagerSQL;
import co.com.quipux.ColegioQuipux.models.dto.GradosCursadosDTO;
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
public class GradosCursadosManagerImpl implements GradosCursadosManager{
    
    GradosCursadosDTO daoGradosCursados = new GradosCursadosDTO();
    ArrayList<GradosCursadosDTO> consulta = new ArrayList<GradosCursadosDTO>();

    @Override
    public GradosCursadosDTO llenarDatosGradoMateriaDTO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<GradosCursadosDTO> consultarGradosCursados(int index, String valor) {
        consulta = new ArrayList<GradosCursadosDTO>();
        //ArrayList<ProfesorEntity> nombres = new ArrayList<ProfesorEntity>();
        BDConexion c = new BDConexion();
        try (Connection con = c.getCon();PreparedStatement stm = c.getCon().
        prepareStatement(GradosCursadosManagerSQL.getGradosCursados(index,valor));){

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                GradosCursadosDTO gradosCu=new GradosCursadosDTO();
                /*gc.idGradoCursado, gd.numeroGrado, es.nombre,"+
                    " es.apellido, gc.ano, gc.estado, gc.notaPromedio"*/
                
                gradosCu.setIdGradoCursado(rs.getInt("gc.idGradoCursado"));
                gradosCu.setNumeroGrado(rs.getString("gd.numeroGrado"));
                gradosCu.setNombre(rs.getString("es.nombre"));
                gradosCu.setApellido(rs.getString("es.apellido"));
                gradosCu.setAno(rs.getString("gc.ano"));
                gradosCu.setEstado(rs.getString("gc.estado"));
                
                if(gradosCu.getEstado().equals("1")){
                    gradosCu.setEstado("Cursando");
                }
                if(gradosCu.getEstado().equals("2")){
                    gradosCu.setEstado("Aprobado");
                }
                if(gradosCu.getEstado().equals("3")){
                    gradosCu.setEstado("Reprobado");
                }
                
                gradosCu.setNotaPromedio(rs.getDouble("gc.notaPromedio"));
                

                consulta.add(gradosCu);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "!Error¡ Clase: GradosCursadosManagerImpl. Metodo: consultarGradosCursados. tipo de Error: " + ex.getMessage() + "\n");
            System.out.println("!Error¡ Clase: GradosCursadosManagerImpl. Metodo: consultarGradosCursados. tipo de Error: " + ex.getMessage() + "\n");
            ex.printStackTrace();
        }
        return consulta;
    }
    
    public String generarTablaDeConsulta(int index, String valor) {
        //TR Filas TV Columnas
        String tabla = "<html><body><table>";
        
        /*gc.idGradoCursado, gd.numeroGrado, es.nombre,"+
                    " es.apellido, gc.ano, gc.estado, gc.notaPromedio"*/
        
        tabla += "<tr bgcolor= \"#f4ea6a\"><td> Código </td><td> Año </td><td> Estudiante </td>"
            +"<td> Grado </td><td> Estado </td><td> Nota Promedio </td> </tr>";

        ArrayList<GradosCursadosDTO> LU = consultarGradosCursados(index, valor);

        for (GradosCursadosDTO u : LU) {
            tabla += "<tr><td>" + u.getIdGradoCursado()+ "</td>" +u.getAno()+ "</td><td>"
                    + u.getNombre()+ " " + u.getApellido() + "</td><td>"
                    + u.getNumeroGrado()+ "</td><td>"
                    + u.getEstado()+ "</td><td>"
                    + u.getNotaPromedio()+ "</td></tr>";
        }
        tabla += "</table></body></html>";
        return tabla;
    }
    
}
