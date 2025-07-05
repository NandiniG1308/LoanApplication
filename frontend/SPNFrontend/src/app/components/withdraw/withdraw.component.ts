import { Component } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';
import { account } from 'src/model/Account';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent {
  accountNumber: any;
  withdrawAmount: any;
  successMessage: any;

  public account:account={}as account;
  constructor(private bankService: AccountService,private snackBar:MatSnackBar) {}

  withdraw(accountnumber: any, withdrawAmount: any) {
    console.log(accountnumber, withdrawAmount);
    this.bankService.withdrawAmount(accountnumber, withdrawAmount)
      .subscribe(
        () => {
          this.openSnackBar('Amount withdrawed successfully');
          this.withdrawAmount = null;
         
        },
        (err: any) => {
          this.openSnackBar('Failed to withdraw the amount');
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


