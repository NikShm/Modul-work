import {Component, Input, OnInit} from '@angular/core';
import {FavouriteService} from "../favouriteService/favourite.service";
import { ActivatedRoute } from '@angular/router';
import {Product} from "../../models/product";
import {ProductService} from "../../services/product.service";
import {CartService} from "../cartService/cart.service";
import {Page} from "../../models/page";
import {HttpClient} from "@angular/common/http";
import {Search} from "../../models/search";

@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavouriteComponent implements OnInit {
    @Input() quantity: number = 0;
    products = this.favouriteService.getItemsFromFav();
    search = new Search(null, "", 0, 0, "name", "ASC", 0, 6, null);
    allProduct = 0;
    pageCount = 1;

  constructor(
      private http: HttpClient,
      private route: ActivatedRoute,
      public favouriteService: FavouriteService,
      public cartService: CartService,
      private productService: ProductService
  ) { }

  ngOnInit(): void {
      this.productService.getAllProduct();
  }

  addToCart(product: Product) {
     this.cartService.addToCart(product);
     window.alert('Your product has been added to the cart!');
  }

  clearFavourite(){
      this.favouriteService.clearFavourite();
  }

  delFromFavourite(product: Product): void {
      const index: number = this.products.indexOf(product);
      this.favouriteService.delFromFavourite(index);
      window.alert('Your product will be delete from the favourite!');
  }
}
