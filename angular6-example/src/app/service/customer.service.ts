import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Customer} from '../model/customer.model';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class CustomerService {

  private customerUrl = 'http://localhost:8080/customer';

  constructor(private http: HttpClient) {
  }

  // private customerUrl = '/api';

  public getCustomer() {
    return this.http.get<Customer[]>(this.customerUrl + '/get');
  }

  public deleteCustomer(id: number) {
    return this.http.delete(this.customerUrl + '/delete/' + id);
  }

  public createCustomer(customer) {
    return this.http.post<Customer>(this.customerUrl + '/new', customer);
  }

  public getCustomerById(id: number) {
    return this.http.get<Customer>(this.customerUrl + '/' + id + '/show');
  }

  // save(car: any): Observable<any> {
  //   let result: Observable<Object>;
  //   if (car['href']) {
  //     result = this.http.put(car.href, car);
  //   } else {
  //     result = this.http.post(this.CAR_API, car);
  //   }
  //   return result;
  // }
  updateCustomer(customer: Customer) {
    return this.http.put(this.customerUrl + '/update', customer);
  }
}
