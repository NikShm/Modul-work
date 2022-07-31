import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  user = {name:"user", role:"NONE"};
  ngOnInit(){
      if(localStorage.getItem(this.user.name) == null){
        localStorage.setItem(this.user.name,this.user.role)
      }
  }
}