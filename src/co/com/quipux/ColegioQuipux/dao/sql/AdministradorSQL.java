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
public class AdministradorSQL {
    
    public static String codigoAdministrador(Tiempo t){
        return "SELECT Lpad( max( cast( Codigo AS signed ) ) +1, 6, '"+t.getAno()+"0' )FROM tbl_administrador";
    }
    
    public static String getInsertarAdministrador(){
        return "INSERT INTO tbl_administrador (idAdministrador,idTipoDocumento,numeroDocumento,nombre,apellido,clave)"
            +" VALUES (?,?,?,?,?,?)";    
    }
}
