import { Injectable } from '@angular/core';
import {Product} from "../../models/product";
import {Search} from "../../models/search";
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

  search(search:Search): Observable<Page> {
    console.log(search)
    return this.http.post('http://localhost:8080/api/favourite/search',search).pipe(map((data: any) => {
      console.log(data)
      return new Page(data.content,data.pageCount, data.page, data.pageSize);
    }));
  }
  constructor(private http: HttpClient) { }
}
