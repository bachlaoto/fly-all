import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {AddUserComponent} from './user/add-user/add-user.component';
import {ListUserComponent} from './user/list-user/list-user.component';
import {EditUserComponent} from './user/edit-user/edit-user.component';
import {AddCustomerComponent} from './customer/add-customer.component';
import {EditCustomerComponent} from './customer/edit-customer.component';
import {CustomerComponent} from './customer/customer.component';
import {ListFlightscheduleComponent} from './flightSchedule/list-flightschedule/list-flightschedule.component';
import {EditFlightscheduleComponent} from './flightSchedule/edit-flightschedule/edit-flightschedule.component';
import {AddFlightscheduleComponent} from './flightSchedule/add-flightschedule/add-flightschedule.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'add-user', component: AddUserComponent},
  {path: 'add-customer', component: AddCustomerComponent},
  {path: 'add-flightSchedule', component: AddFlightscheduleComponent},
  {path: 'list-user', component: ListUserComponent},
  {path: 'customer', component: CustomerComponent},
  {path: 'list-flightSchedule', component: ListFlightscheduleComponent},
  {path: 'edit-user', component: EditUserComponent},
  {path: 'edit-customer', component: EditCustomerComponent},
  {path: 'edit-flightSchedule', component: EditFlightscheduleComponent},
  {path: '', component: LoginComponent}
];

export const routing = RouterModule.forRoot(routes);
