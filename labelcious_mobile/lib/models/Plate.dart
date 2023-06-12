import 'dart:convert';
import 'package:mobilelabelcious/models/Category.dart';

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

  Plate(
      {this.id,
      this.name,
      this.description,
      this.image,
      this.category_id,
      this.category});

  factory Plate.fromJson(Map<String, dynamic> json) => Plate(
        id: json["id"],
        name: json["name"],
        description: json["description"],
        category_id: json["category_id"],
        category: Category.fromJson(json["category"]),
      );

  Map<String, dynamic> toJson() => {
        "id": id,
        "name": name,
        "description": description,
        "category_id": category_id,
        "category": category?.toJson(),
      };
}
