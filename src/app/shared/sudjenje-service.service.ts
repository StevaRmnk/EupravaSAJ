import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import jwt_decode from 'jwt-decode';
import { environment } from 'src/environments/environment';
import { SudjenjePayload } from '../optuznice/sudjenje.payload';
import { Observable } from 'rxjs';
import { Presuda } from '../prikaz-sudjenja/presuda.payload';
@Injectable({
  providedIn: 'root'
})
export class SudjenjeServiceService {
  apiUrl = environment.sudstvoUrl;

  constructor(private httpClient: HttpClient) { }

  zakaziSudjenje(sudjenjePayload: SudjenjePayload): Observable <any>{
    return this.httpClient.post(this.apiUrl+"/sudstvo/sudjenje/", sudjenjePayload, {responseType: 'text'})
   }

   napraviPresudu(presudaPayload: Presuda): Observable <any>{
    return this.httpClient.post(this.apiUrl+"/sudstvo/presude/", presudaPayload, {responseType: 'text'})
   }

   getSudjenja(){
    const jwtToken = localStorage.getItem('SToken'); 
    const decodedPToken = jwt_decode(jwtToken!) as { [key: string]: any };
    
    const headers = new HttpHeaders().set('Authorization', `Bearer ${jwtToken}`);
    return this.httpClient.get<any>(`${this.apiUrl}/sudstvo/sudjenje/` + decodedPToken['sub'],{
      headers,
    });
   }

   getSvaSudjenja(email: String){
    return this.httpClient.get<any>(`${this.apiUrl}/sudstvo/sudjenje/osumnjiceni/`+email);
   }

   getPresude(){
    const jwtToken = localStorage.getItem('SToken'); 
    const decodedPToken = jwt_decode(jwtToken!) as { [key: string]: any };
    
    const headers = new HttpHeaders().set('Authorization', `Bearer ${jwtToken}`);
    return this.httpClient.get<any>(`${this.apiUrl}/sudstvo/presude/sudija/` + decodedPToken['sub'],{
      headers,
    });
   }
}
