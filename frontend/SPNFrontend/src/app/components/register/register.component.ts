import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthService } from 'src/app/services/auth.service';
import { User } from 'src/model/User';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  public user: User = {} as User;

  constructor(private service: AuthService, private snackBar: MatSnackBar) {}

  form = {
    userName: '',
    email: '',
    password: '',
    phoneNo: '',
    address: ''
  }

  emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
  phoneRegex = /[0-9]/;

  RegisterUser() {
    this.service.register(this.user).subscribe(
      data => {
        console.log(data);
        this.openSnackBar('Registered successfully');
      },
      error => {
        console.log(error);
        this.openSnackBar('Registration failed');
      }
    );
  }
  

  openSnackBar(message: string) {
    this.snackBar.open(message, 'Close', {
      duration: 3000, // Duration in milliseconds (3 seconds)
      horizontalPosition: 'center',
      verticalPosition: 'bottom'
    });
  }
}
