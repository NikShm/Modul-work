import { Injectable } from '@angular/core';
import {Product} from "../../models/product";
import {Observable} from "rxjs";
import {Page} from "../../models/page";
import {map} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
@Injectable({
  providedIn: 'root'
})
export class FavouriteService {
  products: Product[] = [];
  done: boolean = false;

  addToFavourite(product: Product) {
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

  delFromFavourite(index:any) {
    this.products.splice(index, 1);
  }

  getItemsFromFav() {
    return this.products;
  }

  clearFavourite() {
    this.products.splice(0, this.products.length);
  }
  constructor(private http: HttpClient) { }
}
