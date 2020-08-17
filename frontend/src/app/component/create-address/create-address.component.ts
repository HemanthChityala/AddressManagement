import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/common/address';
import { AddressService } from 'src/app/service/address.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-address',
  templateUrl: './create-address.component.html',
  styleUrls: ['./create-address.component.css']
})
export class CreateAddressComponent implements OnInit {


  address: Address = new Address();
  submitted = false;

  constructor(private addressService: AddressService,
    private router: Router) { }

  ngOnInit(){
  }
 
  addAddress() {
    this.addressService.addAddress(this.address).subscribe(data => {
      this.address = data;
      console.log(this.address);
    });
    this.gotoList();
  }


  onSubmit(){
    this.submitted = true;
    this.addAddress();
  }

  gotoList(){
    this.router.navigate(['/address']);
  }


}
