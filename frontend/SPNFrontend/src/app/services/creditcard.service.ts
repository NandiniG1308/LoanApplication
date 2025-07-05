import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CreditCard } from 'src/model/CreditCard';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CreditcardService {

  constructor(private http:HttpClient) { }
  saveCreditCard(card:CreditCard):Observable<any>{
    return this.http.post('http://localhost:5058/api/v1/creditcard/save',card);
  }

  getCreditCard(email:any):Observable<any>{   
    return this.http.get(`http://localhost:5058/api/v1/creditcard/cards/${email}`);
  }

  getAllCreditCard():Observable<CreditCard[]>{
    return this.http.get<CreditCard[]>('http://localhost:5058/api/v1/creditcard/cards');
  }
}
