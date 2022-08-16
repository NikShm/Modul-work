import { Input, Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Product } from 'src/app/models/product';
import { Brand } from 'src/app/models/brand';
import { ProductService } from 'src/app/services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['../product/product.component.css', './product-form.component.css']
})
export class ProductFormComponent implements OnInit {
  @Input() product: Product = new Product();
  brands: Brand[] = [];
  image!: File;
  @Input() mode: string = "create";

  constructor(private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
    if (JSON.parse(localStorage.getItem("user")!).role !== "ADMIN"){
      this.router.navigate(['/login']);
    } 
    else {
      this.productService.getBrands().subscribe(val => {
        this.brands = val;
      });
    }
  }

  exit() {
    if (this.mode === 'edit') {
      this.returnToInfo();
    }
    else if (this.mode === 'create') {
      this.router.navigate(['/products']);
    }
  }

  @Output() onInfo = new EventEmitter<boolean>();

  public returnToInfo() {
    this.onInfo.emit(false);
  }

  public previewImage() { 
    const fileReader = new FileReader();
    const file = (<HTMLInputElement>document.getElementById("photo")).files![0];
    this.image = file;
    fileReader.readAsDataURL(file);
    fileReader.onload = function(fileReaderEvent) {
      (<HTMLImageElement>document.getElementById("preview-img")).src = fileReaderEvent.target?.result as string;
    }
  }

  onSave() {
    if (this.mode === 'edit') {
      this.productService.updateProduct(this.product, this.image).then(() => {
        window.alert(`Product №${this.product.id} was updated successfully.`);
        this.returnToInfo();
      });
    }
    else if (this.mode === 'create') {
      this.productService.createProduct(this.product, this.image).then((id) => {
        window.alert(`Product was created successfully with id ${id}.`);
        this.router.navigate([`/products/${id}`]);
      })
    }
  }

  compareFn(b1: Brand, b2: Brand) {
    return b1 && b2 ? b1.id === b2.id : b1 === b2;
  }
}
