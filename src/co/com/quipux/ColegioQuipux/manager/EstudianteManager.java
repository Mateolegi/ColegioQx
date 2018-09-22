/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.manager;

import co.com.quipux.ColegioQuipux.models.dto.EstudianteDTO;
import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
public interface EstudianteManager {
    
    public EstudianteDTO llenarDatosGradoMateriaDTO();
    
    /*Consulta los grados cursados por campos o directamente todos para eso se usa
    el index donde 0 seria todo.*/
    public ArrayList<EstudianteDTO> consultarEstudiantes(int index,String valor);
    
    public String generarTablaDeConsulta(int index, String valor);
}
