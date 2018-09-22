/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao;

import co.com.quipux.ColegioQuipux.models.entity.EstudianteEntity;

/**
 *
 * @author Sebas
 */
public interface EstudianteDAO {
    
    public boolean registrarEstudiante(EstudianteEntity estudiante);
    
    public EstudianteEntity consultarEstudiante(int idEstudiante);
    
    public String generarCodigoEstudiante();
    
    //public void registrarEgresoEstudiante();
    //public void registrarRetiroEstudiante();
    //public void registrarGraduacionEstudiante();
    
}
