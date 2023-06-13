import 'dart:convert';

List<User> userFromJson(String str) =>
    List<User>.from(json.decode(str).map((x) => User.fromJson(x)));

String userToJson(List<User> data) =>
    json.encode(List<dynamic>.from(data.map((x) => x.toJson())));

String singleUserToJson(User user) => json.encode(user.toJson());

class User {
  int? id;
  String? firstName;
  String? lastName;
  String? email;
  String? password;
  String? image;
  String? job;
  String? number;
  int? role;

  User({
    this.id,
    this.firstName,
    this.lastName,
    this.email,
    this.password,
    this.image,
    this.job,
    this.number,
    this.role,
  });

  factory User.fromJson(Map<String, dynamic> json) => User(
        id: json["id"],
        firstName: json["firstName"],
        lastName: json["lastName"],
        email: json["email"],
        password: json["password"],
        image: json["image"],
        job: json["job"],
        number: json["number"],
        role: json["role"],
      );

  Map<String, dynamic> toJson() => {
        "id": id,
        "firstName": firstName,
        "lastName": lastName,
        "email": email,
        "password": password,
        "image": image,
      };
}
