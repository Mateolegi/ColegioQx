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
public class GradosCursadosEntity {
    private int idGradoCursado; /*Tamaño BD: 6*/
    private int idGrado;/*Tamaño BD: 2*/
    private String idGrupo;
    private int idEstudiante;/*Tamaño BD: 7*/
    private String ano;/*Tamaño BD: 4*/
    private String estado;/*Tamaño BD: 1*/
    private double notaPromedio;/*Tamaño BD: (3,2)*/

    public int getIdGradoCursado() {
        return idGradoCursado;
    }

    public void setIdGradoCursado(int idGradoCursado) {
        this.idGradoCursado = idGradoCursado;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }
    
    

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
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

    public double getNotaPromedio() {
        return notaPromedio;
    }

    public void setNotaPromedio(double notaPromedio) {
        this.notaPromedio = notaPromedio;
    }
    
    
    
}
