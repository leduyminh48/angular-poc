import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: '/app/categories',
  },
  {
    path: 'app',
    loadChildren: './pages/main-page/main-page.module#MainPageModule',
  },
  {
    path: 'not-found',
    loadChildren:
      './pages/not-found-page/not-found-page.module#NotFoundPageModule',
  },
  {
    path: '**',
    redirectTo: '/not-found',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    useHash: true
  })],
  exports: [RouterModule],
})
export class AppRoutingModule {}
