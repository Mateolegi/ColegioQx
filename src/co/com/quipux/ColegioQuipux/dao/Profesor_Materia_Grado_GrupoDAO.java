/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao;

import co.com.quipux.ColegioQuipux.models.entity.Profesor_Materia_GrupoEntity;

/**
 *
 * @author Sebas
 */
public interface Profesor_Materia_Grado_GrupoDAO {
    
    /*Se registran las materias que da un profesor 
    en que grados da esas materias y a que grupos.*/
    public boolean registrarProfesor_Materia_Grado_Grupo(Profesor_Materia_GrupoEntity PMGG);
    
}
