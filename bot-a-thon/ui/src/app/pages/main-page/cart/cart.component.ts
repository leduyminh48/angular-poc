import { Component, OnInit } from '@angular/core';
import { CartManagerService, IProductWithQuantity } from '../../../shared/services/cart-manager.service';
import { CredentialService } from '../../../shared/services/credential.service';
import * as format from 'date-fns/format';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material';
import { ActivatedRoute, Router } from '@angular/router';

export interface ICartResp {
  userId?: number,
  timeUnits: string,
  timeUnitAmount: number,
  startDate: string,
  products: IProductWithQuantity[]
}

@Component({
  selector: 'ee-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  timeUnit: string = 'WEEK';
  timeUnitAmount: number = 1;
  startDate = this.getCurrentDate();
  isLatest = false;

  constructor(
    public cartManager: CartManagerService,
    private credentialService: CredentialService,
    private httpClient: HttpClient,
    private snackBar: MatSnackBar,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe(
      params => {
        this.isLatest = params.latest;
        if (params.latest) {
          this.getLatestCart();
        }
      }
    )
  }

  getLatestCart() {
    return this.httpClient.get<ICartResp>('/template/user')
      .subscribe(res => {
        this.timeUnit = res.timeUnits;
        this.timeUnitAmount = res.timeUnitAmount;
        this.startDate = res.startDate;
        this.cartManager.setCart(res.products);
      })
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
        this.snackBar.open('Done, please check your email', null, {
          duration: 3000
        });
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

  goToProductDetails(id) {
    this.router.navigate(['/app/products', id]);
  }

}
