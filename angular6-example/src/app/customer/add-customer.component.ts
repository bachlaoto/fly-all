// import {Component, OnInit} from '@angular/core';
// import {Router} from '@angular/router';
//
// import {Customer} from '../model/customer.model';
// import {CustomerService} from '../service/customer.service';
//
// @Component({
//   selector: 'app-customer',
//   templateUrl: './add-customer.component.html'
// })
// export class AddCustomerComponent implements OnInit {
//
//   customer: Customer;
//
//   constructor(private router: Router, private customerService: CustomerService) {
//
//   }
//
//   ngOnInit() {
//     this.customer = new Customer();
//   }
//
//   createCustomer(): void {
//     this.customerService.createCustomer(this.customer)
//       .subscribe(data => {
//         alert('Customer created successfully.');
//       });
//
//   }
//
// }

import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../service/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './add-customer.component.html'
})
export class AddCustomerComponent implements OnInit {

  addForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder, private router: Router, private customerService: CustomerService) {
  }

  get f() {
    return this.addForm.controls;
  }

  ngOnInit() {

    this.addForm = this.formBuilder.group({
      id: [],
      customerName: ['', Validators.required],
      otherDetails: ['', Validators.required]
    });

  }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.addForm.invalid) {
      return;
    }

    alert('Add customer succeful');
    this.customerService.createCustomer(this.addForm.value)
      .subscribe(data => {
        this.router.navigate(['customer']);
      });

  }

}

