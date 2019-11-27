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
        numeroHabitacion : '202',
        cantidadPersonas : 2,
        fechaIngreso : '5/15/2019',
        fechaSalida : '5/20/2019'
    },
    path = require ( 'path' );

    it('Navegacion, pagina principal de la aplicacion', function(){
        browser.get('http://localhost:4200/');

        expect(browser.getTitle()).toEqual('HotelManagerApp');

        browser.sleep(3000);
    });

    it ('Enlace, crear usuario', function(){
        browser.get( 'http://localhost:4200/');
        element(by.id('crear-usuario')).click();

        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/crear-usuario');
        browser.sleep(1000);
    });

    it('Crear usuario', function(){
        browser.get('http://localhost:4200/crear-usuario');
        element(by.id('inputCedula')).sendKeys(usuario.numeroCedula);
        element(by.id('inputPrimerNombre')).sendKeys(usuario.primerNombre);
        element(by.id('inputSegundoNombre')).sendKeys(usuario.segundoNombre);
        element(by.id('inputPrimerApellido')).sendKeys(usuario.primerApellido);
        element(by.id('inputSegundoApellido')).sendKeys(usuario.segundoApellido);
        element(by.id('inputNumeroCelular')).sendKeys(usuario.numeroCeular);
        browser.sleep(1000);
        element(by.id('btnCrearUsuario')).click();
        element(by.buttonText('OK')).click();

    });

    it('Volver del form de crear usuario a la pag principal' , function(){
        browser.get( 'http://localhost:4200/crear-usuario');
        browser.sleep(1000);
        element(by.id('btnVolverPrincipal')).click();
        browser.sleep(1000);
        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/principal');
        browser.sleep(1000);

    });

    it ('Enlace, crear reserva', function(){
        browser.get( 'http://localhost:4200/');
        browser.sleep(1000);
        element(by.id('crear-reserva')).click();
        browser.sleep(1000);
        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/crear-reserva');
        browser.sleep(1000);

    });

    it('Crear reserva ', function(){
        browser.get('http://localhost:4200/crear-reserva');
        element(by.id('inputCedula')).sendKeys(reserva.numeroCedula);
        element(by.id('inputNumeroHabitacion')).sendKeys(reserva.numeroHabitacion);
        element(by.id('inputCantidadPersonas')).sendKeys(reserva.cantidadPersonas);
        element(by.id('inputFechaIngreso')).sendKeys(reserva.fechaIngreso);
        element(by.id('inputFechaSalida')).sendKeys(reserva.fechaSalida);
        browser.sleep(1000);
        element(by.id('btnCrearReserva')).click();
        element(by.buttonText('OK')).click();
    });

    it('Volver del form de crear reserva a la pag principal' , function(){
        browser.get( 'http://localhost:4200/crear-reserva');
        browser.sleep(1000);
        element(by.id('btnVolverPrincipal')).click();
        browser.sleep(1000);
        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/principal');
        browser.sleep(1000);

    });

    it ('Enlace, reserva', function(){
        browser.get( 'http://localhost:4200/');
        browser.sleep(1000);
        element(by.id('eliminar-reserva')).click();
        browser.sleep(1000);
        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/eliminar-reserva');        
        browser.sleep(1000);
    });

    
    it('Volver del form de eliminar reserva a la pag principal' , function(){
        browser.get( 'http://localhost:4200/eliminar-reserva');


        element(by.id('btnVolverPrincipal')).click();

        expect(browser.getCurrentUrl()).toBe('http://localhost:4200/principal');

    });
});