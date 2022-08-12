import { Component } from '@angular/core';
import {Search} from "./models/search";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  user = {login:"user", role:"CUSTOMER"};
  ngOnInit(){
      if(localStorage.getItem("user") == null){
        localStorage.setItem("user",JSON.stringify(this.user))
      }
      if(localStorage.getItem("searchParameter") == null){
          localStorage.setItem("searchParameter",JSON.stringify(new Search(null, "", 0, 0, "name", "ASC", 0, 25, null)))
      }
  }
}