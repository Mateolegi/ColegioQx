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
public class DetallePlanEvaluacionEntity {
    private int idDetallePEvaluacion; /*Tamaño BD: 6*/
    private double valorPorcentajeSeguimiento;/*Tamaño BD: (4,2)*/
    private double valorPorcentajeParcial;/*Tamaño BD: (4,2)*/
    private double valorPorcentajeFinal; /*Tamaño BD: (4,2)*/
    private String numeroPeriodos;/*Tamaño BD: 1*/
    private String ano;/*Tamaño BD: 4*/

    public int getIdDetallePEvaluacion() {
        return idDetallePEvaluacion;
    }

    public void setIdDetallePEvaluacion(int idDetallePEvaluacion) {
        this.idDetallePEvaluacion = idDetallePEvaluacion;
    }

    public double getValorPorcentajeSeguimiento() {
        return valorPorcentajeSeguimiento;
    }

    public void setValorPorcentajeSeguimiento(double valorPorcentajeSeguimiento) {
        this.valorPorcentajeSeguimiento = valorPorcentajeSeguimiento;
    }

    public double getValorPorcentajeParcial() {
        return valorPorcentajeParcial;
    }

    public void setValorPorcentajeParcial(double valorPorcentajeParcial) {
        this.valorPorcentajeParcial = valorPorcentajeParcial;
    }

    public double getValorPorcentajeFinal() {
        return valorPorcentajeFinal;
    }

    public void setValorPorcentajeFinal(double valorPorcentajeFinal) {
        this.valorPorcentajeFinal = valorPorcentajeFinal;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    
}
