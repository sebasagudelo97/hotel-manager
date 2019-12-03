import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Usuario } from '../model/usuario';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable()
export class UsuarioService {

  // hacer uso del environment
   
  
  constructor(private http: HttpClient) { }

  create(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`${environment.endpoint}/usuario`, usuario)    
  }

  listUsuarios(): Observable<Usuario[]> {
    return this.http.get(`${environment.endpoint}/usuario`).pipe(
      map(response => response as Usuario[])
    );
  } 

  eliminar(cedulaCiudadania: number):Observable<Usuario>{
    return this.http.delete<Usuario>(`${environment.endpoint}/usuario/${cedulaCiudadania}`)
  }
}
 