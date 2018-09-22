/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao.sql;

/**
 *
 * @author Sebas
 */
public class ProfesorSQL {
    
    public static String getNombreProfesores(){
        return "SELECT idProfesor,nombre,apellido FROM tbl_profesor";
    }
    
    public static String insertarProfesor(){
        return "INSERT INTO tbl_profesor (idProfesor,idTipoDocumento,numeroDocumento,nombre,"
                + "apellido,correo,clave) "
            +"VALUES (?,?,?,?,?,?,?)";
    }
    
}
