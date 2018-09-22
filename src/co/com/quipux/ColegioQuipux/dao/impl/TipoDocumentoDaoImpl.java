/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao.impl;

import co.com.quipux.ColegioQuipux.dao.TipoDocumentoDAO;
import co.com.quipux.ColegioQuipux.dao.sql.TipoDocumentoSQL;
import co.com.quipux.ColegioQuipux.models.entity.TipoDocumentoEntity;
import co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica.BDConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebas
 */
public class TipoDocumentoDaoImpl implements TipoDocumentoDAO{
    
    private ArrayList<TipoDocumentoEntity> listaTipoDoc = new ArrayList<TipoDocumentoEntity>();

    @Override
    public boolean registrarTipoDeDocumento(TipoDocumentoEntity tipoDoc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoDocumentoEntity> getNombresTipoDeDocumentos() {
        listaTipoDoc=new ArrayList<TipoDocumentoEntity>();
        //ArrayList<ProfesorEntity> nombres = new ArrayList<ProfesorEntity>();
        BDConexion c = new BDConexion();
        try{
            PreparedStatement stm= c.getCon().prepareStatement
                (TipoDocumentoSQL.getDatosTipoDocumento());
            
            ResultSet rs= stm.executeQuery();
            
            while(rs.next()){
                TipoDocumentoEntity objU= new TipoDocumentoEntity();
                objU.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                objU.setNombreDocumento(rs.getString("nombreDocumento"));
                objU.setSiglas(rs.getString("siglas"));
                
                listaTipoDoc.add(objU);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "!Error¡ Clase: ProfesorDaoImpl. Metodo: getNombreDeProfesor. tipo de Error: "+ ex.getMessage()+"\n");
            System.out.println("!Error¡ Clase: ProfesorDaoImpl. Metodo: getNombreDeProfesor. tipo de Error: "+ ex.getMessage()+"\n");
            ex.printStackTrace();
        }finally{
            try{
                c.getCon().close();
            }catch(Exception e){
                
            }
        }// Finaliza un bloque de excepciones
        return listaTipoDoc;
    }

    @Override
    public String[] getListadoSiglas() {
        //TR Filas TV Columnas
        listaTipoDoc=getNombresTipoDeDocumentos();
        String[] tabla=new String[listaTipoDoc.size()];
        int i=0;
        for (TipoDocumentoEntity u: listaTipoDoc) {
            tabla[i]=""+u.getNombreDocumento();
            i++;
        }
        
        return tabla;
    }

    @Override
    public int[] getCodigoTipoDocumento() {
        //TR Filas TV Columnas
        listaTipoDoc=getNombresTipoDeDocumentos();
        int[] tabla=new int[listaTipoDoc.size()];
        int i=0;
        for (TipoDocumentoEntity u: listaTipoDoc) {
            tabla[i]=u.getIdTipoDocumento();
            i++;
        }
        return tabla;
    }
    
}
