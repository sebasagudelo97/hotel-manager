import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Usuario } from '../model/usuario';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { BaseService } from 'src/app/core/services/base.service';

@Injectable()
export class UsuarioService extends BaseService {   
  
  constructor(protected http: HttpClient) {
    super(http);
   }

  public create(usuario: Usuario) {
    return this.doPost<Usuario, boolean>(`${environment.endpoint}/usuario`, usuario)    
  }

  public listUsuarios(){
    return this.doGet<Usuario[]>(`${environment.endpoint}/usuario`)
  } 

  public eliminar(cedulaCiudadania: number){
    return this.doDelete<Usuario>(`${environment.endpoint}/usuario/${cedulaCiudadania}`)
  }
}
 