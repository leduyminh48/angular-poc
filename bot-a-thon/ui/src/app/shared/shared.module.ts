import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ComponentsModule } from './components';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [CommonModule, ComponentsModule, FormsModule],
  exports: [ComponentsModule, FormsModule],
  declarations: [],
})
export class SharedModule {}
