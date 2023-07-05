import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ZapisnikComponent } from './zapisnik/zapisnik.component';
import { PregledZapisnikaComponent } from './pregled-zapisnika/pregled-zapisnika.component';
import { PotvrdaKaznjavanjeComponent } from './potvrda-kaznjavanje/potvrda-kaznjavanje.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent,
    LoginComponent,
    ZapisnikComponent,
    PregledZapisnikaComponent,
    PotvrdaKaznjavanjeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
