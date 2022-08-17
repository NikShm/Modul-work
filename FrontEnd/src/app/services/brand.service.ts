import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Brand } from "../models/brand";
import { Observable } from 'rxjs';
import {map} from "rxjs/operators";
import{ GlobalConstants } from './global-constants';

@Injectable({
  providedIn: 'root'
})
export class BrandService {

  constructor(private http: HttpClient) { }

  getAllBrands():Observable<Brand[]> {
    return this.http.get<Brand[]>(GlobalConstants.apiURL + '/api/brands/').pipe(map((data: any) => {
      return data.map(function(brand: any): Brand {
        return new Brand(brand);
      })
    }));
  }
}
