import {Component, OnInit} from '@angular/core';
import {Product} from "../../models/product";
import {ProductService} from "../../services/product.service";
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

    searchParameter = this.productService.getSearchParameter();//new Search(null, "", 0, 0, "name", "ASC", 0, 6, null);

    clear() {
        this.searchParameter.categoryType = null;
        this.searchParameter.brand = "";
        this.searchParameter.name = "";
        this.searchParameter.sortField = "name";
        this.searchParameter.sortDirection = "ASC";
        this.sortValue = "";
    }

    setCategory(event: any) {
        if (event.target.value == "null") {
            this.searchParameter.categoryType = null
        } else {
            this.searchParameter.categoryType = event.target.value
        }
    }

    changePage(page: number) {
        this.searchParameter.page = page;
        this.productService.setSearchParameter(this.searchParameter)
        this.search();
    }

    setSorted() {
        this.searchParameter.page -= this.searchParameter.page == 0 ? 0 : 1;
        switch (this.sortValue) {
            case "NameUp": {
                this.searchParameter.sortField = "name";
                this.searchParameter.sortDirection = "ASC";
                break;
            }
            case "NameDown": {
                this.searchParameter.sortField = "name";
                this.searchParameter.sortDirection = "DESC";
                break;
            }
            case "PriceUp": {
                this.searchParameter.sortField = "price";
                this.searchParameter.sortDirection = "ASC";
                break;
            }
            case "PriceDown": {
                this.searchParameter.sortField = "price";
                this.searchParameter.sortDirection = "DESC";
                break;
            }
            default: {
                break;
            }
        }
    }

    getFirst() {
        this.searchParameter.page = 0;
        this.productService.setSearchParameter(this.searchParameter)
        this.search()
    }

    getLast() {
        if (this.pageCount != 0) {
            this.searchParameter.page = this.pageCount - 1;
        }
        this.productService.setSearchParameter(this.searchParameter)
        this.search()
    }

    constructor(
        private productService: ProductService,
        private cartService: CartService,
        private favouriteService: FavouriteService) {
    }

    search() {
        this.productService.search().subscribe((page: Page) => {
            this.products = page.products;
            this.allProduct = page.totalItem;
            this.pageCount = page.pageCount
        });
    }

    ngOnInit() {
        this.search();
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
