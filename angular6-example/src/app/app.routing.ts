import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {AddUserComponent} from './add-user/add-user.component';
import {ListUserComponent} from './list-user/list-user.component';
import {EditUserComponent} from './edit-user/edit-user.component';
import {AddCustomerComponent} from './customer/add-customer.component';
import {EditCustomerComponent} from './customer/edit-customer.component';
import {CustomerComponent} from './customer/customer.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'add-user', component: AddUserComponent},
  {path: 'add-customer', component: AddCustomerComponent},
  {path: 'list-user', component: ListUserComponent},
  {path: 'customer', component: CustomerComponent},
  {path: 'edit-user', component: EditUserComponent},
  {path: 'edit-customer', component: EditCustomerComponent},
  {path: '', component: LoginComponent}
];

export const routing = RouterModule.forRoot(routes);
