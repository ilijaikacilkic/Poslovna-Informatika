import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { BankaComponent } from './components/banka/banka.component';
import { LoginComponent } from './components/login/login.component';
import { RegistracijaComponent } from './components/registracija/registracija.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'banke', component: BankaComponent },
  {path: 'registracija', component: RegistracijaComponent} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
