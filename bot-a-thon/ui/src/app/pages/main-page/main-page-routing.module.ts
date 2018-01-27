import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainPageComponent } from './main-page.component';

const routes: Routes = [
  {
    path: '',
    component: MainPageComponent,
    children: [
      {
        path: '',
        redirectTo: '/app/categories',
        pathMatch: 'full',
      },
      {
        path: 'categories',
        loadChildren: './categories/categories.module#CategoriesModule',
      },
      {
        path: 'products',
        loadChildren: './products/products.module#ProductsModule',
      },
      {
        path: 'cart',
        loadChildren: './cart/cart.module#CartModule',
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MainPageRoutingModule {}
