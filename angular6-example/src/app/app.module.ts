import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {routing} from './app.routing';
import {AuthenticationService} from './service/auth.service';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AddUserComponent} from './add-user/add-user.component';
import {EditUserComponent} from './edit-user/edit-user.component';
import {ListUserComponent} from './list-user/list-user.component';
import {UserService} from './service/user.service';
import {CustomerComponent} from './customer/customer.component';
import {AddCustomerComponent} from './customer/add-customer.component';
import {EditCustomerComponent} from './customer/edit-customer.component';
import {CustomerService} from './service/customer.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListUserComponent,
    AddUserComponent,
    EditUserComponent,
    CustomerComponent,
    AddCustomerComponent,
    EditCustomerComponent
  ],
  imports: [
    BrowserModule,
    routing,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [AuthenticationService, UserService, CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
