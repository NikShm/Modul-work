import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {User} from "../../models/user";
import {Observable} from "rxjs";
import {Page} from "../../models/page";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login = "";

  password = "";

  constructor(private userService: UserService) { }

  submit(){
     this.userService.getUser(this.login, this.password).subscribe((user: User) => {
       console.log(user)
       if(user.role != "NONE"){
         localStorage.setItem("user", user.role)
       }
     })
  }

  ngOnInit(): void {
  }

}
