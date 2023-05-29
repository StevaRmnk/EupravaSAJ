import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../shared/auth.service';
import jwt_decode from 'jwt-decode';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  isLogged!: string;
  constructor(private route: ActivatedRoute, private authService: AuthService) { }
  
  ngOnInit(): void {
    this.setToken()
    this.checkToken();
  }

  checkToken(){
    this.isLogged = this.authService.isLogged();
  }
  
  setToken(): void {
    const token = this.route.snapshot.queryParamMap.get('at');
    if (token) {
      try {
        const decodedToken = jwt_decode(token) as { [key: string]: any };
        localStorage.setItem('token', token);
      } catch (err) {
        
      }
    }
  }
}
