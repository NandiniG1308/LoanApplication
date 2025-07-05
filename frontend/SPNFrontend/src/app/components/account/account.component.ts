import { Component } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AccountService } from 'src/app/services/account.service';
import { account } from '../../../model/Account';
@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent {

  public Account:account={} as account;

  constructor(private service:AccountService,private fb:FormBuilder,private snackBar: MatSnackBar ) {}

  

  registerForm = this.fb.group({
    accountHolderName: new FormControl("",[Validators.required,Validators.minLength(2),Validators.pattern("[a-zA-Z].*")]),
    accountHolderLastName: new FormControl("",[Validators.required,Validators.minLength(2),Validators.pattern("[a-zA-Z].*")]),
    email: new FormControl("",[Validators.required,Validators.email]),
    phoneNumber: new FormControl("",[Validators.required,Validators.minLength(10),Validators.maxLength(10),Validators.pattern("[0-9]*")]),
    gender: new FormControl("",[Validators.required]),
    adharNumber: new FormControl("",[Validators.required,Validators.minLength(12),Validators.maxLength(12),Validators.pattern("[0-9]*")]),
    panCardNumber: new FormControl("",[Validators.required,Validators.minLength(10),Validators.maxLength(10)]),
    address:new FormControl("",[Validators.required,Validators.minLength(10)]),
    accountType: new FormControl("",[Validators.required])
  });


  registerSubmitted(){
    let accountDetails:any=this.registerForm.value;
    this.service.addAccount(accountDetails).subscribe((data:any)=>{console.log(data);
      this.openSnackBar('Account created successfully');
    })
    
    // console.log(this.registerForm.get("firstName"))
  }

  openSnackBar(message: string) {
    this.snackBar.open(message, 'Close', {
      duration: 3000, // Duration in milliseconds (3 seconds)
      horizontalPosition: 'center',
      verticalPosition: 'bottom'
    });
  }

  get firstName(){
    return this.registerForm.get("accountHolderName");
  }
  get lastName(){
    return this.registerForm.get("accountHolderLastName");
  }
  get Email(){
    return this.registerForm.get("email");
  }
  get Mobile(){
    return this.registerForm.get("phoneNumber");
  }
  get Gender(){
    return this.registerForm.get("gender");
  }
  get Aadhar(){
    return this.registerForm.get("adharNumber");
  }
  get PanCard(){
    return this.registerForm.get("panCardNumber");
  }
  get Address(){
    return this.registerForm.get("address");

  }
  get AccountType(){
    return this.registerForm.get("accountType");
  }
  // get Balance(): FormControl{
  //   return this.registerForm.get("balance") as FormControl;
  // }

  }


