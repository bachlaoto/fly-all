import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Airline} from '../model/airline.model';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class AirlineService {

  private airlineUrl = 'http://localhost:8080/airline';

  constructor(private http: HttpClient) {
  }

  // private airlineUrl = '/api';

  public getAirline() {
    return this.http.get<Airline[]>(this.airlineUrl + '/get');
  }

  public deleteAirline(id: number) {
    return this.http.delete(this.airlineUrl + '/delete/' + id);
  }

  public createAirline(airline) {
    return this.http.post<Airline>(this.airlineUrl + '/new', airline);
  }

  public getAirlineById(id: number) {
    return this.http.get<Airline>(this.airlineUrl + '/' + id + '/show');
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
  updateAirline(airline: Airline) {
    return this.http.put(this.airlineUrl + '/update', airline);
  }
}
