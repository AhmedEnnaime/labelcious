import { createReducer, on } from '@ngrx/store';
import { Category } from 'src/app/utils/models/category.model';
import * as CategoryActions from 'src/app/store/actions/category.action';

export interface CategoryState {
  category: Category | null;
  loading: boolean;
  error: any;
}

export const initialState: CategoryState = {
  category: null,
  loading: false,
  error: null,
};

export const categoryReducer = createReducer(
  initialState,
  on(CategoryActions.addCategory, (state, { category }) => ({
    ...state,
    category,
  })),
  on(CategoryActions.getCategory, (state) => ({
    ...state,
    loading: true,
  })),
  on(CategoryActions.getCategorySuccess, (state, { category }) => ({
    ...state,
    loading: false,
    category,
  })),
  on(CategoryActions.getCategoryFailure, (state, { error }) => ({
    ...state,
    loading: false,
    error,
  }))
);
