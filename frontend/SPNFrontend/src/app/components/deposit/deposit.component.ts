import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AccountService } from 'src/app/services/account.service';
import { account } from 'src/model/Account';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent {
  accountNumber: any;
  depositAmount: any;
  successMessage: any;

  public account:account={}as account;

  constructor(private bankService: AccountService,private snackBar:MatSnackBar) {} // Inject the BankService or your service



deposit(accountnumber: any, depositamount: any) {
  console.log(accountnumber, depositamount);
  this.bankService.depositeAmount(accountnumber, depositamount)
    .subscribe(
      () => {
        this.successMessage = 'Deposit successful.';
        this.depositAmount = null;
        this.openSnackBar('Amount depositted successfully');
      },
      (err: any) => {
        this.openSnackBar('Failed to deposit');
        console.error(err);
      }
    );
}

openSnackBar(message: string) {
  this.snackBar.open(message, 'Close', {
    duration: 3000, // Duration in milliseconds (3 seconds)
    horizontalPosition: 'center',
    verticalPosition: 'top'
  });
}

}


