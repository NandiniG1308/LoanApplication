import { Component } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { CreditcardService } from 'src/app/services/creditcard.service';
import { CreditCard } from 'src/model/CreditCard';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-creditcard',
  templateUrl: './creditcard.component.html',
  styleUrls: ['./creditcard.component.css']
})
export class CreditcardComponent {
 public creditcard:CreditCard={} as CreditCard;
public cards:Array<any>=[];


 constructor(private service:CreditcardService, private snackBar:MatSnackBar){}

 
 AddCreditCard(){
  this.service.saveCreditCard(this.creditcard).subscribe((data:any)=>{
    this.cards.push(data);
    

  });
  this.openSnackBar('Applied for credit card ')
 }
 

 openSnackBar(message: string) {
  this.snackBar.open(message, 'Close', {
    duration: 3000, 
    horizontalPosition: 'center',
    verticalPosition: 'top'
  });
}
}
