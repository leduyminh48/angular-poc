import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoriesComponent } from './categories.component';
import { CategoriesResolveService } from './categories-resolve.service';

const routes: Routes = [{
  path: '',
  component: CategoriesComponent,
  resolve: {
    categories: CategoriesResolveService
  }
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [CategoriesResolveService]
})
export class CategoriesRoutingModule { }
