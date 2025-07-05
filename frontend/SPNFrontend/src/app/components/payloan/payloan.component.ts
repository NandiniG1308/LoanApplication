import { Component } from '@angular/core';
import { LoanService } from 'src/app/services/loan.service';
import { Loan } from 'src/model/Loan';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-payloan',
  templateUrl: './payloan.component.html',
  styleUrls: ['./payloan.component.css']
})
export class PayloanComponent {

  public loan: Loan = { loanType:''} as Loan;
  public loanId:any ;
  public loanAmt:any;
  constructor(private deposit: LoanService, private snackBar:MatSnackBar) { }
  depositAmount(loanId:any,loanAmt:any) {
    this.deposit.depositAmount(loanId, loanAmt).subscribe(
      (data)=>{console.log(data)
    });
      this.openSnackBar('Payment for loan successfully')

}
openSnackBar(message: string) {
  this.snackBar.open(message, 'Close', {
    duration: 3000, 
    horizontalPosition: 'center',
    verticalPosition: 'top'
  });
}
}
