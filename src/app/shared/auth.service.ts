import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { LoginRequestPayload } from '../login/login-request.payload';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  apiUrl = environment.policijaUrl;

  isLogged(): string{
    const token = localStorage.getItem("token")
    const PToken = localStorage.getItem("PToken");

    if(PToken){
      return "policajac"
    }
    if(token){
      return "korisnik"
    }
    return "false";
  }

  login(loginRequestPayload: LoginRequestPayload): Observable <any>{
    return this.httpClient.post(this.apiUrl+"/policija/login", loginRequestPayload, {responseType: 'text'})
   }

   logout(){
    localStorage.clear()
   }

}
