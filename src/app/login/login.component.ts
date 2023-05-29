import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { LoginRequestPayload } from './login-request.payload';
import { AuthService } from '../shared/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm: FormGroup = new FormGroup({});
  loginRequestPayload!: LoginRequestPayload;

  constructor(private authService: AuthService,  private router: Router,) { 
    this.loginRequestPayload = {
      brojZnacke: '',
      lozinka: ''
     
    }
  }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      brojZnacke: new FormControl(''),
      lozinka: new FormControl('')
    

    });
  }

  login(){
    this.loginRequestPayload.brojZnacke = this.loginForm.get('brojZnacke')?.value;
    this.loginRequestPayload.lozinka = this.loginForm.get('lozinka')?.value;

    this.authService.login(this.loginRequestPayload)
    .subscribe(response => {
      console.log('Login Successful');
      const data = JSON.parse(response);
      const token = data.token
      localStorage.setItem("PToken", token);
      this.router.navigate(['/home'])
    });
  }

}
