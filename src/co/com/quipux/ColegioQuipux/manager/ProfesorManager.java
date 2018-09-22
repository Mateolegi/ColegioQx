/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.manager;

import co.com.quipux.ColegioQuipux.models.dto.ProfesorConsultaSimpleDTO;
import co.com.quipux.ColegioQuipux.models.dto.ProfesorDTO;

/**
 *
 * @author Sebas
 */
public interface ProfesorManager {
    
    public ProfesorConsultaSimpleDTO consultaSimpleProfesor(int idProsefor);
    
    public boolean registrarProfesor(ProfesorDTO profesor);
    
    public String[] nombreProfesores();
    
}
