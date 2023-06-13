import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:mobilelabelcious/models/Feedback.dart';

class FeedbackService {
  static var client = http.Client();

  static Future<Feedback?> addFeedback(Feedback feedback) async {
    var response = await client.post(
      Uri.parse('http://localhost:8082/api/feedbacks'),
      body: singleFeedbackToJson(feedback),
      headers: {'Content-Type': 'application/json'},
    );

    if (response.statusCode == 201) {
      var jsonString = response.body;
      var newFeedback = Feedback.fromJson(json.decode(jsonString));
      return newFeedback;
    } else {
      print("error");
      return null;
    }
  }
}
