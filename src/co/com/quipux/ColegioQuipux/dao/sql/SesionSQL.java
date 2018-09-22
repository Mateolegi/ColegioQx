/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao.sql;

import co.com.quipux.ColegioQuipux.models.dto.SesionDto;

/**
 *
 * @author Sebas
 */
public class SesionSQL {
    
    public static String validarUsuarioProfesor(){
        SesionDto se = new SesionDto();
        return "SELECT * FROM tbl_profesor WHERE numeroDocumento ='"
                +SesionDto.getNumeroDocumento()+"'";
    }
    
    public static String validarUsuarioEstudiante(){
        return "SELECT * FROM tbl_estudiante WHERE numeroDocumento ='"
                +SesionDto.getNumeroDocumento()+"'";
    }
    
    public static String validarUsuarioAdministrador(){
        return "SELECT * FROM tbl_administrador WHERE numeroDocumento ='"
                +SesionDto.getNumeroDocumento()+"'";
    }
    
}
