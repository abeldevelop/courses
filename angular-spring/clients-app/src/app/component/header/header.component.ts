import { Component } from '@angular/core';
import { AuthorizationService } from 'src/app/service/authorization.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html'
})
export class HeaderComponent {
  title:string = 'App Angular';
  authorizationService:AuthorizationService;

  constructor(authorizationService:AuthorizationService) {
    this.authorizationService = authorizationService;
  }

  logOut():void {
    this.authorizationService.logOut();
  }
}
