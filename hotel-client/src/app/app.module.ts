import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CrearUsuarioComponent } from './feature/usuario/components/crear-usuario/crear-usuario.component';
import { UsuarioService } from './feature/usuario/shared/services/usuario.service';
import { PrincipalComponent } from './feature/principal/principal.component';
import { HttpClientModule } from '@angular/common/http';
import { CrearReservaComponent } from './feature/reserva/components/crear-reserva/crear-reserva.component';
import { ReservaService } from './feature/reserva/shared/services/reserva.service';
import { EliminarReservaComponent } from './feature/reserva/components/eliminar-reserva/eliminar-reserva.component';
import { EliminarUsuarioComponent } from './feature/usuario/components/eliminar-usuario/eliminar-usuario.component';


@NgModule({
  declarations: [
    AppComponent,
    CrearUsuarioComponent,
    PrincipalComponent,
    CrearReservaComponent,
    EliminarReservaComponent,
    EliminarUsuarioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    HttpClientModule
  ],
  providers: [UsuarioService, ReservaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
