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
public class Profesor_Materia_GrupoManagerSQL {
    
    public static String getGrupo(String campo,int index,String valor){
        String resultado="";
        switch(index){
            case 0:/*Consultar todo*/
                resultado = "SELECT  ps.nombre,ps.apellido,gd.numeroGrado,gp.idGrupo, ma.nombreMateria"+
                    " FROM tbl_profesor_materia_grupo gm"+
                    " INNER JOIN tbl_profesor ps on gm.idProfesor = ps.idProfesor"+
                    " INNER join tbl_materia ma on  gm.idMateria = ma.idMateria" +
                    " INNER Join tbl_grupo gp on gm.idGrupo = gp.idGrupo" +
                    " INNER join tbl_grado gd on gp.idGrado = gd.idGrado";
                break; 
            case 1:/*Por*/
                resultado = "SELECT  ps.nombre,ps.apellido,gd.numeroGrado,gp.idGrupo, ma.nombreMateria"+
                    " FROM tbl_profesor_materia_grupo gm"+
                    " INNER JOIN tbl_profesor ps on gm.idProfesor = ps.idProfesor"+
                    " AND ps.nombre LIKE '%"+valor+"%' OR ps.apellido LIKE '%"+valor+"%'"+
                    " INNER join tbl_materia ma on  gm.idMateria = ma.idMateria" +
                    " INNER Join tbl_grupo gp on gm.idGrupo = gp.idGrupo" +
                    " INNER join tbl_grado gd on gp.idGrado = gd.idGrado";
                break;
            case 2:
                resultado = "SELECT  ps.nombre,ps.apellido,gd.numeroGrado,gp.idGrupo, ma.nombreMateria"+
                    " FROM tbl_profesor_materia_grupo gm"+
                    " INNER JOIN tbl_profesor ps on gm.idProfesor = ps.idProfesor"+
                    " INNER join tbl_materia ma on  gm.idMateria = ma.idMateria AND ma.nombreMateria LIKE '%"+valor+"%'" +
                    " INNER Join tbl_grupo gp on gm.idGrupo = gp.idGrupo" +
                    " INNER join tbl_grado gd on gp.idGrado = gd.idGrado";
                break;
                
            case 3:
                resultado = "SELECT  ps.nombre,ps.apellido,gd.numeroGrado,gp.idGrupo, ma.nombreMateria"+
                    " FROM tbl_profesor_materia_grupo gm"+
                    " INNER JOIN tbl_profesor ps on gm.idProfesor = ps.idProfesor"+
                    " INNER join tbl_materia ma on  gm.idMateria = ma.idMateria" +
                    " INNER Join tbl_grupo gp on gm.idGrupo = gp.idGrupo AND gp.idGrupo LIKE '____"+valor+"%'" +
                    " INNER join tbl_grado gd on gp.idGrado = gd.idGrado";
                break;
                
            case 4:
                resultado = "SELECT  ps.nombre,ps.apellido,gd.numeroGrado,gp.idGrupo, ma.nombreMateria"+
                    " FROM tbl_profesor_materia_grupo gm"+
                    " INNER JOIN tbl_profesor ps on gm.idProfesor = ps.idProfesor"+
                    " INNER join tbl_materia ma on  gm.idMateria = ma.idMateria" +
                    " INNER Join tbl_grupo gp on gm.idGrupo = gp.idGrupo" +
                    " INNER join tbl_grado gd on gp.idGrado = gd.idGrado AND gd.numeroGrado LIKE '%"+valor+"%'";
                break;
                
        }
        return resultado;
    }
    
}
