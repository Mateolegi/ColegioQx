/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao;

import co.com.quipux.ColegioQuipux.models.entity.TipoNotaEntity;

/**
 *
 * @author Sebas
 */
public interface TipoNotaDAO {
    /*Permite ingresar los detalles de las notas del profesor.
    Se podría decir que esto hace parte fundamental del plan de evaluación
    ya que tiene lo más impotante que es la información.*/
    public boolean registrarTipoNota(TipoNotaEntity tipoNota);
    
}
