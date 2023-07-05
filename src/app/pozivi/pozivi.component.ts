import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { SudjenjeServiceService } from '../shared/sudjenje-service.service';
import { GetSudjenjePayload } from '../prikaz-sudjenja/getSudjenje.payload';
import jwt_decode from 'jwt-decode';

@Component({
  selector: 'app-pozivi',
  templateUrl: './pozivi.component.html',
  styleUrls: ['./pozivi.component.css']
})
export class PoziviComponent {

  mojiPozivi!: GetSudjenjePayload[]
  email!:String;
  constructor(private httpClient: HttpClient,private sudjenjeService: SudjenjeServiceService ) { 

   
  }

  ngOnInit(): void {
    const token = localStorage.getItem("token");
    const decodedToken = jwt_decode(token!) as { [key: string]: any };
    this.email=decodedToken['email']
   this.getPozivi();
  }

  getPozivi(){
    this.sudjenjeService.getSvaSudjenja(this.email).subscribe(
      response => {
        this.mojiPozivi = response
     
        
      })
  }
}
