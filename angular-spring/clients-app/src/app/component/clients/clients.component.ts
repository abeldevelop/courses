import { Component, OnInit } from '@angular/core';
import { Client } from './client';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html'
})
export class ClientsComponent implements OnInit {

  clients:Client[] = [
    {id: 1, name: 'Name 1', surname: 'Surname 1', email: 'email1@mail.com', createAt: '2020-02-17'},
    {id: 2, name: 'Name 2', surname: 'Surname 2', email: 'email2@mail.com', createAt: '2020-02-16'},
    {id: 3, name: 'Name 3', surname: 'Surname 3', email: 'email3@mail.com', createAt: '2020-02-15'},
    {id: 4, name: 'Name 4', surname: 'Surname 4', email: 'email4@mail.com', createAt: '2020-02-14'},
    {id: 5, name: 'Name 5', surname: 'Surname 5', email: 'email5@mail.com', createAt: '2020-02-13'},
    {id: 6, name: 'Name 6', surname: 'Surname 6', email: 'email6@mail.com', createAt: '2020-02-12'},
    {id: 7, name: 'Name 7', surname: 'Surname 7', email: 'email7@mail.com', createAt: '2020-02-11'},
    {id: 8, name: 'Name 8', surname: 'Surname 8', email: 'email8@mail.com', createAt: '2020-02-10'},
    {id: 9, name: 'Name 9', surname: 'Surname 9', email: 'email9@mail.com', createAt: '2020-02-09'},
    {id: 10, name: 'Name 10', surname: 'Surname 10', email: 'email10@mail.com', createAt: '2020-02-08'},
    {id: 11, name: 'Name 11', surname: 'Surname 11', email: 'email11@mail.com', createAt: '2020-02-07'},
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
