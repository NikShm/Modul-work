import {Injectable} from "@angular/core";
import {Product} from "../models/product";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Search} from "../models/search";
import {Page} from "../models/page";

@Injectable({
    providedIn: 'root'
})
export class ProductService {

    constructor(private http: HttpClient) {
    }

    getOneProduct(id: string): Observable<Product> {
        return this.http.get<Product>('http://localhost:8080/api/products/' + id);
    }

    updateProduct(productToUpdate: Product, newImage: File) {
        let productData: Product | FormData;
        const category = productToUpdate.category.replace(/_/g, "-").toLowerCase();
        const imgPath = newImage ? newImage.name : productToUpdate.photoPath;
        const matches = imgPath.match(/.[a-zA-Z]+/g);
        const extension = matches![matches!.length-1];
        const newPath = `assets/images/${category}/${category}${productToUpdate.id}${extension}`;
        
        if (newImage) {
            productData = new FormData();
            productData.append('photo', newImage);
            productData.append('newPath', newPath);
            productData.append('oldPath', productToUpdate.photoPath);
        
            this.http.post('http://localhost:8080/api/products/uploadPhoto/', productData).toPromise()
            .then(res => {
                productToUpdate.photoPath = newPath;
                productData = new Product(productToUpdate);
                this.http.put('http://localhost:8080/api/products/update/', productData).subscribe();
            });
        }
        else {
            productToUpdate.photoPath = newPath;
            productData = new Product(productToUpdate);
            this.http.put('http://localhost:8080/api/products/update/', productData).subscribe();
        }
    }

    getLastProduct(): Observable<Product[]> {
        return this.http.get('http://localhost:8080/api/products/last-10').pipe(map((data: any) => {
            return data.map(function (product: any): Product {
                return new Product(product);
            });
        }));
    }

    getAllProduct(): Observable<Product[]> {
        return this.http.get('http://localhost:8080/api/products/').pipe(map((data: any) => {
            return data.map(function (product: any): Product {
                return new Product(product);
            });
        }));
    }
    getAllSortedProductAndSearch(sortType:string, field:string, search:string): Observable<Product[]> {
        return this.http.get('http://localhost:8080/api/products/sort='+sortType+"/field="+field+"/search="+search).pipe(map((data: any) => {
            return data.map(function (product: any): Product {
                return new Product(product);
            });
        }));
    }

    search(search:Search): Observable<Page> {
        console.log(search)
        return this.http.post('http://localhost:8080/api/products/search',search).pipe(map((data: any) => {
            console.log(data)
            return new Page(data.content,data.pageCount, data.page, data.pageSize);
        }));
    }
}
