import {Injectable} from "@angular/core";
import {Product} from "../models/product";
import {HttpClient} from "@angular/common/http";
import {Observable, of} from "rxjs";
import {map, shareReplay} from "rxjs/operators";
import {Search} from "../models/search";
import {Page} from "../models/page";
import {Brand} from "../models/brand";
import {BrandService} from "./brand.service";
import{ GlobalConstants } from './global-constants';

@Injectable({
    providedIn: 'root'
})
export class ProductService {

    searchParameter = new Search(null, "", 0, 0, "name", "ASC", 0, 25, null);
    private brands: Brand[] = [];

    constructor(private http: HttpClient, private brandService: BrandService) {
    }

    getBrands(): Observable<Brand[]> {
        let result = this.brandService.getAllBrands().pipe(shareReplay(1));
        if (!this.brands.length)
            result.subscribe(val => {
                this.brands = val
            });
        return this.brands.length ? of(this.brands) : result;
    }

    getOneProduct(id: string): Observable<Product> {
        return this.http.get<Product>(GlobalConstants.apiURL + '/api/products/' + id);
    }

    async updateProduct(productToUpdate: Product, newImage: File) {
        let productData: Product | FormData;
        const category = productToUpdate.category.replace(/_/g, "-").toLowerCase();
        const imgPath = newImage ? newImage.name : productToUpdate.photoPath;
        const matches = imgPath.match(/.[a-zA-Z]+/g);
        const extension = matches![matches!.length - 1];
        const newPath = `assets/images/${category}/${category}${productToUpdate.id}${extension}`;

        if (newImage) {
            let oldPath = productToUpdate.photoPath;
            oldPath = oldPath.substring(0, oldPath.indexOf('?'));

            productData = new FormData();
            productData.append('photo', newImage);
            productData.append('newPath', newPath);
            productData.append('oldPath', oldPath);

            await this.http.post(GlobalConstants.apiURL + '/api/products/uploadPhoto/', productData).toPromise();
        }
        productData = new Product(productToUpdate);
        productData.photoPath = newPath;
        await this.http.put(GlobalConstants.apiURL + '/api/products/update/', productData).toPromise();
    }

    async createProduct(productToCreate: Product, image: File) {
        let productData: Product | FormData;
        productData = new Product(productToCreate);

        const id = <string>await this.http.post(GlobalConstants.apiURL + '/api/products/create/', productData).toPromise();
        const category = productToCreate.category.replace(/_/g, "-").toLowerCase();
        const matches = image.name.match(/.[a-zA-Z]+/g);
        const extension = matches![matches!.length - 1];
        const newPath = `assets/images/${category}/${category}${id}${extension}`;

        productData = new FormData();
        productData.append('photo', image);
        productData.append('newPath', newPath);
        productData.append('id', id);

        await this.http.post(GlobalConstants.apiURL + '/api/products/uploadPhoto/', productData).toPromise();
        return id;
    }

    deleteProduct(id: string) {
        return this.http.delete<Product>(GlobalConstants.apiURL + '/api/products/' + id);
    }

    getLastProduct(): Observable<Product[]> {
        return this.http.get(GlobalConstants.apiURL + '/api/products/last-10').pipe(map((data: any) => {
            return data.map(function (product: any): Product {
                return new Product(product);
            });
        }));
    }

    getAllSortedProductAndSearch(sortType: string, field: string, search: string): Observable<Product[]> {
        return this.http.get(GlobalConstants.apiURL + '/api/products/sort=' + sortType + "/field=" + field + "/search=" + search).pipe(map((data: any) => {
            return data.map(function (product: any): Product {
                return new Product(product);
            });
        }));
    }

    setSearchParameter(search: Search) {
        this.searchParameter.name = search.name;
        this.searchParameter.brand = search.brand;
        this.searchParameter.priceFrom = search.priceFrom;
        this.searchParameter.priceTo = search.priceTo;
        this.searchParameter.sortField = search.sortField;
        this.searchParameter.sortDirection = search.sortDirection;
        this.searchParameter.page = search.page;
        this.searchParameter.categoryType = search.categoryType;
    }

    setSearchPage(page: number) {
        this.searchParameter.page = page;
    }

    searchHomePage(text: any) {
        this.searchParameter.name = text;
    }

    searchHeader(text: any) {
        this.searchParameter.categoryType = text;
    }

    search(): Observable<Page> {
        if (this.searchParameter.priceTo <= 0) {
            this.searchParameter.priceTo = null;
        }
        if (this.searchParameter.priceFrom <= 0) {
            this.searchParameter.priceFrom = null;
        }
        return this.http.post(GlobalConstants.apiURL + '/api/products/search', this.searchParameter).pipe(map((data: any) => {
            return new Page(data.content, data.pageCount, data.page, data.pageSize, data.totalItem);
        }));
    }
}
