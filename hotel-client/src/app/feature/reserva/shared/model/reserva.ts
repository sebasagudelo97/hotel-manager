import { Usuario } from 'src/app/feature/usuario/shared/model/usuario';
import { Factura } from 'src/app/feature/factura/shared/model/factura';

export class Reserva{
    idReserva ?:number;
    numeroCedula:number;
    numeroHabitacion:string;
    cantidadPersonas:number;
    fechaIngreso:Date;
    fechaSalida:Date;
}