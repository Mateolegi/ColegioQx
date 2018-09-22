/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao;

import co.com.quipux.ColegioQuipux.models.entity.GradoEntity;
import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
public interface GradoDAO {
    
    public void registrarGrado(GradoEntity grado);
    
    public void consultarGrado();
    
    public ArrayList<GradoEntity> getNumeroDeGrado();
    
    public String[] getListadoDeGrados();
    
    public int[] getCodigoGrado();
    
}
