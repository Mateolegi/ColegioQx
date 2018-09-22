/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.presentacion.interfaceGrafica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jhon Sebastian Agudelo Sierra
 * Correo: Sebastamriel@gmail.com
 */
public class BDConexion {
    //Declaración de objeto que devulve la conección
    private Connection conectar = null;
    public BDConexion(){}
    
    public Connection getCon(){
         setConexionDB();
         return conectar;
     }//Fin de getCon
    
    public void setCon(Connection c){
         conectar=c;
     }//Fin setCon
    
    public void setConexionDB(){
                String host="localhost";//127.0.0.1 o ip
                /*
                A nivel local:localhost
                Remoto //permisos en bd remota
                */
  
                String puerto="3306"; // o deacuerdo a la instancia
                String bd="quikacademy2_0";
                String user="root";
                String clave="";
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    setCon(DriverManager.getConnection("jdbc:mysql://localhost:"+puerto+"/"+bd, user,clave));
                    System.out.println("¡Conexión exitosa con la base de datos!");
                }catch(Exception ex){
                    System.out.println("¡Error! al conectar con MySQL: Tipo de error: "+ex.getMessage());
                }
            }
    
    static{//Metodos propios de una clase
         try{
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             }
         catch (ClassNotFoundException e){
             System.out.println("ClassNotFoundException" + e.getMessage());
          }//Si la clase no se encuentra 
         catch (InstantiationException e2){
             System.out.println("InstantiationException" + e2.getMessage()); 
          }//No se encontro la instancia       
         catch (IllegalAccessException e3){ 
             System.out.println("IllegalAccessException" + e3.getMessage() );
          }//si hay acceso a la base de datos   
         catch (Exception e4){
                 System.out.println("Exception" + e4.getMessage()  );
                 }//algo general diers
             }//fin static

}
