import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  product!: Product;
  editedProduct!: Product;
  editMode: boolean = false;

  constructor(private route: ActivatedRoute, private productService: ProductService) { }

  ngOnInit(): void {
    this.getProduct();
  }

  private getProduct(): void {
    const id: string = this.route.snapshot.paramMap.get('id') ?? '';
    this.productService.getOneProduct(id).subscribe(data => this.product = new Product(data));
  }

  changeEditMode(value: boolean) {
    this.getProduct();
    this.editMode = value;
  }

  showEditForm(value: boolean) {
    this.editedProduct = new Product(this.product);
    this.editMode = value;
  }
}