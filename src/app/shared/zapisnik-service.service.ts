import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ZapisnikPayload } from '../zapisnik/zapisnik.payload';
import { Observable } from 'rxjs';
import jwt_decode from 'jwt-decode';
import { PregledZapisnikaComponent } from '../pregled-zapisnika/pregled-zapisnika.component';

@Injectable({
  providedIn: 'root'
})
export class ZapisnikServiceService {

  apiUrl = environment.policijaUrl;
  
  constructor(private httpClient: HttpClient) { }

  napraviZapisnik(zapisnikPayload: ZapisnikPayload): Observable <any>{
    const jwtToken = localStorage.getItem('PToken'); 
    const headers = new HttpHeaders().set('Authorization', `Bearer ${jwtToken}`);
  
    return this.httpClient.post(this.apiUrl+"/policija/zapisnici/", zapisnikPayload, {
      headers,
      responseType: 'text'
    });
   }

   zapisniciPolicajca(brojZnacke: String){
    return this.httpClient.get<any>(`${this.apiUrl}/policija/zapisnici/` + brojZnacke)
   }
   
   potvrda(){
    const Token = localStorage.getItem("token");
    const decodedPToken = jwt_decode(Token!) as { [key: string]: any };
    return this.httpClient.get<any>("http://localhost:8083/sudstvo/potvrda/" + decodedPToken['email'])
   }

 
}
