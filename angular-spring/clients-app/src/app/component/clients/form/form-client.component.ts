import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Client } from '../model/client';
import { ClientService } from '../service/client.service';
import Swal from 'sweetalert2';
import { Region } from '../model/region';

@Component({
  selector: 'app-form',
  templateUrl: './form-client.component.html'
})
export class FormClientComponent implements OnInit {

  title:string = 'Crear Cliente';
  regions:Region[];
  client:Client = new Client();
  formButtonText:string = 'Crear';
  isNew:boolean = true;
  errorMessage:string;

  constructor(
    private clientService:ClientService,
    private router:Router,
    private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.loadClient();
    this.loadRegions();
  }

  loadRegions():void {
    this.clientService.findAllRegions().subscribe(response => this.regions = response);
  }

  loadClient(): void {
    this.activatedRoute.params.subscribe(
      params => {
        let id = params['id'];
        if(id) {
          this.clientService.findById(id).subscribe(
            response => this.client = response,
            error => {
              if(error.status == 400 || error.status == 404) {
                Swal.fire('Error', `${error.error.message}`, 'error');
                this.router.navigate(['/clients']);
              }
            }
          );
          this.isNew = false;
          this.title = 'Editar Cliente';
          this.formButtonText = 'Editar';
        }
      }
    );
  }

  sendForm():void {
    if(this.isNew) {
      this.create();
    } else {
      this.update();
    }
  }

  create():void {
    this.clientService.create(this.client).subscribe(
      response => {
        this.router.navigate(['/clients'])
        Swal.fire('Nuevo Cliente', `Cliente ${response.name} creado correctamente`, 'success')
      },
      error => {
        this.errorMessage = error.error.message;
        Swal.fire('Error', `${error.error.message}`, 'error');
      }
    );
  }

  update():void {
    this.clientService.update(this.client).subscribe(
      response => {
        this.router.navigate(['/clients'])
        Swal.fire('Cliente Actualizado', `Cliente ${response.name} editado correctamente`, 'success')
      },
      error => {
        Swal.fire('Error', `${error.error.message}`, 'error');
      }
    );
  }

  compareRegion(iteration:Region, selected:Region):boolean {
    if(iteration === undefined && selected === undefined) {
      return true;
    }
    return iteration === null || iteration === undefined ||
          selected === null || selected === undefined
          ? false : iteration.id === selected.id;
  }
}
