import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../shared/model/usuario';
import { UsuarioService } from '../../shared/services/usuario.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-crear-usuario',
  templateUrl: './crear-usuario.component.html',
  styleUrls: ['./crear-usuario.component.css']
})
export class CrearUsuarioComponent implements OnInit {

  private usuario:Usuario = new Usuario;
  form:NgForm; 

  constructor(private usuarioService: UsuarioService, 
    private router: Router,) { }

  ngOnInit() {    
  }

  OnSubmit(form:NgForm){
    console.log(this.usuario)
    this.usuarioService.create(this.usuario)
    .subscribe(usuario => {
      this.router.navigate(['/principal'])
      Swal.fire({
        position:'center',
        icon:"success",
        text:`El usuario ${this.usuario.primerNombre} ${this.usuario.primerApellido} ha sido creado con exito`,
        title:'Creación exitosa!',
        timer:8000,
        showConfirmButton:true
      })
    })
  }
}
