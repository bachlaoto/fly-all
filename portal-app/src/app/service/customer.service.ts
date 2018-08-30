import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Customer} from '../models/customer.model';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class CustomerService {

  private userUrl = 'http://localhost:8080/customer';

  constructor(private http: HttpClient) {
  }

  // private userUrl = '/api';

  public getCustomer() {
    return this.http.get<Customer[]>(this.userUrl + '/get');
  }

  public deleteCustomer(id) {
    return this.http.delete(this.userUrl + '/delete' + id);
  }

  public createCustomer(customer) {
    return this.http.post<Customer>(this.userUrl + 'new', customer);
  }

}
