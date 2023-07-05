import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PrijavaPayload } from '../prijave-gradjanina/prijava.payload';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PrijaveServiceService {

  apiUrl = environment.tuzilastvoUrl;

  constructor(private httpClient: HttpClient) { }

  napraviPrijavu(prijavaPayload: PrijavaPayload): Observable <any>{
    const jwtToken = localStorage.getItem('token'); 
    const headers = new HttpHeaders().set('Authorization', `Bearer ${jwtToken}`);
  
    return this.httpClient.post(this.apiUrl+"/tuzilastvo/prijaveGradjanina/", prijavaPayload, {
      headers,
      responseType: 'text'
    });
   }

   getPrijave(){
    return this.httpClient.get<any>(`${this.apiUrl}/tuzilastvo/prijaveGradjanina/`)
   }
}
