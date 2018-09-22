/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao;

import co.com.quipux.ColegioQuipux.models.entity.CiudadResidencialEntity;
import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
public interface CiudadResidencialDAO {
    
    public void registrarCiudadResidencial(CiudadResidencialEntity ciudadResidencial);
    
    public ArrayList<CiudadResidencialEntity> getNombresCiudadResidencial();
    
    public String[] getListadoCiudades();
    
    public int[] getCodigoCiudades();
    
}
