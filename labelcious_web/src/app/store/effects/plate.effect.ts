import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { select, Store } from '@ngrx/store';
import { EMPTY, map, mergeMap, withLatestFrom, catchError } from 'rxjs';
import { Plate } from 'src/app/utils/models/plate.model';
import { selectPlates } from '../selectors/plate.selector';
import * as PlateActions from '../actions/plate.action';
import { PlateService } from 'src/app/services/api/plate.service';

@Injectable()
export class PlateEffects {
  constructor(
    private actions$: Actions,
    private plateService: PlateService,
    private store: Store<{ plates: Plate[] }>
  ) {}

  index$ = createEffect(() =>
    this.actions$.pipe(
      ofType(PlateActions.indexAPI),
      withLatestFrom(this.store.pipe(select(selectPlates))),
      mergeMap(([action, plates]) => {
        if (plates.length === 0) {
          return this.plateService.index().pipe(
            map((allPlates) => {
              return PlateActions.indexAPISuccess({ allPlates });
            }),
            catchError(() => EMPTY)
          );
        }
        return EMPTY;
      })
    )
  );

  show$ = createEffect(() =>
    this.actions$.pipe(
      ofType(PlateActions.showAPI),
      mergeMap((action) => {
        return this.plateService.show(action.id).pipe(
          map((plate) => {
            return PlateActions.showAPISuccess({ plate });
          }),
          catchError(() => EMPTY)
        );
      })
    )
  );

  store$ = createEffect(() =>
    this.actions$.pipe(
      ofType(PlateActions.storeAPI),
      mergeMap((action) => {
        return this.plateService.store(action.plate).pipe(
          map((plate) => {
            return PlateActions.storeAPISuccess({ plate });
          }),
          catchError(() => EMPTY)
        );
      })
    )
  );

  update$ = createEffect(() =>
    this.actions$.pipe(
      ofType(PlateActions.updateAPI),
      mergeMap((action) => {
        return this.plateService.update(action.id, action.plate).pipe(
          map((plate) => {
            return PlateActions.updateAPISuccess({ plate });
          }),
          catchError(() => EMPTY)
        );
      })
    )
  );

  destroy$ = createEffect(() =>
    this.actions$.pipe(
      ofType(PlateActions.destroyAPI),
      mergeMap((action) => {
        return this.plateService.destroy(action.id).pipe(
          map(() => {
            return PlateActions.destroyAPISuccess({ id: action.id });
          }),
          catchError(() => EMPTY)
        );
      })
    )
  );
}

// i want to restart the server and clean the cache : npm run clean
