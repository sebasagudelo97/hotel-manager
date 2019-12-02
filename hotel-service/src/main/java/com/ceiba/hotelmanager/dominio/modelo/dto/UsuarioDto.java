package com.ceiba.hotelmanager.dominio.modelo.dto;

import com.ceiba.hotelmanager.dominio.modelo.Usuario;

public class UsuarioDto {

    private Long idUsuario;
    private Long cedulaCiudadania;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String numeroCelular;

    public UsuarioDto(){

    }

    public UsuarioDto(Long idUsuario, Long cedulaCiudadania, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String numeroCelular) {
        this.idUsuario = idUsuario;
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

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getCedulaCiudadania() {
        return cedulaCiudadania;
    }

    public void setCedulaCiudadania(Long cedulaCiudadania) {
        this.cedulaCiudadania = cedulaCiudadania;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public Usuario build(){
        return new Usuario(this.idUsuario,this.cedulaCiudadania,this.primerNombre,this.segundoNombre,this.primerApellido,this.segundoApellido,this.numeroCelular);
    }

}
