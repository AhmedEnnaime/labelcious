import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './views/pages/home/home.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },

  {
    path: 'Categories',
    loadChildren: () =>
      import('./views/components/category/category.module').then(
        (m) => m.CategoryModule
      ),
  },
  {
    path: 'plates',
    loadChildren: () =>
      import('./views/components/plate/plate.module').then(
        (m) => m.PlateModule
      ),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
