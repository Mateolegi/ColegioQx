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
public class SesionDto {
    public static int idUsuaio;
    public static String nombre;
    public static String apellido;
    public static String numeroDocumento;
    public static int idTipoDocumento;
    public static String clave;
    public static int idGrupo;/*TamañoBD: 2*/
    public static int idCiudadResidencial;/*TamañoBD: 6*/
    public static String fechaNacimiento;/*TamañoBD: 10*/
    public static String sexo;/*TamañoBD: 1*/
    public static String direccionResidencial;
    public static String telefonoResidencial;
    public static String telefonoCelular;
    public static String correo;

    public static int getIdUsuaio() {
        return idUsuaio;
    }

    public static void setIdUsuaio(int idUsuaio) {
        SesionDto.idUsuaio = idUsuaio;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        SesionDto.nombre = nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static void setApellido(String apellido) {
        SesionDto.apellido = apellido;
    }

    public static String getNumeroDocumento() {
        return numeroDocumento;
    }

    public static void setNumeroDocumento(String numeroDocumento) {
        SesionDto.numeroDocumento = numeroDocumento;
    }

    public static int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public static void setIdTipoDocumento(int idTipoDocumento) {
        SesionDto.idTipoDocumento = idTipoDocumento;
    }

    public static String getClave() {
        return clave;
    }

    public static void setClave(String clave) {
        SesionDto.clave = clave;
    }

    public static int getIdGrupo() {
        return idGrupo;
    }

    public static void setIdGrupo(int idGrupo) {
        SesionDto.idGrupo = idGrupo;
    }

    public static int getIdCiudadResidencial() {
        return idCiudadResidencial;
    }

    public static void setIdCiudadResidencial(int idCiudadResidencial) {
        SesionDto.idCiudadResidencial = idCiudadResidencial;
    }

    public static String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public static void setFechaNacimiento(String fechaNacimiento) {
        SesionDto.fechaNacimiento = fechaNacimiento;
    }

    public static String getSexo() {
        return sexo;
    }

    public static void setSexo(String sexo) {
        SesionDto.sexo = sexo;
    }

    public static String getDireccionResidencial() {
        return direccionResidencial;
    }

    public static void setDireccionResidencial(String direccionResidencial) {
        SesionDto.direccionResidencial = direccionResidencial;
    }

    public static String getTelefonoResidencial() {
        return telefonoResidencial;
    }

    public static void setTelefonoResidencial(String telefonoResidencial) {
        SesionDto.telefonoResidencial = telefonoResidencial;
    }

    public static String getTelefonoCelular() {
        return telefonoCelular;
    }

    public static void setTelefonoCelular(String telefonoCelular) {
        SesionDto.telefonoCelular = telefonoCelular;
    }

    public static String getCorreo() {
        return correo;
    }

    public static void setCorreo(String correo) {
        SesionDto.correo = correo;
    }
    
    
    
}
