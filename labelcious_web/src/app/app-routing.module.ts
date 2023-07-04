import { counterReducer } from 'src/app/store/reducers/counter.reducer';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { StoreModule } from '@ngrx/store';

const routes: Routes = [];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    StoreModule.forRoot({ count: counterReducer }),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}

// create :my-counter.component.ts : -> ng g c views/components/demo/my-counter
