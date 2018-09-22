/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao.impl;

import co.com.quipux.ColegioQuipux.dao.AdministradorDAO;
import co.com.quipux.ColegioQuipux.dao.sql.AdministradorSQL;
import co.com.quipux.ColegioQuipux.models.entity.AdministradorEntity;
import co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica.BDConexion;
import co.com.quipux.ColegioQuipux.util.Tiempo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Sebas
 */
public class AdministradorDaoImpl implements AdministradorDAO{

    @Override
    public boolean registrarAdministrador(AdministradorEntity admin) {
        boolean validacion =false;
        BDConexion c = new BDConexion();
        String resultado = "";
        
        /*public static String Codigo,nombre,apellido,tipoDocumento,numeroDocumento,fechaNacimiento
        ,sexo,ciudad,direccion,telefono,celular,correo,grado,grupo,clave,estado;*/
        try{
            PreparedStatement pst= c.getCon().prepareStatement(AdministradorSQL.getInsertarAdministrador());
            //idAdministrador,idTipoDocumento,numeroDocumento,nombre,apellido,clave
           /*1*/pst.setInt(1,getCodigoAdministrador());
                pst.setInt(2,admin.getIdTipoDocumento());
                pst.setString(3,admin.getNumeroDocumento());
                pst.setString(4,admin.getNombre());
                pst.setString(5,admin.getApellido());
                pst.setString(6,admin.getClave());
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
            
         resultado+= "¡Error! clase: Dao, Metodo: getInsertarProfesor() Tipo de error:\n"+ex.getMessage()+"\n Line: \n";
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
    public int getCodigoAdministrador() {
        int Codigo=0;
            BDConexion conexion = new BDConexion();
            Tiempo t = new Tiempo();
            try{
            Connection conection = conexion.getCon();
            Statement st = conection.createStatement();
            ResultSet rs = st.executeQuery(AdministradorSQL.codigoAdministrador(t));
               if(rs.next()){
                Codigo = rs.getInt(1);
                }else{
                   System.out.println("La consulta no ha funcionado");
                   Codigo=0;
               }
            }catch(Exception ex){
                System.out.println("¡Error! clase: Dao, Metodo: getCodigoAdministrador() Tipo de error:\n"+ex.getMessage()+"\n Line: \n");
            }
            finally{
                try{
                conexion.getCon().close();
                    System.out.println("Se cerro la conexión");
                }catch(Exception ex){
                }//FIN CATCH
            }//FIN FINALLY
            return Codigo;
    }
    
}
