import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(private router:Router){}
  logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('email')
    this.router.navigate(['/login']);
  }
}
