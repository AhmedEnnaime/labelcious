import 'package:curved_navigation_bar/curved_navigation_bar.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:mobilelabelcious/controllers/CategoryController.dart';
import 'package:mobilelabelcious/widgets/categoriesWidget.dart';
import 'package:mobilelabelcious/widgets/homeAppBar.dart';
import 'package:mobilelabelcious/widgets/platesWidget.dart';
import 'package:badges/badges.dart' as badges;

class Home extends StatelessWidget {
  final CategoryController categoryController = Get.put(CategoryController());

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ListView(
        children: [
          HomeAppBar(),
          Container(
            // Temporary height
            // height: 500,
            padding: EdgeInsets.only(top: 15),
            decoration: BoxDecoration(
                color: Color(0xFFEDECF2),
                borderRadius: BorderRadius.only(
                    topLeft: Radius.circular(35),
                    topRight: Radius.circular(35))),
            child: Column(children: [
              Container(
                alignment: Alignment.centerLeft,
                margin: EdgeInsets.symmetric(vertical: 20, horizontal: 10),
                child: Text(
                  "Categories",
                  style: TextStyle(
                      fontSize: 25,
                      fontWeight: FontWeight.bold,
                      color: Color(0xFF4C53A5)),
                ),
              ),
              CategoriesWidget(),
              Container(
                alignment: Alignment.centerLeft,
                margin: EdgeInsets.symmetric(vertical: 20, horizontal: 10),
                child: Text(
                  "Today's plates",
                  style: TextStyle(
                      fontSize: 25,
                      fontWeight: FontWeight.bold,
                      color: Color(0xFF4C53A5)),
                ),
              ),

              // Implementation of PlatesWidget
              PlatesWidget(),
            ]),
          ),
        ],
      ),
      bottomNavigationBar: CurvedNavigationBar(
          backgroundColor: Colors.transparent,
          onTap: (index) {},
          height: 70,
          color: Color(0xFF4C53A5),
          index: 1,
          items: [
            IconButton(
              icon: Icon(Icons.person, size: 30, color: Colors.white),
              onPressed: () {
                Navigator.pushNamed(context, "profile");
              },
            ),
            Icon(
              Icons.home,
              size: 30,
              color: Colors.white,
            ),
            badges.Badge(
              badgeContent: Text(
                "3",
                style: TextStyle(color: Colors.white),
              ),
              badgeStyle: badges.BadgeStyle(
                  badgeColor: Colors.red, padding: EdgeInsets.all(7)),
              child: InkWell(
                onTap: () {
                  Navigator.pushNamed(context, "cart");
                },
                child: Icon(
                  Icons.shopping_bag_outlined,
                  size: 32,
                  color: Colors.white,
                ),
              ),
            )
          ]),
    );
  }
}
