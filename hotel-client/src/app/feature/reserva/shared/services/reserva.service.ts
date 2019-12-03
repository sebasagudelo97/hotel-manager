import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reserva } from '../model/reserva';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable()
export class ReservaService {

  constructor(private http: HttpClient) {}

  create(reserva: Reserva): Observable<Reserva>{
    return this.http.post<Reserva>(`${environment.endpoint}/reserva`, reserva)
  }  
  
  listReservas(): Observable<Reserva[]> {
    return this.http.get(`${environment.endpoint}/reserva`).pipe(
      map(response => response as Reserva[])
    );
  }  

  eliminar(numeroCedula: number):Observable<Reserva>{
    return this.http.delete<Reserva>(`${environment.endpoint}/reserva/${numeroCedula}`)
  }
}
