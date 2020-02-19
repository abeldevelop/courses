import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClientService } from '../service/client.service';
import { Client } from '../model/client';
import Swal from 'sweetalert2';
import { Pagination } from '../model/pagination';
import { ClientDetailModalService } from '../client-detail/client-detail-modal.service';
import { AuthorizationService } from 'src/app/service/authorization.service';
import { URL_BACKEND } from 'src/app/config';

@Component({
  selector: 'app-clients',
  templateUrl: './show-all-clients.component.html'
})
export class ShowAllClientsComponent implements OnInit {

  baseUrl:string = URL_BACKEND;
  clients:Client[];
  pagination:Pagination;
  page:number = 1;
  selectedClient:Client;
  authorizationService:AuthorizationService

  constructor(
    private clientService:ClientService,
    private activatedRoute:ActivatedRoute,
    private clientDetailModalService:ClientDetailModalService,
    authorizationService:AuthorizationService) {
      this.authorizationService = authorizationService;
    }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      params => {
        let page:number = +params.get('page');
        if(page) {
          this.page = page;
        }
        this.findAllWithPagination();
      });
      this.clientDetailModalService.getNotifyUpload().subscribe(
        client => {
          this.findAllWithPagination();
         this.clients = this.clients.map(
            originalClient => {
              if(client.id == originalClient.id) {
                originalClient.profileImage = client.profileImage;
                this.selectedClient = originalClient;
              }
              return originalClient;
            }
          )
        }
      );
  }

  private findAllWithPagination():void {
    this.clientService.findAllWithPagination(this.page).subscribe(
      response => {
        this.clients = response.clients
        this.pagination = response.pagination;
      });
  }

  delete(client:Client):void {
    Swal.fire({
      title: '¿Estas seguro?',
      text: `¿Seguro de eliminar al cliente ${client.name}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText : 'No, cancelar'
    }).then((result) => {
      if (result.value) {
        this.clientService.delete(client.id).subscribe(
          response => {
            this.findAllWithPagination();
            Swal.fire(
              'Eliminado!',
              `Cliente ${client.name} eliminado correctamente`,
              'success'
            )
          },
          error => {
            Swal.fire('Error', `${error.error.message}`, 'error');
          }
        );
      }
    })
  }

  selectClient(client):void {
    this.selectedClient = client;
    this.clientDetailModalService.openModal();
  }
}
