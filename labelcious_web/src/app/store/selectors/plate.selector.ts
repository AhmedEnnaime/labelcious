import { createFeatureSelector, createSelector } from '@ngrx/store';
import { Plate } from 'src/app/utils/models/plate.model';

export const selectPlates = createFeatureSelector<Plate[]>('plates');

export const selectPlateById = (id: string) =>
  createSelector(selectPlates, (plates: Plate[]) =>
    plates.find((plate) => plate.id.toString() === id)
  );
