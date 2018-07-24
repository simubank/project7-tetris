import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { InvestmentsService } from './investments.service';
import { Chart } from 'angular-highcharts';

@Component({
  selector: 'app-investments',
  templateUrl: './investments.component.html',
  styleUrls: ['./investments.component.css']
})

export class InvestmentsComponent implements OnInit {

  multiplier = [2683.72998, 2697.850098, 2719.310059, 2731.330078, 2742.669922, 2751.149902, 2745.550049, 2752.969971,
    2770.179932, 2798.959961, 2784.98999, 2802.399902, 2802.600098, 2809.159912, 2835.050049, 2845.419922, 2846.23999,
    2847.47998, 2867.22998, 2832.73999, 2832.409912, 2816.449951, 2808.919922, 2741.060059, 2614.780029, 2690.949951,
    2685.01001, 2601.780029, 2636.75, 2646.27002, 2651.209961, 2713.459961, 2727.139893, 2722.98999, 2720.530029,
    2710.419922, 2715.800049, 2757.370117, 2780.449951, 2753.780029, 2715.219971, 2658.889893, 2681.060059, 2730.179932,
    2710.179932, 2732.75, 2752.909912, 2790.540039, 2792.310059, 2774.060059, 2754.27002, 2750.570068, 2741.379883,
    2715.050049, 2714.98999, 2691.360107, 2646.709961, 2619.350098, 2667.570068, 2611.300049, 2614.409912, 2633.449951];
  multiplierIndex = 0;

  savingsData = [];
  growthData = [];

  tempVar: string; // bounded

  userName;

  retrievedData;

  // https://www.npmjs.com/package/angular-highcharts
  chart = new Chart({
    chart: {
      type: 'line'
    },
    title: {
      text: ''
    },
    credits: {
      enabled: false
    },
/*    plotOptions: {
      line: {
        marker: false
      }
    },*/
    series: [
      {
        name: 'Amount Invested',
        color: '#434348',
        data: this.savingsData
      },
      {
        name: 'Investment Growth',
        color: '#19b14b',
        data: this.growthData
      }
    ]
  });

  pieChart = new Chart({
    chart: {
      type: 'pie'
    },
    title: {
      text: ''
    },
    tooltip: {
      pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    plotOptions: {
      pie: {
        allowPointSelect: true
      }
    },
    series: [{
      name: 'Investment Categories',
     /* colorByPoint: true,*/
      data: [{
        name: '<strong>EQUITY FUND</strong><br>',
        y: 55,
        sliced: true,
        selected: true
      },
      {
        name: '<strong>BOND FUND</strong><br> ',
        y: 30,
        sliced: true,
        selected: true
      },
      {
        name: '<strong>INDEX FUND</strong><br> ',
        y: 15,
        sliced: true,
        selected: true
      }]
    }]
  });


  constructor(private router: Router, private investmentsService: InvestmentsService) {

    // TEMP: Populate savingsData with shitty useless stuff
    for (let i = 0; i < 62; i++) {
      this.savingsData.push((i+2500));
    }

    this.savingsData.map(x => {
      this.growthData.push((x + this.multiplier[this.multiplierIndex])*0.5);
      this.multiplierIndex++;
    });

    console.log('savings:', this.savingsData);
    console.log('growth data:', this.growthData);

  }

  ngOnInit() {
    console.log('initialized');
    this.getUserName();
  }

  getUserName(): void {
    this.investmentsService.getUserName()
      .subscribe(
        data => {
          this.userName = ', ' + data.substr(0,data.indexOf(' '));
        },
        err => console.error(err),
        () => console.log("done:", this.retrievedData)
      )
  }


  getChartData(): void {
    let temp = this;
    this.investmentsService.getPieGraphData()
      .subscribe(
        data => {this.retrievedData = data},
        err => console.error(err),
        () => console.log("done:", this.retrievedData)
      );


    /*      .subscribe( data => {
            // console.log('retrieved the following data:', data);
        this.retrievedData = (data);
        console.log("got the data");
        console.log('received:', this.retrievedData.text());

      });*/

  }

  onSubmit() {
    this.getChartData();
    console.log('ONSUBMIT');


  }
}
