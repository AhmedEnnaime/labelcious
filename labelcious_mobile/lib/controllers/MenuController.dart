import 'package:get/get.dart';
import 'package:mobilelabelcious/models/Menu.dart';
import 'package:mobilelabelcious/services/menuService.dart';

class MenuController extends GetxController {
  var menusList = <Menu>[].obs;

  void getMenuByDate() async {
    try {
      menusList.clear();
      var menus = await MenuService.fetchMenus();
      print("menus: ${menus}");
      if (menus.isNotEmpty) {
        menusList.value = menus;
      }
    } catch (e) {
      print(e);
    }
  }
}
