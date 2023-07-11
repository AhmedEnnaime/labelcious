import { StoreModule } from '@ngrx/store';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoryRoutingModule } from './category-routing.module';
import { CategoryComponent } from './overview/category.component';
import { categoryReducer } from 'src/app/store/reducers/category.reducer';
import { CategoryEffects } from 'src/app/store/effects/category.effect';
import { EffectsModule } from '@ngrx/effects';
import { FormsModule } from '@angular/forms';
import { CategoryService } from 'src/app/services/api/category.service';
import { CreateComponent } from './create/create.component';
import { UpdateComponent } from './update/update.component';

@NgModule({
  declarations: [CategoryComponent, CreateComponent, UpdateComponent],
  imports: [
    CommonModule,
    CategoryRoutingModule,
    StoreModule.forFeature('categories', categoryReducer),
    EffectsModule.forFeature([CategoryEffects]),
    FormsModule,
  ],
  providers: [CategoryService],
})
export class CategoryModule {}

// ng g m views\components\plate --routing
