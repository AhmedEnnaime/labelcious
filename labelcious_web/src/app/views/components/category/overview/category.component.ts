import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from 'src/app/utils/models/category.model';
import { Store, select } from '@ngrx/store';
import { selectCategories } from 'src/app/store/selectors/category.selector';
import { deleteAPI, indexAPI } from 'src/app/store/actions/category.action';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss'],
})
export class CategoryComponent implements OnInit {
  categories$: Observable<Category[]>;

  constructor(private store: Store) {
    this.categories$ = this.store.pipe(select(selectCategories));
  }

  ngOnInit(): void {
    this.store.dispatch(indexAPI());
  }

  delete(id: string) {
    this.store.dispatch(deleteAPI({ id }));
  }
}
