import { Component } from '@angular/core';
import { AuthService } from '../shared/auth.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import jwt_decode from 'jwt-decode';
import { Route, Router } from '@angular/router';
import { HomeComponent } from '../home/home.component';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {

  isLogged!: string;
  picture!: String;
  name!:String;
  surname!: String;
  brojZnacke!:String;
  apiUrl = environment.policijaUrl;
  authUrl= environment.authUrl;

  constructor(private httpClient: HttpClient, private authService: AuthService, private router: Router, private home: HomeComponent) { }

  ngOnInit(): void {
    this.tokenCheck()
  }

  tokenCheck(){
    this.isLogged=this.authService.isLogged();
    switch ( this.isLogged ) {
      case "policajac":
        const PToken = localStorage.getItem("PToken");
        const decodedPToken = jwt_decode(PToken!) as { [key: string]: any };
        this.name = decodedPToken['ime'];
        this.surname = decodedPToken['prezime'];
        this.brojZnacke = decodedPToken['sub'];
          break;
      case "korisnik":
        const token = localStorage.getItem("token");
        const decodedToken = jwt_decode(token!) as { [key: string]: any };
        this.picture=decodedToken['picture']
        this.name=decodedToken['name']
          break;
      case "false":
         
          break;
   }
  }

  logout(){
    this.authService.logout()
    this.tokenCheck();
    this.home.checkToken()

  }
  
  
}
