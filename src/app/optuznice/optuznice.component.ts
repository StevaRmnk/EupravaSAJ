import { Component } from '@angular/core';
import { OptuznicaPayload } from './getOptuznica.payload';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { OptuzniceServiceService } from '../shared/optuznice-service.service';
import jwt_decode from 'jwt-decode';
import { environment } from 'src/environments/environment';
import { FormControl, FormGroup } from '@angular/forms';
import { SudjenjePayload } from './sudjenje.payload';
import * as bootstrap from 'bootstrap'
import { SudjenjeServiceService } from '../shared/sudjenje-service.service';
import { GetSudjenjePayload } from '../prikaz-sudjenja/getSudjenje.payload';

@Component({
  selector: 'app-optuznice',
  templateUrl: './optuznice.component.html',
  styleUrls: ['./optuznice.component.css']
})
export class OptuzniceComponent {

  optuznice!: OptuznicaPayload[]
  brojLicence!: String;
  jmbgOptuzenog!: String;
  sudjenja!: GetSudjenjePayload[]

  sudjenjeForm: FormGroup = new FormGroup({});
  sudjenjePayload!: SudjenjePayload;
  showAlert: boolean = false;
  showAlertSuccess: boolean = false;
  // optuznice!: Optuznica[]


  constructor(private httpClient: HttpClient,private optuzniceService: OptuzniceServiceService, private sudjenjeService: SudjenjeServiceService ) { 
    this.sudjenjePayload = {
      brojSale: 0,
      jmbgOptuzenog: '',
      vremeSudjenja: new Date(),
      brojSudijskeLicence: '',
      idOptuznice:0

     
    }
  }

  ngOnInit(): void {
    const SToken = localStorage.getItem("SToken");
    const decodedPToken = jwt_decode(SToken!) as { [key: string]: any };
    this.brojLicence =  decodedPToken['sub'];
    this.getSudjenja()
    this.sveOptuznice();
    this.sudjenjeForm = new FormGroup({
      brojSale: new FormControl(''),
      jmbgOptuzenog: new FormControl(''),
      vremeSudjenja: new FormControl(''),
      brojSudijskeLicence: new FormControl(''),
      idOptuznice: new FormControl('')
     
  
    });
    
  }

  getSudjenja(){
    this.sudjenjeService.getSudjenja().subscribe(
      response => {
        this.sudjenja = response
        
      })
  }

  sveOptuznice(){
    this.optuzniceService.sveOptuznice().subscribe(
      response => {
        this.optuznice = response.filter((optuznica: OptuznicaPayload) => {
          return !this.sudjenja.some(sudjenje => sudjenje.idOptuznice === optuznica.idOptuznice);
        });
        
        
      })
  }


  zakazivanje(jmbgOptuzenog: String, idOptuznice: number){
    this.jmbgOptuzenog=jmbgOptuzenog;
    localStorage.setItem("jmbgOptuzenog", jmbgOptuzenog.toString())
    localStorage.setItem("idOptuznice",  idOptuznice.toString())
    var modal = new bootstrap.Modal(document.getElementById('exampleModal3')!);
    modal.show();

  }

  zakaziSudjenje(){
    const SToken = localStorage.getItem("SToken");
    const decodedPToken = jwt_decode(SToken!) as { [key: string]: any };
    this.sudjenjePayload.brojSudijskeLicence =  decodedPToken['sub'];
    this.sudjenjePayload.brojSale = this.sudjenjeForm.get('brojSale')?.value;
    this.sudjenjePayload.jmbgOptuzenog = localStorage.getItem("jmbgOptuzenog")!;
    this.sudjenjePayload.idOptuznice =  parseInt(localStorage.getItem("idOptuznice")!);
    localStorage.removeItem("jmbgOptuzenog")
    localStorage.removeItem("idOptuznice")
    this.sudjenjePayload.vremeSudjenja = this.sudjenjeForm.get('vremeSudjenja')?.value;

    this.sudjenjeService.zakaziSudjenje(this.sudjenjePayload)
    .subscribe(response => {
      this.showAlertSuccess = true;
      this.getSudjenja()
      this.sveOptuznice()
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
