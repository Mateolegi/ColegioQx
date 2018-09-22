/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao;

import co.com.quipux.ColegioQuipux.models.entity.ProfesorEntity;
import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
public interface ProfesorDAO {
    
    public boolean registrarProfesor(ProfesorEntity profesor);
    
    public ProfesorEntity consultarProfesor(int idProfesor);
    
    public ArrayList<ProfesorEntity> getNombreDeProfesores();
    
    public String[] getListadoProfesor();
    
    public int[] getCodigoProfesor();
}
