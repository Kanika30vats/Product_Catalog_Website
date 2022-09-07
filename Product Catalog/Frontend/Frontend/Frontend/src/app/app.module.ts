import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './MyComponents/login/login.component';
import { RegistrationComponent } from './MyComponents/registration/registration.component';
import {  MatDialogModule} from '@angular/material/dialog';
import { DashboardComponent } from './MyComponents/dashboard/dashboard.component';
import { DetailsComponent } from './MyComponents/details/details.component';
import {MatButtonModule} from '@angular/material/button';
import { NavbarComponent } from './MyComponents/navbar/navbar.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import { BackButtonDisableModule } from 'angular-disable-browser-back-button';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
   DashboardComponent,
   DetailsComponent,
   NavbarComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BackButtonDisableModule.forRoot(),
    FormsModule,
    HttpClientModule,
    MatDialogModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule
    
    
    
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents:[]
})
export class AppModule { }
