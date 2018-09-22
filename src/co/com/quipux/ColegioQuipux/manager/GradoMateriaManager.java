/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.manager;

import co.com.quipux.ColegioQuipux.models.dto.GradoMateriaDTO;
import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
public interface GradoMateriaManager {
    
    public ArrayList<GradoMateriaDTO> consultarTodoGradoPorMateria();
    
    public ArrayList<GradoMateriaDTO> consultarPorGradoOMateria(String valorCampo,int tipoMaOGra);
    
}
