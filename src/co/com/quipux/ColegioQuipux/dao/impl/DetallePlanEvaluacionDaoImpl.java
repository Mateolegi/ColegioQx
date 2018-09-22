/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao.impl;

import co.com.quipux.ColegioQuipux.dao.DetallePlanEvaluacionDAO;
import co.com.quipux.ColegioQuipux.models.entity.DetallePlanEvaluacionEntity;
import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
public class DetallePlanEvaluacionDaoImpl implements DetallePlanEvaluacionDAO{

    private ArrayList<DetallePlanEvaluacionEntity> listaProfesor = new ArrayList<DetallePlanEvaluacionEntity>();
    
    @Override
    public boolean registrarDetallePlanEvaluacion(DetallePlanEvaluacionEntity plan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetallePlanEvaluacionDAO consultarDetallePlanEvaliacion(String ano) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
