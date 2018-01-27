import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AngularMaterialModule } from './angular-material/angular-material.module';
import { NavbarModule } from './navbar';
import { SidenavModule } from './sidenav';
import { PopularProductsModule } from './popular-products';

const componentModules = [AngularMaterialModule, NavbarModule, SidenavModule, PopularProductsModule];

@NgModule({
  imports: [CommonModule, ...componentModules],
  exports: [...componentModules],
})
export class ComponentsModule {}
