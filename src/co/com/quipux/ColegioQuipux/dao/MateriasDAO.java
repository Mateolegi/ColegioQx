/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao;

import co.com.quipux.ColegioQuipux.models.entity.GradoEntity;
import co.com.quipux.ColegioQuipux.models.entity.MateriasEntity;
import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
public interface MateriasDAO {
    
    public boolean registrarMaterias(MateriasEntity materia);
    
    public String generarCodigoDeMateria(String Nodo);
    
    public ArrayList<MateriasEntity> getDatosMateria();
    
    public String[] getListadoDeMaterias();
    
    public String[] getCodigoMateria();
    
}
