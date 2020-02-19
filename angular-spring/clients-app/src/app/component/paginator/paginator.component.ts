import { Component, OnInit, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Pagination } from '../clients/model/pagination';

@Component({
  selector: 'paginator-nav',
  templateUrl: './paginator.component.html'
})
export class PaginatorComponent implements OnInit, OnChanges {

  @Input() pagination:Pagination;
  pages:number[];
  from:number;
  to:number;

  constructor() { }

  ngOnInit(): void {
    this.initPaginator();
  }

  ngOnChanges(changes:SimpleChanges): void {
    let paginationUpdated = changes['pagination'];
    if(paginationUpdated.previousValue) {
      this.initPaginator();
    }
  }

  private initPaginator():void {
    this.from = Math.min(Math.max(1, this.pagination.page-4), this.pagination.totalPages-5);
    this.to = Math.max(Math.min(this.pagination.totalPages, this.pagination.page+4), 6);

    if(this.pagination.totalPages > 5) {
      this.pages = new Array(this.to - this.from + 1).fill(0).map((_valor, indice) => indice + this.from);
    } else {
      this.pages = new Array(this.pagination.totalPages).fill(0).map((_valor, indice) => indice + 1);
    }
  }

}
