/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao;

import co.com.quipux.ColegioQuipux.models.entity.GrupoEntity;

/**
 *
 * @author Sebas
 */
public interface GrupoDAO {
    
    public boolean registrarGrupo(GrupoEntity grupo);
    
    public void consultarGruposDeProfesor(int idProfesor);
    
    public int getCodigoGrupo(String grado);
    
}
