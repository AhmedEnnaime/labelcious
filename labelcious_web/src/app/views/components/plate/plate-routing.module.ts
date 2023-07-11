import { Plate } from 'src/app/utils/models/plate.model';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PlateComponent } from './overview/plate.component';

const routes: Routes = [
  {
    path: '',
    component: PlateComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PlateRoutingModule {}
