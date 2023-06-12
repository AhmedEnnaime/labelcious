import 'package:http/http.dart' as http;
import 'package:mobilelabelcious/models/Category.dart';

class CategoryService {
  static var client = http.Client();

  static Future<List<Category>> fetchCategories() async {
    var response =
        await client.get(Uri.parse('http://localhost:8082/api/categories'));
    if (response.statusCode == 200) {
      var jsonString = response.body;
      var categories = categoryFromJson(jsonString);

      for (var i = 0; i < categories.length; i++) {
        categories[i].id =
            categories[i].id; // Assign category ID from the response
      }

      return categories;
    } else {
      return [];
    }
  }
}
