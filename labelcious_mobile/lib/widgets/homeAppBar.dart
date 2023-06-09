import 'package:flutter/material.dart';
import 'package:badges/badges.dart' as badges;

class HomeAppBar extends StatefulWidget {
  const HomeAppBar({super.key});

  @override
  State<HomeAppBar> createState() => _HomeAppBarState();
}

class _HomeAppBarState extends State<HomeAppBar> {
  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      padding: EdgeInsets.all(25),
      child: Row(
        children: [
          const Icon(
            Icons.sort,
            size: 30,
            color: Color(0xFF4C53A5),
          ),
          const Padding(
            padding: EdgeInsets.only(left: 20),
            child: Text(
              "Labelcious",
              style: TextStyle(
                  fontSize: 23,
                  fontWeight: FontWeight.bold,
                  color: Color(0xFF4C53A5)),
            ),
          ),
          Spacer(),
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
                color: Color(0xFF4C53A5),
              ),
            ),
          )
        ],
      ),
    );
  }
}
