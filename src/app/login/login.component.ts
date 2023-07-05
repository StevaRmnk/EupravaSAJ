import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AuthServiceService } from '../shared/auth-service.service';
import { Router } from '@angular/router';
import { LoginRequestPayload } from './login-request.payload';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup = new FormGroup({});
  loginRequestPayload!: LoginRequestPayload;

  constructor(private authService: AuthServiceService,  private router: Router,) { 
    this.loginRequestPayload = {
      brojLicence: '',
      lozinka: ''
     
    }
  }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      brojLicence: new FormControl(''),
      lozinka: new FormControl('')
    

    });
  }

  login(){
    this.loginRequestPayload.brojLicence = this.loginForm.get('brojLicence')?.value;
    this.loginRequestPayload.lozinka = this.loginForm.get('lozinka')?.value;

    this.authService.login(this.loginRequestPayload)
    .subscribe(response => {
      console.log('Login Successful');
      const data = JSON.parse(response);
      const token = data.token
      localStorage.setItem("SToken", token);
      this.router.navigate(['/home'])
    });
  }

}
