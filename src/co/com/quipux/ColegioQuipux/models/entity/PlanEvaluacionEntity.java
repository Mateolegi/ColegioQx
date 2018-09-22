/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.models.entity;

/**
 *
 * @author Sebas
 */
public class PlanEvaluacionEntity {
    private int idPlanEvaluacion; /*Tamaño BD: 6*/
    private int idDetallePEvaluacion; /*Tamaño BD: 6*/
    private int idProfesor;/*Tamaño BD: 4*/
    private String idMateria;/*Tamaño BD: 6*/

    public int getIdPlanEvaluacion() {
        return idPlanEvaluacion;
    }

    public void setIdPlanEvaluacion(int idPlanEvaluacion) {
        this.idPlanEvaluacion = idPlanEvaluacion;
    }

    public int getIdDetallePEvaluacion() {
        return idDetallePEvaluacion;
    }

    public void setIdDetallePEvaluacion(int idDetallePEvaluacion) {
        this.idDetallePEvaluacion = idDetallePEvaluacion;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }
    
    
    
}
