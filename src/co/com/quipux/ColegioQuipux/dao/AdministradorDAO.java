/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao;

import co.com.quipux.ColegioQuipux.models.entity.AdministradorEntity;

/**
 *
 * @author Sebas
 */
public interface AdministradorDAO {
    
    public boolean registrarAdministrador(AdministradorEntity admin);
    
    public int getCodigoAdministrador();
    
}
