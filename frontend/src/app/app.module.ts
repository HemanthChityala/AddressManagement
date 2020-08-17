import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CreateAddressComponent } from './component/create-address/create-address.component';
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { AddressService } from './service/address.service';

import { AddressListComponent } from './component/address-list/address-list.component';

import { AddressDetailsComponent } from './component/address-details/address-details.component';

import { UpdateAddressComponent } from './component/update-address/update-address.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateAddressComponent,
    AddressDetailsComponent,
    AddressListComponent,
    UpdateAddressComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    ConfirmationPopoverModule.forRoot({
      confirmButtonType: 'danger',
    }),
  ],
  providers: [AddressService],
  bootstrap: [AppComponent],
})
export class AppModule {}
