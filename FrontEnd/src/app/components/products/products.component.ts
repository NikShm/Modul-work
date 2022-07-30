import {Component, OnInit} from '@angular/core';
import {Product} from "../../models/product";
import {ProductService} from "../../services/product.service";
import {Search} from "../../models/search";
import {Page} from "../../models/page";

import {CartService} from "../../services/cart.service";
import {FavouriteService} from "../../services/favourite.service";

@Component({
    selector: 'app-products',
    templateUrl: './products.component.html',
    styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

    products: Product[] = [];

    allProduct = 0;

    pageCount = 1;

    sortValue = "";

    search = new Search(null, "", 0, 0, "name", "ASC", 0, 6, null);

    clear() {
        this.search.categoryType = "null";
        this.search.brand = this.search.sortField = this.search.sortDirection = "";
        this.sortValue = "";
    }

    setSorted() {
        this.search.page -= this.search.page == 0 ? 0 : 1;
        switch (this.sortValue) {
            case "NameUp": {
                this.search.sortField = "name";
                this.search.sortDirection = "ASC";
                break;
            }
            case "NameDown": {
                this.search.sortField = "name";
                this.search.sortDirection = "DESC";
                break;
            }
            case "PriceUp": {
                this.search.sortField = "price";
                this.search.sortDirection = "ASC";
                break;
            }
            case "PriceDown": {
                this.search.sortField = "price";
                this.search.sortDirection = "DESC";
                break;
            }
            default: {
                break;
            }
        }
    }

    getFirst() {
        this.search.page = 0;
        this.getSearch()
    }

    getLast() {
        if (this.pageCount != 0) {
            this.search.page = this.pageCount - 1;
        }
        this.getSearch()
    }

    constructor(
        private productService: ProductService,
        private cartService: CartService,
        private favouriteService: FavouriteService) {
    }

    getSearch() {
        this.productService.search(this.search).subscribe((page: Page) => {
            this.products = page.products;
            this.search.page = page.page + 1;
            this.search.pageSize = page.pageSize;
            this.allProduct = page.pageCount * page.pageSize;
            this.pageCount = page.pageCount
        });
    }

    ngOnInit() {
        this.productService.search(this.search).subscribe((page: Page) => {
            this.products = page.products;
            this.search.page = page.page;
            this.search.pageSize = page.pageSize;
            this.allProduct = page.pageCount * page.pageSize
        });
    }

    addToCart(product: Product) {
        this.cartService.addToCart(product);
        window.alert('Your product has been added to the cart!');
    }

    addToFavourite(product: Product) {
        this.favouriteService.addToFavourite(product);
        window.alert('Your product has been added to the favourites!');
    }
}
