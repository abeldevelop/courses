import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../domain/client';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private baseUrl:string = 'http://localhost:8080';
  private clientsUrl = this.baseUrl + '/api/clients';

  constructor(private httpClient:HttpClient) { }

  getClients(): Observable<Client[]> {
    return this.httpClient.get(this.clientsUrl)
      .pipe(
        map(response => response as Client[])
      );
  }
}
