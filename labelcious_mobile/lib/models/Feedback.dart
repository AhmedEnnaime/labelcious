import 'dart:convert';

import 'package:mobilelabelcious/models/User.dart';

List<Feedback> feedbackFromJson(String str) =>
    List<Feedback>.from(json.decode(str).map((x) => Feedback.fromJson(x)));

String feedbackToJson(List<Feedback> data) =>
    json.encode(List<dynamic>.from(data.map((x) => x.toJson())));

class Feedback {
  int? id;
  String? message;
  int? user_id;
  int? plate_id;
  User? user;

  Feedback({
    this.id,
    this.message,
    this.user_id,
    this.plate_id,
    this.user,
  });

  factory Feedback.fromJson(Map<String, dynamic> json) => Feedback(
        id: json["id"],
        message: json["message"],
        user_id: json["user_id"],
        plate_id: json["plate_id"],
        user: User.fromJson(json["user"]),
      );

  Map<String, dynamic> toJson() => {
        "id": id,
        "message": message,
        "user_id": user_id,
        "plate_id": plate_id,
        "user": user?.toJson(),
      };
}
