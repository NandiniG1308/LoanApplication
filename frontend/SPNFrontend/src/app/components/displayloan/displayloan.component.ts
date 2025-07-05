import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { LoanService } from 'src/app/services/loan.service';
import { Loan } from 'src/model/Loan';


@Component({
  selector: 'app-displayloan',
  templateUrl: './displayloan.component.html',
  styleUrls: ['./displayloan.component.css']
})
export class DisplayloanComponent {

  loan:Loan = new Loan();
  public loans: any;
  public loanId:any;
  public monthlyEmi:any;
  constructor(private route: ActivatedRoute,private loanService:LoanService ) {}
   
  getLoanByLoanId(loanId:any){
    
    this.loanService.getLoanByLoanId(loanId).subscribe((data)=>{
      this.loans=data
      console.log(this.loans);
      
    }
    )
  }

 
}
