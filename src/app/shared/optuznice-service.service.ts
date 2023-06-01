import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { OptuznicaPayload } from '../pregled-zapisnika/Optuznica.payload';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OptuzniceServiceService {

  apiUrl = environment.tuzilastvoUrl;

  constructor(private httpClient: HttpClient) { }

  optuzniceTuzioca(brojLicence: String){
    // const jwtToken = localStorage.getItem('TToken'); 
    // const headers = new HttpHeaders().set('Authorization', `Bearer ${jwtToken}`);
  
      return this.httpClient.get<any>(`${this.apiUrl}/tuzilastvo/optuznice/tuzilac/` + brojLicence)
     
   }

   sveOptuznice(){
    // const jwtToken = localStorage.getItem('TToken'); 
    // const headers = new HttpHeaders().set('Authorization', `Bearer ${jwtToken}`);
  
      return this.httpClient.get<any>(`${this.apiUrl}/tuzilastvo/optuznice/`)
     
   }

   napraviOptuznicu(optuznicaPayload: OptuznicaPayload): Observable <any>{
    const jwtToken = localStorage.getItem('TToken'); 
    const headers = new HttpHeaders().set('Authorization', `Bearer ${jwtToken}`);
  
    return this.httpClient.post(this.apiUrl+"/tuzilastvo/optuznice/", optuznicaPayload, {
      headers,
      responseType: 'text'
    });
   }
}
