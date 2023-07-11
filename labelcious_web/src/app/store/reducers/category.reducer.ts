import { createReducer, on } from '@ngrx/store';
import { Category } from 'src/app/utils/models/category.model';
import * as CategoryActions from '../actions/category.action';

export const initialState: Array<Category> = [];

export const categoryReducer = createReducer(
  initialState,
  on(CategoryActions.indexAPISuccess, (state, { allCategories }) => {
    return allCategories;
  }),
  on(CategoryActions.showAPISuccess, (state, { category }) => {
    return state.concat(category);
  }),
  on(CategoryActions.storeAPISuccess, (state, { category }) => {
    return {
      ...state,
      categoryToLog: category,
    };
  }),
  on(CategoryActions.updateAPISuccess, (state, { category }) => {
    return state.map((item) => {
      if (item.id === category.id) {
        return category;
      }
      return item;
    });
  }),
  on(CategoryActions.deleteAPISuccess, (state, { id }) => {
    return state.filter((item) => item.id !== id);
  })
);
