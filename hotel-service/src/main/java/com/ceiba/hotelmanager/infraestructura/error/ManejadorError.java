package com.ceiba.hotelmanager.infraestructura.error;


import com.ceiba.hotelmanager.dominio.excepcion.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.ConcurrentHashMap;


@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(ManejadorError.class);
    private static final String OCURRIO_UN_ERROR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrio un error, porfavor contactar al administrador";
    private static final ConcurrentHashMap<String, Integer> CODIGO_ESTADO = new ConcurrentHashMap<>();

    public ManejadorError(){
        CODIGO_ESTADO.put(ExcepcionCaracteres.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGO_ESTADO.put(ExcepcionObligatorio.class.getSimpleName(),HttpStatus.BAD_REQUEST.value());
        CODIGO_ESTADO.put(ExcepcionDuplicidad.class.getSimpleName(),HttpStatus.BAD_REQUEST.value());
        CODIGO_ESTADO.put(ExcepcionPersonasSegunElPiso.class.getSimpleName(),HttpStatus.BAD_REQUEST.value());
        CODIGO_ESTADO.put(ExcepcionFechaInvalida.class.getSimpleName(),HttpStatus.BAD_REQUEST.value());
        CODIGO_ESTADO.put(ExcepcionHabitacionInvalida.class.getSimpleName(),HttpStatus.BAD_REQUEST.value());
        CODIGO_ESTADO.put(ExcepcionEstadoHabitacion.class.getSimpleName(),HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllException(Exception exception){
        ResponseEntity<Error> resultado;

        String excepcionNombre=exception.getClass().getSimpleName();
        String mensaje=exception.getMessage();
        Integer codigo=CODIGO_ESTADO.get(excepcionNombre);

        if (codigo != null){
            Error error = new Error(excepcionNombre,mensaje);
            resultado=new ResponseEntity<>(error,HttpStatus.valueOf(codigo));
        }else {
            LOGGER_ERROR.error(excepcionNombre,exception);
            Error error = new Error(excepcionNombre, OCURRIO_UN_ERROR_CONTACTAR_AL_ADMINISTRADOR);
            resultado=new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resultado;
}

}
