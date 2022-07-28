import {Component, Input, OnInit} from '@angular/core';
import {CartService} from "../../services/cart.service";
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
  sum: number = 0;
  done: boolean = false;
  pageFav = {page: 0, pageSize: 5, allProduct: 0, pageCount: 1}

  constructor(
      private route: ActivatedRoute,
      private cartService: CartService,
  ) { }

  ngOnInit(): void {
  }

  clearCart(){
    this.cartService.clearCart();
  }

  delFromCart(product: Product): void {
    const index: number = this.products.indexOf(product);
    this.cartService.delFromCart(index);
    window.alert('Your product will be deleted from the cart!');
  }

  totalSum(){
    this.sum = 0;
    for(let i = 0; i < this.products.length; i++){
      this.sum += Number(this.products[i].price);
      this.done = true;
    }
    return this.sum;
  }

}
