import { createFeatureSelector, createSelector } from '@ngrx/store';
import { Category } from 'src/app/utils/models/category.model';

export const selectCategories =
  createFeatureSelector<Array<Category>>('categories');

export const selectCategoryById = (id: string) =>
  createSelector(selectCategories, (Categories: Array<Category>) =>
    Categories.find((Category) => Category.id.toString() === id)
  );
