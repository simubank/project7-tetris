import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { Router } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { InvestmentsComponent } from './investments/investments.component';
import { LoginComponent } from './login/login.component';
import { NavbarComponent } from './navbar/navbar.component';

import { InvestmentsService } from './investments/investments.service';

@NgModule({
  declarations: [
    AppComponent,
    InvestmentsComponent,
    LoginComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    InvestmentsService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

  // Diagnostic only: inspect router configuration
  constructor(router: Router) {
    console.log('Routes: ', JSON.stringify(router.config, undefined, 2));
  }

}
