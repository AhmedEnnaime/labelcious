import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:mobilelabelcious/controllers/CategoryController.dart';

class CategoriesWidget extends GetWidget<CategoryController> {
  @override
  Widget build(BuildContext context) {
    return Obx(() {
      return SingleChildScrollView(
        scrollDirection: Axis.horizontal,
        child: Row(
          children: [
            for (var category in controller.categoriesList)
              GestureDetector(
                onTap: () {
                  print(category.id);
                  controller.selectCategory(category.id ?? 0);
                },
                child: Obx(() {
                  bool isSelected =
                      category.id == controller.selectedCategoryIndex.value;
                  return Container(
                    margin: EdgeInsets.symmetric(horizontal: 8),
                    padding: EdgeInsets.symmetric(vertical: 5, horizontal: 10),
                    decoration: BoxDecoration(
                      color: isSelected ? Colors.blue : Colors.white,
                      borderRadius: BorderRadius.circular(20),
                    ),
                    child: Row(
                      crossAxisAlignment: CrossAxisAlignment.center,
                      children: [
                        Image.asset(
                          "assets/pastry.png",
                          width: 40,
                          height: 40,
                        ),
                        Text(
                          category.name ?? "",
                          style: TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 17,
                            color: Color(0xFF4C53A5),
                          ),
                        ),
                      ],
                    ),
                  );
                }),
              ),
          ],
        ),
      );
    });
  }
}
