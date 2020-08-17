import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/common/address';
import { ActivatedRoute, Router } from '@angular/router';
import { AddressService } from 'src/app/service/address.service';

@Component({
  selector: 'app-update-address',
  templateUrl: './update-address.component.html',
  styleUrls: ['./update-address.component.css']
})
export class UpdateAddressComponent implements OnInit {

  addressId: number;
  address: Address;

  constructor(private route: ActivatedRoute, private router: Router,
    private addressService: AddressService) { }

    ngOnInit() {
      this.address = new Address();
  
      this.addressId = this.route.snapshot.params['id'];
      
      this.addressService.getAddress(this.addressId)
        .subscribe(data => {
          console.log(data)
          this.address = data;
        }, error => console.log(error));
    }
  
    updateAddress() {
      this.addressService.updateAddress(this.addressId, this.address)
        .subscribe(data => console.log(data), error => console.log(error));
      this.address = new Address();
      this.gotoList();
    }
  
    onSubmit() {
      this.updateAddress();    
    }
  
    gotoList() {
      this.router.navigate(['/address']);
    }
  }

  
  