import { createSelector, createFeatureSelector } from '@ngrx/store';
import { CategoryState } from 'src/app/store/reducers/category.reducer';

export const selectCategoryState =
  createFeatureSelector<CategoryState>('category');

export const selectCategory = createSelector(
  selectCategoryState,
  (state) => state.category
);

export const selectLoading = createSelector(
  selectCategoryState,
  (state) => state.loading
);

export const selectError = createSelector(
  selectCategoryState,
  (state) => state.error
);
