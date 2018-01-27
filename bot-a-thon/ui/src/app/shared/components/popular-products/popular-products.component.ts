import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { IProduct } from '../../../pages/main-page/products/products-list/products-resolve.service';
import { CartManagerService } from '../../services/cart-manager.service';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material';

@Component({
  selector: 'ee-popular-products',
  templateUrl: './popular-products.component.html',
  styleUrls: ['./popular-products.component.scss']
})
export class PopularProductsComponent implements OnInit {
  products$: Observable<IProduct[]>;

  constructor(
    private httpClient: HttpClient,
    private cartManager: CartManagerService,
    private router: Router,
    private dialog: MatDialog,
  ) { }

  ngOnInit() {
    this.products$ = this.httpClient.get<IProduct[]>('/product/popular')
  }

  addToCart(product) {
    this.cartManager.addToCart(product, 1);
  }

  goToProductDetails(id) {
    this.dialog.closeAll();
    this.router.navigate(['/app/products', id]);
  }
}
