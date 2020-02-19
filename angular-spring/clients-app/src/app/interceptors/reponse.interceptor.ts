import { Injectable } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { AuthorizationService } from '../service/authorization.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ResponseInterceptor implements HttpInterceptor {

  constructor(private authorizationService:AuthorizationService, private router:Router) { }

  intercept(req: HttpRequest<any>, next:HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      catchError(
        error => {
          if(error.status == 401) {
            if(this.authorizationService.isAuthenticated()) {
              this.authorizationService.logOut(); //TODO Aqui deberia ser refreshToken
            }
            this.router.navigate(['/login']);
          }
          if(error.status == 403) {
            Swal.fire('Acceso denegado', 'No tienes permiso a este recurso', 'warning');
            this.router.navigate(['/clients']);
          }
          return throwError(error);
        }
      )
    );
  }
}
