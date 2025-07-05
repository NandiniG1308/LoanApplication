import { Component } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';
import { Account } from 'src/model/Account';

@Component({
  selector: 'app-balance',
  templateUrl: './balance.component.html',
  styleUrls: ['./balance.component.css']
})
export class BalanceComponent {
  account:Account=new Account();
  Balance:any;
  constructor(private service:AccountService){}

  getBalanceByName(accountNumber:any){

    this.service.getBalanceByAccountNumber(accountNumber).subscribe((data)=>{
      this.Balance=data;
    })
   
    
  }

}
