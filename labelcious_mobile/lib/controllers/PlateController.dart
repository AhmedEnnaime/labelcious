import 'package:get/get.dart';
import 'package:mobilelabelcious/pages/plate.dart';

class PlateController extends GetxController {
  var platesList = <Plate>[].obs();

  @override
  void onInit() {
    getPlatesByCategoryId();
    super.onInit();
  }

  void getPlatesByCategoryId() async {
    try {} catch (e) {
      print(e);
    }
  }
}
