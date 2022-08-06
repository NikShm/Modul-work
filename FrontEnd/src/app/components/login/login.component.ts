import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {User} from "../../models/user";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login = "";

  password = "";

  constructor(private userService: UserService, private router:Router) { }

  submit(){
     this.userService.getUser(this.login, this.password).subscribe((user: User) => {
       if(user.role == "ADMIN"){
         localStorage.setItem("user", JSON.stringify(user))
         this.router.navigate([""]).then(() => window.setTimeout(()=> {alert("Welcome " + user.login)}, 100))
       }else {
         window.alert("You entered the wrong login or password")
       }
     })
  }

  ngOnInit(): void {
  }

}
