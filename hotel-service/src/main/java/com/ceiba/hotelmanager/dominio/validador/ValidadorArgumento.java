package com.ceiba.hotelmanager.dominio.validador;

import com.ceiba.hotelmanager.dominio.excepcion.*;

import java.time.LocalDate;

public final class ValidadorArgumento {
    private static final String[] HABITACION_DEL_SEGUNDO_AL_CUARTO_PISO = {"201", "202", "203", "204", "205", "206", "207", "208", "209", "210",
            "301", "302", "303", "304", "305", "306", "307", "308", "309", "310",
            "401", "402", "403", "404", "405", "406", "407", "408", "409", "410"};
    private static final String[] HABITACION_DEL_QUINTO_PISO = {"501", "502", "503", "504", "505", "506", "507", "508", "509", "510"};
    private static final int CANTIDAD_MAXIMA_PERSONAS_SEGUNDO_CUARTO_PISO = 3;
    private static final int CANTIDAD_MINIMA_PERSONAS_SEGUNDO_CUARTO_PISO = 1;
    private static final int CANTIDAD_MAXIMA_PERSONAS_QUINTO_PISO = 8;
    private static final int CANTIDAD_MINIMA_PERSONAS_QUINTO_PISO = 4;

    private ValidadorArgumento() {
    }

    public static void validarLongitudArgumento(String mensaje, String palabraValidar, int numeroCaracteresObligatorios) {
        if (palabraValidar.length() < numeroCaracteresObligatorios) {
            throw new ExcepcionCaracteres(mensaje);
        }
    }

    public static void validarCampoObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionObligatorio(mensaje);
        }
    }

    public static boolean encontrarHabitacionPrimerosCuatroPisos(String numeroHabitacion) {
        boolean valor = false;
        for (int i = 0; i <= HABITACION_DEL_SEGUNDO_AL_CUARTO_PISO.length - 1; i++
        ) {
            if (HABITACION_DEL_SEGUNDO_AL_CUARTO_PISO[i].equals(numeroHabitacion)) {
                valor = true;
                i = HABITACION_DEL_SEGUNDO_AL_CUARTO_PISO.length;
            }
        }
        return valor;
    }

    public static boolean encontrarHabitacionQuintoPiso(String numeroHabitacion) {
        boolean valor = false;
        for (int i = 0; i <= HABITACION_DEL_QUINTO_PISO.length - 1; i++) {
            if (HABITACION_DEL_QUINTO_PISO[i].equals(numeroHabitacion)) {
                valor = true;
                i = HABITACION_DEL_QUINTO_PISO.length;
            }
        }
        return valor;
    }

    public static void validadorCorrecto(String numeroHabitacion, int cantidadPersonas, String mensaje) {
        if (encontrarHabitacionPrimerosCuatroPisos(numeroHabitacion)) {
            if (cantidadPersonas > CANTIDAD_MAXIMA_PERSONAS_SEGUNDO_CUARTO_PISO || cantidadPersonas < CANTIDAD_MINIMA_PERSONAS_SEGUNDO_CUARTO_PISO) {
                throw new ExcepcionPersonasSegunElPiso(mensaje);
            }
        } else if (encontrarHabitacionQuintoPiso(numeroHabitacion)) {
            if (cantidadPersonas > CANTIDAD_MAXIMA_PERSONAS_QUINTO_PISO || cantidadPersonas < CANTIDAD_MINIMA_PERSONAS_QUINTO_PISO) {
                throw new ExcepcionPersonasSegunElPiso(mensaje);
            }
        }
    }

    public static void validarCorrectoIngresoHabitacion(String numeroHabitacion, String mensaje){
        if (!encontrarHabitacionPrimerosCuatroPisos(numeroHabitacion) && !encontrarHabitacionQuintoPiso(numeroHabitacion)){
            throw new ExcepcionHabitacionInvalida(mensaje);
        }
    }

    public static void validarVeracidadFecha(LocalDate fechaIngreso, LocalDate fechaSalida, String mensaje){
        if (fechaIngreso.isAfter(fechaSalida)){
            throw new ExcepcionFechaInvalida(mensaje);
        }
    }
}