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
public class GradosCursadosDTO {
    private int idGradoCursado;
    private String numeroGrado;
    private String nombre;
    private String apellido;
    private String ano;
    private String estado;
    private Double notaPromedio;

    public int getIdGradoCursado() {
        return idGradoCursado;
    }

    public void setIdGradoCursado(int idGradoCursado) {
        this.idGradoCursado = idGradoCursado;
    }

    public String getNumeroGrado() {
        return numeroGrado;
    }

    public void setNumeroGrado(String numeroGrado) {
        this.numeroGrado = numeroGrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getNotaPromedio() {
        return notaPromedio;
    }

    public void setNotaPromedio(Double notaPromedio) {
        this.notaPromedio = notaPromedio;
    }
    
    
    
}
