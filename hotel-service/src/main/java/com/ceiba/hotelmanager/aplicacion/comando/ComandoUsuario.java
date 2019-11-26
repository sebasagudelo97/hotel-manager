package com.ceiba.hotelmanager.aplicacion.comando;


public class ComandoUsuario {

    private Long idUsuario;
    private Long cedulaCiudadania;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String numeroCelular;

    public ComandoUsuario(Long idUsuario, Long cedulaCiudadania, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String numeroCelular) {

        this.idUsuario=idUsuario;
        this.cedulaCiudadania = cedulaCiudadania;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroCelular = numeroCelular;

    }


    public Long getIdUsuario() {
        return idUsuario;
    }

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

    public String getNumeroCelular() {
        return numeroCelular;
    }
}
