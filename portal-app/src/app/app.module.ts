import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {UserComponent} from './user/user.component';
import {AppRoutingModule} from './app.routing.module';
import {UserService} from './user/user.service';
import {HttpClientModule} from '@angular/common/http';
import {AddUserComponent} from './user/add-user.component';
import {CustomerComponent} from './customer/customer.component';
import {CustomerService} from './service/customer.service';
import {MyNewDirectiveDirective} from './customer/my-new-directive.directive';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    AddUserComponent,
    CustomerComponent,
    MyNewDirectiveDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService, CustomerService],

  bootstrap: [AppComponent]
})
export class AppModule {
}
