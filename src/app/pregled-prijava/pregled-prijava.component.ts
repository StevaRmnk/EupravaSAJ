import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { PrijaveServiceService } from '../shared/prijave-service.service';
import { PrijavaGradjanina } from './PrijavaGradjanina';
import jwt_decode from 'jwt-decode';
import { FormControl, FormGroup } from '@angular/forms';
import { OptuznicaPayload } from '../pregled-zapisnika/Optuznica.payload';
import { OptuzniceServiceService } from '../shared/optuznice-service.service';
import { Optuznica } from '../optuznice/Optuznica';

@Component({
  selector: 'app-pregled-prijava',
  templateUrl: './pregled-prijava.component.html',
  styleUrls: ['./pregled-prijava.component.css']
})
export class PregledPrijavaComponent {
  prijaveGradjanina!: PrijavaGradjanina[]
  optuznicaForm: FormGroup = new FormGroup({});
  optuznicaPayload!: OptuznicaPayload;
  showAlert: boolean = false;
  showAlertSuccess: boolean = false;
  optuznice!: Optuznica[]

  constructor(private httpClient: HttpClient, private prijavaService: PrijaveServiceService,private optuzniceService: OptuzniceServiceService ) { 
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
    this.optuzniceTuzioca()
   this.prijaveGradjana()
   this.optuznicaForm = new FormGroup({
    datumPodizanjaOptuznice: new FormControl(''),
    brojLicenceTuzioca: new FormControl(''),
    jmbgOptuzenog: new FormControl(''),
    statusOptuznice: new FormControl(''),
    idZapisnika: new FormControl(''),
    idPrijaveGradjanina: new FormControl('')
  

  });
  }
  
  // optuzniceTuzioca(){
  //   this.optuzniceService.sveOptuznice().subscribe(
  //     response => {
  //       this.optuznice = response
        
  //     })
  // }

  prijaveGradjana(){
    this.prijavaService.getPrijave().subscribe(
      response => {
        this.prijaveGradjanina = response.filter((prijavaGradjanina: PrijavaGradjanina) => {
          return !this.optuznice.some(optuznica => optuznica.idPrijaveGradjanina === prijavaGradjanina.idPrijave);
        });
        
      })
  }
  optuzniceTuzioca(){
    this.optuzniceService.sveOptuznice().subscribe(
      response => {
        this.optuznice = response
        
      })
  }

  napraviOptuznicu(idPrijave: number, jmbgOsumnjicenog: String,){
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
    this.optuznicaPayload.idPrijaveGradjanina = idPrijave
    

    this.optuzniceService.napraviOptuznicu(this.optuznicaPayload)
    .subscribe(response => {
     
      this.showAlertSuccess = true;
      // this.optuzniceTuzioca();
      // this.zapisniciPolicajca();

      
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
