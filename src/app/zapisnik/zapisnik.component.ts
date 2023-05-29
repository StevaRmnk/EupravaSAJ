import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ZapisnikPayload } from './zapisnik.payload';
import { AuthService } from '../shared/auth.service';
import { Router } from '@angular/router';
import { ZapisnikServiceService } from '../shared/zapisnik-service.service';
import jwt_decode from 'jwt-decode';
import { HttpErrorResponse } from '@angular/common/http';
import { CommunicationService } from '../shared/communication.service';


@Component({
  selector: 'app-zapisnik',
  templateUrl: './zapisnik.component.html',
  styleUrls: ['./zapisnik.component.css']
})
export class ZapisnikComponent {

  zapisnikForm: FormGroup = new FormGroup({});
  zapisnikPayload!: ZapisnikPayload;
  showAlert: boolean = false;
  showAlertSuccess: boolean = false;



  constructor(private authService: AuthService,  private router: Router, private zapisnikService: ZapisnikServiceService) { 
    this.zapisnikPayload = {
      brojZnacke: '',
      jmbgOsumnjicenog: '',
      datumPravljenjaZapisnika: new Date(),
      opisPrekrsaja: '',
      tipDokaza:'',
      datumZavodjenjaDokaza: new Date()
     
    }
  }
  
  ngOnInit(): void {
    this.zapisnikForm = new FormGroup({
      brojZnacke: new FormControl(''),
      jmbgOsumnjicenog: new FormControl(''),
      datumPravljenjaZapisnika: new FormControl(''),
      opisPrekrsaja: new FormControl(''),
      tipDokaza: new FormControl(''),
      datumZavodjenjaDokaza: new FormControl('')
    

    });
  }

  napraviZapisnik(){
    const PToken = localStorage.getItem("PToken");
    const decodedPToken = jwt_decode(PToken!) as { [key: string]: any };
    this.zapisnikPayload.brojZnacke =  decodedPToken['sub'];
    this.zapisnikPayload.jmbgOsumnjicenog = this.zapisnikForm.get('jmbgOsumnjicenog')?.value;
    const currentDate = new Date();
const localDateTime = currentDate.toLocaleString('en-US', {
  timeZone: 'Europe/Belgrade',
});
this.zapisnikPayload.datumPravljenjaZapisnika = new Date(localDateTime);
    this.zapisnikPayload.datumPravljenjaZapisnika = new Date(localDateTime);
this.zapisnikPayload.datumPravljenjaZapisnika = new Date(localDateTime);
    this.zapisnikPayload.opisPrekrsaja = this.zapisnikForm.get('opisPrekrsaja')?.value;
    this.zapisnikPayload.tipDokaza = this.zapisnikForm.get('tipDokaza')?.value;
    this.zapisnikPayload.datumZavodjenjaDokaza = this.zapisnikForm.get('datumZavodjenjaDokaza')?.value;

    this.zapisnikService.napraviZapisnik(this.zapisnikPayload)
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
