import {Component, OnInit} from '@angular/core';
import {Product} from "../../models/product";
import {ProductService} from "../../services/product.service";
import {Page} from "../../models/page";
import {CartService} from "../../services/cart.service";
import {FavouriteService} from "../../services/favourite.service";
import {Search} from "../../models/search";
import {Router} from '@angular/router';
import {Brand} from 'src/app/models/brand';

@Component({
    selector: 'app-products',
    templateUrl: './products.component.html',
    styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

    products: Product[] = [];
    brands: Brand[] = [];
    allProduct = 0;
    pageCount = 1;
    sortValue = "";
    searchParameter = new Search(null, "", 0, 0, "name", "ASC", 0, 25, null);

    clear() {
        this.searchParameter.categoryType = null;
        this.searchParameter.brand = "";
        this.searchParameter.name = "";
        this.searchParameter.sortField = "name";
        this.searchParameter.sortDirection = "ASC";
        this.searchParameter.priceFrom = 0;
        this.searchParameter.priceTo = 0;
        this.sortValue = "";
    }

    setCategory(event: any) {
        console.log(event.target.value)
        if (event.target.value == "null") {
            this.searchParameter.categoryType = null
        } else {
            this.searchParameter.categoryType = event.target.value
        }
    }

    setCategoryWithHeader(event: any) {
        this.searchParameter.categoryType = event.target.name
        this.apply()

    }

    getCategory() {
        return this.searchParameter.categoryType;
    }

    apply() {
        this.searchParameter.page = 0;
        this.search();
    }

    changePage(page: number) {
        window.scroll(0,0);
        this.searchParameter.page = page;
        this.search();
    }

    setSorted() {
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
        window.scroll(0,0);
        this.searchParameter.page = 0;
        this.search()
    }

    getLast() {
        this.searchParameter.page = this.pageCount - 1;
        this.search()
    }

    constructor(
        private productService: ProductService,
        private cartService: CartService,
        private favouriteService: FavouriteService,
        private router: Router) {
    }

    search() {
        this.productService.search(this.searchParameter).subscribe((page: Page) => {
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

    openCreatePage() {
        this.router.navigate(['products/new']);
    }
}
