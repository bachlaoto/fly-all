// import { Component, OnInit } from '@angular/core';
// import {CustomerService, UserService} from '../service/customer.service';
// import {Router} from '@angular/router';
// import {FormBuilder, FormGroup, Validators} from '@angular/forms';
// import {first} from 'rxjs/operators';
// import {Customer} from '../models/customer.model';
//
// @Component({
//   selector: 'app-edit-customer',
//   templateUrl: './edit-customer.component.html',
//   styleUrls: ['./edit-customer.component.css']
// })
// export class EditCustomerComponent implements OnInit {
//
//   customer: Customer;
//   editForm: FormGroup;
//   constructor(private formBuilder: FormBuilder, private router: Router, private customerService: CustomerService) { }
//
//   ngOnInit() {
//     const customerId = localStorage.getItem('editCustomerId');
//     if(!customerId) {
//       alert('Invalid action.')
//       this.router.navigate(['list-customer']);
//       return;
//     }
//     this.editForm = this.formBuilder.group({
//       id: [],
//       email: ['', Validators.required],
//       firstName: ['', Validators.required],
//       lastName: ['', Validators.required]
//     });
//     this.customerService.getCustomerById(+customerId)
//       .subscribe( data => {
//         this.editForm.setValue(data);
//       });
//   }
//
//   onSubmit() {
//     this.customerService.updateCustomer(this.editForm.value)
//       .pipe(first())
//       .subscribe(
//         data => {
//           this.router.navigate(['list-customer']);
//         },
//         error => {
//           alert(error);
//         });
//   }
//
// }
