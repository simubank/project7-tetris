import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InvestmentsComponent } from './investments/investments.component';
import { LoginComponent } from './login/login.component';

const appRoutes: Routes = [
  {
    path: 'investments',
    component: InvestmentsComponent
  },
  {
    path: 'login',
    component: LoginComponent
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
