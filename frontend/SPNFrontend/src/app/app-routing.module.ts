import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { AccountComponent } from './components/account/account.component';
import { BalanceComponent } from './components/balance/balance.component';
import { CreditcardComponent } from './components/creditcard/creditcard.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { DepositComponent } from './components/deposit/deposit.component';
import { DisplayaccountComponent } from './components/displayaccount/displayaccount.component';
import { DisplaycreditcardComponent } from './components/displaycreditcard/displaycreditcard.component';
import { DisplayloanComponent } from './components/displayloan/displayloan.component';
import { LoanComponent } from './components/loan/loan.component';
import { LoginComponent } from './components/login/login.component';
import { MainComponent } from './components/main/main.component';
import { PayloanComponent } from './components/payloan/payloan.component';
import { RegisterComponent } from './components/register/register.component';
import { WithdrawComponent } from './components/withdraw/withdraw.component';

const routes: Routes = [
  {path:'',component:RegisterComponent},
  {path:'login',component:LoginComponent},
  {path:'dashboard',component:DashboardComponent,canActivate:[AuthGuard]},
  {path:'main',component:MainComponent,canActivate:[AuthGuard]},
  {path:'creditcard',component:CreditcardComponent,canActivate:[AuthGuard]},
  {path:'displaycreditcard',component:DisplaycreditcardComponent,canActivate:[AuthGuard]},
  {path:'account',component:AccountComponent,canActivate:[AuthGuard]},
  {path:'balance',component:BalanceComponent,canActivate:[AuthGuard]},
  {path:'deposit',component:DepositComponent,canActivate:[AuthGuard]},
  {path:'withdraw',component:WithdrawComponent,canActivate:[AuthGuard]},
  {path:'displayaccount',component:DisplayaccountComponent,canActivate:[AuthGuard]},
  {path:'loan',component:LoanComponent,canActivate:[AuthGuard]},
  {path:'payloan',component:PayloanComponent,canActivate:[AuthGuard]},
  {path:'displayloan',component:DisplayloanComponent,canActivate:[AuthGuard]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
