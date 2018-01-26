import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IProduct } from '../products-list/products-resolve.service';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'ee-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss'],
})
export class ProductDetailsComponent implements OnInit {
  product$: Observable<IProduct>;
  orderQuantity = 1;

  constructor(private route: ActivatedRoute) {}

  ngOnInit() {
    this.product$ = this.route.data.map(data => data.product);
  }

  removeQuantity() {
    this.orderQuantity--;
  }

  addQuantity() {
    this.orderQuantity++;
  }
}
