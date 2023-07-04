import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Config } from 'src/app/utils/config/app.config';

@Injectable()
export class Presenter {
  public end_point!: string;
  public URL!: string;
  public http!: HttpClient;

  public constructor(http: HttpClient) {
    this.http = http;
  }

  public setEndpoint(endpoint: string): void {
    this.end_point = endpoint;
    this.URL = Config.BASE_URL + this.end_point;
  }

  public index(): void {
    this.http.get(this.URL).subscribe({
      next: (data) => {
        console.table(data);
        // store data here
      },
      error: (response) => {
        console.table(response.error);
      },
    });
  }

  public find(id: number) {
    this.http.get(this.URL + '/' + id).subscribe({
      next: (data) => {
        console.table(data);
      },
      error: (response) => {
        console.error('an error has occurred in find method');
        console.table(response.error);
      },
    });
  }

  public filter(key: any, value: any) {
    return 'filter';
  }

  public update() {
    return 'update';
  }

  public delete() {
    return 'delete';
  }
}
