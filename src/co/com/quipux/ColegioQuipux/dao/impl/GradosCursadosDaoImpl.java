/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao.impl;

import co.com.quipux.ColegioQuipux.dao.GradosCursadosDAO;
import co.com.quipux.ColegioQuipux.dao.sql.GradosCursadosSQL;
import co.com.quipux.ColegioQuipux.models.entity.GradosCursadosEntity;
import co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica.BDConexion;
import co.com.quipux.ColegioQuipux.util.Tiempo;
import java.sql.PreparedStatement;

/**
 *
 * @author Sebas
 */
public class GradosCursadosDaoImpl implements GradosCursadosDAO{

    @Override
    public boolean registrarGradosCursado(GradosCursadosEntity GradoCursado) {
        boolean validacion =false;
        BDConexion c = new BDConexion();
        String resultado = "";
        Tiempo t = new Tiempo();
        try{
            PreparedStatement pst= c.getCon().prepareStatement(GradosCursadosSQL.getInsertarGrado());
            
                pst.setInt(1,GradoCursado.getIdGradoCursado());
                pst.setInt(2,GradoCursado.getIdGrado());
                pst.setString(3,GradoCursado.getIdGrupo());
                pst.setInt(4,GradoCursado.getIdEstudiante());
                pst.setString(5,GradoCursado.getAno());
                pst.setString(6,GradoCursado.getEstado());
                pst.setDouble(7,GradoCursado.getNotaPromedio());
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
            
         resultado+= "¡Error! clase: Dao, Metodo: getInsertarGrado() Tipo de error:\n"+ex.getMessage()+"\n Line: \n";
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
    
}
