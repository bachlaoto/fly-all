import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {Customer} from '../models/customer.model';
import {CustomerService} from '../service/customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './add-customer.component.html'
})
export class AddCustomerComponent implements OnInit {

  customer: Customer;

  constructor(private router: Router, private customerService: CustomerService) {

  }

  ngOnInit() {
    this.customer = new Customer();
  }

  createCustomer(): void {
    this.customerService.createCustomer(this.customer)
      .subscribe(data => {
        alert('Customer created successfully.');
      });

  }

}
