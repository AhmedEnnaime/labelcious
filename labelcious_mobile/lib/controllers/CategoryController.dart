import 'package:get/get.dart';
import 'package:mobilelabelcious/models/Category.dart';
import 'package:mobilelabelcious/services/CategoryService.dart';

class CategoryController extends GetxController {
  var categoriesList = <Category>[].obs;

  var selectedCategoryIndex = 0.obs;

  @override
  void onInit() {
    getCategories();
    super.onInit();
  }

  void getCategories() async {
    try {
      var categories = await CategoryService.fetchCategories();
      if (categories.isNotEmpty) {
        categoriesList.value = categories;
        selectedCategoryIndex.value =
            categoriesList[0].id ?? 0; // Set initial selected category
      }
    } catch (e) {
      print(e);
    }
  }

  void selectCategory(int categoryId) {
    selectedCategoryIndex.value = categoryId;
    print('Selected Category ID: $categoryId');
  }
}
