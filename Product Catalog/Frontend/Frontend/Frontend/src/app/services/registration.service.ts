import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http'
import { Customer } from '../class/customer';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private _http: HttpClient) { }

  public loginCustomerFromRemote(customer: Customer):Observable<any>{
    return this._http.post<any>("http://localhost:8000/loginUser", customer)
  }

  public registerUserFromRemote(customer: Customer):Observable<any>{
    return this._http.post<any>("http://localhost:8000/registerUser", customer)
  }
}
