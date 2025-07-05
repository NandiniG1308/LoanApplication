import { Component } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  constructor(private service: AuthService) {}

  ngOnInit() {
    console.log("Dashboard");
    console.log(this.service.getemail());
  }

 
}
