import 'dart:convert';
import 'package:mobilelabelcious/models/Category.dart';
import 'package:mobilelabelcious/models/Feedback.dart';

List<Plate> plateFromJson(String str) =>
    List<Plate>.from(json.decode(str).map((x) => Plate.fromJson(x)));

String plateToJson(List<Plate> data) =>
    json.encode(List<dynamic>.from(data.map((x) => x.toJson())));

class Plate {
  int? id;
  String? name;
  String? description;
  String? image;
  int? category_id;
  Category? category;
  List<Feedback>? feedbacks;
  int? quantity;

  Plate({
    this.id,
    this.name,
    this.description,
    this.image,
    this.category_id,
    this.category,
    this.feedbacks,
    this.quantity,
  });

  factory Plate.fromJson(Map<String, dynamic> json) => Plate(
        id: json["id"],
        name: json["name"],
        description: json["description"],
        category_id: json["category_id"],
        category: Category.fromJson(json["category"]),
        feedbacks: List<Feedback>.from(
            json["feedbacks"].map((x) => Feedback.fromJson(x))),
        quantity: json["quantity"],
      );

  Map<String, dynamic> toJson() => {
        "id": id,
        "name": name,
        "description": description,
        "category_id": category_id,
        "category": category?.toJson(),
        "feedbacks":
            List<dynamic>.from(feedbacks?.map((x) => x.toJson()) ?? []),
        "quantity": quantity,
      };
}
