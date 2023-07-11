import { Category } from './category.model';
export interface Plate {
  id: string;
  name: string;
  description: string;
  image: string;
  Category: Category;
}
