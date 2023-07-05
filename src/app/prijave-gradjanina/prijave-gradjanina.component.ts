import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { OptuzniceServiceService } from '../shared/optuznice-service.service';
import { ZapisnikServiceService } from '../shared/zapisnik-service.service';
import { PrijavaPayload } from './prijava.payload';
import jwt_decode from 'jwt-decode';
import { PrijaveServiceService } from '../shared/prijave-service.service';

@Component({
  selector: 'app-prijave-gradjanina',
  templateUrl: './prijave-gradjanina.component.html',
  styleUrls: ['./prijave-gradjanina.component.css']
})
export class PrijaveGradjaninaComponent {

  prijavaForm: FormGroup = new FormGroup({});
  prijavaPayload: PrijavaPayload
  showAlert: boolean = false;
  showAlertSuccess: boolean = false;
  constructor(private httpClient: HttpClient, private prijavaService: PrijaveServiceService ) { 
    this.prijavaPayload = {
      opisPrekrsaja: '',
      jmbgOsumnjicenog: '',
      datumPodizanjaPrijave: new Date(),
      anonimna: false,
      jmbgGradjanina:'',
     
    }
  }

  ngOnInit(): void {
    this.prijavaForm = new FormGroup({
      opisPrekrsaja: new FormControl(''),
      jmbgOsumnjicenog: new FormControl(''),
      datumPodizanjaPrijave: new FormControl(''),
      anonimna: new FormControl(''),
      jmbgGradjanina: new FormControl('')
  
    });
  }

  napraviPrijavu(){
    const Token = localStorage.getItem("token");
    const decodedPToken = jwt_decode(Token!) as { [key: string]: any };
    if(this.prijavaForm.get('anonimna')?.value == false){
      this.prijavaPayload.jmbgGradjanina = decodedPToken['email'];
      this.prijavaPayload.anonimna =  false;
    }
    if(this.prijavaForm.get('anonimna')?.value == true){
      this.prijavaPayload.anonimna =  true;
      this.prijavaPayload.jmbgGradjanina = "";
    }
    
    
    this.prijavaPayload.jmbgOsumnjicenog = this.prijavaForm.get('jmbgOsumnjicenog')?.value;
    const currentDate = new Date();
const localDateTime = currentDate.toLocaleString('en-US', {
  timeZone: 'Europe/Belgrade',
});
    this.prijavaPayload.datumPodizanjaPrijave = new Date(localDateTime);
    this.prijavaPayload.datumPodizanjaPrijave = new Date(localDateTime);
    this.prijavaPayload.opisPrekrsaja = this.prijavaForm.get('opisPrekrsaja')?.value;   
    this.prijavaService.napraviPrijavu(this.prijavaPayload)
    .subscribe(response => {
     
      this.showAlertSuccess = true;
    },
    (error: HttpErrorResponse) => {
      if (error) {
        this.showAlert = true;
     
      } 
       
       }
      );
  }

  closeAlert() {
    this.showAlert = false;
  }
  closeAlertSuccess() {
    this.showAlertSuccess = false;
  }
}
