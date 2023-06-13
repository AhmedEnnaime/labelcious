import 'package:get/get.dart';
import 'package:mobilelabelcious/controllers/PlateController.dart';
import 'package:mobilelabelcious/controllers/UserController.dart';
import 'package:mobilelabelcious/models/Feedback.dart';
import 'package:mobilelabelcious/models/Plate.dart';
import 'package:mobilelabelcious/services/FeedbackService.dart';

class FeedbackController extends GetxController {
  RxList<Feedback> feedbacks = <Feedback>[].obs;

  void addFeedback(Feedback feedback) async {
    UserController userController = Get.find<UserController>();
    PlateController plateController = Get.find<PlateController>();
    Plate plate = plateController.selectedPlate.value;

    var newFeedback = Feedback(
      message: feedback.message,
      user_id: userController.googleUser!.id.hashCode,
      plate_id: plate.id,
    );
    try {
      var addedFeedback = await FeedbackService.addFeedback(newFeedback);
      if (addedFeedback != null) {
        feedbacks.add(addedFeedback); // Add the new feedback to the list
        print("Feedback added successfully");
      }
    } catch (e) {
      print("Error: $e");
      rethrow;
    }
  }
}
