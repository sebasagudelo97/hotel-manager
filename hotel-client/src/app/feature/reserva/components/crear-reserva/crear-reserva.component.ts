import { Component, OnInit } from '@angular/core';
import { Reserva } from '../../shared/model/reserva';
import { NgForm } from '@angular/forms';
import { ReservaService } from '../../shared/services/reserva.service';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/feature/usuario/shared/model/usuario';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-crear-reserva',
  templateUrl: './crear-reserva.component.html',
  styleUrls: ['./crear-reserva.component.css']
})
export class CrearReservaComponent implements OnInit {

  public reserva:Reserva;
  form:NgForm
  
  constructor(private reservaService: ReservaService,
    private router: Router,) { }

  ngOnInit() {
    this.reserva=new Reserva();
    
  }
  OnSubmit(form:NgForm){
    console.log("Este es la reserva" + this.reserva.numeroHabitacion + this.reserva.numeroCedula +
    this.reserva.cantidadPersonas + this.reserva.fechaIngreso + this.reserva.fechaSalida)
    this.reservaService.create(this.reserva)
    .subscribe(reserva => {
      this.router.navigate(['/principal'])
      Swal.fire({
        position:'center',
        icon:'success',
        title:'Creación exitosa!',
        text:`La reserva se ha creado con exito n/
              Fecha Ingreso: ${this.reserva.fechaIngreso} n/
              Fecha Salida:  ${this.reserva.fechaSalida}`,
        showConfirmButton:true
      })
    })
  }
}
