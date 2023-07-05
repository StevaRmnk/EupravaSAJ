import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { SudjenjeServiceService } from '../shared/sudjenje-service.service';
import { Presuda } from '../prikaz-sudjenja/presuda.payload';

@Component({
  selector: 'app-prikaz-presuda',
  templateUrl: './prikaz-presuda.component.html',
  styleUrls: ['./prikaz-presuda.component.css']
})
export class PrikazPresudaComponent {

  presude!:Presuda[]
  
  constructor(private httpClient: HttpClient,private sudjenjeService: SudjenjeServiceService ) { 

   
  }

  ngOnInit(): void {
    this.getPresude();
  }

  getPresude(){
    this.sudjenjeService.getPresude().subscribe(
      response => {
        this.presude = response
        
      })
  }
}
