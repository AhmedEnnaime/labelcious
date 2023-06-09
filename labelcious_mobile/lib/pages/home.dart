import 'package:curved_navigation_bar/curved_navigation_bar.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:mobilelabelcious/widgets/categoriesWidget.dart';
import 'package:mobilelabelcious/widgets/homeAppBar.dart';
import 'package:mobilelabelcious/widgets/platesWidget.dart';

class Home extends StatefulWidget {
  const Home({super.key});

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  Future<void> logout() async {
    final GoogleSignIn googleSignIn = GoogleSignIn();
    await googleSignIn.signOut();
  }

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
          // Center(
          //   child: Column(
          //     mainAxisAlignment: MainAxisAlignment.center,
          //     children: [
          //       Text("Home page"),
          //       ElevatedButton(
          //           onPressed: () async {
          //             logout();
          //             if (mounted) {
          //               Navigator.pop(context);
          //             }
          //           },
          //           child: Text("Logout"))
          //     ],
          //   ),
          // ),
        ],
      ),
      bottomNavigationBar: CurvedNavigationBar(
          backgroundColor: Colors.transparent,
          onTap: (index) {},
          height: 70,
          color: Color(0xFF4C53A5),
          items: [
            Icon(
              Icons.person,
              size: 30,
              color: Colors.white,
            ),
            Icon(
              Icons.home,
              size: 30,
              color: Colors.white,
            ),
            Icon(
              CupertinoIcons.cart_fill,
              size: 30,
              color: Colors.white,
            )
          ]),
    );
  }
}
