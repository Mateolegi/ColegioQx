/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.manager.sql;

/**
 *
 * @author Sebas
 */
public class ProfesorManagerSQL {
    
    public static String getProfesorPorParametros(String campo){
       // "SELECT nombre,apellido FROM tbl_profesor WHERE idProfesor LIKE '%?%'"
        return "SELECT idProfesor,idTipoDocumento,numeroDocumento,nombre,apellido,correo "
            +"FROM tbl_profesor "+
            "WHERE "+campo+" LIKE '%?%'";
    }
    
    public static String getProfesores(){
       // "SELECT nombre,apellido FROM tbl_profesor WHERE idProfesor LIKE '%?%'"
        return "SELECT * "
            +"FROM tbl_profesor ";
    }
    
}
