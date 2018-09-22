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
public class GrupoManagerSQL {
    
    public static String getGrupo(String campo,int index,String valor){
        String resultado="";
        switch(index){
            case 0:
                resultado = "SELECT  gm.idGrupo,gr.nombre,gd.numeroGrado,gm.cantidadEstudiantes,gm.jornada"+
                    " FROM tbl_grupo gm"+
                    " INNER join tbl_profesor gr on  gm.idProfesor = gr.idProfesor AND gr.nombre LIKE '%"+valor+"%'"+
                    " INNER Join tbl_grado gd on gm.idGrado = gd.idGrado ORDER BY gm.idGrupo ASC";
                break; 
            case 1:
                resultado = "SELECT  gm.idGrupo,gr.nombre,gd.numeroGrado,gm.cantidadEstudiantes,gm.jornada"+
                    " FROM tbl_grupo gm"+
                    " INNER join tbl_profesor gr on  gm.idProfesor = gr.idProfesor"+
                    " INNER Join tbl_grado gd on gm.idGrado = gd.idGrado AND gd.numeroGrado LIKE '%"+valor+"%' ORDER BY gm.idGrupo ASC";
                break;
            case 2:
                resultado = "SELECT  gm.idGrupo,gr.nombre,gd.numeroGrado,gm.cantidadEstudiantes,gm.jornada"+
                    " FROM tbl_grupo gm"+
                    " INNER join tbl_profesor gr on  gm.idProfesor = gr.idProfesor"+
                    " INNER Join tbl_grado gd on gm.idGrado = gd.idGrado"+
                    " WHERE gm."+campo+" LIKE '%"+valor+"%' ORDER BY gm.idGrupo ASC";
                break;
        }
        return resultado;
    }
    
    public static String getGrupo(){
        return "SELECT  gm.idGrupo,gr.nombre,gd.numeroGrado,gm.cantidadEstudiantes,gm.jornada"+
        " FROM tbl_grupo gm"+
        " INNER join tbl_profesor gr on  gm.idProfesor = gr.idProfesor"+
        " INNER Join tbl_grado gd on gm.idGrado = gd.idGrado ORDER BY gm.idGrupo ASC";
    }
}
