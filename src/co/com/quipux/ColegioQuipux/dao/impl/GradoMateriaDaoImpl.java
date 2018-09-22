/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao.impl;

import co.com.quipux.ColegioQuipux.dao.sql.GrupoSQL;
import co.com.quipux.ColegioQuipux.dao.sql.ProfesorSQL;
import co.com.quipux.ColegioQuipux.models.entity.GradoMateriaEntity;
import co.com.quipux.ColegioQuipux.models.entity.ProfesorEntity;
import co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica.BDConexion;
import co.com.quipux.ColegioQuipux.util.Tiempo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import co.com.quipux.ColegioQuipux.dao.GradoMateriaDAO;
import co.com.quipux.ColegioQuipux.dao.sql.GradoMateriaSQL;

/**
 *
 * @author Sebas
 */
public class GradoMateriaDaoImpl implements GradoMateriaDAO{
    
    ArrayList<GradoMateriaEntity> listaGradoMateria;

    @Override
    public boolean registrarGradoMateria(GradoMateriaEntity GM) {
        boolean validacion =false;
        BDConexion c = new BDConexion();
        String resultado = "";
        Tiempo t = new Tiempo();
        try{
            PreparedStatement pst= c.getCon().prepareStatement(GrupoSQL.getInsertarGrupo());
            
                pst.setInt(1,GM.getIdGrado());
                pst.setString(2,GM.getIdMateria());
                pst.execute();
                
            if(pst.getUpdateCount()>=1){
                resultado = "Usuario Almacenado";
                System.out.println(resultado);
                validacion =true;
            }else{
                resultado = "Error al guardar";
                System.out.println(resultado);
                validacion =false;
            }
            
        }catch(Exception ex){
            
         resultado+= "¡Error! clase: Dao, Metodo: registrarGrupo() Tipo de error:\n"+ex.getMessage()+"\n Line: \n";
         ex.printStackTrace();
            System.out.println(resultado);
        }
        
        finally{
            try{
                c.getCon().close();
            }catch(Exception ex){
                
            }
        }
        
        return validacion;
    }

    @Override
    public GradoMateriaEntity consultarGradoPorMateria() {
        listaGradoMateria = new ArrayList<GradoMateriaEntity>();
        //ArrayList<ProfesorEntity> nombres = new ArrayList<ProfesorEntity>();
        BDConexion c = new BDConexion();
        GradoMateriaEntity objU = new GradoMateriaEntity();
        
        try (PreparedStatement stm = c.getCon().prepareStatement(GradoMateriaSQL.getGradoMateria());){
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                objU.setIdGrado(rs.getInt("idGrado"));
                objU.setIdMateria(rs.getString("idMateria"));
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
        return objU;
    }
    
}
