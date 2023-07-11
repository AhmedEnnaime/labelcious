import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/utils/models/category.model';
import { CategoryService } from 'src/app/services/api/category.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss'],
})
export class UpdateComponent implements OnInit {
  category: Category = {
    id: '',
    name: '',
    price: '',
    description: '',
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private categoryService: CategoryService
  ) {}

  ngOnInit(): void {
    const categoryId = this.route.snapshot.paramMap.get('id');
    if (categoryId) {
      this.categoryService.show(categoryId).subscribe((category) => {
        this.category = category;
      });
    }
  }

  onSubmit() {
    const categoryId = this.route.snapshot.paramMap.get('id');
    if (categoryId) {
      this.categoryService.update(categoryId, this.category).subscribe(() => {
        this.router.navigate(['/Categories']);
      });
    }
  }
}
