import { Component, OnInit } from '@angular/core';
import {Product} from "../../models/product";
import {ProductService} from "../../services/product.service";
import {Router} from "@angular/router";
import {CartService} from "../../services/cart.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  products: Product[] = [];

  searchText = "";

  search() {
    this.productService.searchHomePage(this.searchText)
    this.router.navigate(["/","products"])
  }

  constructor(private productService: ProductService,
              private router: Router,
              private cartService: CartService) {
  }

  addToCart(product: Product) {
    this.cartService.addToCart(product);
    window.alert('Your product has been added to the cart!');
  }

  ngOnInit() {
    this.productService.getLastProduct().subscribe((data: Product[]) => {this.products=data;});
  }

}
