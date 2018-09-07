import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-add-flightschedule',
  templateUrl: './add-flightschedule.component.html',
  styleUrls: ['./add-flightschedule.component.css']
})
export class AddFlightscheduleComponent implements OnInit {

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
      arrivalTime: ['', Validators.required],
      departureTime: ['', Validators.required],
      flightNumber: ['', Validators.required],
      otherDetails: ['', Validators.required],
      airlineCode: ['', Validators.required]
    });

  }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.addForm.invalid) {
      return;
    }

    alert('Add flight schedule successful');
    this.customerService.createCustomer(this.addForm.value)
      .subscribe(data => {
        this.router.navigate(['list-flightSchedule']);
      });

  }

}
