import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Product } from 'src/app/product';
import { ProductserviceService } from 'src/app/services/productservice.service';
import { Delivery } from 'src/app/class/delivery';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private service: ProductserviceService) { }

  isDelivery: boolean = false;
  test: boolean = false;
  deliveryData: any;
  delivery = new Delivery();
  ngOnInit(): void {
    console.warn("Data", this.data);

  }
  checkPincode(pid: any) {
    console.log("pid is", pid);
    console.log("pincode is", this.delivery.pincode);
    this.service.getAvailability(pid, this.delivery.pincode).subscribe((res) => {
      console.log(res, "res==>");
      this.deliveryData = res;
      console.log("deliver", res.expectedDeliveryTime);
      if (res.length) {
        this.isDelivery = true;
        this.test = false;
      }
      else {
        this.test = true;
        this.isDelivery = false;
      }
    });

  }

}
