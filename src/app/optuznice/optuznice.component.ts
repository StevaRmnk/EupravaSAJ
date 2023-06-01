import { Component } from '@angular/core';
import { GetZapisnikPayload } from '../pregled-zapisnika/getZapisnik.payload';
import { HttpClient } from '@angular/common/http';
import jwt_decode from 'jwt-decode';
import { ZapisnikServiceService } from '../shared/zapisnik-service.service';
import { OptuzniceServiceService } from '../shared/optuznice-service.service';
import { Optuznica } from './Optuznica';

@Component({
  selector: 'app-optuznice',
  templateUrl: './optuznice.component.html',
  styleUrls: ['./optuznice.component.css']
})
export class OptuzniceComponent {

  zapisnici!: GetZapisnikPayload[]
  brojLicence!: String;
  optuznice!: Optuznica[]

  constructor(private httpClient: HttpClient, private zapisnikService: ZapisnikServiceService,private optuzniceService: OptuzniceServiceService ) { 
   
  }

  ngOnInit(): void {
    const TToken = localStorage.getItem("TToken");
    const decodedPToken = jwt_decode(TToken!) as { [key: string]: any };
    this.brojLicence =  decodedPToken['sub'];
    this.optuzniceTuzioca();
  }

  optuzniceTuzioca(){
    this.optuzniceService.optuzniceTuzioca(this.brojLicence).subscribe(
      response => {
        this.optuznice = response
        
      })
  }

}
