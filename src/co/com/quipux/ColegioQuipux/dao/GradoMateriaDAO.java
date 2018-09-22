/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao;

import co.com.quipux.ColegioQuipux.models.entity.GradoMateriaEntity;

/**
 *
 * @author Sebas
 */
public interface GradoMateriaDAO {
    
    /*Se registraran las materias que se den en los diferentes grados*/
    public boolean registrarGradoMateria(GradoMateriaEntity GM);
    
    public GradoMateriaEntity consultarGradoPorMateria();
    
}
