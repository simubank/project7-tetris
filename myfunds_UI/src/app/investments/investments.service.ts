import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json' })
};

@Injectable()
export class InvestmentsService {

  constructor(private http: HttpClient) {}

  private apiRoot = 'http://localhost:8080/myfunds/save/angular1';

  // https://github.com/angular/angular/issues/18672
  public getUserName() {
    return this.http.get('http://localhost:8080/myfunds/save/user/customerName', {responseType: 'text'});
  }

  // Just testing with this...
  public getPieGraphData() {
    return this.http.get<string>(this.apiRoot);
  }
}
