import 'package:get/get.dart';
import 'package:mobilelabelcious/controllers/PlateController.dart';
import 'package:mobilelabelcious/controllers/UserController.dart';
import 'package:mobilelabelcious/models/Feedback.dart';
import 'package:mobilelabelcious/models/Plate.dart';
import 'package:mobilelabelcious/services/FeedbackService.dart';

class FeedbackController extends GetxController {
  void addFeedback(Feedback feedback) async {
    UserController userController = Get.find<UserController>();
    PlateController plateController = Get.find<PlateController>();
    Plate plate = plateController.selectedPlate.value;

    var newFeedback = Feedback(
      message: feedback.message,
      user_id: int.parse(userController.googleUser!.id),
      plate_id: plate.id,
    );
    try {
      var addFeedback = FeedbackService.addFeedback(newFeedback);
      if (addFeedback != null) {
        print("Feedback added successfully");
      }
    } catch (e) {
      print("error: ${e}");
      throw Exception(e);
    }
  }
}
