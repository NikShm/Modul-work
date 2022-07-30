import { Input, Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Product } from 'src/app/models/product';
import { Brand } from 'src/app/models/brand';
import { BrandService } from 'src/app/services/brand.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['../../shared/css/product.css', './product-form.component.css']
})
export class ProductFormComponent implements OnInit {
  @Input() product!: Product;
  brands: Brand[] = [];
  image!: File;

  constructor(private brandService: BrandService, private productService: ProductService) { }

  ngOnInit(): void {
    this.getBrands();
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

  private getBrands() {
    this.brandService.getAllBrands().subscribe(data => this.brands = data);
  }

  onSave() {
    this.productService.updateProduct(this.product, this.image);
    window.alert(`Product №${this.product.id} was updated successfully.`);
    //location.reload();
    this.returnToInfo();
  }

  compareFn(b1: Brand, b2: Brand) {
    return b1.id === b2.id;
  }
}
