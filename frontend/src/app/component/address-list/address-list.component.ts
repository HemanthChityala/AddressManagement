import { Component, OnInit } from '@angular/core';
import { AddressService } from 'src/app/service/address.service';
import { Address } from 'src/app/common/address';
import { Observable } from "rxjs";
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-address-list',
  templateUrl: './address-list.component.html',
  styleUrls: ['./address-list.component.css']
})

export class AddressListComponent implements OnInit {

  address: Observable<Address[]>;

  id: BigInteger;

  public popoverTitle:string ="Delete Address Confirmation";
  public popoverMessage:string="Do you really want to delete this record";
  public cancelClicked:boolean= false;
//


  addresses:Address[];

  constructor(private _addressService: AddressService,private route: ActivatedRoute,private router: Router) { }

  

  ngOnInit(): void {
    this.listAddress();
    this.id = this.route.snapshot.params['id'];

  }

  reloadData() {
    this.address = this._addressService.getAddresses();
  }

  deleteAddress(addressId: number) {
    this._addressService.deleteAddress(addressId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }


 listAddress(){
   this._addressService.getAddresses().subscribe(
     data => this.addresses =data);
 }

//  updateAddress(id: number){
//   this.router.navigate(['update', id]);
// }


addressDetails(id: number){
  this.router.navigate(['details', id]);
}

}