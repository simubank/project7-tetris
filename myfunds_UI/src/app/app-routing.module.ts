import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InvestmentsComponent } from './investments/investments.component';
import { LoginComponent } from './login/login.component';
import {TransactionsComponent} from "./chequings/transactions.component";
import {SettingsComponent} from "./settings/settings.component";

const appRoutes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'investments',
    component: InvestmentsComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'transactions',
    component: TransactionsComponent
  },
  {
    path: 'settings',
    component: SettingsComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes/*,
      {
        enableTracing: true, // <-- debugging purposes only
      }*/
    )
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
