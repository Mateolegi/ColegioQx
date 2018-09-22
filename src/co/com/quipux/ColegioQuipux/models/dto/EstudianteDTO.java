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
public class EstudianteDTO {
    /*es.idEstudiante,es.nombre,es.apellido, td.siglas, es.numeroDocumento,
    es.fechaNacimiento,es.sexo,cd.nombreCiudad,es.telefonoResidencial,
    es.telefonoCelular,es.correo*/
    private int idEstudiante;
    private String nombreEstudiante;
    private String apellidoEstudiante;
    private String siglas;
    private String numeroDocumento;
    private String fechaNacimiento;
    private String sexo;
    private String nombreCiudad;
    private String telefonoResidencial;
    private String telefonoCelular;
    private String correo;

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

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

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getTelefonoResidencial() {
        return telefonoResidencial;
    }

    public void setTelefonoResidencial(String telefonoResidencial) {
        this.telefonoResidencial = telefonoResidencial;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String corre) {
        this.correo = corre;
    }
    
    
    
}
