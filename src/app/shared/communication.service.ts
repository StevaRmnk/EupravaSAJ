import { Injectable } from '@angular/core';
import { PregledZapisnikaComponent } from '../pregled-zapisnika/pregled-zapisnika.component';

@Injectable({
  providedIn: 'root'
})
export class CommunicationService {

  constructor(private pregledZapisnika: PregledZapisnikaComponent) {}


  updateZapisnici(){
    this.pregledZapisnika.zapisniciPolicajca()
  }
}
