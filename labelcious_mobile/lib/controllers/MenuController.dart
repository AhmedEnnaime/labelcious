import 'package:get/get.dart';
import 'package:mobilelabelcious/controllers/categoryController.dart';
import 'package:mobilelabelcious/models/Menu.dart';
import 'package:mobilelabelcious/services/menuService.dart';

class MenuController extends GetxController {
  var menusList = <Menu>[].obs;

  void getMenuByDate() async {
    try {
      menusList.clear();
      var menus = await MenuService.fetchMenus();
      print("menus: $menus");
      if (menus.isNotEmpty) {
        // Get the selected category ID
        CategoryController categoryController = Get.find<CategoryController>();
        int selectedCategoryId = categoryController.selectedCategoryIndex.value;

        // Filter the plates based on the selected category ID
        menusList.value = menus
            .where((menu) => menu.plates!
                .any((plate) => plate.category!.id == selectedCategoryId))
            .toList();
      }
    } catch (e) {
      print(e);
    }
  }
}
