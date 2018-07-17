import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class TestServiceService {
  apiRoot = 'https://itunes.apple.com/search';

  constructor(private http: HttpClient) {
  }

  getUserInfo() {
    apiURL = `${this.apiRoot}?term=${term}&media=music&limit=20`;
    console.log('apiURL is:', apiURL);
    return this.http.get(apiURL);
  }
}

// https://codecraft.tv/courses/angular/http/http-with-observables/
