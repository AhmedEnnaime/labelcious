import 'package:http/http.dart' as http;
import 'package:intl/intl.dart';
import 'package:mobilelabelcious/models/Menu.dart';

class MenuService {
  static var client = http.Client();

  static Future<List<Menu>> fetchMenus() async {
    DateTime now = DateTime.now();
    String formatedDate = DateFormat('yyyy-MM-dd').format(now);

    var response = await client
        .get(Uri.parse('http://localhost:8082/api/menus/date/${formatedDate}'));

    if (response.statusCode == 200) {
      var jsonString = response.body;
      var menus = menuFromJson(jsonString);
      return menus;
    } else {
      return [];
    }
  }
}
