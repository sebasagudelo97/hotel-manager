import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Usuario } from '../model/usuario';
import { map } from 'rxjs/operators';

@Injectable()
export class UsuarioService {

  // hacer uso del environment
  private urlEndPoint: string = 'http://localhost:8080';  
  
  constructor(private http: HttpClient) { }

  create(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`${this.urlEndPoint}/usuario`, usuario)    
  }

  listUsuarios(): Observable<Usuario[]> {
    return this.http.get(this.urlEndPoint + '/usuario').pipe(
      map(response => response as Usuario[])
    );
  } 

  eliminar(cedulaCiudadania: number):Observable<Usuario>{
    return this.http.delete<Usuario>(this.urlEndPoint + '/usuario' + `/${cedulaCiudadania}`)
  }
}
 