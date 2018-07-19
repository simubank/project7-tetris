import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { InvestmentsService } from './investments.service';

@Component({
  selector: 'app-investments',
  templateUrl: './investments.component.html',
  styleUrls: ['./investments.component.css']
})
export class InvestmentsComponent implements OnInit {

  tempVar: string; // bounded

  constructor(private router: Router, private investmentsService: InvestmentsService) {

  }

  ngOnInit() {
    console.log('initialized');
  }

  getChartData(): void {
    this.investmentsService.getPieGraphData()
      .subscribe( data => {
        console.log('retrieved the following data:', data);
      });
  }

  onSubmit() {
    console.log('Submit!');

    this.getChartData();
  }
}
