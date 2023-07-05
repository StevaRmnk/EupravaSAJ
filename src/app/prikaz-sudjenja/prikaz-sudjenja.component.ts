import { Component } from '@angular/core';
import { GetSudjenjePayload } from './getSudjenje.payload';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { SudjenjeServiceService } from '../shared/sudjenje-service.service';
import { FormControl, FormGroup } from '@angular/forms';
import { Presuda } from './presuda.payload';
import * as bootstrap from 'bootstrap'
import jwt_decode from 'jwt-decode';

@Component({
  selector: 'app-prikaz-sudjenja',
  templateUrl: './prikaz-sudjenja.component.html',
  styleUrls: ['./prikaz-sudjenja.component.css']
})
export class PrikazSudjenjaComponent {
  sudjenja!: GetSudjenjePayload[]
  presudaForm: FormGroup = new FormGroup({});
  presudaPayload!: Presuda;
  showAlert: boolean = false;
  showAlertSuccess: boolean = false;
  presude!:Presuda[]
  

  constructor(private httpClient: HttpClient,private sudjenjeService: SudjenjeServiceService ) { 

    this.presudaPayload = {
      idOptuznice: 0,
      jmbgOptuzenog: '',
      sudija:'',
      kriv: false,    
    }
  }

  ngOnInit(): void {
    this.getPresude()
    this.getSudjenja()
    this.presudaForm = new FormGroup({
      idOptuznice: new FormControl(''),
      jmbgOptuzenog: new FormControl(''),
      sudija: new FormControl(''),
      kriv: new FormControl(''),
     
  
    });
  }

  getPresude(){
    this.sudjenjeService.getPresude().subscribe(
      response => {
        this.presude = response
        
      })
  }

  getSudjenja(){
    this.sudjenjeService.getSudjenja().subscribe(
      response => {
        this.sudjenja = response.filter((sudjenje: GetSudjenjePayload) => {
          return !this.presude.some(presuda => presuda.idOptuznice === sudjenje.idOptuznice);
        });
        
      })
  }
  presudi(jmbgOptuzenog: String, idOptuznice: Number, brojSudijskeLicence: String ){

    localStorage.setItem("jmbgOptuzenog", jmbgOptuzenog.toString())
    localStorage.setItem("idOptuznice", idOptuznice.toString())
    var modal = new bootstrap.Modal(document.getElementById('exampleModal')!);
    modal.show();
  }

  napraviPresudu(kriv:Boolean){
    const SToken = localStorage.getItem("SToken");
    const decodedPToken = jwt_decode(SToken!) as { [key: string]: any };
    this.presudaPayload.sudija =  decodedPToken['sub'];
    this.presudaPayload.idOptuznice = parseInt(localStorage.getItem("idOptuznice")!);
    this.presudaPayload.jmbgOptuzenog = localStorage.getItem("jmbgOptuzenog")!;
    this.presudaPayload.kriv =  kriv;
    localStorage.removeItem("jmbgOptuzenog")
    localStorage.removeItem("idOptuznice")

    this.sudjenjeService.napraviPresudu(this.presudaPayload)
    .subscribe(response => {
      this.getPresude();
      this.getSudjenja();
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


