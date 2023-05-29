import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ZapisnikServiceService } from '../shared/zapisnik-service.service';
import { GetZapisnikPayload } from './getZapisnik.payload';
import jwt_decode from 'jwt-decode';

@Component({
  selector: 'app-pregled-zapisnika',
  templateUrl: './pregled-zapisnika.component.html',
  styleUrls: ['./pregled-zapisnika.component.css']
})
export class PregledZapisnikaComponent {

  zapisnici!: GetZapisnikPayload[]
  brojZnacke!: String;

  constructor(private httpClient: HttpClient, private zapisnikService: ZapisnikServiceService ) { 
   
  }

  ngOnInit(): void {
    const PToken = localStorage.getItem("PToken");
    const decodedPToken = jwt_decode(PToken!) as { [key: string]: any };
    this.brojZnacke =  decodedPToken['sub'];
    this.zapisniciPolicajca();
  }

  zapisniciPolicajca(){
    this.zapisnikService.zapisniciPolicajca(this.brojZnacke).subscribe(
      response => {
        this.zapisnici = response
        
      })
  }
}
