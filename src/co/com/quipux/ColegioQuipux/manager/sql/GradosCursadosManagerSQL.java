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
public class GradosCursadosManagerSQL {
    
    public static String getGradosCursados(int index,String valor){
        String resultado="";
        switch(index){
            case 0:/*TODO*/
                resultado = "SELECT gc.idGradoCursado, gd.numeroGrado, es.nombre,"+
                    " es.apellido, gc.ano, gc.estado, gc.notaPromedio"+
                    " FROM tbl_gradoscursados gc"+
                    " INNER JOIN tbl_grupo gp on gc.idGrupo = gp.idGrupo"+
                    " INNER JOIN tbl_estudiante es on gc.idEstudiante = es.idEstudiante"+
                    " INNER JOIN tbl_grado gd on gp.idGrado = gd.idGrado";
                break;
            case 1:/*GRUPO*/
                resultado = "SELECT gc.idGradoCursado, gd.numeroGrado, es.nombre,"+
                    " es.apellido, gc.ano, gc.estado, gc.notaPromedio"+
                    " FROM tbl_gradoscursados gc"+
                    " INNER JOIN tbl_grupo gp on gc.idGrupo = gp.idGrupo AND gp.idGrupo LIKE '%"+valor+"%'"+
                    " INNER JOIN tbl_estudiante es on gc.idEstudiante = es.idEstudiante"+
                    " INNER JOIN tbl_grado gd on gp.idGrado = gd.idGrado";
                break;
            case 2:/*Estudiante*/
                resultado = "SELECT gc.idGradoCursado, gd.numeroGrado, es.nombre,"+
                    " es.apellido, gc.ano, gc.estado, gc.notaPromedio"+
                    " FROM tbl_gradoscursados gc"+
                    " INNER JOIN tbl_grupo gp on gc.idGrupo = gp.idGrupo"+
                    " INNER JOIN tbl_estudiante es on gc.idEstudiante = es.idEstudiante AND es.nombre LIKE '%"+valor+"%'"+
                    " OR es.apellido LIKE '%"+valor+"%'"+
                    " INNER JOIN tbl_grado gd on gp.idGrado = gd.idGrado";
                break;
            case 3:/*Ano*/
                resultado = "SELECT gc.idGradoCursado, gd.numeroGrado, es.nombre,"+
                    " es.apellido, gc.ano, gc.estado, gc.notaPromedio"+
                    " FROM tbl_gradoscursados gc"+
                    " INNER JOIN tbl_grupo gp on gc.idGrupo = gp.idGrupo"+
                    " INNER JOIN tbl_estudiante es on gc.idEstudiante = es.idEstudiante"+
                    " INNER JOIN tbl_grado gd on gp.idGrado = gd.idGrado"+
                    " WHERE gc.ano LIKE '%"+valor+"%'";
                break;
            case 4:/*ESTADO*/
                resultado = "SELECT gc.idGradoCursado, gd.numeroGrado, es.nombre,"+
                    " es.apellido, gc.ano, gc.estado, gc.notaPromedio"+
                    " FROM tbl_gradoscursados gc"+
                    " INNER JOIN tbl_grupo gp on gc.idGrupo = gp.idGrupo"+
                    " INNER JOIN tbl_estudiante es on gc.idEstudiante = es.idEstudiante"+
                    " INNER JOIN tbl_grado gd on gp.idGrado = gd.idGrado"+
                    " WHERE gc.estado LIKE '%"+valor+"%'";
                break;   
                
            case 5:/*NotaPromedio*/
                resultado = "SELECT gc.idGradoCursado, gd.numeroGrado, es.nombre,"+
                    " es.apellido, gc.ano, gc.estado, gc.notaPromedio"+
                    " FROM tbl_gradoscursados gc"+
                    " INNER JOIN tbl_grupo gp on gc.idGrupo = gp.idGrupo"+
                    " INNER JOIN tbl_estudiante es on gc.idEstudiante = es.idEstudiante"+
                    " INNER JOIN tbl_grado gd on gp.idGrado = gd.idGrado"+
                    " WHERE gc.notaPromedio LIKE '%"+valor+"%'";
                break;
                
            case 6:/*Código*/
                resultado = "SELECT gc.idGradoCursado, gd.numeroGrado, es.nombre,"+
                    " es.apellido, gc.ano, gc.estado, gc.notaPromedio"+
                    " FROM tbl_gradoscursados gc"+
                    " INNER JOIN tbl_grupo gp on gc.idGrupo = gp.idGrupo"+
                    " INNER JOIN tbl_estudiante es on gc.idEstudiante = es.idEstudiante"+
                    " INNER JOIN tbl_grado gd on gp.idGrado = gd.idGrado"+
                    " WHERE gc.idGradoCursado LIKE '%"+valor+"%'";
                break;  
                
            
            
        }
        
        
        return resultado;
    }
    
}

