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

  // deleteUser(user: User): void {
  //   this.userService.deleteUser(user)
  //     .subscribe( data => {
  //       this.users = this.users.filter(u => u !== user);
  //     })
  // };

}
