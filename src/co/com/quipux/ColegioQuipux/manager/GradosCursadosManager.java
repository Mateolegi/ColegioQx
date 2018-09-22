/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.manager;

import co.com.quipux.ColegioQuipux.models.dto.GradosCursadosDTO;
import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
public interface GradosCursadosManager {
    
    public GradosCursadosDTO llenarDatosGradoMateriaDTO();
    
    /*Consulta los grados cursados por campos o directamente todos para eso se usa
    el index donde 0 seria todo.*/
    public ArrayList<GradosCursadosDTO> consultarGradosCursados(int index,String valor);
    
}
