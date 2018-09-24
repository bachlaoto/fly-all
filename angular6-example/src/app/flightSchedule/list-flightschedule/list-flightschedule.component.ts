import {Component, OnInit} from '@angular/core';
import {FlightSchedule} from '../../model/flightSchedule.model';
import {Router} from '@angular/router';
// import {FlightScheduleService} from '../../service/flightSchedule.service';
// import {FlightSchedule} from '../../model/flightSchedule.model';
import {FlightScheduleService} from '../../service/flight-schedule.service';
import {Airline} from '../../model/airline.model';

@Component({
  selector: 'app-list-flightschedule',
  templateUrl: './list-flightschedule.component.html',
  styleUrls: ['./list-flightschedule.component.css']
})
export class ListFlightscheduleComponent implements OnInit {

  flightSchedules: FlightSchedule[];
  airlines: Airline[];
  constructor(private router: Router, private flightScheduleService: FlightScheduleService) {

  }

  ngOnInit() {
    // if ( sessionStorage.getItem('loginok') == null) {
    //   this.router.navigate(['']);
    // } else {
    //   this.flightScheduleService.getFlightSchedule()
    //     .subscribe(data => {
    //       this.flightSchedules = data;
    //     });
    // }
    if (sessionStorage.getItem('loginok') == null) {
      this.router.navigate(['']);
    }
    this.flightScheduleService.getFlightSchedule()
      .subscribe(data => {
        this.flightSchedules = data;
      });

  }

  deleteFlightSchedule(flightSchedule: FlightSchedule): void {
    this.flightScheduleService.deleteFlightSchedule(flightSchedule.id)
      .subscribe(data => {
        this.flightSchedules = this.flightSchedules.filter(u => u !== flightSchedule);
      });
  }

  editFlightSchedule(flightSchedule: FlightSchedule): void {
    localStorage.removeItem('editFlightScheduleId');
    localStorage.setItem('editFlightScheduleId', flightSchedule.id.toString());
    this.router.navigate(['edit-flightSchedule']);
  }

}
