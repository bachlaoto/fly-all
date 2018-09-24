import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {FlightScheduleService} from '../../service/flight-schedule.service';
import {AirlineService} from '../../service/airline.service';
import {Airline} from '../../model/airline.model';

@Component({
  selector: 'app-add-flightschedule',
  templateUrl: './add-flightschedule.component.html',
  styleUrls: ['./add-flightschedule.component.css']
})
export class AddFlightscheduleComponent implements OnInit {

  addForm: FormGroup;
  submitted = false;
  airlines: Airline[];

  constructor(private formBuilder: FormBuilder, private router: Router, private flightScheduleService: FlightScheduleService
    , private airlineService: AirlineService) {
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
    this.flightScheduleService.createFlightSchedule(this.addForm.value)
      .subscribe(data => {
        this.router.navigate(['list-flightSchedule']);
      });
    this.airlineService.getAirline()
      .subscribe(data => {
        this.airlines = data;
      });
  }

}
