import {Component, Input, OnInit} from '@angular/core';
import {CartService} from "../cartService/cart.service";
import {ActivatedRoute } from '@angular/router';
import {Product} from "../../models/product";
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  @Input() quantity: number = 0;
  products = this.cartService.getItems();

  constructor(
      private route: ActivatedRoute,
      public cartService: CartService,

  ) { }

  ngOnInit(): void {
  }

  clearCart(){
    this.cartService.clearCart();
  }

  delFromCart(product: Product): void {
    const index: number = this.products.indexOf(product);
    this.cartService.delFromCart(index);
    window.alert('Your product will be delete from the cart!');
  }

  totalSum(){
    this.cartService.totalSum();
  }

}
