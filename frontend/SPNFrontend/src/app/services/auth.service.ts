import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/model/User';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  email:string=''

  getemail(){
    return this.email;
  }
  setemail(data:any){
    this.email=data;
  }

  constructor(private http:HttpClient) { }

  register(User:User):Observable<any>{
    return this.http.post("http://localhost:5078/api/v1/user/",User);
  }

  login(credentials:any):Observable<any>{
    return this.http.post("http://localhost:5078/api/v1/user/login",credentials);
  }

  isAuthenticated(token:any){
    return this.http.get('http://localhost:5078/api/v1/user/auth',token);
  }



  
}

  