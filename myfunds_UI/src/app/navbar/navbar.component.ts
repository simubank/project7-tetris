import {Component, OnInit} from '@angular/core';
// import { Router } from '@angular/router';


// For reference: https://medium.com/@tiboprea/build-a-responsive-bootstrap-4-navbar-in-angular-5-without-jquery-c59ad35b007

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  logintext: String = 'Login';

  constructor() {

  }

  ngOnInit() {
    console.log(' navbar initialized');
  }

}
