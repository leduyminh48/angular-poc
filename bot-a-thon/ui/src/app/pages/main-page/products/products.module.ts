import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductsRoutingModule } from './products-routing.module';
import { ProductsComponent } from './products-list/products.component';
import { SharedModule } from '../../../shared';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProductRatingComponent } from './product-rating/product-rating.component';

@NgModule({
  imports: [CommonModule, ProductsRoutingModule, SharedModule],
  declarations: [
    ProductsComponent,
    ProductDetailsComponent,
    ProductRatingComponent,
  ],
})
export class ProductsModule {}
