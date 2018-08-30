import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {UserComponent} from './user/user.component';
import {AddUserComponent} from './user/add-user.component';
import {CustomerComponent} from './customer/customer.component';
import {AddCustomerComponent} from './customer/add-customer.component';

const routes: Routes = [
  {path: 'users', component: UserComponent},
  {path: 'add', component: AddUserComponent},
  {path: 'customers', component: CustomerComponent},
  {path: 'addCustomer', component: AddCustomerComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule {
}
