import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { OptuzniceComponent } from './optuznice/optuznice.component';
import { PrikazSudjenjaComponent } from './prikaz-sudjenja/prikaz-sudjenja.component';
import { PrikazPresudaComponent } from './prikaz-presuda/prikaz-presuda.component';
import { PoziviComponent } from './pozivi/pozivi.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    HomeComponent,
    LoginComponent,
    OptuzniceComponent,
    PrikazSudjenjaComponent,
    PrikazPresudaComponent,
    PoziviComponent
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
