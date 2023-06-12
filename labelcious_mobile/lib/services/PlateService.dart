import 'package:http/http.dart' as http;
import 'package:mobilelabelcious/models/Plate.dart';

class PlateService {
  static var client = http.Client();

  static Future<List<Plate>> fetchPlates(int category_id) async {
    var response = await client.get(
        Uri.parse('http://localhost:8082/api/plates/category/${category_id}'));
    if (response.statusCode == 200) {
      var jsonString = response.body;
      var plates = plateFromJson(jsonString);

      return plates;
    } else {
      return [];
    }
  }
}
