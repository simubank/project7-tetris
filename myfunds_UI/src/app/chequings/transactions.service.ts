import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json' })
};

@Injectable()
export class TransactionsService {

  constructor(private http: HttpClient) {}

  private apiRoot = 'http://localhost:8080/myfunds/save/angular';

  // Just testing with this...
  public getPieGraphData() {
    return this.http.get(this.apiRoot);
  }
}
