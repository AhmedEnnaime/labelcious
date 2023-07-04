// structure: app\utils\config\app.config.ts

import { Injectable } from '@angular/core';

@Injectable()
export class Config {
  static readonly BASE_URL = 'http://localhost:8080/api/';
}
