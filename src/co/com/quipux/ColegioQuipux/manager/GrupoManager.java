/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.manager;

import co.com.quipux.ColegioQuipux.models.dto.GradoMateriaDTO;
import co.com.quipux.ColegioQuipux.models.dto.GrupoDTO;
import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
public interface GrupoManager {
    
    public GrupoDTO llenarDatosGradoMateriaDTO();
    
    public ArrayList<GrupoDTO> consultarTodosLosGrupos();
    
    public ArrayList<GrupoDTO> consultarGruposPorCampos(String Campo,int index,String valor);
    
}
