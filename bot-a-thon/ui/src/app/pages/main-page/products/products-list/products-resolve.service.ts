import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { HttpClient } from '@angular/common/http';
import { ICategory } from '../../categories/categories-resolve.service';

export interface IProduct {
  id: string;
  category: ICategory;
  name: string;
  barCode: number;
  bonus: number;
  discount: number;
  imageUri: string;
  price: number;
}

@Injectable()
export class ProductsResolveService implements Resolve<IProduct[]> {
  constructor(private httpClient: HttpClient) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IProduct[]> {
    return this.httpClient.get<IProduct[]>(
      `/product/category/${route.queryParams.category}`
    );
  }
}
