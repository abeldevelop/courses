import { Injectable, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClientDetailModalService {

  modal:boolean;
  private notifyUpload = new EventEmitter<any>();

  constructor() {}

  openModal() {
    this.modal = true;
  }

  closeModal() {
    this.modal = false;
  }

  getNotifyUpload():EventEmitter<any> {
    return this.notifyUpload;
  }

}
