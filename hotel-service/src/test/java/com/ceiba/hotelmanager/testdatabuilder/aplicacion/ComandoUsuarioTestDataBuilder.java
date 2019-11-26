package com.ceiba.hotelmanager.testdatabuilder.aplicacion;

import com.ceiba.hotelmanager.aplicacion.comando.ComandoUsuario;

public class ComandoUsuarioTestDataBuilder {
    private static final String PRIMER_NOMBRE="Juan";
    private static final Long ID_USUARIO=1L;
    private static final String SEGUNDO_NOMBRE="Sebastian";
    private static final String PRIMER_APELLIDO="Agudelo";
    private static final String SEGUNDO_APELLIDO="Mejia";
    private static final Long CEDULA_CIUDADANIA=1036960221L;
    private static final String NUMERO_CELULAR="3144568565";

    private Long idUsuario;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Long cedulaCiudadania;
    private String numeroCelular;

    public ComandoUsuarioTestDataBuilder(){

        this.idUsuario=ID_USUARIO;
        this.primerNombre=PRIMER_NOMBRE;
        this.segundoNombre=SEGUNDO_NOMBRE;
        this.primerApellido=PRIMER_APELLIDO;
        this.segundoApellido=SEGUNDO_APELLIDO;
        this.numeroCelular=NUMERO_CELULAR;
        this.cedulaCiudadania=CEDULA_CIUDADANIA;
    }

    public ComandoUsuarioTestDataBuilder conIdUsuario(Long idUsuario){
        this.idUsuario=idUsuario;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conPrimerNombre(String primerNombre){
        this.primerNombre=primerNombre;
        return this;
    }

    public  ComandoUsuarioTestDataBuilder conSegundoNombre(String segundoNombre){
        this.segundoNombre=segundoNombre;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conPrimerApellido(String primerApellido){
        this.primerApellido=primerApellido;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conSegundoApellido(String segundoApellido){
        this.segundoApellido=segundoApellido;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conNumeroCelular(String numeroCelular){
        this.numeroCelular=numeroCelular;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conCedulaCiudadania(Long cedulaCiudadania){
        this.cedulaCiudadania=cedulaCiudadania;
        return this;
    }

    public ComandoUsuario build(){
        return new ComandoUsuario(this.idUsuario, this.cedulaCiudadania, this.primerNombre, this.segundoNombre, this.primerApellido, this.segundoApellido, this.numeroCelular);
    }
}
