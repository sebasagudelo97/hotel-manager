import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reserva } from '../model/reserva';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class ReservaService {

  private urlEndPoint: string='http://localhost:8080'
  constructor(private http: HttpClient) {}

  create(reserva: Reserva): Observable<Reserva>{
    return this.http.post<Reserva>(this.urlEndPoint + '/reserva', reserva)
  }  
  
  listReservas(): Observable<Reserva[]> {
    return this.http.get(this.urlEndPoint + '/reserva').pipe(
      map(response => response as Reserva[])
    );
  }  

  eliminar(numeroCedula: number):Observable<Reserva>{
    return this.http.delete<Reserva>(this.urlEndPoint + '/reserva' + `/${numeroCedula}`)
  }
}
