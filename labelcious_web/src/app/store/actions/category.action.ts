import { createAction, props } from '@ngrx/store';
import { Category } from 'src/app/utils/models/category.model';

export const indexAPI = createAction(
  '[Categories API] Invoke Categories Fetch API'
);

export const indexAPISuccess = createAction(
  '[Categories API] Invoke Categories Fetch API Success',
  props<{ allCategories: Array<Category> }>()
);

export const indexAPIFailure = createAction(
  '[Categories API] Invoke Categories Fetch API Failure',
  props<{ error: any }>()
);

export const showAPI = createAction(
  '[Category API] Invoke Category Fetch API',
  props<{ id: string }>()
);

export const showAPISuccess = createAction(
  '[Category API] Invoke Category Fetch API Success',
  props<{ category: Category }>()
);

export const showAPIFailure = createAction(
  '[Category API] Invoke Category Fetch API Failure',
  props<{ error: any }>()
);

export const storeAPI = createAction(
  '[Category API] Invoke Category Store API',
  props<{ category: Category }>()
);

export const storeAPISuccess = createAction(
  '[Category API] Invoke Category Store API Success',
  props<{ category: Category }>()
);

export const storeAPIFailure = createAction(
  '[Category API] Invoke Category Store API Failure',
  props<{ error: any }>()
);

export const updateAPI = createAction(
  '[Category API] Invoke Category Update API',
  props<{ id: string; category: Category }>()
);

export const updateAPISuccess = createAction(
  '[Category API] Invoke Category Update API Success',
  props<{ category: Category }>()
);

export const updateAPIFailure = createAction(
  '[Category API] Invoke Category Update API Failure',
  props<{ error: any }>()
);

export const deleteAPI = createAction(
  '[Category API] Invoke Category Delete API',
  props<{ id: string }>()
);

export const deleteAPISuccess = createAction(
  '[Category API] Invoke Category Delete API Success',
  props<{ id: string }>()
);

export const deleteAPIFailure = createAction(
  '[Category API] Invoke Category Delete API Failure',
  props<{ error: any }>()
);
