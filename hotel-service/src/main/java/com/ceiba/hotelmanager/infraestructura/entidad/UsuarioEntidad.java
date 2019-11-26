package com.ceiba.hotelmanager.infraestructura.entidad;

import com.ceiba.hotelmanager.dominio.validador.ValidadorArgumento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class UsuarioEntidad {
    private static final String LOS_CAMPOS_DEBEN_SER_OBLIGATORIOS = "Este campo debe ser obligatorio ";
    private static final String NUMERO_CARACTERES_NO_PERMITIDOS = "El numero de campos debe ser mayor a %s";

    private static final int NUMERO_CARACTERES=4;

    @Id
    @Column(name = "in_codigo")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;

    @Column(name = "lon_cedula_ciudadania", nullable = false)
    private Long cedulaCiudadania;

    @Column(name = "nv_primer_nombre", nullable = false)
    private String primerNombre;

    @Column(name = "nv_segundo_nombre")
    private String segundoNombre;

    @Column(name = "nv_primer_apellido", nullable = false)
    private String primerApellido;

    @Column(name = "nv_segundo_apellido")
    private String segundoApellido;

    @Column(name = "nv_numero_celular", nullable = false)
    private String numeroCelular;

    public UsuarioEntidad(){}

    public UsuarioEntidad(Long idUsuario, Long cedulaCiudadania, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,  String numeroCelular) {

        ValidadorArgumento.validarCampoObligatorio(primerNombre,LOS_CAMPOS_DEBEN_SER_OBLIGATORIOS);
        ValidadorArgumento.validarCampoObligatorio(primerApellido,LOS_CAMPOS_DEBEN_SER_OBLIGATORIOS);
        ValidadorArgumento.validarCampoObligatorio(numeroCelular,LOS_CAMPOS_DEBEN_SER_OBLIGATORIOS);
        ValidadorArgumento.validarCampoObligatorio(cedulaCiudadania,LOS_CAMPOS_DEBEN_SER_OBLIGATORIOS);
        ValidadorArgumento.validarLongitudArgumento(String.format(NUMERO_CARACTERES_NO_PERMITIDOS,NUMERO_CARACTERES),primerNombre,NUMERO_CARACTERES);
        ValidadorArgumento.validarLongitudArgumento(String.format(NUMERO_CARACTERES_NO_PERMITIDOS,NUMERO_CARACTERES),primerApellido,NUMERO_CARACTERES);
        ValidadorArgumento.validarLongitudArgumento(String.format(NUMERO_CARACTERES_NO_PERMITIDOS,NUMERO_CARACTERES),numeroCelular,NUMERO_CARACTERES);

        this.idUsuario=idUsuario;
        this.cedulaCiudadania = cedulaCiudadania;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.numeroCelular = numeroCelular;
    }

}
