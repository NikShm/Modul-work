import { Input, Component, OnInit, HostListener, Output, EventEmitter } from '@angular/core';
import { Product } from 'src/app/models/product';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-product-info',
  templateUrl: './product-info.component.html',
  styleUrls: ['../../shared/css/product.css', './product-info.component.css']
})
export class ProductInfoComponent implements OnInit {
  @Input() product!: Product;

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
  }

  public showActions() {
    document.getElementById("dropdown-content-actions")?.classList.toggle("show");
    document.getElementById("actions")?.classList.remove("btn-dropdown-not-active");
    document.getElementById("actions")?.classList.toggle("btn-dropdown-active");
  }

  @HostListener('window:click', ['$event'])
  public onClick(event: MouseEvent) {
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

  @Output() onEdit = new EventEmitter<boolean>();

  public enableEditMode() {
    this.onEdit.emit(true);
  }

  addToCart(product: Product) {
    this.cartService.addToCart(product);
    console.log(this.cartService.getItems());
    window.alert('Your product has been added to the cart!');
  }
}