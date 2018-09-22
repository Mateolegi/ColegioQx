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
public class PlanEvaluacionSQL {
    
    public static String getInsertarPlanEvaluacion(){
        return "INSERT INTO tbl_planevaluacion (idPlanEvaluacion,idDetallePEvaluacion,idProfesor,idMateria)"
            +" VALUES (?,?,?,?)";  
    }
}

