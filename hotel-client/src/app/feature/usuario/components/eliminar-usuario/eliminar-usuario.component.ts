import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../shared/model/usuario';
import { UsuarioService } from '../../shared/services/usuario.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-eliminar-usuario',
  templateUrl: './eliminar-usuario.component.html',
  styleUrls: ['./eliminar-usuario.component.css']
})
export class EliminarUsuarioComponent implements OnInit {

  usuario: Usuario[];

  constructor(private usuarioService: UsuarioService,
    private router: Router,) { }

  ngOnInit() {
    this.usuarioService.listUsuarios().subscribe(
      usuarios => this.usuario = usuarios
    );
  }

  eliminar(usuario: Usuario): void
{
  Swal.fire({
    title:'¿Estas Seguro?',
    text: 'Es seguro que deseas eliminar este usuario?',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText: 'Si, eliminar ',
    cancelButtonText: 'Error, no eliminar'
  }).then((result) => {
    if(result.value){
      this.usuarioService.eliminar(usuario.cedulaCiudadania).subscribe(
        response => {
          this.router.navigate(['/principal'])
          this.usuario = this.usuario.filter(us => us !== usuario)
          Swal.fire(
            'Eliminado!',
            `El usuario ${usuario.primerNombre} ${usuario.primerApellido} ha sido eliminado con exito`,
            'success'
          )
        }
      )
    }else if(result.dismiss==Swal.DismissReason.cancel){
      Swal.fire(
        'Cancelada',
        'La eliminacion del usuario ha sido cancelada',
        'error'
      )
    }
  })
}
}
