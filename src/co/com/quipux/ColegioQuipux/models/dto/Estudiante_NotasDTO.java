/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.models.dto;

/**
 *
 * @author Sebas
 */
public class Estudiante_NotasDTO {
    private String nombreEstudiante;
    private String apellidoEstudiante;
    private String nombreMateria;
    private double valorNota;
    private String tipoNota;
    private String nombreNota;
    private String descripcionNota;

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public double getValorNota() {
        return valorNota;
    }

    public void setValorNota(double valorNota) {
        this.valorNota = valorNota;
    }

    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }

    public String getNombreNota() {
        return nombreNota;
    }

    public void setNombreNota(String nombreNota) {
        this.nombreNota = nombreNota;
    }

    public String getDescripcionNota() {
        return descripcionNota;
    }

    public void setDescripcionNota(String descripcionNota) {
        this.descripcionNota = descripcionNota;
    }
    
    
    
    
}
