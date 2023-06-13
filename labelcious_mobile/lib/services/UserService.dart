import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:mobilelabelcious/models/User.dart';

class UserService {
  static var client = http.Client();

  static Future<User?> addUser(User user) async {
    var requestBody = singleUserToJson(user);
    print('Request body: $requestBody');
    var response = await client.post(
      Uri.parse('http://localhost:8082/api/users/signup'),
      body: singleUserToJson(user),
      headers: {'Content-Type': 'application/json'},
    );
    if (response.statusCode == 201) {
      var jsonString = response.body;
      var newUser = User.fromJson(json.decode(jsonString));
      return newUser;
    } else if (response.statusCode == 400) {
      return null; // Return null to indicate that the user already exists
    } else {
      print("Failed to add user. Status code: ${response.statusCode}");
      throw Exception("Failed to add user.");
    }
  }
}
