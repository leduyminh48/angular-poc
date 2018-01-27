import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { IProduct } from './products-resolve.service';
import 'rxjs/add/operator/share';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import { MatDialog } from '@angular/material';
import { CartComponent } from '../cart/cart.component';
import { CartManagerService } from '../../../../shared/services/cart-manager.service';

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

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private cartManager: CartManagerService
  ) {}

  ngOnInit() {
    this.products = this.route.data
      .do(data => {
        this.categoryName = data.products[0].category.name;
      })
      .map(data => data.products);
  }

  goToProductDetails(id) {
    this.router.navigate(['/app/products', id])
  }

  addToCart(product, quantity) {
    this.cartManager.addToCart(product, quantity);
  }
}
