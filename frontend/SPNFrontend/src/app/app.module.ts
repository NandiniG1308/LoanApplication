import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { MainComponent } from './components/main/main.component';
import { ReactiveFormsModule } from '@angular/forms';

import { ToastrModule } from 'ngx-toastr';
import { CreditcardComponent } from './components/creditcard/creditcard.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { DisplaycreditcardComponent } from './components/displaycreditcard/displaycreditcard.component';
import { CreditcardPipe } from './pipes/creditcard.pipe';
import { AccountComponent } from './components/account/account.component';
import { DisplayaccountComponent } from './components/displayaccount/displayaccount.component';
import { BalanceComponent } from './components/balance/balance.component';
import { DepositComponent } from './components/deposit/deposit.component';
import { WithdrawComponent } from './components/withdraw/withdraw.component';
import { LoanComponent } from './components/loan/loan.component';
import { DisplayloanComponent } from './components/displayloan/displayloan.component';
import { PayloanComponent } from './components/payloan/payloan.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    DashboardComponent,
    RegisterComponent,
    LoginComponent,
    MainComponent,
    CreditcardComponent,
    NavbarComponent,
    DisplaycreditcardComponent,
    CreditcardPipe,
    AccountComponent,
    DisplayaccountComponent,
    BalanceComponent,
    DepositComponent,
    WithdrawComponent,
    LoanComponent,
    DisplayloanComponent,
    PayloanComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    MatSnackBarModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
