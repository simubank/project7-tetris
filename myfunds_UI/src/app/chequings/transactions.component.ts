import { Component, OnInit } from '@angular/core';
import { TransactionsService } from './transactions.service';
import { Router } from '@angular/router';
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
   styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {
  rewardAmount = 50;

  //Get these from service
  transactionData: any;
  accountBalance;
  dataReady=false;

  columns = ["postDate", "currencyAmount"];
  constructor(private router: Router, private transactionsService: TransactionsService) {

  }

  ngOnInit() {
    console.log('initialized');
    this.getTransactionData();
    this.getAccountBalance();
  }

  getTransactionData(): void {
  let temp = this;
  this.transactionsService.getTransactionData()
    .subscribe(
      (data:any) => {
        this.transactionData = data.result;
      },
      err => console.error(err),
      () => {
        //sort by newest first
        this.transactionData.sort(function(a,b) {
          var keyA = new Date(a.postDate),
            keyB = new Date(b.postDate);
          // Compare the 2 dates
          if(keyA < keyB) return 1;
          if(keyA > keyB) return -1;
          return 0;
        });
        console.log("done:", this.transactionData);
        this.dataReady=true;

      }
    );
  }

  getAccountBalance() {
    this.transactionsService.getAccountBalance()
      .subscribe(
        (data:any) => this.accountBalance = data.result.bankAccount.balance,
        err => console.error(err),
        () => {console.log(this.accountBalance)}
  )
  }


}
