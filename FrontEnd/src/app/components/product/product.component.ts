import { Component, HostListener, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { ProductService } from 'src/app/services/product.service';

import {CartService} from "../cartService/cart.service";
@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  public product!: Product;


  constructor(private route: ActivatedRoute, private productService: ProductService,
    private location: Location, private cartService: CartService) { }

  ngOnInit(): void {
    this.getProduct();
  }

  private getProduct(): void {
    const id = this.route.snapshot.paramMap.get('id') ?? '';
    this.productService.getOneProduct(id).subscribe(product => this.product = product);
  }

  public showActions() {
    document.getElementById("dropdown-content-actions")?.classList.toggle("show");
    document.getElementById("actions")?.classList.remove("btn-dropdown-not-active");
    document.getElementById("actions")?.classList.toggle("btn-dropdown-active");
  }

  @HostListener('window:click', ['$event'])
  onClick(event: MouseEvent) {
    if (!(<HTMLElement>event.target).matches('#actions')) {
      const dropdown = document.getElementById("dropdown-content-actions");
      const button = document.getElementById("actions");
      if (dropdown?.classList.contains('show')) {
        dropdown.classList.remove('show');
      }
      if (button?.classList.contains('btn-dropdown-active')) {
        button.classList.remove('btn-dropdown-active');
        button.classList.toggle('btn-dropdown-not-active');
      }
    }
  }

  addToCart(product: Product) {
    this.cartService.addToCart(product);
    window.alert('Your product has been added to the cart!');
  }
}