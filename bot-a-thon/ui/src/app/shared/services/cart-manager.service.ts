import { Injectable } from '@angular/core';
import { CartComponent } from '../../pages/main-page/products/cart/cart.component';
import { MatDialog } from '@angular/material';

export interface IProductWithQuantity {
  id: number;
  quantity: number;
}

@Injectable()
export class CartManagerService {
  private cart: IProductWithQuantity[] = [];

  constructor(private dialog: MatDialog) { }

  addToCart(product, quantity) {
    this.dialog.open(CartComponent, {
      width: '50rem',
      height: '80rem',
      data: {
        product,
        quantity
      }
    })
  }

  pushToArray(product, quantity) {
    if (this.productIsInCart(product)) {

    }
  }

  productIsInCart(product) {
    return this.cart.some(el => el.id === product.id);
  }

  getCart() {
    return this.cart;
  }

  getLength() {
    return this.cart.length;
  }

}
