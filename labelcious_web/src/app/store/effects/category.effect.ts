import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { select, Store } from '@ngrx/store';
import { EMPTY, map, mergeMap, withLatestFrom, catchError } from 'rxjs';
import { CategoryService } from 'src/app/services/api/category.service';
import { Category } from 'src/app/utils/models/category.model';
import { selectCategories } from '../selectors/category.selector';
import * as CategoryActions from '../actions/category.action';
import { tap } from 'rxjs/operators';

@Injectable()
export class CategoryEffects {
  constructor(
    private actions$: Actions,
    private categoryService: CategoryService,
    private store: Store<{ categories: Array<Category> }>
  ) {}

  index$ = createEffect(() =>
    this.actions$.pipe(
      ofType(CategoryActions.indexAPI),
      withLatestFrom(this.store.pipe(select(selectCategories))),
      mergeMap(([action, categories]) => {
        if (categories.length === 0) {
          return this.categoryService.index().pipe(
            map((allCategories) => {
              return CategoryActions.indexAPISuccess({ allCategories });
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
      ofType(CategoryActions.showAPI),
      mergeMap((action) => {
        return this.categoryService.show(action.id).pipe(
          map((category) => {
            return CategoryActions.showAPISuccess({ category });
          }),
          catchError(() => EMPTY)
        );
      })
    )
  );

  store$ = createEffect(() =>
    this.actions$.pipe(
      ofType(CategoryActions.storeAPI),
      mergeMap((action) => {
        return this.categoryService.store(action.category).pipe(
          tap((category) => {
            console.log(category);
          }),
          map((category) => {
            return CategoryActions.storeAPISuccess({ category });
          }),
          catchError(() => EMPTY)
        );
      })
    )
  );

  update$ = createEffect(() =>
    this.actions$.pipe(
      ofType(CategoryActions.updateAPI),
      mergeMap((action) => {
        return this.categoryService.update(action.id, action.category).pipe(
          map((category) => {
            return CategoryActions.updateAPISuccess({ category });
          }),
          catchError(() => EMPTY)
        );
      })
    )
  );

  delete$ = createEffect(() =>
    this.actions$.pipe(
      ofType(CategoryActions.deleteAPI),
      mergeMap((action) => {
        return this.categoryService.destroy(action.id).pipe(
          map((category) => {
            return CategoryActions.deleteAPISuccess({ id: action.id });
          }),
          catchError(() => EMPTY)
        );
      })
    )
  );
}
