import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './MyComponents/dashboard/dashboard.component';
import { LoginComponent } from './MyComponents/login/login.component';
import { RegistrationComponent } from './MyComponents/registration/registration.component';

const routes: Routes = [
  {
    path:'', component:LoginComponent,
  },
  {
    path:'loginSuccess', component:DashboardComponent
  },
  {
    path:'registration', component: RegistrationComponent
  },
  {
    path:'login', component:LoginComponent
  },
  {
    path:'home', component:LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
