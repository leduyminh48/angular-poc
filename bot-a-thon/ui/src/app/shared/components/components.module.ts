import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AngularMaterialModule } from './angular-material/angular-material.module';
import { NavbarModule } from './navbar';
import { SidenavModule } from './sidenav';

const componentModules = [AngularMaterialModule, NavbarModule, SidenavModule];

@NgModule({
  imports: [CommonModule, ...componentModules],
  exports: [...componentModules],
  declarations: [],
})
export class ComponentsModule {}
