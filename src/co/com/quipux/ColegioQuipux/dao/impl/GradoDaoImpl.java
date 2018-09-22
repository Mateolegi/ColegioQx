/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao.impl;

import co.com.quipux.ColegioQuipux.dao.GradoDAO;
import co.com.quipux.ColegioQuipux.dao.sql.GradoSQL;
import co.com.quipux.ColegioQuipux.models.entity.GradoEntity;
import co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica.BDConexion;
import co.com.quipux.ColegioQuipux.util.Tiempo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebas
 */
public class GradoDaoImpl implements GradoDAO{

    ArrayList<GradoEntity> ArrayGrado = new ArrayList<GradoEntity>();
    
    @Override
    public void registrarGrado(GradoEntity grado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarGrado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<GradoEntity> getNumeroDeGrado() {
        ArrayGrado=new ArrayList<GradoEntity>();
        //ArrayList<ProfesorEntity> nombres = new ArrayList<ProfesorEntity>();
        BDConexion c = new BDConexion();
        try{
            PreparedStatement stm= c.getCon().prepareStatement
                (GradoSQL.getCodigoDeGrado());
            
            ResultSet rs= stm.executeQuery();
            
            while(rs.next()){
                GradoEntity objU= new GradoEntity();
                objU.setIdGrado(rs.getInt("idGrado"));
                objU.setNumeroGrado(rs.getString("numeroGrado"));
                
                ArrayGrado.add(objU);
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
        return ArrayGrado;
    }

    @Override
    public String[] getListadoDeGrados() {
       //TR Filas TV Columnas
        ArrayGrado=getNumeroDeGrado();
        String[] tabla=new String[ArrayGrado.size()];
        int i=0;
        for (GradoEntity u: ArrayGrado) {
            tabla[i]=""+u.getNumeroGrado();
            i++;
        }
        
        return tabla;
    }

    @Override
    public int[] getCodigoGrado() {
        //TR Filas TV Columnas
        ArrayGrado=getNumeroDeGrado();
        
        int[] tabla=new int[ArrayGrado.size()];
        
        int i=0;
        for (GradoEntity u: ArrayGrado) {
            tabla[i]=u.getIdGrado();
            i++;
        }
        return tabla;
    }
    
    
    
}
