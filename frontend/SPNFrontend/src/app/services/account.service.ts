import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { account } from '../../../src/model/Account';
@Injectable({
  providedIn: 'root'
})
export class AccountService {

  email:string='';

  constructor(private http:HttpClient) { }
  addAccount(acc:account){
    console.log(acc);
    return this.http.post('http://localhost:5069/api/v1/createAccount',acc);

  }
  getAccountByEmailId(emailId:any){
    return this.http.get(`http://localhost:5069/api/v1/email/${emailId}`);
  }

  getBalanceByAccountNumber(accountNumber:any){
    return this.http.get(`http://localhost:5069/api/v1/${accountNumber}/balance`)
  }
 
  getAccountById(accountNumber:any):Observable<account>{
    return this.http.get<account>(`http://localhost:5069/api/v1/ccreateAcount/${accountNumber}`);
  }
  getAccounts():Observable<any>{
    return this.http.get(`http://localhost:5069/api/v1/getAccounts`);
  }

  depositeAmount(accountNumber:any,amount:any){
    return this.http.put(`http://localhost:5069/api/v1/${accountNumber}/deposite/${amount}`,amount);
  }

  withdrawAmount(accountNumber:any,amount:any){
    return this.http.put(`http://localhost:5069/api/v1/${accountNumber}/withdraw/${amount}`,amount);
  }
}


