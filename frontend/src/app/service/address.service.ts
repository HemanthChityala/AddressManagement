import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Address } from '../common/address';
import { throwError, Observable } from 'rxjs';
import { tap, catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class AddressService {
  private baseUrl = 'http://localhost:8085/showAll';
  private baseUrl1 = 'http://localhost:8085/addAddress/1';
  private baseUrl2 = 'http://localhost:8085/address';
  private baseurl3 = 'http://localhost:8085/showById';


  headers = new HttpHeaders()
    .set('Content-Type', 'application/json')
    .set('Accept', 'application/json');
  httpOptions = {
    headers: this.headers,
  };

  constructor(private http: HttpClient) {}

  private handleError(error: any) {
    console.error(error); //Created a function to handle and log errors, in case
    return throwError(error);
  }

  public getAddresses() {
    return this.http.get<Address[]>(this.baseUrl);
  }

  addAddress(address: Address): Observable<Address> {
    id1: 1;
    address.addressId = null;
    return this.http
      .post<Address>(this.baseUrl1, address, this.httpOptions)
      .pipe(
        tap((data) => console.log(data)),
        catchError(this.handleError)
      );
  }

  getAddress(id: number): Observable<any> {
    return this.http.get(`${this.baseurl3}/${id}`);
  }

  createAddress(address: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/${'add'}`, address);
 }

  updateAddress(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl2}/${'update'}/${id}`, value);
  }

  deleteAddress(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl2}/${'delete'}/${id}`, {
      responseType: 'text',
    });
  }

  getAddressList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/${'show'}`);
  }
}
