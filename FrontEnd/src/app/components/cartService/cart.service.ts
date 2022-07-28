import {Injectable, Input} from '@angular/core';
import {Product} from "../../models/product";
import {Observable} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class CartService {
  products: Product[] = [];
  done: boolean = false;

  addToCart(product: Product) {
    this.done = true;
    for(let i = 0; i < this.products.length; i++){
      if (this.products[i].id == product.id){
        this.done = false;
      }
    }

    if (!this.done){
      return this.products;
    }
    else {
      return this.products.push(product);
    }
  }

  delFromCart(index:any) {
    this.products.splice(index, 1);
  }

  getItems() {
    return this.products;
  }

  clearCart() {
   this.products.splice(0, this.products.length);
  }
  constructor() { }
}
