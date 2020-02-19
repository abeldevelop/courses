import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { ShowAllClientsComponent } from './component/clients/show-all/show-all-clients.component';
import { FormClientComponent } from './component/clients/form/form-client.component';
import { PaginatorComponent } from './component/paginator/paginator.component';
import { ClientDetailComponent } from './component/clients/client-detail/client-detail.component';
import { LoginComponent } from './component/login/login.component';

import { AuthGuard } from './guards/auth.guard';

import { AuthInterceptor } from './interceptors/http.interceptor';

const ROUTES: Routes = [
  {path: '', redirectTo: '/clients', pathMatch: 'full'},
  {path: 'clients', component: ShowAllClientsComponent},
  {path: 'clients/page/:page', component: ShowAllClientsComponent},
  {path: 'clients/form', component: FormClientComponent, canActivate: [AuthGuard], data:{role:'ROLE_ADMIN'}},
  {path: 'clients/form/:id', component: FormClientComponent, canActivate: [AuthGuard], data:{role:'ROLE_ADMIN'}},
  {path: 'login', component: LoginComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ShowAllClientsComponent,
    FormClientComponent,
    PaginatorComponent,
    ClientDetailComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(ROUTES)
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
