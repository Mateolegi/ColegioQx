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
public class Estudiante_NotasManagerSQL {

    public static String getGradosCursados(int index, String valor) {
        String resultado = "";
        switch (index) {/*0: TODO / 1: Valor nota  /2: Tipo de nota (Parcial, Seguimiento) /
            3: Materia / 4: Estudiante / 5: nombre nota / 6: Fecha entrega*/
            case 0:/*TODO*/
                resultado = "SELECT es.nombre,es.apellido,ma.nombreMateria,notas.valorNota, tiNo.tipoNota,tiNo.nombreNota, tiNo.FechaEntrega FROM tbl_estudiante_notas esNo"
                        + " INNER JOIN tbl_notas notas on esNo.idNotas = notas.idNotas"
                        + " INNER JOIN tbl_tiponota tiNo on notas.idTipoNota = tiNo.idTipoNota"
                        + " INNER JOIN tbl_planevaluacion ple on tiNO.idPlanEvaluacion = ple.idPlanEvaluacion"
                        + " INNER JOIN tbl_profesor_materia_grupo promagru on ple.idProfesor = promagru.idProfesor"
                        + " INNER JOIN tbl_profesor profe on promagru.idProfesor = profe.idProfesor"
                        + " INNER JOIN tbl_materia ma on promagru.idMateria = ma.idMateria"
                        + " INNER JOIN tbl_estudiante es on esNo.idEstudiante = es.idEstudiante";
                break;
            case 1:/*Valor nota*/
                resultado = "SELECT es.nombre,es.apellido,ma.nombreMateria,notas.valorNota, tiNo.tipoNota,tiNo.nombreNota, tiNo.FechaEntrega FROM tbl_estudiante_notas esNo"
                        + " INNER JOIN tbl_notas notas on esNo.idNotas = notas.idNotas AND notas.valorNota LIKE '"+valor+"%'"
                        + " INNER JOIN tbl_tiponota tiNo on notas.idTipoNota = tiNo.idTipoNota"
                        + " INNER JOIN tbl_planevaluacion ple on tiNO.idPlanEvaluacion = ple.idPlanEvaluacion"
                        + " INNER JOIN tbl_profesor_materia_grupo promagru on ple.idProfesor = promagru.idProfesor"
                        + " INNER JOIN tbl_profesor profe on promagru.idProfesor = profe.idProfesor"
                        + " INNER JOIN tbl_materia ma on promagru.idMateria = ma.idMateria"
                        + " INNER JOIN tbl_estudiante es on esNo.idEstudiante = es.idEstudiante";
                break;
                
            case 2:/*Tipo de nota (Seguimiento, parcial, final)*/
                resultado = "SELECT es.nombre,es.apellido,ma.nombreMateria,notas.valorNota, tiNo.tipoNota,tiNo.nombreNota, tiNo.FechaEntrega FROM tbl_estudiante_notas esNo"
                        + " INNER JOIN tbl_notas notas on esNo.idNotas = notas.idNotas"
                        + " INNER JOIN tbl_tiponota tiNo on notas.idTipoNota = tiNo.idTipoNota AND tiNo.tipoNota LIKE '%"+valor+"%'"
                        + " INNER JOIN tbl_planevaluacion ple on tiNO.idPlanEvaluacion = ple.idPlanEvaluacion"
                        + " INNER JOIN tbl_profesor_materia_grupo promagru on ple.idProfesor = promagru.idProfesor"
                        + " INNER JOIN tbl_profesor profe on promagru.idProfesor = profe.idProfesor"
                        + " INNER JOIN tbl_materia ma on promagru.idMateria = ma.idMateria"
                        + " INNER JOIN tbl_estudiante es on esNo.idEstudiante = es.idEstudiante";
                break; 
                
            case 3:/*Materia*/
                resultado = "SELECT es.nombre,es.apellido,ma.nombreMateria,notas.valorNota, tiNo.tipoNota,tiNo.nombreNota, tiNo.FechaEntrega FROM tbl_estudiante_notas esNo"
                        + " INNER JOIN tbl_notas notas on esNo.idNotas = notas.idNotas"
                        + " INNER JOIN tbl_tiponota tiNo on notas.idTipoNota = tiNo.idTipoNota"
                        + " INNER JOIN tbl_planevaluacion ple on tiNO.idPlanEvaluacion = ple.idPlanEvaluacion"
                        + " INNER JOIN tbl_profesor_materia_grupo promagru on ple.idProfesor = promagru.idProfesor"
                        + " INNER JOIN tbl_profesor profe on promagru.idProfesor = profe.idProfesor"
                        + " INNER JOIN tbl_materia ma on promagru.idMateria = ma.idMateria AND ma.nombreMateria LIKE '%"+valor+"%'"
                        + " INNER JOIN tbl_estudiante es on esNo.idEstudiante = es.idEstudiante";
                break;
                
            case 4:/*Estudiante*/
                resultado = "SELECT es.nombre,es.apellido,ma.nombreMateria,notas.valorNota, tiNo.tipoNota,tiNo.nombreNota, tiNo.FechaEntrega FROM tbl_estudiante_notas esNo"
                        + " INNER JOIN tbl_notas notas on esNo.idNotas = notas.idNotas"
                        + " INNER JOIN tbl_tiponota tiNo on notas.idTipoNota = tiNo.idTipoNota"
                        + " INNER JOIN tbl_planevaluacion ple on tiNO.idPlanEvaluacion = ple.idPlanEvaluacion"
                        + " INNER JOIN tbl_profesor_materia_grupo promagru on ple.idProfesor = promagru.idProfesor"
                        + " INNER JOIN tbl_profesor profe on promagru.idProfesor = profe.idProfesor"
                        + " INNER JOIN tbl_materia ma on promagru.idMateria = ma.idMateria"
                        + " INNER JOIN tbl_estudiante es on esNo.idEstudiante = es.idEstudiante AND es.nombre LIKE '%"+valor+"%'";
                break;
            case 5:/*Nombre Nota*/
                resultado = "SELECT es.nombre,es.apellido,ma.nombreMateria,notas.valorNota, tiNo.tipoNota,tiNo.nombreNota, tiNo.FechaEntrega FROM tbl_estudiante_notas esNo"
                        + " INNER JOIN tbl_notas notas on esNo.idNotas = notas.idNotas"
                        + " INNER JOIN tbl_tiponota tiNo on notas.idTipoNota = tiNo.idTipoNota AND tiNO.nombreNota LIKE '%"+valor+"%'"
                        + " INNER JOIN tbl_planevaluacion ple on tiNO.idPlanEvaluacion = ple.idPlanEvaluacion"
                        + " INNER JOIN tbl_profesor_materia_grupo promagru on ple.idProfesor = promagru.idProfesor"
                        + " INNER JOIN tbl_profesor profe on promagru.idProfesor = profe.idProfesor"
                        + " INNER JOIN tbl_materia ma on promagru.idMateria = ma.idMateria"
                        + " INNER JOIN tbl_estudiante es on esNo.idEstudiante = es.idEstudiante";
                break;
                
            case 6:/*FechaEntrega*/
                resultado = "SELECT es.nombre,es.apellido,ma.nombreMateria,notas.valorNota, tiNo.tipoNota,tiNo.nombreNota, tiNo.FechaEntrega FROM tbl_estudiante_notas esNo"
                        + " INNER JOIN tbl_notas notas on esNo.idNotas = notas.idNotas"
                        + " INNER JOIN tbl_tiponota tiNo on notas.idTipoNota = tiNo.idTipoNota AND tiNO.FechaEntrega LIKE '%"+valor+"%'"
                        + " INNER JOIN tbl_planevaluacion ple on tiNO.idPlanEvaluacion = ple.idPlanEvaluacion"
                        + " INNER JOIN tbl_profesor_materia_grupo promagru on ple.idProfesor = promagru.idProfesor"
                        + " INNER JOIN tbl_profesor profe on promagru.idProfesor = profe.idProfesor"
                        + " INNER JOIN tbl_materia ma on promagru.idMateria = ma.idMateria"
                        + " INNER JOIN tbl_estudiante es on esNo.idEstudiante = es.idEstudiante";
                break;    
            
        }

        return resultado;
    }

}
