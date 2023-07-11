import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Config } from 'src/app/utils/config/app.config';
import { Category } from 'src/app/utils/models/category.model';
import { Observable } from 'rxjs';

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

  public index(): Observable<Category[]> {
    return this.http.get<Category[]>(this.URL);
  }

  public show(id: string): Observable<Category> {
    return this.http.get<Category>(this.URL + '/' + id);
  }

  public store(data: Category): Observable<Category> {
    return this.http.post<Category>(this.URL, data);
  }

  public update(id: string, data: Category): Observable<Category> {
    return this.http.put<Category>(this.URL + '/' + id, data);
  }

  public destroy(id: string): Observable<Category> {
    return this.http.delete<Category>(this.URL + '/' + id);
  }
}
