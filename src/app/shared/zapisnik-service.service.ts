import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ZapisnikServiceService {

  apiUrl = environment.tuzilastvoUrl;

  constructor(private httpClient: HttpClient) { }

  zapisniciPolicajca(){
    const jwtToken = localStorage.getItem('TToken'); 
    const headers = new HttpHeaders().set('Authorization', `Bearer ${jwtToken}`);
    return this.httpClient.get<any>(`${this.apiUrl}/tuzilastvo/zapisnici/`,{
      headers,
    });
   }
  
}
