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
public class GrupoSQL {
    
    public static String getInsertarGrupo(){
        return "INSERT INTO tbl_grupo (idGrupo,idProfesor,idGrado,"
                + "cantidadEstudiantes,jornada) VALUES (?,?,?,?,?)";
    }
    
    public static String codigoGrupo(Tiempo t,String grupo){
        return "SELECT Lpad( max( cast( idGrupo AS signed ) )"
            +" +1, 8, '"+t.getAno()+grupo+"0"+null+"' )FROM tbl_grupo"
            +" WHERE idGrupo LIKE '%"+grupo+"%'";
    }
    
}
