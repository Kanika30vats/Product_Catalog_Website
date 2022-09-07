import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/class/customer';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  customer = new Customer();
  msg: any;
  constructor(private service: RegistrationService, private router: Router) { }

  ngOnInit(): void {
  }

  registerCustomer(confirmPass: any) {

    if (this.customer.password == confirmPass.value) {
      this.service.registerUserFromRemote(this.customer).subscribe(
        data => {
          this.msg = "Registration successful";
          this.router.navigate(['/login'])
        },
        error => {
          this.msg = "Username already registered!";
          // console.warn(this.msg);

        }

      )
    }
    else {
      this.router.navigate(['/registration']);
    }
  }


  login() {
    this.router.navigateByUrl("/home");
  }
}
