import {Component, OnInit} from '@angular/core';
import {Customer} from '../models/customer.model';
import {CustomerService} from '../service/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customers: Customer[];

  constructor(private router: Router, private customerService: CustomerService) {

  }

  ngOnInit() {
    this.customerService.getCustomer()
      .subscribe(data => {
        this.customers = data;
      });
  }

  deleteCustomer(customer: Customer): void {
    this.customerService.deleteCustomer(customer.id)
      .subscribe(data => {
        this.customers = this.customers.filter(u => u !== customer);
      });
  }

  // editCustomer(customer: Customer): void {
  //   localStorage.removeItem("editUserId");
  //   localStorage.setItem("editUserId", user.id.toString());
  //   this.router.navigate(['edit-user']);
  // };
}
