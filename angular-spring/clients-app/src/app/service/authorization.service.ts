import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../domain/user';
import { URL_BACKEND } from '../config';

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {

  private baseUrl:string = URL_BACKEND;
  private user:User;
  private accessToken:string;

  constructor(private httpClient:HttpClient) { }

  login(user:User):Observable<any> {
    const credentials = btoa('angularapp:12345');
    const httpHeaders:HttpHeaders = new HttpHeaders({'Content-Type':'application/x-www-form-urlencoded', 'Authorization':'Basic ' + credentials});
    let params = new URLSearchParams();
    params.set('grant_type', 'password');
    params.set('username', user.username);
    params.set('password', user.password);
    return this.httpClient.post<any>(`${this.baseUrl}/oauth/token`, params.toString(), {headers: httpHeaders});
  }

  saveUser(accessToken:string):void {
    this.accessToken = accessToken;
    this.user = this.retrieveUserFromAccessToken(accessToken);
    sessionStorage.setItem('user', JSON.stringify(this.user));
    sessionStorage.setItem('accessToken', accessToken);
  }

  getUser():User {
    if(this.user != null) {
      return this.user;
    } else if(this.user == null && sessionStorage.getItem('user') != null) {
      this.user = JSON.parse(sessionStorage.getItem('user')) as User;
      return this.user;
    }
    return new User();
  }

  getAccessToken():string {
    if(this.accessToken != null) {
      return this.accessToken;
    } else if(this.accessToken == null && sessionStorage.getItem('accessToken') != null) {
      this.accessToken = sessionStorage.getItem('accessToken');
      return this.accessToken;
    }
    return null;
  }

  private retrieveUserFromAccessToken(accessToken:string):User {
    if(accessToken != null) {
      let payload = this.getDataFromAccesToken(accessToken);
      let user = new User();
      user.name = payload.name;
      user.username = payload.user_name;
      user.surname = payload.surname;
      user.name = payload.name;
      user.roles = payload.authorities;
      user.email = payload.email;
      return user;
    } else {
      return null;
    }
  }

  getDataFromAccesToken(accessToken:string) {
    return JSON.parse(atob(accessToken.split('.')[1]));
  }

  isAuthenticated():boolean {
    if(this.getAccessToken() != null) {
      return true;
    }
    return false;
  }

  logOut():void {
    this.accessToken = null;
    this.user = null;
    sessionStorage.clear();
  }

  hasRole(role:string):boolean {
    if(this.user == null) {
      return false;
    } else {
      return (this.user.roles.includes(role));
    }
  }
}
