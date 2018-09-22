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
public class GradosCursadosSQL {
    
    public static String getInsertarGrado(){
        return "INSERT INTO tbl_gradoscursados (idGradoCursado,idGrado,idGrupo,"
            + "idEstudiante,ano,estado,notaPromedio) "
            +"VALUES (?,?,?,?,?,?,?)";
    }
    
}
