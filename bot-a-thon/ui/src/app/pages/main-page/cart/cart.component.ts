import { Component, OnInit } from '@angular/core';
import { CartManagerService } from '../../../shared/services/cart-manager.service';
import { CredentialService } from '../../../shared/services/credential.service';
import * as format from 'date-fns/format';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'ee-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  timeUnit: string = 'WEEK';
  timeUnitAmount: number = 1;
  startDate = this.getCurrentDate();

  constructor(
    public cartManager: CartManagerService,
    private credentialService: CredentialService,
    private httpClient: HttpClient,
    private snackBar: MatSnackBar,
  ) {}

  ngOnInit() {
  }

  getTotalForItem(item) {
    return this.cartManager.getTotalForItem(item);
  }

  addQuantity(item) {
    this.cartManager.addQuantity(item);
  }

  removeQuantity(item) {
    this.cartManager.removeQuantity(item);
  }

  submit() {
    this.httpClient.post<null>('/template/webOrder', this.getData())
      .subscribe(() => {
        this.snackBar.open('Done, please check your email');
      })

  }

  getData() {
    const products = this.cartManager.getCart()
      .map(el => ({
        id: el.product.id,
        quantity: el.quantity
      }));

    console.log(this.credentialService.userId);

    return {
      userId: this.credentialService.userId,
      timeUnit: this.timeUnit,
      timeUnitAmount: this.timeUnitAmount,
      startDate: this.startDate,
      products
    }
  }

  getCurrentDate() {
    const date = new Date();

    return format(date, 'YYYY-MM-DD');
  }

}
