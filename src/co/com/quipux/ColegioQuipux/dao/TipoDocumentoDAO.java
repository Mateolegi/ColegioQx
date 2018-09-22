/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao;

import co.com.quipux.ColegioQuipux.models.entity.TipoDocumentoEntity;
import java.util.ArrayList;

/**
 *
 * @author Sebas
 */
public interface TipoDocumentoDAO {
    
    public boolean registrarTipoDeDocumento(TipoDocumentoEntity tipoDoc);
    
    public ArrayList<TipoDocumentoEntity> getNombresTipoDeDocumentos();
    
    public String[] getListadoSiglas();
    
    public int[] getCodigoTipoDocumento();
    
}
