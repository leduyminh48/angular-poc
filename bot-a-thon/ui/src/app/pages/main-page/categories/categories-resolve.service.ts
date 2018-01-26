import { Injectable } from '@angular/core';
import { Resolve } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/catch';

export interface ICategory {
  id: string;
  name: string;
}

@Injectable()
export class CategoriesResolveService implements Resolve<ICategory[]> {

  constructor(private httpClient: HttpClient) {
  }

  resolve(): Observable<ICategory[]> {
    return this.httpClient
      .get<ICategory[]>('/catalog/categories')
      .catch(() => Observable.of([
        {
          id: '1',
          name: '1',
        }
      ]));
  }

}
