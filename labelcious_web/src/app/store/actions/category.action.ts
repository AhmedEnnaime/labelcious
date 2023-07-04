import { createAction, props } from '@ngrx/store';
import { Category } from 'src/app/utils/models/category.model';

export const addCategory = createAction(
  '[Category] Add Category',
  props<{ category: Category }>()
);

export const getCategory = createAction('[Category] Get Category');
export const getCategorySuccess = createAction(
  '[Category] Get Category Success',
  props<{ category: Category }>()
);

export const getCategoryFailure = createAction(
  '[Category] Get Category Failure',
  props<{ error: any }>()
);
