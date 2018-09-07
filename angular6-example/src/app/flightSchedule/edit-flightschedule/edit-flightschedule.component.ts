import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {first} from 'rxjs/operators';
import {FlightScheduleService} from '../../service/flight-schedule.service';
import {FlightSchedule} from '../../model/flightSchedule.model';

@Component({
  selector: 'app-edit-flightschedule',
  templateUrl: './edit-flightschedule.component.html',
  styleUrls: ['./edit-flightschedule.component.css']
})
export class EditFlightscheduleComponent implements OnInit {

  flightSchedule: FlightSchedule;
  editForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private flightScheduleService: FlightScheduleService) {
  }

  ngOnInit() {
    const flightScheduleId = localStorage.getItem('editFlightScheduleId');
    if (!flightScheduleId) {
      alert('Invalid action.');
      this.router.navigate(['list-flightSchedule']);
      return;
    }
    this.editForm = this.formBuilder.group({
      id: [],
      arrivalTime: ['', Validators.required],
      departureTime: ['', Validators.required],
      flightNumber: ['', Validators.required],
      otherDetails: ['', Validators.required],
      airlineCode: ['', Validators.required]
    });
    this.flightScheduleService.getFlightScheduleById(+flightScheduleId)
      .subscribe(data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {
    this.flightScheduleService.updateFlightSchedule(this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['list-flightSchedule']);
        },
        error => {
          alert(error);
        });
  }

}
