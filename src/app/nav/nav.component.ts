import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import jwt_decode from 'jwt-decode';
import { environment } from 'src/environments/environment';
import { AuthServiceService } from '../shared/auth-service.service';
import { Router } from '@angular/router';
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
  brojLicence!:String;
  apiUrl = environment.tuzilastvoUrl;
  authUrl= environment.authUrl;

  constructor(private httpClient: HttpClient, private authService: AuthServiceService, private router: Router, private home: HomeComponent) { }

  ngOnInit(): void {
    this.tokenCheck()
  }

  tokenCheck(){
    this.isLogged=this.authService.isLogged();
    switch ( this.isLogged ) {
      case "tuzilac":
        const TToken = localStorage.getItem("TToken");
        const decodedPToken = jwt_decode(TToken!) as { [key: string]: any };
        this.name = decodedPToken['ime'];
        this.surname = decodedPToken['prezime'];
        this.brojLicence = decodedPToken['sub'];
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
