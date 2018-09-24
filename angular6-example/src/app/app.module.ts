import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {routing} from './app.routing';
import {AuthenticationService} from './service/auth.service';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AddUserComponent} from './user/add-user/add-user.component';
import {EditUserComponent} from './user/edit-user/edit-user.component';
import {ListUserComponent} from './user/list-user/list-user.component';
import {UserService} from './service/user.service';
import {CustomerComponent} from './customer/customer.component';
import {AddCustomerComponent} from './customer/add-customer.component';
import {EditCustomerComponent} from './customer/edit-customer.component';
import {CustomerService} from './service/customer.service';
import {FlightScheduleService} from './service/flight-schedule.service';
import {ListFlightscheduleComponent} from './flightSchedule/list-flightschedule/list-flightschedule.component';
import {EditFlightscheduleComponent} from './flightSchedule/edit-flightschedule/edit-flightschedule.component';
import {AddFlightscheduleComponent} from './flightSchedule/add-flightschedule/add-flightschedule.component';
import {HeaderComponent} from './header/header.component';
import {AirlineService} from './service/airline.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListUserComponent,
    AddUserComponent,
    EditUserComponent,
    CustomerComponent,
    AddCustomerComponent,
    EditCustomerComponent,
    ListFlightscheduleComponent,
    EditFlightscheduleComponent,
    AddFlightscheduleComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    routing,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [AuthenticationService, UserService, CustomerService, FlightScheduleService, AirlineService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
