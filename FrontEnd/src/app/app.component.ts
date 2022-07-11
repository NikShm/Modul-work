import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FrontEnd';
}


/*
import {Component,OnInit} from '@angular/core';
import {Product} from "./product";
import {ProductService} from "./product.service";

@Component({
    selector: 'purchase-app',
    template:
        `
            <div class="box-container">
                <div class="box" *ngFor="let product of products">
                    <span class="discount">-10%</span>
                    <div class="image">
                        <img src="{{product.photoPath}}" alt="">
                        <div class="icons">
                            <a href="#" class="fas fa-heart"></a>
                            <a href="#" class="cart-btn">add to cart</a>
                            <a href="#" class="fas fa-share"></a>
                        </div>
                    </div>
                    <div class="content">
                        <h3>{{product.name}}</h3>
                        <div class="price">{{product.price}}$</div>
                    </div>
                </div>
            </div>`,
    // providers: [ProductService]
})
export class AppComponent implements OnInit  {

    products: Product[] = [];

    constructor(private productService: ProductService) {
    }

    ngOnInit() {
        this.productService.getLastProduct().subscribe((data: Product[]) => {this.products=data;});
    }
}
*/
