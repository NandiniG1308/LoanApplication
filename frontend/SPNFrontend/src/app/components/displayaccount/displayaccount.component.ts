import { Component } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';
import { Account } from 'src/model/Account';

@Component({
  selector: 'app-displayaccount',
  templateUrl: './displayaccount.component.html',
  styleUrls: ['./displayaccount.component.css']
})
export class DisplayaccountComponent {

  public account:Account={} as Account;
  public accounts:Array<any> =[];

  constructor(private service:AccountService){}
  
  ngOnInit():void{
    console.log(localStorage.getItem('email'));
    this.service.getAccountByEmailId(localStorage.getItem('email')).subscribe((data:any)=>{
      this.accounts=data
      console.log(this.accounts);
    });
    
    
  }

}
