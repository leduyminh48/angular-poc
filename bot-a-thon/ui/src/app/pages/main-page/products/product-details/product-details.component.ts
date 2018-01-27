import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IProduct } from '../products-list/products-resolve.service';
import { Observable } from 'rxjs/Observable';
import { CartManagerService } from '../../../../shared/services/cart-manager.service';

@Component({
  selector: 'ee-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.scss'],
})
export class ProductDetailsComponent implements OnInit {
  product$: Observable<IProduct>;
  orderQuantity = 1;

  constructor(
    private route: ActivatedRoute,
    private cartManager: CartManagerService,
  ) {}

  ngOnInit() {
    this.product$ = this.route.data.map(data => data.product);
  }

  removeQuantity() {
    if (this.orderQuantity > 1) {
      this.orderQuantity--;
    }
  }

  addQuantity() {
    this.orderQuantity++;
  }

  addToCart(product) {
    this.cartManager.addToCart(product, this.orderQuantity);
  }
}
