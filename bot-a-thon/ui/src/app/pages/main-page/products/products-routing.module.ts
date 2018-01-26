import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductsComponent } from './products-list/products.component';
import { ProductsResolveService } from './products-list/products-resolve.service';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProductDetailsResolveService } from './product-details/product-details-resolve.service';

const routes: Routes = [
  {
    path: '',
    component: ProductsComponent,
    resolve: {
      products: ProductsResolveService,
    },
  },
  {
    path: ':id',
    component: ProductDetailsComponent,
    resolve: {
      product: ProductDetailsResolveService,
    },
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [ProductsResolveService, ProductDetailsResolveService],
})
export class ProductsRoutingModule {}
