import { Component, OnChanges, OnInit } from '@angular/core';
import { ProductserviceService } from 'src/app/services/productservice.service';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ActivatedRoute, Router, RouterLink, RouterModule } from '@angular/router';
import { DetailsComponent } from '../details/details.component';
import { SearchProduct } from 'src/app/class/searchProduct';
import { DataTransferServiceService } from 'src/app/services/data-transfer-service.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  flag: boolean = false;
  receivedData: any;
  constructor(private readonly dial: MatDialog, private service: ProductserviceService, private dialog: MatDialog, private route: ActivatedRoute, private dataService: DataTransferServiceService, private router: Router) {

    this.receivedData = dataService.dataFromService;

  }

  description: any;
  msg: any;
  pId: any = 0;
  result: boolean = false;
  readData: any;
  data: any;


  SearchProduct = new SearchProduct();
  ngOnInit(): void {
    this.SearchProduct.pname = '';
    this.flag = this.dataService.dataFromService;
    this.service.getAllData().subscribe((res) => {
      console.log(res, "res==>");
      this.readData = res;
      //this.readData=this.dataService.dataFromService;

      this.dataService.dataFromService = this.readData;

    });
    console.log("rd", this.receivedData);

  }


  showAllProds() {
    this.SearchProduct.pname = '';
    this.service.getAllData().subscribe((res) => {
      this.result = false;
      console.log(res, "res==>");
      this.readData = res;
      console.log("read", this.readData);

    });

  }
  checkDetails(pId: any) {

    this.service.getSingleData(pId).subscribe((res) => {
      console.log(res, "res==>");
      this.description = res;

      console.log("description", this.description);

      const dialogRef = this.dialog.open(DetailsComponent, {

        width: '40%',
        height: '80%',
        data: {
          image: res.image,
          brand: res.brand,
          code: res.code,
          id: res.pId,
          name: res.name,
          price: res.price,
          des: res.desc

        },
      });
    });
  }

  searchProduct(pname: any) {

    this.service.getCustomSearch(this.SearchProduct.pname).subscribe(
      (res) => {
        console.log(res, "querry==>");
        this.readData = res;
        if (this.readData.length) {
          this.result = false;

        } else {
          this.result = true;

        }
      }

    );
  }



  sortAsc() {
    if (this.SearchProduct.pname == '') {
      this.service.sortAllByPriceAsc().subscribe((res) => {
        this.result = false;
        console.log(res, "res sorted==>");
        this.readData = res;
      });
    }
    else {
      this.service.sortPriceAsc(this.SearchProduct.pname).subscribe((res) => {
        console.log(res, "res sorted==>");
        this.readData = res;
      });
    }
  }

  sortDesc() {

    if (this.SearchProduct.pname == '') {
      this.service.sortAllByPriceDesc().subscribe((res) => {
        this.result = false;
        console.log(res, "res sorted==>");
        this.readData = res;
      });
    }
    else {
      this.service.sortPriceDesc(this.SearchProduct.pname).subscribe((res) => {
        console.log(res, "res sorted==>");
        this.readData = res;
      });
    }
  }

  logout() {
    this.dataService.dataFromService = false;
    this.router.navigateByUrl("/home");
  }


}
