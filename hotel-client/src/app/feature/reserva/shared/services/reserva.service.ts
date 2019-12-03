import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reserva } from '../model/reserva';
import { environment } from 'src/environments/environment';
import { BaseService } from 'src/app/core/services/base.service';

@Injectable()
export class ReservaService extends BaseService {

  constructor(protected http: HttpClient) {
    super(http);
  }

  public create(reserva: Reserva){
    return this.doPost<Reserva, boolean>(`${environment.endpoint}/reserva`, reserva)
  }  
  
  public listReservas() {
    return this.doGet<Reserva[]>(`${environment.endpoint}/reserva`)
  }  

  public eliminar(numeroCedula: number){
    return this.doDelete<Reserva>(`${environment.endpoint}/reserva/${numeroCedula}`)
  }
}
