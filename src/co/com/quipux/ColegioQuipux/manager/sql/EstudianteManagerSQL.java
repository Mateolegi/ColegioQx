/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.quipux.ColegioQuipux.manager.sql;

/**
 *
 * @author Sebas
 */
public class EstudianteManagerSQL {

    public static String getEstudiante(int index, String valor) {
        String resultado = "";
        switch (index) {/*0: TODO / 1: Código/ 2: Estudiante/ 3: Tipo Doc/ 
            4: Número Documento/ 5: Fecha Nacimiento/ 6: Sexo/ 7: Ciudad/ 
            8: Teléfono residencial/ 9: Teléfono celular/ 10: Correo*/
            case 0:/*TODO*/
                resultado = "SELECT es.idEstudiante,es.nombre,es.apellido, td.siglas, es.numeroDocumento,es.fechaNacimiento,es.sexo,cd.nombreCiudad,es.telefonoResidencial,es.telefonoCelular,es.correo FROM tbl_estudiante es"
                        + " INNER JOIN tbl_tipodocumento td on es.idTipoDocumento = td.idTipoDocumento"
                        + " INNER JOIN tbl_ciudades cd on es.idCiudadResidencial = cd.idCiudadResidencial";
                break;
            case 1:/*Código*/
                resultado = "SELECT es.idEstudiante,es.nombre,es.apellido, td.siglas, es.numeroDocumento,es.fechaNacimiento,es.sexo,cd.nombreCiudad,es.telefonoResidencial,es.telefonoCelular,es.correo FROM tbl_estudiante es"
                        + " INNER JOIN tbl_tipodocumento td on es.idTipoDocumento = td.idTipoDocumento"
                        + " INNER JOIN tbl_ciudades cd on es.idCiudadResidencial = cd.idCiudadResidencial"
                        + " WHERE es.idEstudiante LIKE '%"+valor+"%'";
                break;
            case 2:/*Estudiante*/
                resultado = "SELECT es.idEstudiante,es.nombre,es.apellido, td.siglas, es.numeroDocumento,es.fechaNacimiento,es.sexo,cd.nombreCiudad,es.telefonoResidencial,es.telefonoCelular,es.correo FROM tbl_estudiante es"
                        + " INNER JOIN tbl_tipodocumento td on es.idTipoDocumento = td.idTipoDocumento"
                        + " INNER JOIN tbl_ciudades cd on es.idCiudadResidencial = cd.idCiudadResidencial"
                        + " WHERE es.nombre LIKE '%"+valor+"%' OR es.apellido LIKE '&"+valor+"&'";
                break;
            case 3:/*Tipo Doc*/
                resultado = "SELECT es.idEstudiante,es.nombre,es.apellido, td.siglas, es.numeroDocumento,es.fechaNacimiento,es.sexo,cd.nombreCiudad,es.telefonoResidencial,es.telefonoCelular,es.correo FROM tbl_estudiante es"
                        + " INNER JOIN tbl_tipodocumento td on es.idTipoDocumento = td.idTipoDocumento"
                        + " INNER JOIN tbl_ciudades cd on es.idCiudadResidencial = cd.idCiudadResidencial"
                        + " WHERE td.siglas LIKE '%"+valor+"%'";
                break;
            case 4:/*Número Documento*/
                resultado = "SELECT es.idEstudiante,es.nombre,es.apellido, td.siglas, es.numeroDocumento,es.fechaNacimiento,es.sexo,cd.nombreCiudad,es.telefonoResidencial,es.telefonoCelular,es.correo FROM tbl_estudiante es"
                        + " INNER JOIN tbl_tipodocumento td on es.idTipoDocumento = td.idTipoDocumento"
                        + " INNER JOIN tbl_ciudades cd on es.idCiudadResidencial = cd.idCiudadResidencial"
                        + " WHERE es.numeroDocumento LIKE '%"+valor+"%'";
                break;
            case 5:/*Fecha Nacimiento*/
                resultado = "SELECT es.idEstudiante,es.nombre,es.apellido, td.siglas, es.numeroDocumento,es.fechaNacimiento,es.sexo,cd.nombreCiudad,es.telefonoResidencial,es.telefonoCelular,es.correo FROM tbl_estudiante es"
                        + " INNER JOIN tbl_tipodocumento td on es.idTipoDocumento = td.idTipoDocumento"
                        + " INNER JOIN tbl_ciudades cd on es.idCiudadResidencial = cd.idCiudadResidencial"
                        + " WHERE es.fechaNacimiento LIKE '%"+valor+"%'";
                break;
            case 6:/*Sexo*/
                resultado = "SELECT es.idEstudiante,es.nombre,es.apellido, td.siglas, es.numeroDocumento,es.fechaNacimiento,es.sexo,cd.nombreCiudad,es.telefonoResidencial,es.telefonoCelular,es.correo FROM tbl_estudiante es"
                        + " INNER JOIN tbl_tipodocumento td on es.idTipoDocumento = td.idTipoDocumento"
                        + " INNER JOIN tbl_ciudades cd on es.idCiudadResidencial = cd.idCiudadResidencial"
                        + " WHERE es.sexo LIKE '%"+valor+"%'";
                break;
            case 7:/*Ciudad*/
                resultado = "SELECT es.idEstudiante,es.nombre,es.apellido, td.siglas, es.numeroDocumento,es.fechaNacimiento,es.sexo,cd.nombreCiudad,es.telefonoResidencial,es.telefonoCelular,es.correo FROM tbl_estudiante es"
                        + " INNER JOIN tbl_tipodocumento td on es.idTipoDocumento = td.idTipoDocumento"
                        + " INNER JOIN tbl_ciudades cd on es.idCiudadResidencial = cd.idCiudadResidencial"
                        + " WHERE cd.nombreCiudad LIKE '%"+valor+"%'";
                break;
            case 8:/*Teléfono residencial*/
                resultado = "SELECT es.idEstudiante,es.nombre,es.apellido, td.siglas, es.numeroDocumento,es.fechaNacimiento,es.sexo,cd.nombreCiudad,es.telefonoResidencial,es.telefonoCelular,es.correo FROM tbl_estudiante es"
                        + " INNER JOIN tbl_tipodocumento td on es.idTipoDocumento = td.idTipoDocumento"
                        + " INNER JOIN tbl_ciudades cd on es.idCiudadResidencial = cd.idCiudadResidencial"
                        + " WHERE es.telefonoResidencial LIKE '%"+valor+"%'";
                break;
            case 9:/*Teléfono celular*/
                resultado = "SELECT es.idEstudiante,es.nombre,es.apellido, td.siglas, es.numeroDocumento,es.fechaNacimiento,es.sexo,cd.nombreCiudad,es.telefonoResidencial,es.telefonoCelular,es.correo FROM tbl_estudiante es"
                        + " INNER JOIN tbl_tipodocumento td on es.idTipoDocumento = td.idTipoDocumento"
                        + " INNER JOIN tbl_ciudades cd on es.idCiudadResidencial = cd.idCiudadResidencial"
                        + " WHERE es.telefonoCelular LIKE '%"+valor+"%'";
                break;
            case 10:/*Correo*/
                resultado = "SELECT es.idEstudiante,es.nombre,es.apellido, td.siglas, es.numeroDocumento,es.fechaNacimiento,es.sexo,cd.nombreCiudad,es.telefonoResidencial,es.telefonoCelular,es.correo FROM tbl_estudiante es"
                        + " INNER JOIN tbl_tipodocumento td on es.idTipoDocumento = td.idTipoDocumento"
                        + " INNER JOIN tbl_ciudades cd on es.idCiudadResidencial = cd.idCiudadResidencial"
                        + " WHERE es.correo LIKE '%"+valor+"%'";
                break;
        }

        return resultado;
    }
}
