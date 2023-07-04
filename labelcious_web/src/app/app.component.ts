import { Component } from '@angular/core';
import { CategoryService } from './services/api/category.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'angular_sass';

  constructor(private categoryService: CategoryService) {
    this.categoryService.index();
  }
}
