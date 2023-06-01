import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { GetZapisnikPayload } from './getZapisnik.payload';
import jwt_decode from 'jwt-decode';
import { ZapisnikServiceService } from '../shared/zapisnik-service.service';
import { FormControl, FormGroup } from '@angular/forms';
import { OptuznicaPayload } from './Optuznica.payload';
import { OptuzniceServiceService } from '../shared/optuznice-service.service';
import { Optuznica } from '../optuznice/Optuznica';
import { OptuzniceComponent } from '../optuznice/optuznice.component';

@Component({
  selector: 'app-pregled-zapisnika',
  templateUrl: './pregled-zapisnika.component.html',
  styleUrls: ['./pregled-zapisnika.component.css']
})
export class PregledZapisnikaComponent {

  zapisnici!: GetZapisnikPayload[]
  brojLicence!: String;
  optuznicaForm: FormGroup = new FormGroup({});
  optuznicaPayload!: OptuznicaPayload;
  showAlert: boolean = false;
  showAlertSuccess: boolean = false;
  optuznice!: Optuznica[]


  constructor(private httpClient: HttpClient, private zapisnikService: ZapisnikServiceService, private optuzniceService: OptuzniceServiceService ) { 
    this.optuznicaPayload = {
      datumPodizanjaOptuznice:new Date(),
      brojLicenceTuzioca: '',
      jmbgOptuzenog: '',
      statusOptuznice: '',
      idZapisnika:0,
      idPrijaveGradjanina: 0
     
    }
  }

  ngOnInit(): void {
    const TToken = localStorage.getItem("TToken");
    const decodedPToken = jwt_decode(TToken!) as { [key: string]: any };
    this.brojLicence =  decodedPToken['sub'];
    this.optuzniceTuzioca()
    this.zapisniciPolicajca();
    this.optuznicaForm = new FormGroup({
      datumPodizanjaOptuznice: new FormControl(''),
      brojLicenceTuzioca: new FormControl(''),
      jmbgOptuzenog: new FormControl(''),
      statusOptuznice: new FormControl(''),
      idZapisnika: new FormControl(''),
      idPrijaveGradjanina: new FormControl('')
    

    });
    
  }

  zapisniciPolicajca(){
    this.zapisnikService.zapisniciPolicajca().subscribe(
      response => {
        this.zapisnici = response.filter((zapisnik: GetZapisnikPayload) => {
          return !this.optuznice.some(optuznica => optuznica.idZapisnika === zapisnik.idZapisnika);
        });
        
      })
  }

  optuzniceTuzioca(){
    this.optuzniceService.sveOptuznice().subscribe(
      response => {
        this.optuznice = response
        
      })
  }
  napraviOptuznicu(idZapisnika: number, jmbgOsumnjicenog: String,){
    const TToken = localStorage.getItem("TToken");
    const decodedPToken = jwt_decode(TToken!) as { [key: string]: any };
    this.optuznicaPayload.brojLicenceTuzioca =  decodedPToken['sub'];
    this.optuznicaPayload.jmbgOptuzenog = jmbgOsumnjicenog;
    const currentDate = new Date();
const localDateTime = currentDate.toLocaleString('en-US', {
  timeZone: 'Europe/Belgrade',
});
this.optuznicaPayload.datumPodizanjaOptuznice = new Date(localDateTime);
    this.optuznicaPayload.statusOptuznice = "NACEKANJU"
    this.optuznicaPayload.idZapisnika = idZapisnika
    

    this.optuzniceService.napraviOptuznicu(this.optuznicaPayload)
    .subscribe(response => {
     
      this.showAlertSuccess = true;
      this.optuzniceTuzioca();
      this.zapisniciPolicajca();

      
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
