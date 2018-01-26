import { Injectable } from '@angular/core';
import { IProduct } from '../products-list/products-resolve.service';
import { ActivatedRouteSnapshot, Resolve } from '@angular/router';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ProductDetailsResolveService implements Resolve<IProduct> {
  constructor() {}

  resolve(route: ActivatedRouteSnapshot): Observable<IProduct> {
    return Observable.of({
      id: '1',
      name: 'Comet Cleanser, 720g',
      barCode: 1,
      bonus: 0,
      discount: 0,
      imageUri: 'chips.jpg',
      price: 1.49,
      category: {
        id: '1',
        name: 'General Purpose Cleaners',
      },
    });
  }
}
