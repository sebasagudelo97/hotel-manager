import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearUsuarioComponent } from './feature/usuario/components/crear-usuario/crear-usuario.component';
import { PrincipalComponent } from './feature/principal/principal.component';
import { CrearReservaComponent } from './feature/reserva/components/crear-reserva/crear-reserva.component';
import { EliminarReservaComponent } from './feature/reserva/components/eliminar-reserva/eliminar-reserva.component';
import { EliminarUsuarioComponent } from './feature/usuario/components/eliminar-usuario/eliminar-usuario.component';



const routes: Routes = [
  { path: 'principal', component: PrincipalComponent },
  { path: 'crear-usuario', component: CrearUsuarioComponent },
  { path: 'crear-reserva', component: CrearReservaComponent},
  { path: 'eliminar-usuario', component: EliminarUsuarioComponent},
  { path: 'eliminar-reserva', component: EliminarReservaComponent},
  {path: '' , redirectTo: 'principal', pathMatch: 'full' },
  { path: '**', component: PrincipalComponent } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }