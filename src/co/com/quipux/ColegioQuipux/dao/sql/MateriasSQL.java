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
public class MateriasSQL {
    
    public static String getInsertarMateria(){
        return "INSERT INTO tbl_materia (idMateria,nombreMateria,descripcion) "
            +"VALUES (?,?,?)";    
    }
    
    public static String codigoMateria(String Nodo){
        return "SELECT Lpad( max( cast( idMateria AS signed ) ) +1, 6, '"+Nodo+"00' )FROM tbl_materia";
    }
    
    public static String getInfoMateria(){
        return "SELECT idMateria,nombreMateria,descripcion FROM tbl_materia";
    }
    
}
