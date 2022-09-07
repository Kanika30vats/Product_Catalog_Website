import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/class/customer';
import { DataTransferServiceService } from 'src/app/services/data-transfer-service.service';
import { RegistrationService } from 'src/app/services/registration.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  customer = new Customer();
  msg: any;
  flag: boolean = false;
  constructor(private _service: RegistrationService, private router: Router, private dataService: DataTransferServiceService) { }

  ngOnInit(): void {
    this.flag = false;
  }

  loginCustomer() {


    this._service.loginCustomerFromRemote(this.customer).subscribe(
      data => {
        console.log("response received");
        this.flag = true;
        this.dataService.dataFromService = this.flag;
        this.router.navigate(['/loginSuccess']);

      },

      error => {
        console.log("Exception occured");
        this.msg = "Enter valid details !";
      }
    )
  }

  registrationRedirect() {
    this.flag = false;
    this.dataService.dataFromService = this.flag;
    this.router.navigate(['/registration'])
  }

}
