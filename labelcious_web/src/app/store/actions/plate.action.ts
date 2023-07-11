import { createAction, props } from '@ngrx/store';
import { Plate } from 'src/app/utils/models/plate.model';

export const indexAPI = createAction('[Plates API] Invoke Plates Fetch API');

export const indexAPISuccess = createAction(
  '[Plates API] Invoke Plates Fetch API Success',
  props<{ allPlates: Array<Plate> }>()
);

export const indexAPIFailure = createAction(
  '[Plates API] Invoke Plates Fetch API Failure',
  props<{ error: any }>()
);

export const showAPI = createAction(
  '[Plate API] Invoke Plate Fetch API',
  props<{ id: string }>()
);

export const showAPISuccess = createAction(
  '[Plate API] Invoke Plate Fetch API Success',
  props<{ plate: Plate }>()
);

export const showAPIFailure = createAction(
  '[Plate API] Invoke Plate Fetch API Failure',
  props<{ error: any }>()
);

export const storeAPI = createAction(
  '[Plate API] Invoke Plate Store API',
  props<{ plate: Plate }>()
);

export const storeAPISuccess = createAction(
  '[Plate API] Invoke Plate Store API Success',
  props<{ plate: Plate }>()
);

export const storeAPIFailure = createAction(
  '[Plate API] Invoke Plate Store API Failure',
  props<{ error: any }>()
);

export const updateAPI = createAction(
  '[Plate API] Invoke Plate Update API',
  props<{ id: string; plate: Plate }>()
);

export const updateAPISuccess = createAction(
  '[Plate API] Invoke Plate Update API Success',
  props<{ plate: Plate }>()
);

export const updateAPIFailure = createAction(
  '[Plate API] Invoke Plate Update API Failure',
  props<{ error: any }>()
);

export const destroyAPI = createAction(
  '[Plate API] Invoke Plate Destroy API',
  props<{ id: string }>()
);

export const destroyAPISuccess = createAction(
  '[Plate API] Invoke Plate Destroy API Success',
  props<{ id: string }>()
);

export const destroyAPIFailure = createAction(
  '[Plate API] Invoke Plate Destroy API Failure',
  props<{ error: any }>()
);
