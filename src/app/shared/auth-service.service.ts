import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { LoginRequestPayload } from '../login/login-request.payload';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor(private httpClient: HttpClient) { }

  apiUrl = environment.sudstvoUrl;

  isLogged(): string{
    const token = localStorage.getItem("token")
    const SToken = localStorage.getItem("SToken");

    if(SToken){
      return "sudija"
    }
    if(token){
      return "korisnik"
    }
    return "false";
  }

  login(loginRequestPayload: LoginRequestPayload): Observable <any>{
    return this.httpClient.post(this.apiUrl+"/sudstvo/login", loginRequestPayload, {responseType: 'text'})
   }

   logout(){
    localStorage.clear()
   }
}
