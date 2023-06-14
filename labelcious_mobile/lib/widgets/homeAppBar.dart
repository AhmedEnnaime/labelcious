import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:mobilelabelcious/controllers/UserController.dart';

class HomeAppBar extends StatefulWidget {
  const HomeAppBar({super.key});

  @override
  State<HomeAppBar> createState() => _HomeAppBarState();
}

class _HomeAppBarState extends State<HomeAppBar> {
  final UserController userController = Get.find<UserController>();

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
          Stack(
            children: [
              SizedBox(
                width: 40,
                height: 40,
                child: ClipRRect(
                  borderRadius: BorderRadius.circular(100),
                  child:
                      Image.network(userController.googleUser?.photoUrl ?? ""),
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
