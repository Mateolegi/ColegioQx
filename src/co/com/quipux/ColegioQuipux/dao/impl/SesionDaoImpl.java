/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao.impl;

import co.com.quipux.ColegioQuipux.dao.SesionDAO;
import co.com.quipux.ColegioQuipux.dao.sql.SesionSQL;
import co.com.quipux.ColegioQuipux.models.dto.SesionDto;
import co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica.BDConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Sebas
 */
public class SesionDaoImpl implements SesionDAO{

    @Override
    public void iniciarSesion(int id, String clave) {
       
    }

    @Override
    public boolean validacionSesionProfesores(){
            boolean validacion=false;
            
            String compClave="";
            String compId="";
            
            BDConexion conexion = new BDConexion();
            
            try{
            
            Connection conection = conexion.getCon();
            Statement st = conection.createStatement();
                
            ResultSet rs = st.executeQuery(SesionSQL.validarUsuarioProfesor());
            
                while(rs.next()){
                compClave = rs.getString("clave");
                compId = rs.getString("numeroDocumento");
                
                //idProfesor,nombre,apellido,numeroDocumento,idDocumento,clave;
                
                SesionDto.setIdUsuaio(rs.getInt("idProfesor"));
                SesionDto.setNombre(rs.getString("nombre"));
                SesionDto.setApellido(rs.getString("apellido"));
                SesionDto.setNumeroDocumento(rs.getString("numeroDocumento"));
                SesionDto.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                SesionDto.setClave(rs.getString("clave"));
                
                }
            
            if(compClave.equals(SesionDto.getClave()) && compId.equals(SesionDto.getNumeroDocumento()) && !compClave.equals("") && !compId.equals("")){
                validacion=true;
            }else{
                validacion=false;
            }
                
            }catch(Exception ex){
                System.out.println("¡Error! clase: SesionDaoImpl, Metodo: validarIngresoProfesor() Tipo de error:\n"+ex.getMessage()+"\n Line: \n");
                ex.printStackTrace();
            }
            finally{
                
                try{
                conexion.getCon().close();
                    System.out.println("Se cerro la conexión");
                }catch(Exception ex){
         
                }//FIN CATCH
     
            }//FIN FINALLY
            
            return validacion;
        }/*FIN metodo: validacionSesionProfesores*/

    @Override
    public boolean validacionSesionEstudiante(){
            boolean validacion=false;
            String compClave="";
            String compId="";
            BDConexion conexion = new BDConexion();
            try{
            Connection conection = conexion.getCon();
            Statement st = conection.createStatement();
            ResultSet rs = st.executeQuery(SesionSQL.validarUsuarioEstudiante());
            
                while(rs.next()){
                compClave = rs.getString("clave");
                compId = rs.getString("numeroDocumento");
                
                /*Codigo,nombre,apellido,tipoDocumento,numeroDocumento,fechaNacimiento
                ,sexo,ciudad,direccion,telefono,celular,correo,grado,grupo*/
                
                SesionDto.setIdUsuaio(rs.getInt("idEstudiante"));
                SesionDto.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                SesionDto.setIdCiudadResidencial(rs.getInt("idCiudadResidencial"));
                //SesionEntity.setNumeroDocumento(rs.getString("numeroDocumento"));
                SesionDto.setNombre(rs.getString("nombre"));
                SesionDto.setApellido(rs.getString("apellido"));
                SesionDto.setFechaNacimiento(rs.getString("fechaNacimiento"));
                SesionDto.setSexo(rs.getString("sexo"));
                SesionDto.setDireccionResidencial(rs.getString("direccionResidencial"));
                SesionDto.setTelefonoResidencial(rs.getString("telefonoResidencial"));
                SesionDto.setTelefonoCelular(rs.getString("telefonoCelular"));
                SesionDto.setCorreo(rs.getString("correo"));
                //SesionEntity.setClave(rs.getString("clave"));
                
                }
            
            if(compClave.equals(SesionDto.getClave()) && compId.equals(SesionDto.getNumeroDocumento()) && !compClave.equals("") && !compId.equals("")){
                validacion=true;
                System.out.println("SesionDao true");
            }else{
                validacion=false;
                System.out.println("SesionDao else");
            }
                
            }catch(Exception ex){
                System.out.println("¡Error! clase: SesionDaoImpl, Metodo: validarSesionEstudiante() Tipo de error:\n"+ex.getMessage()+"\n Line: \n");
                ex.printStackTrace();
            }
            finally{
                
                try{
                conexion.getCon().close();
                    System.out.println("Se cerro la conexión");
                }catch(Exception ex){
         
                }//FIN CATCH
     
            }//FIN FINALLY
            
            return validacion;
        }/*FIN metodo: validacionSesionEstudiante*/

    @Override
    public boolean validacionSesionAdministrador() {
        boolean validacion=false;
            
            String compClave="";
            String compId="";
            
            BDConexion conexion = new BDConexion();
            
            try{
            
            Connection conection = conexion.getCon();
            Statement st = conection.createStatement();
                
            ResultSet rs = st.executeQuery(SesionSQL.validarUsuarioAdministrador());
            
                while(rs.next()){
                compClave = rs.getString("clave");
                compId = rs.getString("numeroDocumento");
                
                //idAdministrador,nombre,apellido,numeroDocumento,idTipoDocumento,clave;
                
                SesionDto.setIdUsuaio(rs.getInt("idAdministrador"));
                SesionDto.setNombre(rs.getString("nombre"));
                SesionDto.setApellido(rs.getString("apellido"));
                SesionDto.setNumeroDocumento(rs.getString("numeroDocumento"));
                SesionDto.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                SesionDto.setClave(rs.getString("clave"));
                
                }
            
            if(compClave.equals(SesionDto.getClave()) && compId.equals(SesionDto.getNumeroDocumento()) && !compClave.equals("") && !compId.equals("")){
                validacion=true;
            }else{
                validacion=false;
            }
                
            }catch(Exception ex){
                System.out.println("¡Error! clase: SesionDaoImpl, Metodo: validarIngresoProfesor() Tipo de error:\n"+ex.getMessage()+"\n Line: \n");
                ex.printStackTrace();
            }
            finally{
                
                try{
                conexion.getCon().close();
                    System.out.println("Se cerro la conexión");
                }catch(Exception ex){
         
                }//FIN CATCH
     
            }//FIN FINALLY
            
            return validacion;
    }
    
}
