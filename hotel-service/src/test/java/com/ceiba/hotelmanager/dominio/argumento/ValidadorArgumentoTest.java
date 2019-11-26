package com.ceiba.hotelmanager.dominio.argumento;

import com.ceiba.hotelmanager.dominio.excepcion.*;
import com.ceiba.hotelmanager.dominio.validador.ValidadorArgumento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ValidadorArgumentoTest {
    private static final String CAMPO_OBLIGATORIO="Este campo debe de ser obligatorio";
    private static final String NUMERO_CARACTERES_OBLIGATORIOS="El numero de caracteres debe de ser mayor que %s";
    private static final String PALABRA_A_VALIDAR="sol";
    private static final int NUMERO_CARACTERES=4;
    private static final LocalDate FECHA_INGRESO=LocalDate.of(2019,5,15);
    private static final LocalDate FECHA_SALIDA=LocalDate.of(2019,5,10);
    private static final String ERROR_EN_LAS_FECHAS="La fecha de ingreso no puede ser mayor a la de salida";
    private static final String NUMERO_HABITACION_SEGUNDO_AL_CUARTO_PISO="301";
    private static final String NUMERO_HABITACION_DEL_QUINTO_PISO="502";
    private static final String NUMERO_DE_HABITACION_INVALIDA="520";
    private static final String MENSAJE_HABITACION_INVALIDA="La habitacion no existe. Las habitacion van del 201-210;301-310;401-410;501-510 ";
    private static final int CANTIDAD_DE_PERSONAS=10;
    private static final String CORRECTO_INGRESO_DE_CANTIDAD_PERSONAS_POR_HABITACION="Ingreso incorrecto, en las habitaciones del segundo al cuarto piso son: (maximo 3 personas, minimo 1) y en las del quinto piso son: (maximo 8, minimo 4)";

    @Test
    void validarCampoObligatorioTest(){
        try {
            ValidadorArgumento.validarCampoObligatorio(null,CAMPO_OBLIGATORIO);
        }catch (ExcepcionObligatorio e){
            Assertions.assertEquals(CAMPO_OBLIGATORIO, e.getMessage());
        }
    }

    @Test
    void validarLongitudArgumentoTest(){
        try {
            ValidadorArgumento.validarLongitudArgumento(NUMERO_CARACTERES_OBLIGATORIOS,PALABRA_A_VALIDAR,NUMERO_CARACTERES);
        }catch (ExcepcionCaracteres e){
            Assertions.assertEquals(NUMERO_CARACTERES_OBLIGATORIOS, e.getMessage());
        }
    }
    @Test
    void validarRegistroIncorrectoDeFechaTest(){
        try {
            ValidadorArgumento.validarVeracidadFecha(FECHA_INGRESO,FECHA_SALIDA,ERROR_EN_LAS_FECHAS);
        }catch (ExcepcionFechaInvalida e){
            Assertions.assertEquals(ERROR_EN_LAS_FECHAS, e.getMessage());
        }
    }

    @Test
    void validarHabitacionEncontradaDelSegundoAlCuartoPisoTest(){
        boolean estadoEncontrado=ValidadorArgumento.encontrarHabitacionPrimerosCuatroPisos(NUMERO_HABITACION_SEGUNDO_AL_CUARTO_PISO);

        Assertions.assertTrue(estadoEncontrado);
    }

    @Test
    void validarHabitacionNoEncontradaDelSegundoAlCuartoPisoTest(){
        boolean estadoEncontrado=ValidadorArgumento.encontrarHabitacionPrimerosCuatroPisos(NUMERO_HABITACION_DEL_QUINTO_PISO);

        Assertions.assertFalse(estadoEncontrado);
    }

    @Test
    void validarHabitacionEncontradaDelQuintoPisoTest(){
        boolean estadoEncontrado=ValidadorArgumento.encontrarHabitacionQuintoPiso(NUMERO_HABITACION_DEL_QUINTO_PISO);

        Assertions.assertTrue(estadoEncontrado);
    }

    @Test
    void validarHabitacionNoEncontradaDelQuintoPisoTest(){
        boolean estadoEncontrado=ValidadorArgumento.encontrarHabitacionQuintoPiso(NUMERO_HABITACION_SEGUNDO_AL_CUARTO_PISO);

        Assertions.assertFalse(estadoEncontrado);
    }

    @Test
    void validarElNoCorrectoIngresoDeHabitacionTest(){
        try {
            ValidadorArgumento.validarCorrectoIngresoHabitacion(NUMERO_DE_HABITACION_INVALIDA,MENSAJE_HABITACION_INVALIDA);
        }catch (ExcepcionHabitacionInvalida e){
            Assertions.assertEquals(MENSAJE_HABITACION_INVALIDA,e.getMessage());
        }
    }

    @Test
    void validarIngresoIncorrectoPersonasPorHabitacionDelSegundoAlCuartoPisoTest(){
        try {
            ValidadorArgumento.validadorCorrecto(NUMERO_HABITACION_SEGUNDO_AL_CUARTO_PISO,CANTIDAD_DE_PERSONAS,CORRECTO_INGRESO_DE_CANTIDAD_PERSONAS_POR_HABITACION);
        }catch (ExcepcionPersonasSegunElPiso e){
            Assertions.assertEquals(CORRECTO_INGRESO_DE_CANTIDAD_PERSONAS_POR_HABITACION, e.getMessage());
        }
    }

    @Test
    void  validarIngresoIncorrectoPeronasPorHabitacionDelQuintoPisoTest(){
        try {
            ValidadorArgumento.validadorCorrecto(NUMERO_HABITACION_DEL_QUINTO_PISO,CANTIDAD_DE_PERSONAS,CORRECTO_INGRESO_DE_CANTIDAD_PERSONAS_POR_HABITACION);
        }catch (ExcepcionPersonasSegunElPiso e){
            Assertions.assertEquals(CORRECTO_INGRESO_DE_CANTIDAD_PERSONAS_POR_HABITACION,e.getMessage());
        }
    }
}
