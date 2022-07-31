import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ProductService} from "../../../services/product.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  search(event:any) {
    this.saveCategory.emit(event)
    // this.productService.searchHeader(event.target.name)
    this.router.navigate(["/","products"])
  }

  @Output() saveCategory= new EventEmitter<any>()

  constructor(private productService: ProductService,
              private router: Router) {
  }

  ngOnInit(): void {
  }

  toAbout() {
    this.router.navigate([""]).then(()=>window.scroll(0,650))
  }

  toContact() {
    this.router.navigate([""]).then(()=> window.setTimeout(()=>{console.log("ss");window.scroll(0,2860)},100))//
  }
}