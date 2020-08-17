import { AddressListComponent } from "../address-list/address-list.component";
import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/common/address';
import { ActivatedRoute, Router } from '@angular/router';
import { AddressService } from 'src/app/service/address.service';

@Component({
  selector: 'app-address-details',
  templateUrl: './address-details.component.html',
  styleUrls: ['./address-details.component.css']
})
export class AddressDetailsComponent implements OnInit {

  addressId: number;
  address: Address;

  constructor(private route: ActivatedRoute,private router :Router,
    private addressService: AddressService ) { }

  ngOnInit() {
    this.address = new Address();

    this.addressId = this.route.snapshot.params['id'];
    
    this.addressService.getAddress(this.addressId)
      .subscribe(data => {
        console.log(data)
        this.address = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['address']);
  }

  updateAddress(id: number){
    this.router.navigate(['update', id]);
  }
  
}