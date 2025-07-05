import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoanService } from 'src/app/services/loan.service';
import { Loan } from 'src/model/Loan';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent {
  public loan: Loan = { loanType:''} as Loan;
  public loans: Array<any> = [];
  public loanId:number | null = null;
  public loanAmt:number | null = null;
  public monthlyEmi:number | null =  null;
  public isSubmitted: boolean = false;
  constructor(private service: LoanService, private router: Router,private snackBar:MatSnackBar) {}
  form={
    loanId:'',
    loanAmt:'',
    duration:'',
    LoanType:''
  }
  
  applyLoan() {
    this.service.applyloan(this.loan).subscribe((data: any) => {
      this.loanId = data.loanId;
      this.monthlyEmi = data.emi;
      console.log(data)
      this.openSnackBar('Applied for loan successfully');
      
    });
  }
  openSnackBar(message: string) {
    this.snackBar.open(message, 'Close', {
      duration: 3000, // Duration in milliseconds (3 seconds)
      horizontalPosition: 'center',
      verticalPosition: 'top'
    });
  }


}
