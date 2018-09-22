/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.dao.impl;

import co.com.quipux.ColegioQuipux.dao.MateriasDAO;
import co.com.quipux.ColegioQuipux.dao.sql.MateriasSQL;
import co.com.quipux.ColegioQuipux.models.entity.MateriasEntity;
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
public class MateriasDaoImpl implements MateriasDAO{

    ArrayList<MateriasEntity> listaGrado = new ArrayList<MateriasEntity>();
    
    @Override
    public boolean registrarMaterias(MateriasEntity materia) {
        boolean validacion =false;
        BDConexion c = new BDConexion();
        String resultado = "";
        Tiempo t = new Tiempo();
        try{
            PreparedStatement pst= c.getCon().prepareStatement(MateriasSQL.getInsertarMateria());
            
                pst.setString(1,materia.getIdMateria());
                pst.setString(2,materia.getNombreMateria());
                pst.setString(3,materia.getDescripcion());
                pst.execute();
                
            if(pst.getUpdateCount()>=1){
                resultado = "Usuario Almacenado";
                System.out.println(resultado);
                validacion =true;
            }else{
                resultado = "Error al guardar";
                System.out.println(resultado);
                validacion =false;
            }
            
        }catch(Exception ex){
            
         resultado+= "¡Error! clase: Dao, Metodo: registrarGrupo() Tipo de error:\n"+ex.getMessage()+"\n Line: \n";
         ex.printStackTrace();
            System.out.println(resultado);
        }
        
        finally{
            try{
                c.getCon().close();
            }catch(Exception ex){
                
            }
        }
        
        return validacion;
    }

    @Override
    public String generarCodigoDeMateria(String Nodo) {
        String Codigo="";
            BDConexion conexion = new BDConexion();
            Tiempo t = new Tiempo();
            try{
            Connection conection = conexion.getCon();
            Statement st = conection.createStatement();
            ResultSet rs = st.executeQuery(MateriasSQL.codigoMateria(Nodo));
               if(rs.next()){
                Codigo = rs.getString(1);
                }else{
                   Codigo="La consulta no ha funcionado";
               }
            }catch(Exception ex){
                System.out.println("¡Error! clase: Dao, Metodo: generarCodigoDeMateria() Tipo de error:\n"+ex.getMessage()+"\n Line: \n");
            }
            finally{
                try{
                conexion.getCon().close();
                    System.out.println("Se cerro la conexión");
                }catch(Exception ex){
                }//FIN CATCH
            }//FIN FINALLY
            return Codigo;
    }
    
    @Override
    public ArrayList<MateriasEntity> getDatosMateria() {
        listaGrado=new ArrayList<MateriasEntity>();
        //ArrayList<ProfesorEntity> nombres = new ArrayList<ProfesorEntity>();
        BDConexion c = new BDConexion();
        try{
            PreparedStatement stm= c.getCon().prepareStatement
                (MateriasSQL.getInfoMateria());
            
            ResultSet rs= stm.executeQuery();
            
            while(rs.next()){
                MateriasEntity objU= new MateriasEntity();
                objU.setIdMateria(rs.getString("idMateria"));
                objU.setNombreMateria(rs.getString("nombreMateria"));
                objU.setDescripcion(rs.getString("descripcion"));
                
                listaGrado.add(objU);
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
        return listaGrado;
    }

    @Override
    public String[] getListadoDeMaterias() {
        //TR Filas TV Columnas
        listaGrado=getDatosMateria();
        String[] tabla=new String[listaGrado.size()];
        int i=0;
        for (MateriasEntity u: listaGrado) {
            tabla[i]=""+u.getNombreMateria();
            i++;
        }
        
        return tabla;
    }

    @Override
    public String[] getCodigoMateria() {
        //TR Filas TV Columnas
        listaGrado=getDatosMateria();
        String[] tabla=new String[listaGrado.size()];
        int i=0;
        for (MateriasEntity u: listaGrado) {
            tabla[i]=""+u.getIdMateria();
            i++;
        }
        
        return tabla;
    }
    
}
