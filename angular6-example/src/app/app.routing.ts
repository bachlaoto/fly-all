import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {AddUserComponent} from './user/add-user/add-user.component';
import {ListUserComponent} from './user/list-user/list-user.component';
import {EditUserComponent} from './user/edit-user/edit-user.component';
import {AddCustomerComponent} from './customer/add-customer.component';
import {EditCustomerComponent} from './customer/edit-customer.component';
import {CustomerComponent} from './customer/customer.component';
import {ListFlightscheduleComponent} from './flightSchedule/list-flightschedule/list-flightschedule.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'add-user', component: AddUserComponent},
  {path: 'add-customer', component: AddCustomerComponent},
  {path: 'list-user', component: ListUserComponent},
  {path: 'customer', component: CustomerComponent},
  {path: 'list-flightschedule', component: ListFlightscheduleComponent},
  {path: 'edit-user', component: EditUserComponent},
  {path: 'edit-customer', component: EditCustomerComponent},
  {path: '', component: LoginComponent}
];

export const routing = RouterModule.forRoot(routes);
