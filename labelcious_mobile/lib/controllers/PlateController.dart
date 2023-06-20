import 'package:get/get.dart';
import 'package:mobilelabelcious/controllers/CategoryController.dart';
import 'package:mobilelabelcious/models/Menu.dart';
import 'package:mobilelabelcious/models/Plate.dart';
import 'package:mobilelabelcious/services/PlateService.dart';
import 'package:mobilelabelcious/services/menuService.dart';

class PlateController extends GetxController {
  var platesList = <Plate>[].obs;

  var selectedPlate = Plate().obs;
  var selectedMenu = Menu().obs;
  var selectedMenuId = 0.obs;

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

      // Fetch the menus
      var menus = await MenuService.fetchMenus();

      // Find the menu with the selected date
      var selectedMenu = menus.firstWhere(
        (menu) => menu.date == DateTime.now(), // Replace with your desired date
        orElse: () =>
            Menu(), // Return a default Menu object if no menu is found
      );

      if (selectedMenu.id != null) {
        // Update the selected menu in PlateController
        this.selectedMenu.value = selectedMenu;

        // Fetch plates from the selected menu
        var plates = selectedMenu.plates ?? [];
        if (plates.isNotEmpty) {
          platesList.value = plates;
        }
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
