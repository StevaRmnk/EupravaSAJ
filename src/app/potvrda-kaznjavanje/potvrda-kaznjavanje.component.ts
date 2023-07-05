import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ZapisnikServiceService } from '../shared/zapisnik-service.service';

@Component({
  selector: 'app-potvrda-kaznjavanje',
  templateUrl: './potvrda-kaznjavanje.component.html',
  styleUrls: ['./potvrda-kaznjavanje.component.css']
})
export class PotvrdaKaznjavanjeComponent {

  cardVisible: boolean = false;
  kriv!:Boolean;
  date: Date = new Date();
  constructor(private httpClient: HttpClient, private zapisnikService: ZapisnikServiceService ) { 
   
  }

  ngOnInit(): void {
   
  }

  zatraziPotvrdu(){
    this.zapisnikService.potvrda().subscribe(
      response => {
        this.kriv = response
        const headerElement: HTMLElement | null = document.getElementById("potvrdaHeader")!;
        const text: HTMLElement | null = document.getElementById("text")!;
        const bodyText: HTMLElement | null = document.getElementById("bodyText")!;
        if (this.kriv) {
          headerElement.style.backgroundColor = "green";
          headerElement.style.color = "white";
          text.textContent="Uspešno"
          bodyText.textContent="Niste nikada ranije osudjivani."
        }
        if (!this.kriv) {
          headerElement.style.backgroundColor = "red";
          headerElement.style.color = "white";
          text.textContent="Neuspešno"
          bodyText.textContent="Osudjivani ste ranije."
        }
        this.cardVisible=true;

        
      })
  }
  }


