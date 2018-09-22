/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao.sql;

import co.com.quipux.ColegioQuipux.util.Tiempo;

/**
 *
 * @author Sebas
 */
public class EstudianteSQL {
    
    public static String codigoEstudiante(Tiempo t){
        return "SELECT Lpad( max( cast( idEstudiante AS signed ) ) +1, 7, '"+t.getAno()+"00' )FROM tbl_estudiante";
    }
    
    public static String getInsertarEstudiante(){
        return "INSERT INTO tbl_estudiante (idEstudiante,idTipoDocumento,idCiudadResidencial,numeroDocumento,nombre,apellido,"
            +"fechaNacimiento,sexo,direccionResidencial,telefonoResidencial,telefonocelular,correo,clave) "
            +"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";    
    }
    
}
