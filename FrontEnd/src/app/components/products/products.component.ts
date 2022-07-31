import {Component, OnInit} from '@angular/core';
import {Product} from "../../models/product";
import {ProductService} from "../../services/product.service";
import {Page} from "../../models/page";
import {HeaderComponent} from "../../shared/layout/header/header.component";
import {CartService} from "../../services/cart.service";
import {FavouriteService} from "../../services/favourite.service";
import { Router } from '@angular/router';
import { Brand } from 'src/app/models/brand';
import { BrandService } from 'src/app/services/brand.service';

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
    searchParameter = this.productService.getSearchParameter();//new Search(null, "", 0, 0, "name", "ASC", 0, 6, null);

    ngOnInit(): void {
        this.productService.getBrands().subscribe(val => {
            this.brands = val;
        });
        this.search();
    }

    clear() {
        this.searchParameter.categoryType = null;
        this.searchParameter.brand = "";
        this.searchParameter.name = "";
        this.searchParameter.sortField = "name";
        this.searchParameter.sortDirection = "ASC";
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
        console.log(event.target.name)
        this.searchParameter.categoryType = event.target.name

    }

    getCategory(){
        return this.searchParameter.categoryType;
    }

    onActivate(event:any) {
        window.scroll(0,0);
        //or document.body.scrollTop = 0;
        //or document.querySelector('body').scrollTo(0,0)
    }

    changePage(page: number) {
        window.scroll(0,0);
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
        window.scroll(0,0);
        this.searchParameter.page = 0;
        this.productService.setSearchParameter(this.searchParameter)
        this.search()
    }

    getLast() {
        window.scroll(0,0);
        if (this.pageCount != 0) {
            this.searchParameter.page = this.pageCount - 1;
        }
        this.productService.setSearchParameter(this.searchParameter)
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
