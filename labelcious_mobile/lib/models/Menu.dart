import 'dart:convert';

import 'package:mobilelabelcious/models/Plate.dart';

List<Menu> menuFromJson(String str) =>
    List<Menu>.from(json.decode(str).map((x) => Menu.fromJson(x)));

String menuToJson(List<Menu> data) =>
    json.encode(List<dynamic>.from(data.map((x) => x.toJson())));

class Menu {
  int? id;
  DateTime? date;
  List<Plate>? plates;

  Menu({
    this.id,
    this.date,
    this.plates,
  });

  factory Menu.fromJson(Map<String, dynamic> json) => Menu(
        id: json["id"],
        date: json["date"],
        plates: List<Plate>.from(json["plates"]..map((x) => Plate.fromJson(x))),
      );

  Map<String, dynamic> toJson() => {
        "id": id,
        "date": date,
        "plates": List<dynamic>.from(plates?.map((x) => x.toJson()) ?? []),
      };
}
