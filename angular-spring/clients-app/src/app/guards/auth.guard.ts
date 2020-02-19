import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthorizationService } from '../service/authorization.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authorizationService:AuthorizationService, private router:Router) {

  }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      console.log("Entra al guard");
      if(this.authorizationService.isAuthenticated() && !this.isTokenExpired()) {
          console.log("1");
          let role = next.data['role'] as string;
          console.log(next);
          if(this.authorizationService.hasRole(role)) {
            console.log("2");
            return true;
          }
          return false;
      }
      this.router.navigate(['/login']);
      return false;
  }

  private isTokenExpired() {
    let token:string = this.authorizationService.getAccessToken();
    let payload = this.authorizationService.getDataFromAccesToken(token);
    let nowInSeconds = new Date().getTime() / 1000;
    if(payload.exp < nowInSeconds) {
      console.log("Expired SI");
      return true;
    }
    console.log("Expired NO");
    return false;
  }
}
