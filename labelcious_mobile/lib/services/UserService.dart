import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:mobilelabelcious/models/User.dart';

class UserService {
  static var client = http.Client();

  static Future<User?> addUser(User user) async {
    // var requestBody = singleUserToJson(user);
    // print('Request body: $requestBody');
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

  static Future<User?> getUserById(int id) async {
    var response =
        await client.get(Uri.parse('http://localhost:8082/api/users/${id}'));

    if (response.statusCode == 200) {
      var jsonString = response.body;
      var user = singleUserFromJson(jsonString);
      return user;
    } else {
      return null;
    }
  }

  static Future<User?> updateUser(User user, int id) async {
    var requestBody = singleUserToJson(user);
    print('Request body: $requestBody');
    var response = await client.put(
      Uri.parse('http://localhost:8082/api/users/${id}'),
      body: singleUserToJson(user),
      headers: {'Content-Type': 'application/json'},
    );

    if (response.statusCode == 200) {
      var jsonString = response.body;
      var updatedUser = User.fromJson(json.decode(jsonString));
      return updatedUser;
    } else {
      print("Failed to update user");
      return null;
    }
  }
}
