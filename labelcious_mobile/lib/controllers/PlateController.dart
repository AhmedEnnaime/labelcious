import 'package:get/get.dart';
import 'package:mobilelabelcious/controllers/CategoryController.dart';
import 'package:mobilelabelcious/models/Plate.dart';
import 'package:mobilelabelcious/services/PlateService.dart';

class PlateController extends GetxController {
  var platesList = <Plate>[].obs;

  var selectedPlate = Plate().obs;

  @override
  void onInit() {
    final categoryController = Get.find<CategoryController>();
    ever(categoryController.selectedCategoryIndex, (_) {
      getPlatesByCategoryId();
    });
    super.onInit();
  }

  void getPlatesByCategoryId() async {
    CategoryController categoryController = Get.find<CategoryController>();
    int selectedCategoryId = categoryController.selectedCategoryIndex.value;

    try {
      platesList.clear();
      var plates = await PlateService.fetchPlates(selectedCategoryId);
      print('Plates: $plates');
      if (plates.isNotEmpty) {
        platesList.value = plates;
      }
    } catch (e) {
      print(e);
    }
  }

  void selectPlate(Plate plate) {
    selectedPlate.value = plate;
    print('Selected Plate : $plate');
  }
}
