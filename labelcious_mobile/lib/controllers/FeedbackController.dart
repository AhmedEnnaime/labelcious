import 'package:get/get.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:mobilelabelcious/controllers/PlateController.dart';
import 'package:mobilelabelcious/controllers/UserController.dart';
import 'package:mobilelabelcious/models/Feedback.dart';
import 'package:mobilelabelcious/models/Plate.dart';

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
  }
}
