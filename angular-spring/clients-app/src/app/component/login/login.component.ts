import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/domain/user';
import Swal from 'sweetalert2';
import { AuthorizationService } from 'src/app/service/authorization.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {

  title:string = 'Por favor Sign In!';
  user:User;

  constructor(
    private authorizationService:AuthorizationService,
    private router:Router) {
    this.user = new User();
  }

  ngOnInit(): void {
    if(this.authorizationService.isAuthenticated()) {
      this.router.navigate(['/clients']);
    }
  }

  login():void {
    console.log(this.user);
    if(this.user.username == null || this.user.password == null) {
      Swal.fire('Error Login!', 'Username o Password vacios', 'error');
    }
    this.authorizationService.login(this.user).subscribe(
      response => {
        this.authorizationService.saveUser(response.access_token);
        this.router.navigate(['/clients']);
      },
      error => {
        if(error.status == 400) {
          Swal.fire('Error Login!', 'Username o Password incorrectos', 'error');
        }
      }
    );
  }
}
