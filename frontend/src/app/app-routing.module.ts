import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddressService } from './service/address.service';
import { CreateAddressComponent } from './component/create-address/create-address.component';
import { UpdateAddressComponent } from './component/update-address/update-address.component';
import { AddressDetailsComponent } from './component/address-details/address-details.component';
import { AddressListComponent } from './component/address-list/address-list.component';

const routes: Routes = [
  { path: "", component: AddressListComponent },
  { path: "address", component: AddressListComponent },
  { path: "add", component: CreateAddressComponent },
  { path: "update/:id", component: UpdateAddressComponent },
  { path: "details/:id", component: AddressDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
