import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { map, Observable } from 'rxjs';
import { AuthService } from './services/auth.service';


@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

token=localStorage.getItem("token");
email=localStorage.getItem('email');
  constructor(private router:Router, private service:AuthService){}
  canActivate(): boolean  {
    if(this.service.isAuthenticated(this.token)){
      return true;
    }else{
      this.router.navigate(['/register']);
      return false;
    }
  }
}


