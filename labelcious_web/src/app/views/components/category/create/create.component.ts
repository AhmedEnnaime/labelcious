import { Component } from '@angular/core';
import { Category } from 'src/app/utils/models/category.model';
import { CategoryService } from 'src/app/services/api/category.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss'],
})
export class CreateComponent {
  category: Category = {
    id: '0',
    name: '',
    price: '0',
    description: '',
  };

  constructor(
    private categoryService: CategoryService,
    private router: Router
  ) {}

  onSubmit() {
    this.categoryService.store(this.category).subscribe((category) => {
      this.router.navigate(['/Categories']);
    });
  }
}
