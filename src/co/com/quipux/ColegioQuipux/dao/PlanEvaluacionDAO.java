/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao;

import co.com.quipux.ColegioQuipux.models.entity.PlanEvaluacionEntity;
import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
public interface PlanEvaluacionDAO {
    
    public boolean registrarPlanDeEvaluacion(PlanEvaluacionEntity Plan);
    
    public ArrayList<String> getNombreDeMaterias();
    
    public String[] vectorMateriasProfesor();
    
}
