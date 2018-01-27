import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PopularProductsComponent } from './popular-products.component';
import { AngularMaterialModule } from '../angular-material/angular-material.module';

@NgModule({
  imports: [
    CommonModule,
    AngularMaterialModule
  ],
  declarations: [PopularProductsComponent],
  exports: [PopularProductsComponent],
})
export class PopularProductsModule { }
