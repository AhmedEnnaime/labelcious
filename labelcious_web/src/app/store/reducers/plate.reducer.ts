import { createReducer, on } from '@ngrx/store';
import { Plate } from 'src/app/utils/models/plate.model';
import * as PlateActions from '../actions/plate.action';

export const initialState: Array<Plate> = [];

export const plateReducer = createReducer(
  initialState,
  on(PlateActions.indexAPISuccess, (state, { allPlates }) => {
    return allPlates;
  }),
  on(PlateActions.showAPISuccess, (state, { plate }) => {
    return state.concat(plate);
  }),
  on(PlateActions.storeAPISuccess, (state, { plate }) => {
    return state.concat(plate);
  }),
  on(PlateActions.updateAPISuccess, (state, { plate }) => {
    return state.map((item) => {
      if (item.id === plate.id) {
        return plate;
      }
      return item;
    });
  }),
  on(PlateActions.destroyAPISuccess, (state, { id }) => {
    return state.filter((item) => item.id !== id);
  })
);
