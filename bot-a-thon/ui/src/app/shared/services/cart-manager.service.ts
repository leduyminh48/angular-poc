import { Injectable } from '@angular/core';
import { CartPopupComponent } from '../../pages/main-page/products/cart-popup/cart-popup.component';
import { MatDialog } from '@angular/material';
import { IProduct } from '../../pages/main-page/products/products-list/products-resolve.service';

export interface IProductWithQuantity {
  product: IProduct;
  quantity: number;
}

@Injectable()
export class CartManagerService {
  private cart: IProductWithQuantity[] = [];

  constructor(private dialog: MatDialog) {
  }

  addToCart(product, quantity) {
    this.dialog.closeAll();
    this.dialog.open(CartPopupComponent, {
      width: '50rem',
      height: '90rem',
      data: {
        product,
        quantity
      }
    });

    this.pushToArray(product, quantity);
  }

  pushToArray(product, quantity) {
    if (this.productIsInCart(product)) {
      const el = this.getProductById(product.id);

      console.log(el);

      el.quantity = el.quantity + quantity;
    } else {
      this.cart.push({ product, quantity });
    }
  }

  productIsInCart(product) {
    return this.cart.some(el => el.product.id === product.id);
  }

  getProductById(id) {
    return this.cart.find(el => el.product.id === id);
  }

  getCart() {
    return [...this.cart];
  }

  getLength() {
    return this.cart.length;
  }

  getTotal() {
    return this.cart.reduce((res, el) => {
      return res + el.product.price * el.quantity;
    }, 0)
  }

  getTotalForItem(item) {
    return item.product.price * item.quantity;
  }

  addQuantity(item) {
    item.quantity++;
  }

  removeQuantity(item) {
    if (item.quantity > 1) {
      item.quantity--;
    }
  }

  setCart(cart: IProductWithQuantity[]) {
    this.cart = cart;
  }

}
