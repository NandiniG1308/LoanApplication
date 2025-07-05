import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { User } from 'src/model/User';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  form = {
    email: '',
    password: ''
  }

  public user: User = {} as User;

  constructor(
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar
  ) { }

  Login(emailId: any, pass: any) {
    this.authService.login({ email: emailId, password: pass }).subscribe((data: any) => {
      console.log(data);
      // Display snackbar message on successful login
      this.snackBar.open('Login successful', 'Dismiss', {
        duration: 2000
      });
    },
      err => {
        if (err.status == 200) {
          console.log(err);
          localStorage.setItem('token', err.error.text);
          this.authService.setemail(emailId);
          localStorage.setItem('email', emailId);
          this.router.navigate(['/dashboard']);
        } else {
          this.snackBar.open('Failed to login', 'Dismiss', {
            duration: 2000
          });
        }
      })
  }
}
