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
    styleUrls: ['../../shared/css/search-container.css','../../shared/css/products-container.css', './products.component.css']
})
export class ProductsComponent implements OnInit {
    products: Product[] = [];
    brands: Brand[] = [];
    allProduct = 0;
    pageCount = 1;
    sortValue = "NameUp";
    classCreateButton = "";
    searchParameter = new Search("", "", 0, 0, "name", "ASC", 0, 25, null);

    clear() {
        this.searchParameter.categoryType = null;
        this.searchParameter.brand = "";
        this.searchParameter.name = "";
        this.searchParameter.sortField = "name";
        this.searchParameter.sortDirection = "ASC";
        this.searchParameter.priceFrom = 0;
        this.searchParameter.priceTo = 0;
        this.sortValue = "NameUp";
    }

    setCategory(event: any) {
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
        this.searchParameter.name = this.searchParameter.name.trim();
        this.searchParameter.page = 0;
        this.productService.setSearchParameter(this.searchParameter);
        this.search();
    }

    changePage(page: number) {
        this.searchParameter.page = page;
        this.productService.setSearchPage(page);
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
        this.searchParameter.page = 0;
        this.productService.setSearchPage(0);
        this.search()
    }

    getLast() {
        this.searchParameter.page = this.pageCount != 0 ? this.pageCount - 1 : 1;
        this.productService.setSearchPage(this.pageCount != 0 ? this.pageCount - 1 : 1);
        this.search()
    }

    constructor(
        private productService: ProductService,
        private cartService: CartService,
        private favouriteService: FavouriteService,
        private router: Router) {
    }

    search() {
        this.productService.search().subscribe((page: Page) => {
            this.products = page.products;
            this.allProduct = page.totalItem;
            this.pageCount = page.pageCount
        });
    }

    ngOnInit() {
        this.productService.getBrands().subscribe(val => {
            this.brands = val;
        });
        this.search();
        if (JSON.parse(localStorage.getItem("user")!).role == "ADMIN") {
            this.classCreateButton = "fas fa-plus-circle"
        } else {
            this.classCreateButton = ""
        }
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
        if (JSON.parse(localStorage.getItem("user")!).role == "ADMIN") {
            this.router.navigate(['products/new']);
        }
    }
}
