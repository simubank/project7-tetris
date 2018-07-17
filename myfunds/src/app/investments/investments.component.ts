import { Component } from '@angular/core';
import { TestServiceService } from '../test-service.service';

@Component({
  template: `
    <p>This is the investments page woo</p>
  `
})
export class InvestmentsComponent implements OnInit {

  ngOnInit() {
    this.getUserData();
  }

  getUserData(): void {
    data = testServiceService.getUserInfo();
    console.log('data retrieved:', data);
  }


}
