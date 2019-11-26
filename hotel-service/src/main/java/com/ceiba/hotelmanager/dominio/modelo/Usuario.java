package com.ceiba.hotelmanager.dominio.modelo;

import com.ceiba.hotelmanager.dominio.validador.ValidadorArgumento;

public class Usuario {

    private static final String ESTE_CAMPO_DEBE_SER_OBLIGATORIO="Este campo debe ser obligatorio ";
    private static final String NUMERO_CARACTERES_NO_PERMITIDOS="El numero de caracteres debe de ser mayor que %s";

    private static final int NUMERO_CARACTERES=2;

    private Long idUsuario;
    private Long cedulaCiudadania;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String numeroCelular;

    public Usuario(Long idUsuario, Long cedulaCiudadania, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,  String numeroCelular) {

        ValidadorArgumento.validarCampoObligatorio(primerNombre,String.format(ESTE_CAMPO_DEBE_SER_OBLIGATORIO," primerNombre"));
        ValidadorArgumento.validarCampoObligatorio(primerApellido,String.format(ESTE_CAMPO_DEBE_SER_OBLIGATORIO,"primerApellido"));
        ValidadorArgumento.validarCampoObligatorio(numeroCelular,String.format(ESTE_CAMPO_DEBE_SER_OBLIGATORIO,"numeroCelular"));
        ValidadorArgumento.validarCampoObligatorio(cedulaCiudadania,String.format(ESTE_CAMPO_DEBE_SER_OBLIGATORIO,"cedulaCiudadania"));
        ValidadorArgumento.validarLongitudArgumento(String.format(NUMERO_CARACTERES_NO_PERMITIDOS,NUMERO_CARACTERES),primerNombre,NUMERO_CARACTERES);
        ValidadorArgumento.validarLongitudArgumento(String.format(NUMERO_CARACTERES_NO_PERMITIDOS,NUMERO_CARACTERES),primerApellido,NUMERO_CARACTERES);
        ValidadorArgumento.validarLongitudArgumento(String.format(NUMERO_CARACTERES_NO_PERMITIDOS,NUMERO_CARACTERES), numeroCelular,NUMERO_CARACTERES);

        this.idUsuario=idUsuario;
        this.cedulaCiudadania = cedulaCiudadania;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroCelular = numeroCelular;
    }
    public Usuario(){}
    public void setIdUsuario(Long idUsuario){this.idUsuario=idUsuario;}

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public Long getIdUsuario(){ return idUsuario; }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public Long getCedulaCiudadania() {
        return cedulaCiudadania;
    }

    public void setCedulaCiudadania(Long cedulaCiudadania) {
        this.cedulaCiudadania = cedulaCiudadania;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }
}
