/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao.impl;

import co.com.quipux.ColegioQuipux.dao.GrupoDAO;
import co.com.quipux.ColegioQuipux.dao.sql.GrupoSQL;
import co.com.quipux.ColegioQuipux.models.entity.GrupoEntity;
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
public class GrupoDaoImpl implements GrupoDAO{
    
    ArrayList<GrupoEntity> listaGrado = new ArrayList<GrupoEntity>();

    @Override
    public boolean registrarGrupo(GrupoEntity grupo) {
        boolean validacion =false;
        BDConexion c = new BDConexion();
        String resultado = "";
        Tiempo t = new Tiempo();
        try{
            PreparedStatement pst= c.getCon().prepareStatement(GrupoSQL.getInsertarGrupo());
            
                pst.setInt(1,grupo.getIdGrupo());
                pst.setInt(2,grupo.getIdProfesor());
                pst.setInt(3,grupo.getIdGrado());
                pst.setInt(4,grupo.getCantidadEstudiantes());
                pst.setString(5, grupo.getJornada());
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
    public void consultarGruposDeProfesor(int idProfesor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCodigoGrupo(String grado) {
        String codigoAntes="";
        int Codigo=0;
            BDConexion conexion = new BDConexion();
            Tiempo t = new Tiempo();
            try{
            Connection conection = conexion.getCon();
            Statement st = conection.createStatement();
            
            ResultSet rs = st.executeQuery(GrupoSQL.codigoGrupo(t,grado));
               if(rs.next()){
                Codigo = rs.getInt(1);
                }else{
                   Codigo=0;
                   System.out.println("Entron en el else, de generar código");
               }
               
               if(Codigo==0){
                   codigoAntes=""+t.getAno()+grado+"01";
                   Codigo = Integer.parseInt(codigoAntes);
               }
               
            }catch(Exception ex){
                System.out.println("¡Error! clase: Dao, Metodo: getCodigoGrupo() Tipo de error:\n"+ex.getMessage()+"\n Line: \n");
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
