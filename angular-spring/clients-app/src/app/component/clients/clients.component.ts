import { Component, OnInit } from '@angular/core';
import { ClientService } from 'src/app/service/client.service';
import { Client } from 'src/app/domain/client';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html'
})
export class ClientsComponent implements OnInit {

  clients:Client[];

  constructor(private clientService:ClientService) { }

  ngOnInit(): void {
    this.clientService.getClients().subscribe(response => this.clients = response);
  }

}
