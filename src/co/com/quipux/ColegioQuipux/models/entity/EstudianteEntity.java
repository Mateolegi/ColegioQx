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
public class EstudianteEntity {
    private int idEstudiante;/*TamañoBD: 7*/
    private int idTipoDocumento;/*TamañoBD: 2*/
    private int idCiudadResidencial;/*TamañoBD: 6*/
    private String numeroDocumento;/*TamañoBD: 12*/
    private String nombre;/*TamañoBD: 30*/
    private String apellido;/*TamañoBD: 30*/
    private String fechaNacimiento;/*TamañoBD: 10*/
    private String sexo;/*TamañoBD: 1*/
    private String direccionResidencial;
    private String telefonoResidencial;
    private String telefonoCelular;
    private String correo;
    private String clave;

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public int getIdCiudadResidencial() {
        return idCiudadResidencial;
    }

    public void setIdCiudadResidencial(int idCiudadResidencial) {
        this.idCiudadResidencial = idCiudadResidencial;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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

    public String getDireccionResidencial() {
        return direccionResidencial;
    }

    public void setDireccionResidencial(String direccionResidencial) {
        this.direccionResidencial = direccionResidencial;
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

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
}
