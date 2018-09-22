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
public class GradoMateriaManagerSQL {
    
    public static String getGradoMateria(){
        return "SELECT gr.numeroGrado, ma.nombreMateria"+
        " FROM tbl_grado_materia gm "+
        " INNER join tbl_grado gr on  gm.idGrado = gr.idGrado"+
        " INNER join tbl_materia ma on  gm.idMateria = ma.idMateria ORDER BY gr.numeroGrado ASC";
    }
    
    public static String getGradoMateriaPorGrado(String valor){
        return "SELECT gr.numeroGrado, ma.nombreMateria"+
        " FROM tbl_grado_materia gm"+
        " INNER join tbl_grado gr on  gm.idGrado = gr.idGrado AND gr.idGrado = '"+valor+"'"+
        " INNER join tbl_materia ma on  gm.idMateria = ma.idMateria ORDER BY ma.nombreMateria ASC";
    }
    
    public static String getGradoMateriaPorMateria(String valor){
        return "SELECT gr.numeroGrado, ma.nombreMateria "+
        "FROM tbl_grado_materia gm "+
        "INNER join tbl_grado gr on  gm.idGrado = gr.idGrado "+
        "INNER join tbl_materia ma on  gm.idMateria = ma.idMateria AND ma.idMateria= '"+valor+"' ORDER BY gr.numeroGrado ASC";
    }
    
}
