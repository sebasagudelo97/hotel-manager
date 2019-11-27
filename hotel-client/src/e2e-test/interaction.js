'use strict'

describe( 'HotelManager interaction', function(){
    var usuario ={
        numeroCedula : 1036960221,
        primerNombre : 'Juan',
        segundoNombre : 'Sebastian',
        primerApellido : 'Agudelo',
        segundoApellido : 'Mejia',
        numeroCeular : '3144568565'
    },

    reserva = {
        numeroCedula : 1036960221,
        numeroHabitacion : '201',
        cantidadPersonas : 2,
        fechaIngreso : '5/15/2019',
        fechaSalida : '5/20/2019'
    },
    path = require ( 'path' );

    it('Navegacion, pagina principal de la aplicacion', function(){
        browser.get('http://localhost:4200/');

        expect(browser.getTitle()).toEqual('HotelManagerApp');
    });

    it ('Enlace, crear usuario', function(){
        browser.get( 'http://localhost:4200/');
        element(by.id('crear-usuario')).click();

        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/crear-usuario');
    });

    it('Crear usuario', function(){
        browser.get('http://localhost:4200/crear-usuario');
        element(by.id('inputCedula')).sendKeys(usuario.numeroCedula);
        element(by.id('inputPrimerNombre')).sendKeys(usuario.primerNombre);
        element(by.id('inputSegundoNombre')).sendKeys(usuario.segundoNombre);
        element(by.id('inputPrimerApellido')).sendKeys(usuario.primerApellido);
        element(by.id('inputSegundoApellido')).sendKeys(usuario.segundoApellido);
        element(by.id('inputNumeroCelular')).sendKeys(usuario.numeroCeular);
        element(by.id('btnCrearUsuario')).click();
        element(by.buttonText('OK')).click();

    });

    it('Volver del form de crear usuario a la pag principal' , function(){
        browser.get( 'http://localhost:4200/crear-usuario');


        element(by.id('btnVolverPrincipal')).click();

        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/principal');

    });

    it ('Enlace, crear reserva', function(){
        browser.get( 'http://localhost:4200/');
        element(by.id('crear-reserva')).click();

        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/crear-reserva');
       

    });

    it('Crear reserva ', function(){
        browser.get('http://localhost:4200/crear-reserva');
        element(by.id('inputCedula')).sendKeys(reserva.numeroCedula);
        element(by.id('inputNumeroHabitacion')).sendKeys(reserva.numeroHabitacion);
        element(by.id('inputCantidadPersonas')).sendKeys(reserva.cantidadPersonas);
        element(by.id('inputFechaIngreso')).sendKeys(reserva.fechaIngreso);
        element(by.id('inputFechaSalida')).sendKeys(reserva.fechaSalida);
        element(by.id('btnCrearReserva')).click();
    });
});