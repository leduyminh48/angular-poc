import { Injectable } from '@angular/core';
import { IProduct } from '../products-list/products-resolve.service';
import { ActivatedRouteSnapshot, Resolve } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ProductDetailsResolveService implements Resolve<IProduct> {
  constructor(private http: HttpClient) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IProduct> {
    const productId = route.params.id;

    return this.http.get<IProduct>(`/product/${productId}`);
  }
}
