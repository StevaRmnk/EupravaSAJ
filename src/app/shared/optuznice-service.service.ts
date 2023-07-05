import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import jwt_decode from 'jwt-decode';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class OptuzniceServiceService {

  apiUrl = environment.sudstvoUrl;

  constructor(private httpClient: HttpClient) { }

  sveOptuznice(){
    const jwtToken = localStorage.getItem('SToken'); 
    const headers = new HttpHeaders().set('Authorization', `Bearer ${jwtToken}`);
    return this.httpClient.get<any>(`${this.apiUrl}/sudstvo/optuznice/`,{
      headers,
    });
   }
}
