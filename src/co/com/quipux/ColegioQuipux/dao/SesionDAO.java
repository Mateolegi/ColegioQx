/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao;

import co.com.quipux.ColegioQuipux.models.dto.SesionDto;

/**
 *
 * @author Sebas
 */
public interface SesionDAO {
    
    public void iniciarSesion(int id,String clave);
    
    public boolean validacionSesionProfesores();
    
    public boolean validacionSesionEstudiante();
    
    public boolean validacionSesionAdministrador();
    
}
