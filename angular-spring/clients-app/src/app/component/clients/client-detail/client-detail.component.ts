import { Component, OnInit, Input } from '@angular/core';
import { Client } from '../model/client';
import { ClientService } from '../service/client.service';
import Swal from 'sweetalert2';
import { HttpEventType } from '@angular/common/http';
import { ClientDetailModalService } from './client-detail-modal.service';
import { AuthorizationService } from 'src/app/service/authorization.service';
import { URL_BACKEND } from 'src/app/config';

@Component({
  selector: 'client-detail',
  templateUrl: './client-detail.component.html'
})
export class ClientDetailComponent implements OnInit {

  baseUrl:string = URL_BACKEND;
  title:string = 'Detalle del Cliente';
  @Input() client:Client;
  selectedPhoto:File;
  progress:number = 0;
  authorizationService:AuthorizationService;
  clientDetailModalService:ClientDetailModalService;

  constructor(
    private clientService:ClientService,
    clientDetailModalService:ClientDetailModalService,
    authorizationService:AuthorizationService) {
      this.authorizationService = authorizationService;
      this.clientDetailModalService = clientDetailModalService;
    }

  ngOnInit(): void {
  }

  selectPhoto(event) {
    this.progress = 0;
    this.selectedPhoto = event.target.files[0];
    if(this.selectedPhoto.type.indexOf('image') < 0) {
      Swal.fire('Error Seleccionar Imagen', `El archivo debe ser del tipo imagen`, 'error');
      this.selectedPhoto = null;
    }
  }

  uploadPhoto() {
    if(!this.selectedPhoto) {
      Swal.fire('Error Upload', `debe seleccionar una foto`, 'error');
    } else {
      this.clientService.uploadProfileImage(this.client.id, this.selectedPhoto).subscribe(
        event => {
          if(event.type === HttpEventType.UploadProgress) {
            this.progress = Math.round((event.loaded/event.total)*100);
          } else if(event.type === HttpEventType.Response){
            this.clientDetailModalService.getNotifyUpload().emit(this.client);
            this.clientService.findById(this.client.id).subscribe(
              response => this.client = response
            );
            Swal.fire('La foto se ha subido correctamente', `Foto subida con exito`, 'success');
          }
        }
      );
    }
  }

  closeModal() {
    this.clientDetailModalService.closeModal();
    this.progress = 0;
    this.selectedPhoto = null;
  }
}
