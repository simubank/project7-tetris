import { Component } from '@angular/core';

@Component({
  template: `
    <h2>Login</h2>
    <div><label>Username</label> <input type="text"></div>
    <div><label>Password</label> <input type="password"></div>
    <button>Submit</button>
    <!--Redirect to Investments on submit-->
  `

})
export class LoginComponent { }
