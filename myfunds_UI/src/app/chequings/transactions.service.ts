import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json' })
};

@Injectable()
export class TransactionsService {

  httpOptions = {
    headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*'
    })
  };


  constructor(private http: HttpClient) {}

  // Just testing with this...
  public getTransactionData() {
    return this.http.get('http://localhost:8080/myfunds/save/angular3', this.httpOptions);
  }

  public getAccountBalance(){
    return this.http.get('http://localhost:8080/myfunds/save/angular2', this.httpOptions);
  }

  public doTransfer(){
    return this.http.get('http://localhost:8080/myfunds/save/user/transfer', {responseType: 'text'});

  }
}
