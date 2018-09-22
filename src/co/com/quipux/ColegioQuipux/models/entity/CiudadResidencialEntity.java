/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.models.entity;

/**
 *
 * @author Sebas
 */
public class CiudadResidencialEntity {
    private int idCiudadResidencial;
    private String nombreCiudad;
    private String departamento;
    private String pais;

    public int getIdCiudadResidencial() {
        return idCiudadResidencial;
    }

    public void setIdCiudadResidencial(int idCiudadResidencial) {
        this.idCiudadResidencial = idCiudadResidencial;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
    
}
