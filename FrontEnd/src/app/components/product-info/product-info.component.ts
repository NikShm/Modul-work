import {Component, EventEmitter, HostListener, Input, OnInit, Output} from '@angular/core';
import {Router} from '@angular/router';
import {Product} from 'src/app/models/product';
import {ProductService} from 'src/app/services/product.service';
import {CartService} from "../../services/cart.service";

@Component({
    selector: 'app-product-info',
    templateUrl: './product-info.component.html',
    styleUrls: ['../product/product.component.css', './product-info.component.css']
})
export class ProductInfoComponent implements OnInit {
    @Input() product!: Product;

    idButtonShowAction = "";

    classButtonShowAction = "";

    constructor(private cartService: CartService, private productService: ProductService, private router: Router) {
    }

    ngOnInit(): void {
        if (JSON.parse(localStorage.getItem("user")!).role == "ADMIN"){
            this.classButtonShowAction = "fas fa-ellipsis-v"
            this.idButtonShowAction = "actions"
        } else{
            this.classButtonShowAction = ""
            this.idButtonShowAction = ""
        }
    }

    public showActions() {
        if (JSON.parse(localStorage.getItem("user")!).role == "ADMIN") {
          document.getElementById("dropdown-content-actions")?.classList.toggle("show");
          document.getElementById("actions")?.classList.toggle("btn-dropdown-active");
        }
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
        }
      }
    }

    @Output() onEdit = new EventEmitter<boolean>();

    public enableEditMode() {
        this.onEdit.emit(true);
    }

    addToCart(product: Product) {
        this.cartService.addToCart(product);
        window.alert('Your product has been added to the cart!');
    }

    delete() {
        if (window.confirm("Are you sure you want to permanently delete this product?")) {
            this.productService.deleteProduct(this.product.id).subscribe(() => {
                window.alert(`Product was deleted successfully.`);
                this.router.navigate(['/products']);
            });
        }
    }
}