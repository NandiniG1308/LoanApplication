import { Component } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { CreditcardService } from 'src/app/services/creditcard.service';
import { CreditCard } from 'src/model/CreditCard';

@Component({
  selector: 'app-displaycreditcard',
  templateUrl: './displaycreditcard.component.html',
  styleUrls: ['./displaycreditcard.component.css']
})
export class DisplaycreditcardComponent {
  public cards: Array<any> = [];
  public card: CreditCard = {} as CreditCard;

  constructor(
    private userCreditCardService: CreditcardService,
    private toastr: ToastrService
  ) {}

  ngOnInit() {
    console.log(localStorage.getItem('email'));
    this.userCreditCardService.getCreditCard(localStorage.getItem('email'))
      .subscribe(
        (data) => {
          if (data) {
            this.card = data;
          } else {
            this.toastr.error('Card does not exist', 'Error');
          }
        },
        (error) => {
          this.toastr.error('Failed to retrieve card', 'Error');
          console.error(error);
        }
      );
  }
}
