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
public class TipoNotaEntity {
    private int idTipoNota; /*Tamaño BD: 6*/
    private int idPlanEvaluacion; /*Tamaño BD: 6*/
    private String tipoNota; /*Seguimiento, parcial, final etc...*/
    private String nombreNota;/*Tamaño BD: 60*/
    private String descripción;/*Tamaño BD: 255*/
    private String fechaEntrega;

    public int getIdTipoNota() {
        return idTipoNota;
    }

    public void setIdTipoNota(int idTipoNota) {
        this.idTipoNota = idTipoNota;
    }

    public int getIdPlanEvaluacion() {
        return idPlanEvaluacion;
    }

    public void setIdPlanEvaluacion(int idPlanEvaluacion) {
        this.idPlanEvaluacion = idPlanEvaluacion;
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

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
    
    
}
