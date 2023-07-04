// structure : app\services\api\category.service.ts

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Presenter } from 'src/app/services/api/presenter/presenter.service';

@Injectable()
export class CategoryService extends Presenter {
  public constructor(http: HttpClient) {
    super(http);
    this.setEndpoint('categories');
  }
}
