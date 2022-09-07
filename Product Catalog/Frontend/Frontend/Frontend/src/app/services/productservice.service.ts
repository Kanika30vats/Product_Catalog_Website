import { HttpClient, JsonpClientBackend } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Product } from '../product';  

@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {

  constructor(private _http: HttpClient) { }
  public getAllData():Observable<any>{
    return this._http.get<any>("http://localhost:8000/allProduct")
  }
  public  getDesc(pId:any):Observable<any>{
    let ids=pId;
    return this._http.get(`http://localhost:8000/desc/${pId}`,{responseType:'text'});
  }
  
  public getSingleData(pId:any):Observable<any>{
    return this._http.get<any>(`http://localhost:8000/singleProduct/${pId}`);
  }

  public getAvailability(pid:any,pincode:any):Observable<any>{
    return this._http.get<any>(`http://localhost:8000/searchPincode?pid=${pid}&pincode=${pincode}`);
  }

  public getCustomSearch(pname:any):Observable<any>{
    return this._http.get<any>(`http://localhost:8000/searchByNameBrandCode?name=${pname}&brand=${pname}&code=${pname}`);
  }

  public sortAllByPriceAsc():Observable<any>{
    return this._http.get<any>(`http://localhost:8000/sortAllByPriceAsc`);
  }

  public sortAllByPriceDesc():Observable<any>{
    return this._http.get<any>(`http://localhost:8000/sortAllByPriceDesc`);
  }

  public sortPriceAsc(pname:any):Observable<any>{
    return this._http.get<any>(`http://localhost:8000/sortbyPriceAsc?name=${pname}&brand=${pname}&code=${pname}`);
  }

  public sortPriceDesc(pname:any):Observable<any>{
    return this._http.get<any>(`http://localhost:8000/sortbyPriceDesc?name=${pname}&brand=${pname}&code=${pname}`);
  }


}


