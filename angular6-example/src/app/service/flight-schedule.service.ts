import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {FlightSchedule} from '../model/flightSchedule.model';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class FlightScheduleService {

  private flightScheduleUrl = 'http://localhost:8080/flightSchedule';

  constructor(private http: HttpClient) {
  }

  // private flightScheduleUrl = '/api';

  public getFlightSchedule() {
    return this.http.get<FlightSchedule[]>(this.flightScheduleUrl + '/get');
  }

  public deleteFlightSchedule(id: number) {
    return this.http.delete(this.flightScheduleUrl + '/delete/' + id);
  }

  public createFlightSchedule(flightSchedule) {
    return this.http.post<FlightSchedule>(this.flightScheduleUrl + '/new', flightSchedule);
  }

  public getFlightScheduleById(id: number) {
    return this.http.get<FlightSchedule>(this.flightScheduleUrl + '/' + id + '/show');
  }

  // save(car: any): Observable<any> {
  //   let result: Observable<Object>;
  //   if (car['href']) {
  //     result = this.http.put(car.href, car);
  //   } else {
  //     result = this.http.post(this.CAR_API, car);
  //   }
  //   return result;
  // }
  updateFlightSchedule(flightSchedule: FlightSchedule) {
    return this.http.put(this.flightScheduleUrl + '/update', flightSchedule);
  }
}
