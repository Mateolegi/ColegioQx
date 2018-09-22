/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao.impl;

import co.com.quipux.ColegioQuipux.dao.CiudadResidencialDAO;
import co.com.quipux.ColegioQuipux.dao.sql.CiudadResidencialSQL;
import co.com.quipux.ColegioQuipux.dao.sql.TipoDocumentoSQL;
import co.com.quipux.ColegioQuipux.models.entity.CiudadResidencialEntity;
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
public class CiudadResidencialDaoImpl implements CiudadResidencialDAO{

    ArrayList<CiudadResidencialEntity> listaCiudadResidencial = new ArrayList<CiudadResidencialEntity>();
    
    @Override
    public void registrarCiudadResidencial(CiudadResidencialEntity ciudadResidencial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CiudadResidencialEntity> getNombresCiudadResidencial() {
        listaCiudadResidencial=new ArrayList<CiudadResidencialEntity>();
        //ArrayList<ProfesorEntity> nombres = new ArrayList<ProfesorEntity>();
        BDConexion c = new BDConexion();
        try{
            PreparedStatement stm= c.getCon().prepareStatement
                (CiudadResidencialSQL.getDatosCiudadResidencial());
            
            ResultSet rs= stm.executeQuery();
            
            while(rs.next()){
                CiudadResidencialEntity objU= new CiudadResidencialEntity();
                objU.setIdCiudadResidencial(rs.getInt("idCiudadResidencial"));
                objU.setNombreCiudad(rs.getString("nombreCiudad"));
                objU.setDepartamento(rs.getString("departamento"));
                objU.setPais(rs.getString("pais"));
                
                listaCiudadResidencial.add(objU);
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
        return listaCiudadResidencial;
    }

    @Override
    public String[] getListadoCiudades() {
        //TR Filas TV Columnas
        listaCiudadResidencial=getNombresCiudadResidencial();
        String[] tabla=new String[listaCiudadResidencial.size()];
        int i=0;
        for (CiudadResidencialEntity u: listaCiudadResidencial) {
            tabla[i]=""+u.getNombreCiudad();
            i++;
        }
        
        return tabla;
    }

    @Override
    public int[] getCodigoCiudades() {
        //TR Filas TV Columnas
        listaCiudadResidencial=getNombresCiudadResidencial();
        int[] tabla=new int[listaCiudadResidencial.size()];
        int i=0;
        for (CiudadResidencialEntity u: listaCiudadResidencial) {
            tabla[i]=u.getIdCiudadResidencial();
            i++;
        }
        return tabla;
    }
    
}
