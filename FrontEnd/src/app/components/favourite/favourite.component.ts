import {Component, Input, OnInit} from '@angular/core';
import {FavouriteService} from "../../services/favourite.service";
import {Product} from "../../models/product";
import {CartService} from "../../services/cart.service";

@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavouriteComponent implements OnInit {
    @Input() quantity: number = 0;
    products = this.favouriteService.getItemsFromFav();
    pageFav = {page: 0, pageSize: 5, allProduct: 0, pageCount: 1}

  constructor(
      private favouriteService: FavouriteService,
      private cartService: CartService,
  ) { }

  ngOnInit(): void {
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
      window.alert('Your product will be deleted from the favourites!');
  }
}
