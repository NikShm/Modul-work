import { Component, OnInit } from '@angular/core';
import {Product} from "../../product";
import {ProductService} from "../../product.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.productService.getLastProduct().subscribe((data: Product[]) => {this.products=data;});
  }

}
