import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidenavComponent } from './sidenav.component';
import { AngularMaterialModule } from '../angular-material/angular-material.module';

@NgModule({
  imports: [CommonModule, AngularMaterialModule],
  declarations: [SidenavComponent],
  exports: [SidenavComponent],
})
export class SidenavModule {}
