import { Component, OnInit } from '@angular/core';
import { Reserva } from '../../shared/model/reserva';
import { ReservaService } from '../../shared/services/reserva.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-eliminar-reserva',
  templateUrl: './eliminar-reserva.component.html',
  styleUrls: ['./eliminar-reserva.component.css']
})
export class EliminarReservaComponent implements OnInit {

  reserva: Reserva[];

  constructor(private reservaService: ReservaService,
    private router: Router,) { }

  ngOnInit() {
    this.reservaService.listReservas().subscribe(
      reservas => this.reserva = reservas
    );
  }

  eliminar(reserva:Reserva):void{
    Swal.fire({
      title:'¿Estas seguro?',
      text:'Estas seguro que quieres eliminar esta reserva?',
      icon:'warning',
      showCancelButton:true,
      confirmButtonText:'Si, eliminar',
      cancelButtonText: 'Error, no eliminar'
    }).then((result) => {
      if(result.value){
        this.reservaService.eliminar(reserva.numeroCedula).subscribe(
          
          response => {
            this.router.navigate(['/principal'])
            this.reserva = this.reserva.filter(res => res ! == reserva)
            Swal.fire(
              'Eliminado!',
              `La reserva del usuario con cedula ${reserva.numeroCedula} ha sido eliminada`,
               'success'
            )
          }
        )        
      }else if(result.dismiss==Swal.DismissReason.cancel){
        Swal.fire(
          'Cancelada',
          'La eliminacion de la reserva ha sido cancelada',
          'error'
        )
      }
    })
  }
}
