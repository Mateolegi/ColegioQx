/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.manager;

import co.com.quipux.ColegioQuipux.models.dto.Profesor_Materia_GrupoDTO;
import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
public interface Profesor_Materia_GrupoManager {
    
    public Profesor_Materia_GrupoDTO llenarDatosGradoMateriaDTO();
    
    public ArrayList<Profesor_Materia_GrupoDTO> consultarTodosLosGrupos();
    
    public ArrayList<Profesor_Materia_GrupoDTO> consultarGruposPorCampos(String Campo,int index,String valor);
    
}
