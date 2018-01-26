import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { IProduct } from './products-resolve.service';
import 'rxjs/add/operator/share';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';

@Component({
  selector: 'ee-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
})
export class ProductsComponent implements OnInit {
  categoryName: string;
  products: Observable<IProduct[]>;
  sortBys = ['Relevance', 'Product name (A-Z)', 'Product name (Z-A)'];
  selected = 'Relevance';

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.products = this.route.data
      .do(data => {
        this.categoryName = data.products[0].category.name;
      })
      .map(data => data.products);
  }
}
