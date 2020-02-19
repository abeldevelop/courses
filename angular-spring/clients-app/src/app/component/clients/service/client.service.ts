import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest, HttpEvent } from '@angular/common/http';
import { Client } from '../model/client';
import { Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { ClientsWithPagination } from '../model/clients-with-pagination';
import { Region } from '../model/region';
import { Router } from '@angular/router';
import { AuthorizationService } from 'src/app/service/authorization.service';
import Swal from 'sweetalert2';
import { URL_BACKEND } from 'src/app/config';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private baseUrl:string = URL_BACKEND;
  private clientsUrl = this.baseUrl + '/api/client';

  constructor(private httpClient:HttpClient, private router:Router, private authorizationService:AuthorizationService) { }

  findAll(): Observable<Client[]> {
    return this.httpClient.get(this.clientsUrl)
      .pipe(
        map(response => response as Client[])
      );
  }

  findAllWithPagination(page:number): Observable<ClientsWithPagination> {
    return this.httpClient.get<ClientsWithPagination>(`${this.clientsUrl}/page/${page}`);
  }


  create(client:Client): Observable<Client> {
    return this.httpClient.post<Client>(this.clientsUrl, client);
  }

  findById(id:number): Observable<Client> {
    return this.httpClient.get<Client>(`${this.clientsUrl}/${id}`);
  }

  update(client:Client): Observable<Client> {
    return this.httpClient.put<Client>(`${this.clientsUrl}/${client.id}`, client);
  }

  delete(id:number): Observable<Client> {
    return this.httpClient.delete<Client>(`${this.clientsUrl}/${id}`);
  }

  uploadProfileImage(id:number, profileImage: File): Observable<HttpEvent<{}>> {
    let formData = new FormData();
    formData.append("file", profileImage);

    const request = new HttpRequest('POST', `${this.clientsUrl}/${id}/profile-image`, formData, {reportProgress: true,});

    return this.httpClient.request(request);
  }

  downloadProfileImage(id:number) {
    return this.httpClient.get<Client>(`${this.clientsUrl}/${id}/profile-image`);
  }

  findAllRegions(): Observable<Region[]> {
    return this.httpClient.get<Region[]>(`${this.clientsUrl}/region`);
  }

//  private isNoAuthorization(error):boolean {
//    if(error.status == 401) {
//      if(this.authorizationService.isAuthenticated()) {
//        this.authorizationService.logOut(); //TODO Aqui deberia ser refreshToken
//      }
//      this.router.navigate(['/login']);
//      return true;
//    }
//    if(error.status == 403) {
//      Swal.fire('Acceso denegado', 'No tienes permiso a este recurso', 'warning');
//      this.router.navigate(['/clients']);
//      return true;
//    }
//    return false;
//  }

//  private addAccessTokenToHeaders():HttpHeaders {
//    let token = this.authorizationService.getAccessToken();
//    if(token != null) {
//      return this.httpHeaders.append('Authorization', `Bearer ${token}`);
//    }
//    return this.httpHeaders;
//  }
}
