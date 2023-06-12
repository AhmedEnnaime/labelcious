import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:mobilelabelcious/controllers/PlateController.dart';
import 'package:mobilelabelcious/models/Plate.dart';

class PlatesWidget extends GetWidget<PlateController> {
  final PlateController plateController = Get.put(PlateController());

  @override
  Widget build(BuildContext context) {
    return Obx(
      () {
        if (plateController.platesList.isEmpty) {
          return Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Image.asset(
                  'assets/not_found.png', // Replace with your desired image asset path
                  height: 200,
                  width: 200,
                ),
                Text(
                  'No plates available', // Custom message for empty list
                  style: TextStyle(fontSize: 18),
                ),
              ],
            ),
          );
        } else {
          return GridView.builder(
            gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
              crossAxisCount: 2,
              childAspectRatio: 0.68,
            ),
            physics: NeverScrollableScrollPhysics(),
            shrinkWrap: true,
            itemCount: plateController.platesList.length,
            itemBuilder: (context, index) {
              Plate plate = plateController.platesList[index];
              return Container(
                padding: EdgeInsets.only(left: 15, right: 15, top: 10),
                margin: EdgeInsets.symmetric(vertical: 8, horizontal: 10),
                decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.circular(20),
                ),
                child: Column(
                  children: [
                    InkWell(
                      onTap: () {
                        Navigator.pushNamed(context, "plate");
                      },
                      child: Container(
                        margin: EdgeInsets.all(10),
                        child: Image.asset(
                          "assets/pastry.png", // Use the plate's image URL
                          height: 120,
                          width: 120,
                        ),
                      ),
                    ),
                    Container(
                      padding: EdgeInsets.only(bottom: 8),
                      alignment: Alignment.centerLeft,
                      child: Text(
                        plate.name ?? '', // Use the plate's name
                        style: TextStyle(
                          fontSize: 18,
                          color: Color(0xFF4C53A5),
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                    Container(
                      alignment: Alignment.centerLeft,
                      child: Text(
                        "Tap to see details",
                        style: TextStyle(
                          fontSize: 15,
                          color: Color(0xFF4C53A5),
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.symmetric(vertical: 2),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          Text(
                            "\$ ${plate.category!.price.toString()}",
                            style: TextStyle(
                              fontSize: 16,
                              fontWeight: FontWeight.bold,
                              color: Color(0xFF4C53A5),
                            ),
                          ),
                          Icon(
                            Icons.shopping_cart_checkout,
                            color: Color(0xFF4C53A5),
                          )
                        ],
                      ),
                    ),
                  ],
                ),
              );
            },
          );
        }
      },
    );
  }
}
