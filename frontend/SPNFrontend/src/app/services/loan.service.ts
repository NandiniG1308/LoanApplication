import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Loan } from 'src/model/Loan';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoanService {
  saveloan(loan: Loan) {
    throw new Error('Method not implemented.');
  }
  constructor(private http:HttpClient) { }
  applyloan(Loan:Loan){
    return this.http.post('http://localhost:5068/api/v1',Loan);
  }
  getLoanByLoanId(loanId:any):Observable<any>{
    return this.http.get(`http://localhost:5068/api/v1/get/${loanId}`);
  }
  depositAmount(loanId:any,loanAmt:any){
    return this.http.put(`http://localhost:5068/api/v1/deposit/${loanId}/${loanAmt}`,loanAmt);
  }
}
